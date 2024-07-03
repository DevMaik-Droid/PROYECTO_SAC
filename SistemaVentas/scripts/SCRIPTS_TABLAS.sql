-- Active: 1714257401294@@127.0.0.1@3306@bd_sistema_ventas
-- crear nuestra base de datos

create database bd_sistema_ventas;
-- usamos la base de datos
use bd_sistema_ventas;

-- tabla usuarios
CREATE TABLE tb_usuario (
    idUsuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    ci VARCHAR(20) NOT NULL,  -- Se aumentó la longitud para contemplar diferentes formatos de CI
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    usuario VARCHAR(15) NOT NULL,
    contrasenia VARCHAR(255) NOT NULL,  -- Se aumentó la longitud de la contraseña
    foto BLOB NOT NULL,
    clave VARCHAR(10) NOT NULL,
    estado VARCHAR(20) NOT NULL, 
    observaciones TEXT,
		nivel VARCHAR(15)
);

-- TABLA PROVEEDOR
CREATE TABLE tb_proveedor(
	idProveedor BIGINT AUTO_INCREMENT PRIMARY KEY,
  empresa VARCHAR(100),
	proveedor VARCHAR(100),
	telefono VARCHAR(20),
	direccion VARCHAR(100),
	email VARCHAR(100),
	productoSum VARCHAR(50),
	estado VARCHAR(10),
	observaciones TEXT,
  fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- DDL COMPONENTES:
CREATE TABLE tb_componente(
	idc int auto_increment PRIMARY KEY,
	claveComponente VARCHAR(10),
	nombre VARCHAR(100),
	marca VARCHAR(100),
	modelo VARCHAR(100),
	capacidad VARCHAR(20),
	velocidad VARCHAR(50),
	imagen BLOB,
	descripcion TEXT,
	fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  idProveedor BIGINT,
  CONSTRAINT fk_cidProveedor FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor)

);

CREATE TABLE tb_laptop(
	idLaptop int auto_increment PRIMARY KEY,
	claveLaptop VARCHAR(10),
	nombre VARCHAR(100),
	marca VARCHAR(100),
	modelo VARCHAR(100),
	procesador VARCHAR(100),
	memoriaRam VARCHAR(100),
	almacenamiento VARCHAR(100),
	conectividad VARCHAR(100),
	tarjetaGrafica VARCHAR(100),
	pantalla VARCHAR(100),
	bateria VARCHAR(100),
	imagen BLOB,
	descripcion TEXT,
	fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP


);

CREATE TABLE tb_accesorios (
	IdAccesorio INT auto_increment PRIMARY KEY,
	claveAccesorio VARCHAR(10),
	nombre VARCHAR(50),
	marca VARCHAR(50),
	modelo VARCHAR(50),
	imagen BLOB,
	descripcion VARCHAR(100),
	fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_claveComponente ON tb_componente (claveComponente);

CREATE TABLE tb_computadora(
    idComputadora INT AUTO_INCREMENT PRIMARY KEY,
    claveComputadora VARCHAR(10),
    nombre VARCHAR(100),
    procesador VARCHAR(50),
    placaMadre VARCHAR(50),
    memoriaRam VARCHAR(50),
    almacenamiento VARCHAR(50),
    tarjetaGrafica VARCHAR(50),
    fuente VARCHAR(50),
    ccase VARCHAR(50),
    monitor VARCHAR(50),
    disipadores VARCHAR(50),
    ventiladores VARCHAR(50),
    imagen BLOB,
    precioReal DECIMAL(10, 2),
    descripcion TEXT,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_procesador FOREIGN KEY (procesador) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_placaMadre FOREIGN KEY (placaMadre) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_memoriaRam FOREIGN KEY (memoriaRam) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_almacenamiento FOREIGN KEY (almacenamiento) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_tarjetaGrafica FOREIGN KEY (tarjetaGrafica) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_fuente FOREIGN KEY (fuente) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_ccase FOREIGN KEY (ccase) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_monitor FOREIGN KEY (monitor) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_disipadores FOREIGN KEY (disipadores) REFERENCES tb_componente(claveComponente),
    CONSTRAINT fk_ventiladores FOREIGN KEY (ventiladores) REFERENCES tb_componente(claveComponente)
);

CREATE TABLE tb_productos(
	idp BIGINT AUTO_INCREMENT PRIMARY KEY,
	claveProducto VARCHAR(10),
	nombreProducto VARCHAR(100),
	categoriaProducto VARCHAR(50),
	precioUnitario DECIMAL(10, 2),
	stock INTEGER,
	precioTotal DECIMAL(10, 2),
	disponibilidad VARCHAR(50) DEFAULT 'DISPONIBLE',
	idProveedor BIGINT,
	idUsuario BIGINT,
	detalle TEXT,
	fechaModificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_Proveedor FOREIGN KEY(idProveedor) REFERENCES tb_proveedor(idProveedor),
	CONSTRAINT fk_Usuario FOREIGN KEY(idUsuario) REFERENCES tb_usuario(idUsuario)
);

CREATE TABLE tb_cliente (
    idCliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correoElectronico VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    departamento VARCHAR(50),
    direccion VARCHAR(100),
    estado VARCHAR(10)
);

CREATE TABLE tb_ventas (
    idVenta BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad DECIMAL(10, 2) NOT NULL,
    precioUnitario DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    metodoPago VARCHAR(50),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idCliente BIGINT,
    idProducto BIGINT,
    idUsuario BIGINT,
    CONSTRAINT fk_Vcliente FOREIGN KEY (idCliente) REFERENCES tb_cliente(idCliente),
    CONSTRAINT fk_Vproducto FOREIGN KEY (idProducto) REFERENCES tb_productos(idp),
    CONSTRAINT fk_Vusuario FOREIGN KEY (idUsuario) REFERENCES tb_usuario(idUsuario)
);

CREATE TABLE tb_factura (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    idVenta BIGINT,
    subTotal DECIMAL(10, 2) NOT NULL,
    impuestos DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    numeroFactura VARCHAR(50) UNIQUE NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_Fventa  FOREIGN KEY (idVenta) REFERENCES tb_ventas(idVenta)
);

CREATE TABLE tb_htransacciones(
  idTransaccion BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombreProducto VARCHAR(100),
  cantidad INTEGER,
  montoTotal DOUBLE,
  montoPagado DOUBLE,
  tipoPago VARCHAR(50),
  estadoPago VARCHAR(50),
  observaciones TEXT,
  fechaCreacion DATE,
  tipoConsulta VARCHAR(15),
  id_Proveedor BIGINT,
  id_Usuario BIGINT,
  CONSTRAINT fk_TProveedor FOREIGN KEY (id_Proveedor) REFERENCES tb_proveedor(idProveedor),
  CONSTRAINT fk_TUsuario FOREIGN KEY (id_Usuario) REFERENCES tb_usuario(idUsuario)
);



CREATE TRIGGER insert_Transaction
AFTER INSERT OR UPDATE ON tb_accesorios
FOR EACH ROW
BEGIN




END;



-- mostrar todas las tablas de mi base de datos
show tables;


