-- Active: 1718856057277@@127.0.0.1@3306@bd_sistema_ventas

use bd_sistema_ventas;
-- 3 proovedores para cada producto
INSERT INTO tb_proveedor (empresa, proveedor, telefono, direccion, email, productoSum, estado, observaciones) VALUES
('Tech Bolivia SRL', 'Juan Pérez', '+59112345678', 'Av. Arce #123, La Paz, Bolivia', 'juan@techbolivia.com', 'COMPUTADORA', 'ACTIVO', ''),
('ByteLatam SA', 'María López', '+59145678901', 'Calle Potosí #456, La Paz, Bolivia', 'maria@bytelatam.com', 'COMPUTADORA', 'ACTIVO', ''),
('SistemasAndes Ltda.', 'Pablo González', '+59178901234', 'Av. Ballivián #789, La Paz, Bolivia', 'pablo@sistemasandes.com', 'COMPUTADORA', 'ACTIVO', ''),
('LaptopWorld Ltda.', 'Martín Ramírez', '+59132165487', 'Calle Murillo #321, La Paz, Bolivia', 'martin@laptopworld.com', 'LAPTOP', 'ACTIVO', ''),
('ElectroComputadoras SRL', 'Ana Silva', '+59165498732', 'Av. Mariscal Santa Cruz #654, La Paz, Bolivia', 'ana@electrocomputadoras.com', 'LAPTOP', 'ACTIVO', ''),
('TecnologíaAndina SA', 'Diego Torres', '+59198765432', 'Calle Sagárnaga #987, La Paz, Bolivia', 'diego@tecnologiaandina.com', 'LAPTOP', 'ACTIVO', ''),
('ComponentesBolivia SA', 'Carla Mendoza', '+59110123456', 'Av. 6 de Agosto #101, La Paz, Bolivia', 'carla@componentesbolivia.com', 'COMPONENTES', 'ACTIVO', ''),
('TecnoPartes Ltda.', 'Pedro García', '+59156789012', 'Calle Landaeta #567, La Paz, Bolivia', 'pedro@tecnoPartes.com', 'COMPONENTES', 'ACTIVO', ''),
('InnovaciónElectrónica SA', 'Laura López', '+59187654321', 'Av. Camacho #876, La Paz, Bolivia', 'laura@innovacionelectronica.com', 'COMPONENTES', 'ACTIVO', ''),
('AccesoriosBolivia SA', 'José Rodríguez', '+59123456789', 'Av. 16 de Julio #234, La Paz, Bolivia', 'jose@accesoriosbolivia.com', 'ACCESORIOS', 'ACTIVO', ''),
('GadgetsAndes SRL', 'Sofía Martínez', '+59134567890', 'Calle Illampu #345, La Paz, Bolivia', 'sofia@gadgetsandes.com', 'ACCESORIOS', 'ACTIVO', ''),
('InnovaciónAccesorios Ltda.', 'Andrés López', '+59178901234', 'Av. Buenos Aires #789, La Paz, Bolivia', 'andres@innovacionaccesorios.com', 'ACCESORIOS', 'ACTIVO', '');

INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES ('C001', 'Tarjeta de Video', 'Nvidia', 'RTX 3080', '8GB', '2000MHz', 'Tarjeta gráfica de alta gama para gaming.');

INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES ('C002', 'Procesador', 'Intel', 'Core i9-10900K', '10 núcleos', '3.7GHz', 'Procesador de alto rendimiento para tareas exigentes.');

INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES ('C003', 'Memoria RAM', 'Corsair', 'Vengeance RGB Pro', '16GB', '3200MHz', 'Módulo de memoria RAM DDR4 con iluminación RGB.');

INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES ('C004', 'Disco Duro', 'Samsung', '970 EVO Plus', '1TB', '3500MB/s', 'Unidad de almacenamiento SSD NVMe de alta velocidad.');

INSERT INTO tb_laptop (claveLaptop, nombre, marca, modelo, procesador, memoriaRam, almacenamiento, conectividad, tarjetaGrafica, pantalla, bateria, descripcion)
VALUES ('L001', 'Laptop Gaming', 'MSI', 'GS66 Stealth', 'Intel Core i7-10750H', '16GB DDR4', '1TB SSD', 'WiFi 6, Bluetooth 5.1', 'Nvidia GeForce RTX 3070', '15.6" Full HD 240Hz', '99.9Wh', 'Laptop de alto rendimiento para juegos.');

INSERT INTO tb_laptop (claveLaptop, nombre, marca, modelo, procesador, memoriaRam, almacenamiento, conectividad, tarjetaGrafica, pantalla, bateria, descripcion)
VALUES ('L002', 'Laptop Ultrabook', 'Dell', 'XPS 13', 'Intel Core i5-1135G7', '8GB LPDDR4x', '512GB PCIe SSD', 'WiFi 6, Bluetooth 5.1', 'Intel Iris Xe Graphics', '13.4" 4K InfinityEdge', '52Wh', 'Laptop ligera y potente para trabajo y entretenimiento.');

INSERT INTO tb_laptop (claveLaptop, nombre, marca, modelo, procesador, memoriaRam, almacenamiento, conectividad, tarjetaGrafica, pantalla, bateria, descripcion)
VALUES ('L003', 'Laptop Convertible', 'HP', 'Spectre x360', 'Intel Core i7-1165G7', '16GB DDR4', '1TB PCIe SSD', 'WiFi 6, Bluetooth 5.0', 'Intel Iris Xe Graphics', '13.3" Full HD Touch', '60Wh', 'Laptop versátil con pantalla táctil convertible.');

INSERT INTO tb_accesorios (claveAccesorio, nombre, marca, modelo, descripcion)
VALUES ('A001', 'Mouse Gaming', 'Logitech', 'G502 Hero', 'Mouse con sensor óptico de alta precisión para gaming.');

INSERT INTO tb_accesorios (claveAccesorio, nombre, marca, modelo, descripcion)
VALUES ('A002', 'Teclado Mecánico', 'Razer', 'BlackWidow Elite', 'Teclado mecánico con retroiluminación RGB personalizable.');

INSERT INTO tb_accesorios (claveAccesorio, nombre, marca, modelo, descripcion)
VALUES ('A003', 'Auriculares Inalámbricos', 'Sony', 'WH-1000XM4', 'Auriculares con cancelación de ruido y sonido de alta resolución.');

-- Placa Base (Motherboard)
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('PL001', 'Placa Base', 'ASUS', 'ROG STRIX Z390-F', NULL, NULL, 'Placa base para juegos de alto rendimiento.'),
('PL002', 'Placa Base', 'Gigabyte', 'B450 AORUS ELITE', NULL, NULL, 'Placa base para una configuración de nivel medio.'),
('PL003', 'Placa Base', 'MSI', 'MAG B550 TOMAHAWK', NULL, NULL, 'Placa base con soporte para los últimos procesadores Ryzen de AMD.');
-- Procesador (CPU)
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('P001', 'Procesador (CPU)', 'Intel', 'Core i7-9700K', '8 núcleos', '3.6GHz', 'Procesador de 9ª generación para tareas intensivas.'),
('P002', 'Procesador (CPU)', 'AMD', 'Ryzen 7 5800X', '8 núcleos', '3.8GHz', 'Procesador de la serie Ryzen 5000 con alto rendimiento en juegos y aplicaciones.'),
('P003', 'Procesador (CPU)', 'Intel', 'Core i9-9900K', '8 núcleos', '3.6GHz', 'Procesador de 9ª generación con rendimiento extremadamente alto y capacidad de overclocking.');

-- Memoria RAM
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('M001', 'Memoria RAM', 'Corsair', 'Vengeance LPX', '8 GB', 'DDR5-6400 MHz', 'Memoria RAM de 8GB DDR5 para una excelente multitarea.'),
('M002', 'Memoria RAM', 'Kingston', 'HyperX Fury', '16 GB', 'DDR4-3200 MHz', 'Memoria RAM de 16GB DDR4 para un rendimiento rápido y estable.'),
('M003', 'Memoria RAM', 'Crucial', 'Ballistix Sport', '32 GB', 'DDR4-3600 MHz', 'Memoria RAM de 32GB DDR4 para una experiencia de juego fluida y multitarea.');

-- Almacenamiento HDD
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('AL004', 'Almacenamiento HDD', 'Seagate', 'Barracuda', '1 TB', '5400 RPM', 'Disco duro de 1TB para almacenamiento.'),
('AL005', 'Almacenamiento HDD', 'Western Digital', 'Blue', '2 TB', '7200 RPM', 'Disco duro de 2TB para almacenar una gran cantidad de datos.'),
('AL006', 'Almacenamiento HDD', 'Toshiba', 'P300', '4 TB', '5400 RPM', 'Disco duro de 4TB para almacenamiento masivo y respaldo de datos.');

-- Almacenamiento SSDtb_usuario
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C007', 'Almacenamiento SSD', 'Samsung', '970 EVO', '500 GB', 'SATA SSD - 300 MB/s a 400 MB/s', 'SSD de 500GB con velocidades de lectura/escritura rápidas.'),
('C008', 'Almacenamiento SSD', 'Crucial', 'MX500', '1 TB', 'SATA SSD - 500 MB/s a 600 MB/s', 'SSD de 1TB con excelente rendimiento y confiabilidad.'),
('C009', 'Almacenamiento SSD', 'Western Digital', 'Blue SN550', '250 GB', 'NVMe M.2 - NVMe PCIe Gen3 x4', 'SSD NVMe de 250GB para una experiencia de carga rápida de aplicaciones y juegos.');

-- Tarjeta grafica (GPU)
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C010', 'Tarjeta grafica (GPU)', 'NVIDIA', 'GeForce RTX 2080', NULL, NULL, 'Tarjeta gráfica de gama alta para juegos exigentes.'),
('C011', 'Tarjeta grafica (GPU)', 'AMD', 'Radeon RX 6800 XT', NULL, NULL, 'Tarjeta gráfica de la serie Radeon RX 6000 para juegos de alta gama y rendimiento 4K.'),
('C012', 'Tarjeta grafica (GPU)', 'NVIDIA', 'GeForce GTX 1660 Super', NULL, NULL, 'Tarjeta gráfica de gama media con excelente rendimiento en juegos.');

-- Fuente Alimentacion
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C013', 'Fuente Alimentacion', 'Corsair', 'RM750X', NULL, NULL, 'Fuente de alimentación modular de alta eficiencia.'),
('C014', 'Fuente Alimentacion', 'EVGA', 'SuperNOVA 650 G5', NULL, NULL, 'Fuente de alimentación completamente modular con certificación 80 PLUS Gold.'),
('C015', 'Fuente Alimentacion', 'Seasonic', 'Focus GX-850', NULL, NULL, 'Fuente de alimentación de alta gama con ventilador de rodamiento fluido y modo híbrido.');

-- Monitor
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C016', 'Monitor', 'ASUS', 'VG248QE', NULL, NULL, 'Monitor de 24" con alta tasa de refresco para juegos.'),
('C017', 'Monitor', 'Acer', 'Nitro XV240Y', NULL, NULL, 'Monitor de 23.8" con panel IPS y tecnología AMD FreeSync para una experiencia de juego suave.'),
('C018', 'Monitor', 'LG', '27GL83A-B', NULL, NULL, 'Monitor de 27" con panel Nano IPS y una alta tasa de refresco para juegos competitivos.');

-- Case
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C019', 'Case', 'NZXT', 'H510', NULL, NULL, 'Case elegante con excelente gestión de cables.'),
('C020', 'Case', 'Corsair', 'Crystal 570X RGB', NULL, NULL, 'Case con paneles de vidrio templado y efectos de iluminación RGB personalizables.'),
('C021', 'Case', 'Cooler Master', 'MasterBox MB511', NULL, NULL, 'Case de diseño minimalista con amplio espacio para componentes de alta gama.');

-- Disipador
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C022', 'Disipador', 'Cooler Master', 'Hyper 212 EVO', NULL, NULL, 'Disipador de calor de bajo perfil para CPU.'),
('C023', 'Disipador', 'Noctua', 'NH-D15', NULL, NULL, 'Disipador de doble torre con excelentes capacidades de enfriamiento.'),
('C024', 'Disipador', 'be quiet!', 'Dark Rock Pro 4', NULL, NULL, 'Disipador de alto rendimiento con diseño asimétrico y ventiladores silenciosos.');

-- Ventiladores
INSERT INTO tb_componente (claveComponente, nombre, marca, modelo, capacidad, velocidad, descripcion)
VALUES 
('C025', 'Ventiladores', 'Corsair', 'AF120', NULL, NULL, 'Ventiladores de alto flujo de aire para una buena refrigeración.'),
('C026', 'Ventiladores', 'NZXT', 'AER RGB 2', NULL, NULL, 'Ventiladores de alta calidad con iluminación RGB personalizable.'),
('C027', 'Ventiladores', 'Noctua', 'NF-F12', NULL, NULL, 'Ventiladores de alta eficiencia y bajo ruido para un enfriamiento silencioso.');

-- DDL Ventas
-- 50 datos
INSERT INTO tb_cliente (nombre, apellido, correoElectronico, telefono, departamento, direccion, estado) VALUES
('Carlos', 'Perez', 'cperez@gmail.com', '75234567', 'La Paz', 'Av. 16 de Julio 456', 'Inactivo'),
('Laura', 'Gonzalez', 'lgonzalez@hotmail.com', '76234567', 'La Paz', 'Calle Comercio 123', 'Activo'),
('Jose', 'Ramirez', 'jramirez@yahoo.com', '77234567', 'La Paz', 'Av. Buenos Aires 789', 'Activo'),
('Elena', 'Martinez', 'emartinez@gmail.com', '78234567', 'La Paz', 'Calle Sagarnaga 321', 'Inactivo'),
('Miguel', 'Rodriguez', 'mrodriguez@hotmail.com', '79234567', 'La Paz', 'Av. Mariscal Santa Cruz 987', 'Activo'),
('Sofia', 'Lopez', 'slopez@gmail.com', '60234567', 'El Alto', 'Calle 1 456', 'Activo'),
('Luis', 'Mendoza', 'lmendoza@yahoo.com', '61234568', 'El Alto', 'Av. 6 de Marzo 123', 'Activo'),
('Lucia', 'Gutierrez', 'lgutierrez@hotmail.com', '62234567', 'El Alto', 'Calle 2 789', 'Inactivo'),
('Andres', 'Gomez', 'agomez@gmail.com', '63234567', 'El Alto', 'Av. Juan Pablo II 321', 'Activo'),
('Carmen', 'Diaz', 'cdiaz@hotmail.com', '64234567', 'El Alto', 'Calle 3 987', 'Activo'),
('Ricardo', 'Fernandez', 'rfernandez@gmail.com', '65234567', 'El Alto', 'Av. Litoral 456', 'Inactivo'),
('Valeria', 'Castro', 'vcastro@yahoo.com', '66234567', 'El Alto', 'Calle 4 123', 'Activo'),
('Daniel', 'Rojas', 'drojas@gmail.com', '67234567', 'El Alto', 'Av. Panoramica 789', 'Activo'),
('Natalia', 'Ruiz', 'nruiz@hotmail.com', '68234567', 'El Alto', 'Calle 5 321', 'Inactivo'),
('Sergio', 'Molina', 'smolina@gmail.com', '69234567', 'El Alto', 'Av. Bolivia 987', 'Activo'),
('Veronica', 'Navarro', 'vnavarro@gmail.com', '70234567', 'La Paz', 'Calle Potosi 456', 'Activo'),
('Roberto', 'Solis', 'rsolis@hotmail.com', '71234568', 'La Paz', 'Av. Armentia 123', 'Activo'),
('Paula', 'Alvarez', 'palvarez@yahoo.com', '72234568', 'La Paz', 'Calle Illampu 789', 'Inactivo'),
('Alberto', 'Cruz', 'acruz@gmail.com', '73234568', 'La Paz', 'Av. Villazon 321', 'Activo'),
('Teresa', 'Herrera', 'therrera@hotmail.com', '74234568', 'La Paz', 'Calle Loayza 987', 'Activo'),
('Gustavo', 'Torres', 'gtorres@gmail.com', '75234568', 'La Paz', 'Av. 6 de Agosto 456', 'Inactivo'),
('Julia', 'Suarez', 'jsuarez@yahoo.com', '76234568', 'La Paz', 'Calle Jaen 123', 'Activo'),
('Felipe', 'Vega', 'fvega@gmail.com', '77234568', 'La Paz', 'Av. Villarroel 789', 'Activo'),
('Isabel', 'Romero', 'iromero@hotmail.com', '78234568', 'La Paz', 'Calle Colon 321', 'Inactivo'),
('Pablo', 'Chavez', 'pchavez@gmail.com', '79234568', 'La Paz', 'Av. Saavedra 987', 'Activo'),
('Luz', 'Ortiz', 'lortiz@gmail.com', '60234568', 'El Alto', 'Calle 6 456', 'Activo'),
('David', 'Soto', 'dsoto@hotmail.com', '61234569', 'El Alto', 'Av. Tiahuanaco 123', 'Activo'),
('Rosa', 'Espinoza', 'respinoza@yahoo.com', '62234568', 'El Alto', 'Calle 7 789', 'Inactivo'),
('Oscar', 'Reyes', 'oreyes@gmail.com', '63234568', 'El Alto', 'Av. Costanera 321', 'Activo'),
('Patricia', 'Campos', 'pcampos@hotmail.com', '64234568', 'El Alto', 'Calle 8 987', 'Activo'),
('Hector', 'Rivas', 'hrivas@gmail.com', '65234568', 'El Alto', 'Av. 16 de Julio 456', 'Inactivo'),
('Marta', 'Figueroa', 'mfigueroa@yahoo.com', '66234568', 'El Alto', 'Calle 9 123', 'Activo'),
('Edgar', 'Aguirre', 'eaguirre@gmail.com', '67234568', 'El Alto', 'Av. Ferroviaria 789', 'Activo'),
('Flor', 'Serrano', 'fserrano@hotmail.com', '68234568', 'El Alto', 'Calle 10 321', 'Inactivo'),
('Martin', 'Delgado', 'mdelgado@gmail.com', '69234568', 'El Alto', 'Av. Aeropuerto 987', 'Activo'),
('Andrea', 'Mendez', 'amendez@gmail.com', '70234568', 'La Paz', 'Calle Mercado 456', 'Activo'),
('Manuel', 'Vera', 'mvera@hotmail.com', '71234569', 'La Paz', 'Av. Perez Velasco 123', 'Activo'),
('Carla', 'Cabrera', 'ccabrera@yahoo.com', '72234569', 'La Paz', 'Calle Landaeta 789', 'Inactivo'),
('Victor', 'Paredes', 'vparedes@gmail.com', '73234569', 'La Paz', 'Av. Peru 321', 'Activo'),
('Elisa', 'Campos', 'ecampos@hotmail.com', '74234569', 'La Paz', 'Calle Montevideo 987', 'Activo'),
('Renato', 'Jimenez', 'rjimenez@gmail.com', '75234569', 'La Paz', 'Av. Sucre 456', 'Inactivo'),
('Antonia', 'Salazar', 'asalazar@yahoo.com', '76234569', 'La Paz', 'Calle Calama 123', 'Activo'),
('Francisco', 'Miranda', 'fmiranda@gmail.com', '77234569', 'La Paz', 'Av. Ecuador 789', 'Activo'),
('Margarita', 'Lara', 'mlara@hotmail.com', '78234569', 'La Paz', 'Calle Colon 321', 'Inactivo'),
('Raul', 'Ramon', 'rramon@gmail.com', '79234569', 'La Paz', 'Av. Montes 987', 'Activo');
