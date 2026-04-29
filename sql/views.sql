BEGIN;

-- Vista para consultar las clases junto con su puntuación media y número de valoraciones
CREATE OR REPLACE VIEW v_clase_resumen AS
SELECT
    c.nombre,
    c.duracion,
    c.clasificacion,
    COUNT(v.id_valoracion)::INTEGER AS numero_valoraciones,
    COALESCE(ROUND(AVG(v.puntuacion)::NUMERIC, 2), 0) AS puntuacion_media
FROM clase c
LEFT JOIN valorar v
    ON v.nombre_clase = c.nombre
GROUP BY c.nombre, c.duracion, c.clasificacion;

-- Vista para consultar sesiones junto con plazas totales, plazas ocupadas, plazas disponibles y % de ocupación.
CREATE OR REPLACE VIEW v_sesion_disponibilidad AS
SELECT
    s.id_sesion,
    s.id_sala,
    sa.nombre AS nombre_sala,
    s.nombre_clase,
    c.duracion,
    s.fecha_sesion,
    s.hora_inicio,
    COUNT(p.id_plaza)::INTEGER AS plazas_totales,
    COUNT(rp.id_plaza)::INTEGER AS plazas_ocupadas,
    (COUNT(p.id_plaza) - COUNT(rp.id_plaza))::INTEGER AS plazas_disponibles,
    COALESCE(
        ROUND(
            COUNT(rp.id_plaza)::NUMERIC * 100
            / NULLIF(COUNT(p.id_plaza), 0),
            2
        ),
        0.00
    ) AS porcentaje_ocupacion
FROM sesion s
JOIN sala sa
    ON sa.id_sala = s.id_sala
JOIN clase c
    ON c.nombre = s.nombre_clase
LEFT JOIN plaza p
    ON p.id_sala = s.id_sala
LEFT JOIN reserva_plaza rp
    ON rp.id_sesion = s.id_sesion
    AND rp.id_sala = p.id_sala
    AND rp.id_plaza = p.id_plaza
GROUP BY
    s.id_sesion,
    s.id_sala,
    sa.nombre,
    s.nombre_clase,
    c.duracion,
    s.fecha_sesion,
    s.hora_inicio;

COMMIT;