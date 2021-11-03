/* create table usuarios (nombre varchar(30), clave varchar(10)); */

/* describe usuarios; */

/* insert into usuarios (nombre, clave) values('Carlos', 'Sivori'); */

/* select * from usuarios; */
/* delete from usuarios; */

DROP TABLE IF EXISTS libros;
CREATE TABLE libros(
titulo varchar(100),
autor varchar(30),
editorial varchar(15),
precio float,
cantidad integer
);
INSERT INTO libros (titulo,autor,editorial,precio,cantidad) VALUES
('El aleph','Borges','Emece',45.50,100),
('Alicia en el pais de las maravillas','Lewis Carroll','Planeta',25,200),
('Matematica estas ahi','Paenza','Planeta',15.8,200);
SELECT titulo,precio FROM libros;
SELECT editorial,cantidad FROM libros;
SELECT * FROM libros;
SELECT * FROM libros order by 2;

