/*
 *  Copyright 2018, Frederiko Cesar Moreira Ribeiro
 *  GitHub: https://github.com/frederikocmr
 */
package persistence;

import java.sql.*;

/**
 *
 * @author frede
 */
public class Conexao {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Conexao() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sgbd2?serverTimezone=UTC&useSSL=false";
                con = DriverManager.getConnection(url, "root", "20141002802573");
                st = con.createStatement();    
            
            

        } catch (Exception ex) {
            System.err.println("Erro no connect BD: " + ex);
        }
    }

    public ResultSet executarSelect(String tabela, String complemento) {
        try {
            String query = "SELECT * FROM " + tabela + "";
            query += " " + complemento;

            rs = st.executeQuery(query);
        } catch (Exception ex) {
            System.err.println("Erro no BD: " + ex);
        }

        return rs;
    }

    public boolean executarInsercao(String tabela, String[] campos, String[] valores) {
        boolean retorno = false;
        try {
            String query = " INSERT INTO " + tabela + "(";
            
            for (String s : campos) {
                query += s + ",";
            }
            
            query = (query.substring(0, query.length() - 1)) + ")";
            query += " VALUES (";
            
            for (String v : valores) {
                query += v + ",";
            }
            
            query = ((query.substring(0, query.length() - 1))) + ")";
            
            PreparedStatement ps = con.prepareStatement(query);

            retorno = ps.execute();
        } catch (Exception ex) {
            System.err.println("Erro no BD: " + ex);
        }

        return retorno;
    }

}
