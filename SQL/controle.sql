DROP DATABASE IF EXISTS controle;

CREATE DATABASE controle;

USE controle;

CREATE TABLE fornecedor (
    id_fornecedor INT(4) AUTO_INCREMENT,
    razaosocial VARCHAR(100) NOT NULL,
    nomefantasia VARCHAR(100) NOT NULL,
    cnpj_cpf VARCHAR(30) NOT NULL,
    ie VARCHAR(30) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    pessoa VARCHAR(10) NOT NULL,
    PRIMARY KEY (id_fornecedor)
);

CREATE TABLE funcionario (
	id_funcionario INT(4) AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    estado VARCHAR(10) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    sexo VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    data DATE,
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE produto (
	id_produto INT(4) AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    quantidade INT(30) NOT NULL,
    fornecedor_FK INT(30),
    nomefantasia VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_produto)
);

INSERT INTO funcionario (id_funcionario, nome, cpf, endereco, bairro, telefone, estado, login, senha, sexo, cep, data) 
				 VALUES (1, "Alessandro", "123.123.123-02", "Rua Ameixeras numero 5", "São Gonçalo", "9 1234-1234", "SP", "admin", "admin", "M", "12123-123", "1996/05/12");
