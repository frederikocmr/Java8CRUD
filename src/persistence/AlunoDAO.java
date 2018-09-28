/*
 *  Copyright 2018, Frederiko Cesar Moreira Ribeiro
 *  GitHub: https://github.com/frederikocmr
 */
package persistence;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.AlunoModel;

/**
 *
 * @author frede
 */
public class AlunoDAO {

    public AlunoDAO() {
    }

    public ArrayList<AlunoModel> getTodosAlunos() {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        ArrayList<AlunoModel> lista = new ArrayList();
        ResultSet rs;
        try {
            Conexao connect = new Conexao();
            rs = connect.executarSelect("Alunos", "");
            while (rs.next()) {
                AlunoModel aluno = new AlunoModel();
                aluno.setSexo(rs.getString("sexo"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setDataNascimento(dateFormat.format(rs.getDate("dataNascimento")));
                aluno.setDisciplinas(DisciplinaDAO.getDisciplinasAluno(rs.getString("idalunos")));
                
                lista.add(aluno);
            }
        } catch (Exception e){
            
        }

        return lista;
    }

}
