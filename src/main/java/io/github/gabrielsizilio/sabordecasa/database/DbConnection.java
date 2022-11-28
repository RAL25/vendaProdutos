/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class DbConnection {
    private static Connection connection;
    
    public static final String URL;
    private static String USER;
    private static String PASSWORD;
    
    static {
        URL = "jdbc:mysql://127.0.0.1:3306/"
                + Dao.DB
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "";
    }

    private DbConnection() {
        
    }
    
    public static Connection getConnection() {
        if(connection == null){
            try {
                System.out.println(">> Nova conexão com banco de dados");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex){
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
