BEGIN;

-- Restricción: validar que la plaza reservada corresponde a la sesión y sala de la reserva
CREATE OR REPLACE FUNCTION fn_validar_reserva_plaza()
RETURNS TRIGGER AS $$
DECLARE
  sesion_reserva INTEGER;
  sala_sesion    INTEGER;
BEGIN
  SELECT r.id_sesion
  INTO sesion_reserva
  FROM reserva r
  WHERE r.id_reserva = NEW.id_reserva;

  IF sesion_reserva IS NULL THEN
    RAISE EXCEPTION 'La reserva % no existe.', NEW.id_reserva;
  END IF;

  IF sesion_reserva <> NEW.id_sesion THEN
    RAISE EXCEPTION 'La plaza reservada no corresponde a la sesión de la reserva.';
  END IF;

  SELECT s.id_sala
  INTO sala_sesion
  FROM sesion s
  WHERE s.id_sesion = NEW.id_sesion;

  IF sala_sesion IS NULL THEN
    RAISE EXCEPTION 'La sesión % no existe.', NEW.id_sesion;
  END IF;

  IF sala_sesion <> NEW.id_sala THEN
    RAISE EXCEPTION 'La plaza seleccionada no pertenece a la sala de la sesión.';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_reserva_plaza
BEFORE INSERT OR UPDATE
ON reserva_plaza
FOR EACH ROW
EXECUTE FUNCTION fn_validar_reserva_plaza();


-- Restricción: no permitir reservas en sesiones de fechas pasadas
CREATE OR REPLACE FUNCTION fn_validar_reserva_sesion_futura()
RETURNS TRIGGER AS $$
DECLARE
    v_fecha_sesion DATE;
BEGIN
    SELECT s.fecha_sesion
    INTO v_fecha_sesion
    FROM sesion s
    WHERE s.id_sesion = NEW.id_sesion;

    IF v_fecha_sesion IS NULL THEN
        RAISE EXCEPTION 'La sesión indicada no existe.';
    END IF;

    IF v_fecha_sesion < CURRENT_DATE THEN
        RAISE EXCEPTION 'No se puede reservar una sesión de una fecha pasada.';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_reserva_sesion_futura
BEFORE INSERT OR UPDATE OF id_sesion
ON reserva
FOR EACH ROW
EXECUTE FUNCTION fn_validar_reserva_sesion_futura();

-- Restricción: solo permitir valorar clases reservadas en fechas ya pasadas
CREATE OR REPLACE FUNCTION fn_validar_valoracion_clase_reservada_finalizada()
RETURNS TRIGGER AS $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM reserva r
        JOIN sesion s
            ON s.id_sesion = r.id_sesion
        WHERE r.id_usuario = NEW.id_usuario
          AND s.nombre_clase = NEW.nombre_clase
          AND s.fecha_sesion < CURRENT_DATE
    ) THEN
        RAISE EXCEPTION 'El usuario solo puede valorar clases que haya reservado en una fecha ya finalizada.';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_valoracion_clase_reservada_finalizada
BEFORE INSERT OR UPDATE OF nombre_clase, id_usuario
ON valorar
FOR EACH ROW
EXECUTE FUNCTION fn_validar_valoracion_clase_reservada_finalizada();

-- Auditoría: registrar cambios sobre valoraciones
CREATE OR REPLACE FUNCTION fn_auditar_valoracion()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN

        INSERT INTO auditoria_valoracion (
            operacion,
            id_valoracion,
            id_usuario,
            nombre_clase,
            opinion_nueva,
            puntuacion_nueva
        )
        VALUES (
            'INSERT',
            NEW.id_valoracion,
            NEW.id_usuario,
            NEW.nombre_clase,
            NEW.opinion,
            NEW.puntuacion
        );

        RETURN NEW;

    ELSIF TG_OP = 'UPDATE' THEN

        INSERT INTO auditoria_valoracion (
            operacion,
            id_valoracion,
            id_usuario,
            nombre_clase,
            opinion_anterior,
            opinion_nueva,
            puntuacion_anterior,
            puntuacion_nueva
        )
        VALUES (
            'UPDATE',
            NEW.id_valoracion,
            NEW.id_usuario,
            NEW.nombre_clase,
            OLD.opinion,
            NEW.opinion,
            OLD.puntuacion,
            NEW.puntuacion
        );

        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN

        INSERT INTO auditoria_valoracion (
            operacion,
            id_valoracion,
            id_usuario,
            nombre_clase,
            opinion_anterior,
            puntuacion_anterior
        )
        VALUES (
            'DELETE',
            OLD.id_valoracion,
            OLD.id_usuario,
            OLD.nombre_clase,
            OLD.opinion,
            OLD.puntuacion
        );

        RETURN OLD;
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_auditar_valoracion
AFTER INSERT OR UPDATE OR DELETE
ON valorar
FOR EACH ROW
EXECUTE FUNCTION fn_auditar_valoracion();

COMMIT;