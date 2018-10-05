/*
 *  Copyright 2018, Frederiko Cesar Moreira Ribeiro
 *  GitHub: https://github.com/frederikocmr
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.AlunoModel;

/**
 *
 * @author frede
 */
public class AlunoDAO {
    private Conexao connect;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps; 

    public AlunoDAO() {
        this.connect = new Conexao();
    }

    public ArrayList<AlunoModel> getTodosAlunos() {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        ArrayList<AlunoModel> lista = new ArrayList();
        DisciplinaDAO d = new DisciplinaDAO();
        try {
            String query = "SELECT * FROM ALUNO";
            st = connect.con.createStatement(); 
            
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                AlunoModel aluno = new AlunoModel();
                aluno.setSexo(rs.getString("sexo"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setDataNascimento(dateFormat.format(rs.getDate("data_nascimento")));
                aluno.setDisciplinas(d.getDisciplinasAluno(rs.getString("cpf")));
                
                lista.add(aluno);
            }
        } catch (Exception ex){
            System.err.println("Erro na listagem Alunos: " + ex);      
        }

        return lista;
    }

    public boolean setAluno(AlunoModel a) {
        boolean retorno = false;
        
        try { 
            ps = connect.con.prepareStatement("INSERT INTO ALUNO (cpf,matricula,nome,data_nascimento,sexo) VALUES (?,?,?,?,?)");
            ps.setString(1, a.getCpf().substring(0, 11));
            ps.setInt(2, a.getMatricula());
            ps.setString(3, a.getNome());

            ps.setDate(4, new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(a.getDataNascimento()).getTime()));
            ps.setString(5, (a.getSexo().equals("Fem.") ? "1" : (a.getSexo().equals("Masc.") ? "2" : "0")));

            retorno = ps.execute(); 
 
        } catch (Exception ex) {
            System.err.println("Erro na inserção Aluno: " + ex);   
        }
        
        return retorno;
    }

}
