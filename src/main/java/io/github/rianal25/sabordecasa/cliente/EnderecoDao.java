/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.rianal25.sabordecasa.cliente;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import io.github.gabrielsizilio.sabordecasa.database.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *<pre>endereco | CREATE TABLE `endereco` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) NOT NULL,
  `numero` smallint(6) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `complemento` varchar(45) NOT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  `cliente_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 </pre>
 * @author Rian Alves <Rian at IFNMG>
 */
public class EnderecoDao extends Dao<Endereco> {
    
    public static final String TABLE = "endereco";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (rua,numero,bairro,complemento,cliente_id) values (?,?,?,?,?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE +" set rua = ?, numero = ?, bairro = ?, complemento = ?, cliente_id = ?, where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Endereco e) {
        try{
            pstmt.setString(1, e.getRua());
            pstmt.setInt(2, e.getNumero());
            pstmt.setString(3, e.getBairro());
            pstmt.setString(4, e.getComplemento());
            pstmt.setLong(5, e.getCliente().getId());
            
            if(e.getId() != null) {
                pstmt.setObject(6, e.getId());
                
            }

        } catch(SQLException ex){
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public List<Endereco> findByClienteId(Long id) {
        
        final String SQL = "SELECT * FROM " +TABLE+ " WHERE cliente_id=?";
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(SQL)) {
            
            preparedStatement.setLong(1, id);
            
            // Show the full sentence
            System.out.println(">>FINDBYCLIENTEID SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public Endereco extractObject(ResultSet resultSet) {
        Endereco endereco = null;

        try {
            endereco = new Endereco();
            endereco.setId(resultSet.getLong("id"));
            endereco.setRua(resultSet.getString("rua"));
            endereco.setNumero(resultSet.getShort("numero"));
            endereco.setBairro(resultSet.getString("bairro"));
            endereco.setComplemento(resultSet.getString("complemento"));
            endereco.setExcluido(resultSet.getBoolean("excluido"));
            
        } catch (SQLException ex) {
                Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return endereco;
    }
}
