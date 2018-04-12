CREATE TABLE pessoa(
    codigo    serial primary key not null,
    nome        VARCHAR(40) not null,
    ativo	boolean,
    logradouro  VARCHAR(40),
    numero  VARCHAR(5),
    complemento VARCHAR(40),
    bairro  VARCHAR(40),
    cep  VARCHAR(8),
    cidade VARCHAR(30),
    estado VARCHAR(2)
);
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('markswell', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('marilia', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('luciana', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('naama', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('kamila', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('ilana', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('lucia', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('daniele', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('henrique', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('julia', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('ana thalita', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');
INSERT INTO pessoa( nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)    VALUES ('fernanda', true, 'alameda verde sete', '59', 'alto', 'mondubim', '60752240', 'fortaleza', 'ce');