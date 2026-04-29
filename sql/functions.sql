BEGIN;

-- Función: consultar plazas disponibles de una sesión
CREATE OR REPLACE FUNCTION fn_plazas_disponibles(p_id_sesion INTEGER)
RETURNS TABLE (
    id_sesion INTEGER,
    id_sala INTEGER,
    id_plaza INTEGER
)
LANGUAGE sql
STABLE
AS $$
    SELECT
        s.id_sesion,
        p.id_sala,
        p.id_plaza
    FROM sesion s
    JOIN plaza p
        ON p.id_sala = s.id_sala
    WHERE s.id_sesion = p_id_sesion
      AND NOT EXISTS (
          SELECT 1
          FROM reserva_plaza rp
          WHERE rp.id_sesion = s.id_sesion
            AND rp.id_sala = p.id_sala
            AND rp.id_plaza = p.id_plaza
      )
    ORDER BY p.id_plaza;
$$;

COMMIT;