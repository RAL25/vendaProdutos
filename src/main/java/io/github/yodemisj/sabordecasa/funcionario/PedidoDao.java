/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.yodemisj.sabordecasa.funcionario.Pedido;
import io.github.gabrielsizilio.sabordecasa.database.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `funcionario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `matricula` bigint(20) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `administrador` tinyint(1) DEFAULT '0',
  `excluido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1</pre>
* 
 * Classe PedidoDao
 * @author yodemis
 */
public class PedidoDao extends Dao<Pedido> {
    public static final String TABLE = "pedido";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (funcionario_id, valorTotal, delivery) values (?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE + " set funcionario_id = ?, valorTotal = ?, delivery = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pedido e) {
        try{
            //pstmt.setObject(1,f.getId());                 
            pstmt.setObject(2,e.getValorTotal());      
            pstmt.setObject(3,e.getDelivery());      
    
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
    public Pedido extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
