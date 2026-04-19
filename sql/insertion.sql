BEGIN;

-- 1. SALAS
INSERT INTO sala (id_sala, nombre) VALUES
(1, 'Sala A'),
(2, 'Sala B'),
(3, 'Sala C'),
(4, 'Sala D'),
(5, 'Sala E');

-- 2. TRABAJADORES
INSERT INTO trabajador (dni, nombre, ap1, ap2, cargo, sueldo) VALUES
('11111111A', 'Laura',  'Gomez',  'Ruiz',   'Monitor',  1800.00),
('22222222B', 'Daniel', 'Perez',  'Soto',   'Monitor',  1820.00),
('33333333C', 'Marta',  'Lopez',  'Castro', 'Monitor',  1750.00),
('44444444D', 'Sergio', 'Martin', 'Varela', 'Monitor',  1780.00),
('55555555E', 'Ana',    'Torres', 'Rey',    'Limpieza', 1450.00),
('66666666F', 'Pablo',  'Suarez', 'Gil',    'Limpieza', 1480.00);

INSERT INTO monitor (dni, especialidad) VALUES
('11111111A', 'Baile'),
('22222222B', 'Spinning'),
('33333333C', 'Yoga-Pilates'),
('44444444D', 'Funcional');

INSERT INTO limpieza (dni) VALUES
('55555555E'),
('66666666F');

-- 3. CLASES
INSERT INTO clase (nombre, duracion, clasificacion) VALUES
('Crossfit', 45, 'Funcional'),
('Pilates',  50, 'Suelo'),
('Yoga',     60, 'Mente-Cuerpo'),
('Spinning', 45, 'Cardio'),
('Zumba',    40, 'Baile'),
('Fuerza',   50, 'Musculacion');

-- 4. ASIGNACIÓN DE TRABAJADORES A SALAS
INSERT INTO trabajar (dni_trabajador, id_sala) VALUES
('11111111A', 1),
('22222222B', 4),
('33333333C', 3),
('44444444D', 1),
('44444444D', 2),
('44444444D', 5),
('55555555E', 1),
('55555555E', 2),
('55555555E', 3),
('66666666F', 4),
('66666666F', 5);

-- 5. IMPARTIR (Monitor, Sala, Clase)
INSERT INTO impartir (dni_monitor, id_sala, nombre_clase) VALUES
('33333333C', 3, 'Pilates'),
('33333333C', 3, 'Yoga'),
('22222222B', 4, 'Spinning'),
('44444444D', 1, 'Crossfit'),
('11111111A', 1, 'Zumba'),
('44444444D', 2, 'Fuerza');

-- 6. EQUIPAMIENTO
INSERT INTO equipo (id_maquina, id_sala, nombre, precio, fecha_adquisicion) VALUES
(1,  1, 'Rack funcional',         3200.00, '2024-01-10'),
(2,  1, 'Set de pesas rusas',      850.00, '2024-02-12'),
(3,  1, 'Caja pliometrica',        290.00, '2024-03-05'),
(4,  2, 'Prensa de pierna',       5400.00, '2023-11-20'),
(5,  2, 'Banco ajustable',         780.00, '2024-01-25'),
(6,  2, 'Mancuernas hexagonales', 1600.00, '2024-02-01'),
(7,  3, 'Colchonetas',             250.00, '2024-01-18'),
(8,  3, 'Bandas elasticas',        180.00, '2024-02-08'),
(9,  3, 'Fitball',                 420.00, '2024-03-14'),
(10, 4, 'Bicicleta indoor 1',     2100.00, '2024-01-30'),
(11, 4, 'Bicicleta indoor 2',     2100.00, '2024-01-30'),
(12, 4, 'Sistema de sonido',       990.00, '2024-02-20'),
(13, 5, 'Bicicleta de aire',      1750.00, '2024-02-15'),
(14, 5, 'Remo indoor',            1450.00, '2024-03-02'),
(15, 5, 'Cuerda de batalla',       160.00, '2024-03-18');

-- 7. PRODUCTOS
INSERT INTO producto (id_producto, nombre, descripcion, precio, stock_disponible) VALUES
(1, 'Botella de agua',     'Agua mineral 500 ml',              1.20, 100),
(2, 'Gatorade',            'Bebida isotonica sabor limon',     2.20,  60),
(3, 'Barrita proteica',    'Barrita de avena y proteina',      2.80,  40),
(4, 'Batido de proteinas', 'Batido listo para tomar',          3.50,  35),
(5, 'Toalla microfibra',   'Toalla ligera para entrenamiento', 9.90,  20),
(6, 'Guantes de gimnasio', 'Guantes para entrenamiento',      14.50,  15);

-- 8. USUARIOS
INSERT INTO usuario (id_usuario, nombre, ap1, ap2, email, contraseña, tipo_usuario, fecha_nacimiento) VALUES
(1, 'Carmen', 'Nunez',  'Lopez', 'admin@gymfit.es',  '$2a$10$QWERTYUIOPasdfghjklZXCVBNMqwertyuiopASDFGHJKL12', 'ADMIN',  '1988-04-14'),
(2, 'Lucia',  'Perez',  'Moran', 'lucia@gymfit.es',  '$2a$10$abcdefghijklmnopqrstuvABCDEFGHIJKLMNOpqrstuvwxyz12', 'NORMAL', '1999-06-21'),
(3, 'Alvaro', 'Gomez',  'Rey',   'alvaro@gymfit.es', '$2a$10$1234567890abcdefghijklmnopqrstuvABCDEFGHIJKLMNO1234', 'NORMAL', '1997-11-03'),
(4, 'Irene',  'Castro', 'Vidal', 'irene@gymfit.es',  '$2a$10$ZYXWVUTSRQponmlkjihGFEDCBAzyxwvutsrqponmLKJIHGF34', 'NORMAL', '2001-01-30'),
(5, 'Diego',  'Suarez', 'Rios',  'diego@gymfit.es',  '$2a$10$mnbvcxzlkjhgfdsapoiuytrewqMNBVCXZLKJHGFDSAPOIUYT56', 'NORMAL', '1995-09-17');

-- 9. SESIONES
INSERT INTO sesion (id_sesion, id_sala, nombre_clase, fecha_sesion, hora_inicio) VALUES
-- Sala A (id_sala=1): Crossfit 45 min, Zumba 40 min
(1,  1, 'Crossfit', '2026-05-05', '08:00:00'),   -- 08:00–08:45
(2,  1, 'Zumba',    '2026-05-05', '19:00:00'),   -- 19:00–19:40
(3,  1, 'Crossfit', '2026-05-06', '18:00:00'),   -- 18:00–18:45
(4,  1, 'Zumba',    '2026-05-07', '19:00:00'),   -- 19:00–19:40

-- Sala C (id_sala=3): Yoga 60 min, Pilates 50 min
(5,  3, 'Yoga',     '2026-05-05', '09:00:00'),   -- 09:00–10:00
(6,  3, 'Pilates',  '2026-05-05', '10:30:00'),   -- 10:30–11:20 ✓ no hay solape
(7,  3, 'Yoga',     '2026-05-06', '18:30:00'),   -- 18:30–19:30
(8,  3, 'Pilates',  '2026-05-07', '09:30:00'),   -- 09:30–10:20

-- Sala D (id_sala=4): Spinning 45 min
(9,  4, 'Spinning', '2026-05-05', '07:00:00'),   -- 07:00–07:45
(10, 4, 'Spinning', '2026-05-05', '18:30:00'),   -- 18:30–19:15 ✓ no hay solape
(11, 4, 'Spinning', '2026-05-06', '07:00:00'),   -- 07:00–07:45

-- Sala B (id_sala=2): Fuerza 50 min
(12, 2, 'Fuerza',   '2026-05-05', '20:00:00'),   -- 20:00–20:50
(13, 2, 'Fuerza',   '2026-05-06', '20:00:00'),   -- 20:00–20:50
(14, 2, 'Fuerza',   '2026-05-07', '17:30:00');   -- 17:30–18:20

-- 10. PLAZAS (15 plazas por sala, id_reserva = NULL => libre)
INSERT INTO plaza (id_plaza, id_sala, id_reserva) VALUES
(1,1,NULL),(2,1,NULL),(3,1,NULL),(4,1,NULL),(5,1,NULL),
(6,1,NULL),(7,1,NULL),(8,1,NULL),(9,1,NULL),(10,1,NULL),
(11,1,NULL),(12,1,NULL),(13,1,NULL),(14,1,NULL),(15,1,NULL),

(1,2,NULL),(2,2,NULL),(3,2,NULL),(4,2,NULL),(5,2,NULL),
(6,2,NULL),(7,2,NULL),(8,2,NULL),(9,2,NULL),(10,2,NULL),
(11,2,NULL),(12,2,NULL),(13,2,NULL),(14,2,NULL),(15,2,NULL),

(1,3,NULL),(2,3,NULL),(3,3,NULL),(4,3,NULL),(5,3,NULL),
(6,3,NULL),(7,3,NULL),(8,3,NULL),(9,3,NULL),(10,3,NULL),
(11,3,NULL),(12,3,NULL),(13,3,NULL),(14,3,NULL),(15,3,NULL),

(1,4,NULL),(2,4,NULL),(3,4,NULL),(4,4,NULL),(5,4,NULL),
(6,4,NULL),(7,4,NULL),(8,4,NULL),(9,4,NULL),(10,4,NULL),
(11,4,NULL),(12,4,NULL),(13,4,NULL),(14,4,NULL),(15,4,NULL),

(1,5,NULL),(2,5,NULL),(3,5,NULL),(4,5,NULL),(5,5,NULL),
(6,5,NULL),(7,5,NULL),(8,5,NULL),(9,5,NULL),(10,5,NULL),
(11,5,NULL),(12,5,NULL),(13,5,NULL),(14,5,NULL),(15,5,NULL);

-- 11. RESERVAS
INSERT INTO reserva (id_reserva, id_usuario, id_sesion, fecha_reserva) VALUES
(1, 2, 10, '2026-04-25'),   -- Lucia  → Spinning sala D sesion 10
(2, 3,  5, '2026-04-26'),   -- Alvaro → Yoga    sala C sesion 5
(3, 4,  1, '2026-04-27'),   -- Irene  → Crossfit sala A sesion 1
(4, 5, 12, '2026-04-28'),   -- Diego  → Fuerza  sala B sesion 12
(5, 2,  6, '2026-04-29'),   -- Lucia  → Pilates sala C sesion 6
(6, 3, 14, '2026-04-30');   -- Alvaro → Fuerza  sala B sesion 14

-- 12. ASIGNACIÓN DE PLAZAS A RESERVAS
-- Reserva 1 (Lucia, sesion 10, sala D=4): plazas 1 y 2
UPDATE plaza SET id_reserva = 1 WHERE id_sala = 4 AND id_plaza IN (1, 2);

-- Reserva 2 (Alvaro, sesion 5, sala C=3): plaza 1
UPDATE plaza SET id_reserva = 2 WHERE id_sala = 3 AND id_plaza = 1;

-- Reserva 3 (Irene, sesion 1, sala A=1): plazas 1, 2 y 3
UPDATE plaza SET id_reserva = 3 WHERE id_sala = 1 AND id_plaza IN (1, 2, 3);

-- Reserva 4 (Diego, sesion 12, sala B=2): plaza 1
UPDATE plaza SET id_reserva = 4 WHERE id_sala = 2 AND id_plaza = 1;

-- Reserva 5 (Lucia, sesion 6, sala C=3): plazas 2 y 3
UPDATE plaza SET id_reserva = 5 WHERE id_sala = 3 AND id_plaza IN (2, 3);

-- Reserva 6 (Alvaro, sesion 14, sala B=2): plazas 2 y 3 (plaza 1 ya ocupada por reserva 4)
UPDATE plaza SET id_reserva = 6 WHERE id_sala = 2 AND id_plaza IN (2, 3);

-- 13. PEDIDOS DE PRODUCTOS
INSERT INTO pedir_producto (id_usuario, id_producto, fecha, hora, cantidad, entregado) VALUES
(2, 1, '2026-04-20', '10:15:00', 2, TRUE),
(2, 4, '2026-04-25', '18:05:00', 1, FALSE),
(3, 3, '2026-04-26', '09:30:00', 3, FALSE),
(4, 2, '2026-04-28', '17:45:00', 2, TRUE),
(5, 6, '2026-04-30', '19:10:00', 1, FALSE),
(5, 1, '2026-04-30', '19:12:00', 1, TRUE);

-- 14. VALORACIONES
INSERT INTO valorar (nombre_clase, id_usuario, fecha, opinion, puntuacion) VALUES
('Crossfit', 2, '2026-04-01', 'Clase intensa y muy bien dirigida.',             5),
('Crossfit', 4, '2026-04-02', 'Buen ritmo, aunque exigente para principiantes.',4),
('Yoga',     3, '2026-04-03', 'Muy relajante y con buenas correcciones.',       5),
('Yoga',     2, '2026-04-04', 'Ambiente agradable y ejercicios bien explicados.',4),
('Pilates',  2, '2026-04-05', 'Trabajo de core muy completo.',                  4),
('Pilates',  5, '2026-04-06', 'Sesion ordenada y muy util para la postura.',    5),
('Spinning', 2, '2026-04-07', 'Mucha energia y buena musica.',                  5),
('Spinning', 3, '2026-04-08', 'Sesion intensa, sali reventado.',                4),
('Zumba',    4, '2026-04-09', 'Divertida y dinamica.',                          5),
('Fuerza',   5, '2026-04-10', 'Clase exigente y efectiva.',                     4),
('Fuerza',   3, '2026-04-11', 'Buen trabajo de fuerza y resistencia.',          4),
('Fuerza',   3, '2026-04-12', 'De las mejores clases de la semana.',            5);

-- 15. AJUSTE DE SECUENCIAS IDENTITY
SELECT setval(pg_get_serial_sequence('sala',     'id_sala'),
              COALESCE((SELECT MAX(id_sala)     FROM sala),     1), true);
SELECT setval(pg_get_serial_sequence('usuario',  'id_usuario'),
              COALESCE((SELECT MAX(id_usuario)  FROM usuario),  1), true);
SELECT setval(pg_get_serial_sequence('producto', 'id_producto'),
              COALESCE((SELECT MAX(id_producto) FROM producto), 1), true);
SELECT setval(pg_get_serial_sequence('sesion',   'id_sesion'),
              COALESCE((SELECT MAX(id_sesion)   FROM sesion),   1), true);
SELECT setval(pg_get_serial_sequence('reserva',  'id_reserva'),
              COALESCE((SELECT MAX(id_reserva)  FROM reserva),  1), true);
SELECT setval(pg_get_serial_sequence('equipo',   'id_maquina'),
              COALESCE((SELECT MAX(id_maquina)  FROM equipo),   1), true);

COMMIT;