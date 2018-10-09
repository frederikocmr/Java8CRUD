/*
 * Copyright 2018, Frederiko Cesar Moreira Ribeiro
 * GitHub: https://github.com/frederikocmr
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Frederiko Cesar
 */
public class AlunoModel {

    private String cpf;
    private String dataNascimento;
    private ArrayList<DisciplinaModel> disciplinas;
    private int matricula;
    private String nome;
    private String sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<DisciplinaModel> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
