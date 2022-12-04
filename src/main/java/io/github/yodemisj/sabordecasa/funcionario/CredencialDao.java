/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

<<<<<<< HEAD:src/main/java/io/github/gabrielsizilio/sabordecasa/database/CredencialDao.java
import io.github.yodemisj.sabordecasa.funcionario.Credencial;
=======
import io.github.gabrielsizilio.sabordecasa.database.Dao;
>>>>>>> Produto:src/main/java/io/github/yodemisj/sabordecasa/funcionario/CredencialDao.java
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `credencial` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `credencial_ibfk_1` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1</pre>
 * 
 * Classe CredencialDao
 * @author yodem
 */
public class CredencialDao extends Dao<Credencial>{
    public static final String TABLE = "credencial";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE + " (email, senha) values (?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE + " set email = ?, senha = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credencial e) {
        try{
            pstmt.setString(1, e.getEmail());       
            pstmt.setString(2, e.getSenha());
            
            if(e.getId() != null) {
                pstmt.setObject(5, e.getId());
            }

        } catch(SQLException ex){
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "select * from "+ TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select * from "+ TABLE + " where excluido = 0";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update "+ TABLE + " set excluido = 1 where id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "update " + TABLE + " set excluido = 0 where id = ?";
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "select * from "+ TABLE + " where excluido = 1";
    }

    @Override
    public Credencial extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
