create database Banco;
USE Banco;

create table pessoa (
    cpf BIGINT(12) PRIMARY KEY,
    nome VARCHAR(100),
    PRIMARY KEY (´cpf´)
);