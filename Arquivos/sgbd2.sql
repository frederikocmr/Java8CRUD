
CREATE SCHEMA `sgbd2`;

CREATE TABLE `aluno` (
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `matricula` int(4) NOT NULL,
  `sexo` int(1) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `disciplina` (
  `codigo` varchar(7) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `aluno_disciplina` (
  `idaluno_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_disciplina` varchar(7) DEFAULT NULL,
  `cpf_aluno` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idaluno_disciplina`),
  KEY `pk_aluno_idx` (`cpf_aluno`),
  KEY `pk_disciplina_idx` (`codigo_disciplina`),
  CONSTRAINT `pk_aluno` FOREIGN KEY (`cpf_aluno`) REFERENCES `aluno` (`cpf`),
  CONSTRAINT `pk_disciplina` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplina` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci