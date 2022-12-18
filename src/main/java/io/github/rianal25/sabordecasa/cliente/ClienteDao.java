/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.rianal25.sabordecasa.cliente;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import io.github.gabrielsizilio.sabordecasa.produto.RecheioDao;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
import static io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao.TABLE;
import static io.github.yodemisj.sabordecasa.funcionario.PedidoDao.TABLE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *<pre> cliente | CREATE TABLE `cliente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 </pre>
 * @author Rian Alves <Rian at IFNMG>
 */
public class ClienteDao extends Dao<Cliente> {
    public static final String TABLE = "Cliente";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (nome) values (?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE +" set nome = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cliente e) {
        try{
            pstmt.setString(1, e.getNome());
            
            if(e.getId() != null) {
                pstmt.setObject(2, e.getId());
            }

        } catch(SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public Cliente extractObject(ResultSet resultSet) {
         Cliente cliente = null;

        try {
            cliente = new Cliente();
            cliente.setId(resultSet.getLong("id"));
            cliente.setNome(resultSet.getString("nome"));
            
            cliente.setExcluido(resultSet.getBoolean("excluido"));
            
        } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return cliente;
    }
}
