
CREATE SCHEMA `sgbd2`;

CREATE TABLE `sgbd2`.`alunos` (
  `idalunos` INT NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `matricula` INT(4) NOT NULL,
  `nome` VARCHAR(25) NOT NULL,
  `sexo` INT(1) NOT NULL,
  PRIMARY KEY (`idalunos`, `cpf`, `matricula`));

CREATE TABLE `sgbd2`.`disciplinas` (
  `iddisciplinas` INT NOT NULL,
  `codigo` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`iddisciplinas`, `codigo`));

CREATE TABLE `sgbd2`.`alunos_disciplinas` (
  `idalunos_disciplinas` INT NOT NULL,
  `codigo_disciplina` VARCHAR(7) NOT NULL,
  `matricula_aluno` INT(4) NOT NULL,
  PRIMARY KEY (`idalunos_disciplinas`, `codigo_disciplina`, `matricula_aluno`));
  
  ALTER TABLE `sgbd2`.`alunos` 
CHANGE COLUMN `matricula` `matricula` INT(4) UNSIGNED NOT NULL AFTER `cpf`,
CHANGE COLUMN `idalunos` `idalunos` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `sgbd2`.`alunos_disciplinas` 
CHANGE COLUMN `idalunos_disciplinas` `idalunos_disciplinas` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `matricula_aluno` `matricula_aluno` INT(4) UNSIGNED NOT NULL ;