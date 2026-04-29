BEGIN;

-- DROP (orden inverso a dependencias)
DROP TABLE IF EXISTS reserva_plaza   CASCADE;
DROP TABLE IF EXISTS pedir_producto CASCADE;
DROP TABLE IF EXISTS valorar         CASCADE;
DROP TABLE IF EXISTS impartir        CASCADE;
DROP TABLE IF EXISTS trabajar        CASCADE;
DROP TABLE IF EXISTS plaza           CASCADE;
DROP TABLE IF EXISTS reserva         CASCADE;
DROP TABLE IF EXISTS sesion          CASCADE;
DROP TABLE IF EXISTS equipo          CASCADE;
DROP TABLE IF EXISTS clase           CASCADE;
DROP TABLE IF EXISTS producto        CASCADE;
DROP TABLE IF EXISTS sala            CASCADE;
DROP TABLE IF EXISTS limpieza        CASCADE;
DROP TABLE IF EXISTS monitor         CASCADE;
DROP TABLE IF EXISTS trabajador      CASCADE;
DROP TABLE IF EXISTS usuario         CASCADE;
DROP TABLE IF EXISTS auditoria_valoracion CASCADE;

DROP FUNCTION IF EXISTS fn_validar_reserva_plaza() CASCADE;

COMMIT;