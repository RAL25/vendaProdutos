/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.ItemDao;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `pedido` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `funcionario_id` bigint(20) unsigned NOT NULL,
  `cliente_id` bigint(20) unsigned NOT NULL,
  `valorTotal` decimal(5,2) DEFAULT NULL,
  `delivery` tinyint(1) DEFAULT '0',
  `excluido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `funcionario_id` (`funcionario_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1</pre>
* 
 * Classe PedidoDao
 * @author yodemis
 */
public class PedidoDao extends Dao<Pedido> {
    public static final String TABLE = "pedido";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (funcionario_id, cliente_id, valorTotal, delivery) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE + " set funcionario_id = ?, cliente_id = ?, valorTotal = ?, delivery = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pedido e) {
        try{
            pstmt.setObject(1,e.getFuncionario().getId());
            pstmt.setObject(2,e.getCliente().getId());                 
            pstmt.setObject(3,e.getValorTotal());      
            pstmt.setObject(4,e.getDelivery());      
    
            if(e.getId() != null) {
                pstmt.setObject(5, e.getId());
            }

        } catch(SQLException ex){
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "select * from "+ TABLE + " where id = ? and excluido = 0";
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
        Pedido pedido = null;
        Funcionario funcionario = null;
        Cliente cliente = null;
        ArrayList<Item> itens = new ArrayList<>();
        
        try {
            pedido = new Pedido();
            pedido.setId(resultSet.getLong("id"));
            funcionario = new FuncionarioDao().findById(resultSet.getLong("funcionario_id"));
            pedido.setFuncionario(funcionario);
            cliente = new ClienteDao().findById(resultSet.getLong("cliente_id"));            
            pedido.setCliente(cliente); 
            
            itens = new ItemDao().findByPedidoId(pedido.getId());
            pedido.setValorTotal(resultSet.getBigDecimal("valorTotal"));
            pedido.setItens(itens);
            pedido.setDelivery(resultSet.getBoolean("delivery"));
            pedido.setExcluido(resultSet.getBoolean("excluido"));

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }
    
    

}
