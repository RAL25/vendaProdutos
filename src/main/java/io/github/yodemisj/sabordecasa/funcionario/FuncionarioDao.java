/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** 
 * <pre>CREATE TABLE `funcionario` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `matricula` bigint(20) unsigned DEFAULT NULL,
    `ativo` tinyint(1) DEFAULT '1',
    `administrador` tinyint(1) DEFAULT '1',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
  ) ENGINE=MyISAM DEFAULT CHARSET=latin1</pre>
 * 
 * Classe FuncionarioDao
 * @author yodemis
 */
public class FuncionarioDao extends Dao {

    @Override
    public String getSaveStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindByIdStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getRestoreFromTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllOnTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
