create database BD1_Mendivil;
use BD1_Mendivil;

create table categoria(
id_cate int auto_increment  primary key,
descripcion varchar(100),
frecuencia_compra varchar(50)
);

INSERT INTO categoria (descripcion, frecuencia_compra) VALUES ('Laptops y Tablets', 'Interdiario');
INSERT INTO categoria (descripcion, frecuencia_compra) VALUES ('Periféricos', 'Semanal');
INSERT INTO categoria (descripcion, frecuencia_compra) VALUES ('Almacenamiento', 'Diario');


create table productos(
id_prod int auto_increment primary key,
nom_prod varchar(100),
id_cate int,
stock_actual int,
foreign key (id_cate) references categoria (id_cate)
);

INSERT INTO productos (nom_prod, id_cate, stock_actual) VALUES ('Laptop Acer Nitro 5', 1, 10);
INSERT INTO productos (nom_prod, id_cate, stock_actual) VALUES ('Mouse Logitech G502', 2, 25);
INSERT INTO productos (nom_prod, id_cate, stock_actual) VALUES ('Disco SSD 1TB Kingston', 3, 15);

create table inventario(
nro_inventario int auto_increment primary key,
fecha date default(current_date),
id_prod int,
costo_ingreso double,
motivo_ingreso varchar(100),
foreign key (id_prod) references productos (id_prod)
);

INSERT INTO inventario (id_prod, costo_ingreso, motivo_ingreso) VALUES (1, 3500.00, 'Compra de lote inicial');
INSERT INTO inventario (id_prod, costo_ingreso, motivo_ingreso) VALUES (2, 150.50, 'Reposición de stock');
INSERT INTO inventario (id_prod, costo_ingreso, motivo_ingreso) VALUES (3, 280.00, 'Ingreso por garantía');


