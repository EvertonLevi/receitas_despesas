CREATE TABLE conta(
    id INT(5) PRIMARY KEY AUTO_INCREMENT, 
    descricao VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE lancamento(
    id INT(5) PRIMARY KEY AUTO_INCREMENT,
    dataLancamento DATETIME DEFAULT CURRENT_TIMESTAMP,
    idContaLancamento INT(5) NOT NULL,
    FOREIGN KEY (idContaLancamento) REFERENCES conta (id),
    descricao VARCHAR(255),
    valor FLOAT(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE usuario(
    id INT(5) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    idLancamentoUsuario INT(5),
    FOREIGN KEY (idLancamentoUsuario) REFERENCES lancamento (id),
    idContaUsuario INT(5),
    FOREIGN KEY (idContaUsuario) REFERENCES conta (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;