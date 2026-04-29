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
('Pilates',  60, 'Suelo'),
('Yoga',     60, 'Mente-Cuerpo'),
('Spinning', 45, 'Cardio'),
('Zumba',    60, 'Baile'),
('Fuerza',   90, 'Musculacion');

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
INSERT INTO usuario (id_usuario, nombre, ap1, ap2, email, contrasena, tipo_usuario, fecha_nacimiento) VALUES
(1, 'Carmen', 'Nunez',  'Lopez', 'admin@gymfit.es',  '$2a$10$QWERTYUIOPasdfghjklZXCVBNMqwertyuiopASDFGHJKL12', 'ADMIN',  '1988-04-14'),
(2, 'Lucia',  'Perez',  'Moran', 'lucia@gymfit.es',  '$2a$10$abcdefghijklmnopqrstuvABCDEFGHIJKLMNOpqrstuvwxyz12', 'NORMAL', '1999-06-21'),
(3, 'Alvaro', 'Gomez',  'Rey',   'alvaro@gymfit.es', '$2a$10$1234567890abcdefghijklmnopqrstuvABCDEFGHIJKLMNO1234', 'NORMAL', '1997-11-03'),
(4, 'Irene',  'Castro', 'Vidal', 'irene@gymfit.es',  '$2a$10$ZYXWVUTSRQponmlkjihGFEDCBAzyxwvutsrqponmLKJIHGF34', 'NORMAL', '2001-01-30'),
(5, 'Diego',  'Suarez', 'Rios',  'diego@gymfit.es',  '$2a$10$mnbvcxzlkjhgfdsapoiuytrewqMNBVCXZLKJHGFDSAPOIUYT56', 'NORMAL', '1995-09-17'),
(6, 'Maria',  'Rañó',   'Myro',  'maria@gymfit.es',  '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','NORMAL','2005-06-15');

-- 9. SESIONES
INSERT INTO sesion (id_sesion, id_sala, nombre_clase, dni_monitor, fecha_sesion, hora_inicio) VALUES
-- Sala A (id_sala=1): Crossfit 45 min, Zumba 40 min
(1,  1, 'Crossfit', '44444444D', '2026-05-02', '08:00:00'),   -- 08:00–08:45
(2,  1, 'Zumba',    '11111111A', '2026-05-01', '19:00:00'),   -- 19:00–19:40
(3,  1, 'Crossfit', '44444444D', '2026-05-13', '14:00:00'),   -- 14:00–14:45
(4,  1, 'Zumba',    '11111111A', '2026-05-14', '19:00:00'),   -- 19:00–19:40

-- Sala C (id_sala=3): Yoga 60 min, Pilates 50 min
(5,  3, 'Yoga',     '33333333C', '2026-04-27', '09:00:00'),   -- 09:00–10:00
(6,  3, 'Pilates',  '33333333C', '2026-05-02', '10:00:00'),   -- 10:30–11:20
(7,  3, 'Yoga',     '33333333C', '2026-05-12', '18:00:00'),   -- 18:30–19:30
(8,  3, 'Pilates',  '33333333C', '2026-05-15', '09:00:00'),   -- 09:30–10:20

-- Sala D (id_sala=4): Spinning 45 min
(9,  4, 'Spinning', '22222222B', '2026-04-28', '07:00:00'),   -- 07:00–07:45
(10, 4, 'Spinning', '22222222B', '2026-05-13', '18:00:00'),   -- 18:30–19:15
(11, 4, 'Spinning', '22222222B', '2026-05-14', '07:00:00'),   -- 07:00–07:45

-- Sala B (id_sala=2): Fuerza 50 min
(12, 2, 'Fuerza',   '44444444D', '2026-05-01', '20:00:00'),   -- 20:00–20:50
(13, 2, 'Fuerza',   '44444444D', '2026-05-13', '20:00:00'),   -- 20:00–20:50
(14, 2, 'Fuerza',   '44444444D', '2026-05-14', '17:00:00');   -- 17:30–18:20

-- 10. PLAZAS (15 plazas por sala)
INSERT INTO plaza (id_plaza, id_sala) VALUES
(1,1),(2,1),(3,1),(4,1),(5,1),
(6,1),(7,1),(8,1),(9,1),(10,1),
(11,1),(12,1),(13,1),(14,1),(15,1),

(1,2),(2,2),(3,2),(4,2),(5,2),
(6,2),(7,2),(8,2),(9,2),(10,2),
(11,2),(12,2),(13,2),(14,2),(15,2),

(1,3),(2,3),(3,3),(4,3),(5,3),
(6,3),(7,3),(8,3),(9,3),(10,3),
(11,3),(12,3),(13,3),(14,3),(15,3),

(1,4),(2,4),(3,4),(4,4),(5,4),
(6,4),(7,4),(8,4),(9,4),(10,4),
(11,4),(12,4),(13,4),(14,4),(15,4),

(1,5),(2,5),(3,5),(4,5),(5,5),
(6,5),(7,5),(8,5),(9,5),(10,5),
(11,5),(12,5),(13,5),(14,5),(15,5);

-- 11. RESERVAS
INSERT INTO reserva (id_reserva, id_usuario, id_sesion, fecha_reserva) VALUES
(1, 2, 10, '2026-04-25'),   -- Lucia  → Spinning sala D sesion 10
(2, 6,  5, '2026-04-24'),   -- Maria  → Yoga     sala C sesion 5
(3, 4,  1, '2026-04-27'),   -- Irene  → Crossfit sala A sesion 1
(4, 5, 12, '2026-04-28'),   -- Diego  → Fuerza   sala B sesion 12
(5, 2,  6, '2026-04-29'),   -- Lucia  → Pilates  sala C sesion 6
(6, 3, 14, '2026-04-29'),   -- Alvaro → Fuerza   sala B sesion 14
(7, 6, 9,  '2026-04-25');   -- Maria  → Spinning sala D sesion 9

-- 12. ASIGNACIÓN DE PLAZAS A RESERVAS
INSERT INTO reserva_plaza (id_reserva, id_sesion, id_sala, id_plaza) VALUES
(1, 10, 4, 1),
(2,  5, 3, 1),
(3,  1, 1, 1),
(4, 12, 2, 1),
(5,  6, 3, 2),
(6, 14, 2, 2),
(7,  9, 4, 2);

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
('Crossfit', 2, '2026-05-03', 'Clase intensa y muy bien dirigida.',             5),
('Crossfit', 4, '2026-05-04', 'Buen ritmo, aunque exigente para principiantes.',4),
('Yoga',     3, '2026-05-01', 'Muy relajante y con buenas correcciones.',       5),
('Yoga',     2, '2026-05-02', 'Ambiente agradable y ejercicios bien explicados.',4),
('Pilates',  2, '2026-05-03', 'Trabajo de core muy completo.',                  4),
('Pilates',  5, '2026-05-04', 'Sesion ordenada y muy util para la postura.',    5),
('Spinning', 2, '2026-05-01', 'Mucha energia y buena musica.',                  5),
('Spinning', 3, '2026-05-02', 'Sesion intensa, sali reventado.',                4),
('Zumba',    6, '2026-05-02', 'Divertida y dinamica.',                          5),
('Fuerza',   5, '2026-05-02', 'Clase exigente y efectiva.',                     4),
('Fuerza',   3, '2026-05-03', 'Buen trabajo de fuerza y resistencia.',          4);

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