CREATE TABLE IF NOT EXISTS
    product (
    id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(255) NOT NULL,
   codigo VARCHAR(50) NOT NULL,
   stock INT NOT NULL
);

INSERT INTO product (nombre, codigo, stock) VALUES
('Manzana', 'MA001', 100),
('Arroz', 'AR002', 50),
('Pollo', 'PO003', 75),
('Leche', 'LE004', 200),
('Pan', 'PA005', 80),
('Papas', 'PA006', 120),
('Refresco', 'RE007', 150),
('Yogurt', 'YO008', 100),
('Jabón', 'JA009', 60),
('Pasta', 'PA010', 90);


CREATE TABLE  IF NOT EXISTS category (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(255) NOT NULL,
   descripcion VARCHAR(255) NOT NULL,
   codigo VARCHAR(50) NOT NULL
);
INSERT INTO category (nombre, descripcion, codigo) VALUES
('Frutas', 'Frutas frescas y de temporada', 'FR001'),
('Verduras', 'Verduras frescas y variadas', 'VR002'),
('Carnes', 'Carnes de res, cerdo y pollo', 'CA003'),
('Pescados', 'Pescados y mariscos', 'PE004'),
('Lácteos', 'Productos lácteos y derivados', 'LA005'),
('Panadería', 'Pan y productos horneados', 'PA006'),
('Bebidas', 'Bebidas refrescantes y jugos', 'BE007'),
('Snacks', 'Aperitivos y snacks', 'SN008'),
('Cereales', 'Cereales y granos', 'CE009'),
('Cuidado Personal', 'Productos de cuidado personal', 'CP010');

CREATE TABLE IF NOT EXISTS customer (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
telefono VARCHAR(20) NOT NULL,
direccion VARCHAR(255) NOT NULL
);

INSERT INTO customer (nombre, apellido, telefono, direccion) VALUES
('Ana', 'Gomez', '3001234567', 'Calle 1 La Victoria'),
('Carlos', 'Martinez', '3109876543', 'Carrera 2 Comuneros'),
('María', 'Rodríguez', '3152345678', 'Avenida 3 Motilones'),
('Javier', 'López', '3008765432', 'Calle 4 Carora'),
('Isabela', 'García', '3207654321', 'Carrera 5 San Martin'),
('Santiago', 'Ramírez', '3502345678', 'Avenida 6 San Luis'),
('Laura', 'Hernández', '3049876543', 'Calle 7 Los Almendros'),
('Daniel', 'Suarez', '3108765432', 'Carrera 8 El contento'),
('Valentina', 'Castro', '3217654321', 'Avenida 9 La Pastora'),
('Juan', 'Ortega', '3002345678', 'Calle 10 La Playa');



CREATE TABLE IF NOT EXISTS sale(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
fecha_generacion TIMESTAMP NOT NULL,
total DOUBLE NOT NULL
);

INSERT INTO sale (nombre, fecha_generacion, total) VALUES
('Venta 1', '2023-08-04 10:30:00', 150.50),
('Venta 2', '2023-08-04 11:15:00', 75.20),
('Venta 3', '2023-08-04 12:00:00', 220.00),
('Venta 4', '2023-08-04 13:45:00', 89.95),
('Venta 5', '2023-08-04 14:20:00', 45.60),
('Venta 6', '2023-08-04 15:10:00', 180.75),
('Venta 7', '2023-08-04 16:30:00', 99.99),
('Venta 8', '2023-08-04 17:15:00', 30.40),
('Venta 9', '2023-08-04 18:00:00', 75.60),
('Venta 10', '2023-08-04 19:20:00', 120.25);
