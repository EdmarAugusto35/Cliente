create database IDE;
use IDE;
create table cliente(
id int auto_increment primary key,
nome varchar(50),
sexo char(1),
cpf varchar(11),
rg varchar (11),
estadoCivil varchar(50),
endereco varchar(50),
bairro varchar(50),
cidade varchar(50),
estado varchar(50),
cep varchar (50),
datadeNac varchar(8),
celula varchar (9),
email varchar(50)
);
create table cliente(
id int auto_increment primary key,
nome varchar(50),
sexo char(1),
cpf varchar(11),
rg varchar (11),
estadoCivil varchar(50),
endereco varchar(50),
bairro varchar(50),
cidade varchar(50),
estado varchar(50),
cep varchar (50),
datadeNac varchar(8),
celula varchar (9),
email varchar(50)
);
create table cliente(
id int auto_increment primary key,
nome varchar(50),
sexo char(1),
cpf varchar(11),
rg varchar (11),
estadoCivil varchar(50),
endereco varchar(50),
bairro varchar(50),
cidade varchar(50),
estado varchar(50),
cep varchar (50),
datadeNac varchar(8),
celula varchar (9),
email varchar(50)
);
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    sexo CHAR(1),
    cpf VARCHAR(11),
    rg VARCHAR(11),
    estadoCivil VARCHAR(50),
    endereco VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(50),
    cep VARCHAR(50),
    datadeNac VARCHAR(8),
    celula VARCHAR(9),
    email VARCHAR(50),
    especialidade varchar(50)
);
select * from funcionarios;
select * from cliente;
describe cliente; 
describe funcionarios;
alter table cliente add datanac varchar (50);
create table usuario(
id int auto_increment primary key,
nome varchar(50),
login varchar (50),
senha varchar (50),
perfil varchar (50)
);
describe usuario;
select * from usuario;