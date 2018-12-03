/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maximiliano Meyer
 */
public class ConnectionDB {

    private static final String DRIVE = "com.mysql.jdbc.Driver";                 // Credencias que serão utilizadas para estabelecer a conexão com o BD
    private static final String URL = "jdbc:mysql://localhost:3306/aviacao";
    private static final String USER = "root";
    private static final String PASS = "insira a senha do BD aqui";

    public static Connection getConnection() {
        try {

            Class.forName(DRIVE);

            return DriverManager.getConnection(URL, USER, PASS);  // Linhas de código qye estabelecer a conexão 

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão ao bando de dados", ex);
        }
    }

    public static void closeConnection(Connection con) {    // 3 variações para encerrar a conexão que serão utilizadas pelas demais classes
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
        closeConnection(con, stmt);
    }

}
