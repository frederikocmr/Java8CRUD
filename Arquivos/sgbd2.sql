
CREATE SCHEMA `sgbd2`;

CREATE TABLE `aluno` (
  `idaluno` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(25) DEFAULT NULL,
  `matricula` int(4) DEFAULT NULL,
  `sexo` int(1) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`idaluno`,`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `disciplina` (
  `iddisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(7) NOT NULL,
  PRIMARY KEY (`iddisciplina`,`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `aluno_disciplina` (
  `idaluno_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_disciplina` varchar(7) DEFAULT NULL,
  `cpf_aluno` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idaluno_disciplina`),
  KEY `pk_aluno_idx` (`cpf_aluno`),
  KEY `pk_disciplina_idx` (`codigo_disciplina`),
  CONSTRAINT `pk_aluno` FOREIGN KEY (`cpf_aluno`) REFERENCES `aluno` (`cpf`),
  CONSTRAINT `pk_disciplina` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplina` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--CREATE TABLE `aluno_disciplina` (
--  `idaluno_disciplina` int(11) NOT NULL AUTO_INCREMENT,
--  `codigo_disciplina` varchar(7) DEFAULT NULL,
--  `cpf_aluno` varchar(11) DEFAULT NULL,
--  PRIMARY KEY (`idaluno_disciplina`)
--) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci