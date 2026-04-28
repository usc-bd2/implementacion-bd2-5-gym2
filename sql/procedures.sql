BEGIN;

-- T8: Registrar una reserva para una sesión.
CREATE OR REPLACE PROCEDURE pr_registrar_reserva(
  IN    p_id_usuario INTEGER,
  IN    p_id_sesion  INTEGER,
  INOUT p_id_reserva INTEGER
)
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = public
AS $$
DECLARE
  v_id_sala  INTEGER;
  v_id_plaza INTEGER;
BEGIN
  p_id_reserva := NULL;

  IF p_id_usuario IS NULL THEN
    RAISE EXCEPTION 'No hay usuario asociado a la reserva.';
  END IF;

  IF p_id_sesion IS NULL THEN
    RAISE EXCEPTION 'Debe seleccionarse una sesión.';
  END IF;

  -- Bloquea la sesión para evitar reservas concurrentes simultáneas
  -- sobre la misma sesión.
  SELECT s.id_sala
  INTO v_id_sala
  FROM sesion s
  WHERE s.id_sesion = p_id_sesion
  FOR UPDATE;

  IF v_id_sala IS NULL THEN
    RAISE EXCEPTION 'La sesión seleccionada no existe.';
  END IF;

  IF NOT EXISTS (
    SELECT 1
    FROM usuario u
    WHERE u.id_usuario = p_id_usuario
  ) THEN
    RAISE EXCEPTION 'El usuario indicado no existe.';
  END IF;

  IF EXISTS (
    SELECT 1
    FROM reserva r
    WHERE r.id_usuario = p_id_usuario
      AND r.id_sesion = p_id_sesion
  ) THEN
    RAISE EXCEPTION 'El usuario ya tiene una reserva para esta sesión.';
  END IF;

  -- Busca una plaza libre real dentro de la sala de la sesión.
  SELECT p.id_plaza
  INTO v_id_plaza
  FROM plaza p
  WHERE p.id_sala = v_id_sala
    AND NOT EXISTS (
      SELECT 1
      FROM reserva_plaza rp
      WHERE rp.id_sesion = p_id_sesion
        AND rp.id_sala = p.id_sala
        AND rp.id_plaza = p.id_plaza
    )
  ORDER BY p.id_plaza
  LIMIT 1;

  IF v_id_plaza IS NULL THEN
    RAISE EXCEPTION 'No hay plazas disponibles para esta sesión.';
  END IF;

  INSERT INTO reserva (id_usuario, id_sesion)
  VALUES (p_id_usuario, p_id_sesion)
  RETURNING id_reserva INTO p_id_reserva;

  INSERT INTO reserva_plaza (id_reserva, id_sesion, id_sala, id_plaza)
  VALUES (p_id_reserva, p_id_sesion, v_id_sala, v_id_plaza);

END;
$$;

COMMIT;
