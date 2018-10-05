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
import model.DisciplinaModel;

/**
 *
 * @author frede
 */
public class DisciplinaDAO {
    private Conexao connect;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps; 

    public DisciplinaDAO() {
        this.connect = new Conexao();
    }

    public ArrayList<DisciplinaModel> getDisciplinasAluno(String cpfAluno) {
        ArrayList<DisciplinaModel> lista = new ArrayList();
        
        try {
            
            String query = "SELECT DISTINCT CODIGO FROM ALUNO_DISCIPLINA AD"
                    + " LEFT JOIN DISCIPLINA D ON AD.CODIGO_DISCIPLINA = D.CODIGO"
                    + " WHERE AD.CPF_ALUNO = " + cpfAluno;
            
            st = connect.con.createStatement(); 
            
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                DisciplinaModel disciplina = new DisciplinaModel();
                disciplina.setCodigo(rs.getString("CODIGO"));

                lista.add(disciplina);
            }
        } catch (Exception ex) {
             System.err.println("Erro na listagem Disciplinas: " + ex);  
        }

        return lista;

    }
    
       public boolean setDisciplina(DisciplinaModel d) {
        boolean retorno = false;
        
        try { 

            ps = connect.con.prepareStatement("INSERT INTO DISCIPLINA (codigo) VALUES (?)");
            ps.setString(1, d.getCodigo());


            retorno = ps.execute(); 
 
        } catch (Exception ex) {
            System.err.println("Erro na inserção Disciplina: " + ex);   
        }
        
        return retorno;
    } 
       
       public boolean setDisciplinaAluno(String codigo, String cpf) {
        boolean retorno = false;
        
        try { 
            ps = connect.con.prepareStatement("INSERT INTO ALUNO_DISCIPLINA (codigo_disciplina, cpf_aluno) VALUES (?,?)");
            ps.setString(1, codigo);
            ps.setString(2, cpf.substring(0, 11));

            retorno = ps.execute(); 
 
        } catch (Exception ex) {
            System.err.println("Erro na inserção Disciplina Aluno: " + ex);   
        }
        
        return retorno;
    } 

}
