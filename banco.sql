drop database Banco;
create database Banco;
USE Banco;

create table pessoa (
    cpf BIGINT(12) NOT NULL,
    nome VARCHAR(100),
    PRIMARY KEY (cpf)
);