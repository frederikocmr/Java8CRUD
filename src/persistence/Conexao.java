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

    public Connection con;

    public Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sgbd?serverTimezone=UTC&useSSL=false";
            con = DriverManager.getConnection(url, "root", "20141002802573");

        } catch (Exception ex) {
            System.err.println("Erro no connect BD: " + ex);
        }
    }
}
