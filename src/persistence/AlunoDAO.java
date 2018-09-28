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

    public void setAlunos(ArrayList<AlunoModel> ap) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.dd.mm");
        try {
            
            String[] campos = new String[5], valores = new String[5];
            Conexao connect = new Conexao();
            campos[0] = "cpf";
            campos[1] = "matricula";
            campos[2] = "dataNascimento";
            campos[3] = "nome";
            campos[4] = "sexo";
            
            for (AlunoModel a : ap){
                valores[0] = "'" + (a.getCpf().substring(0, 11)) + "'";
                valores[1] = "" + a.getMatricula();
                valores[2] =  dateFormat.format("" + a.getDataNascimento());
                valores[3] = "'" +a.getNome() + "'" ;
                valores[4] = (a.getSexo().equals("Fem.") ? "1" : (a.getSexo().equals("Masc.") ? "2" : "0"));
                
                connect.executarInsercao("Alunos", campos, valores);    
            }
            
            
        } catch (Exception e) {
            
        }
    }

}
