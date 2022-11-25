/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.database;

import java.sql.Connection;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class DbConnection {
    public static final String URL;
    
    private static Connection conexao;
    private static String usuario;
    private static String senha;
    
    static {
        URL = "jdbc:mysql://127.0.0.1:3306/"
                + 
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        usuario = "root";
        senha = "";
    }
    
}
