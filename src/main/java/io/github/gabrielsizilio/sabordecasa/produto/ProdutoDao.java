/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import io.github.gabrielsizilio.sabordecasa.database.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `produto` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `precoBase` decimal(6,2) NOT NULL,
  `valorProduto` decimal(6,2) NOT NULL,
  `recheio_id` bigint(20) unsigned DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `recheio_id` (`recheio_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`recheio_id`) REFERENCES `recheio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1</pre>
 * 
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class ProdutoDao extends Dao<Produto>{
    
    public static final String TABLE = "produto";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO "
                + TABLE
                + " (nome, precoBase, recheio_id, valorProduto)"
                + " VALUES (?, ?, ?, ?)";    
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " 
            + TABLE 
            + " SET nome = ?, precoBase = ?, recheio_id = ?, valorProduto = ?"
            + " WHERE id = ?"; 
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Produto e) {
        try {
            pstmt.setString(1, e.getNome());
            
            pstmt.setObject(2, e.getPrecoBase(), java.sql.Types.DECIMAL);
            if(e.getRecheio() == null) {
                pstmt.setString(3, null);
            } else {
                pstmt.setObject(3, e.getRecheio().getId(), java.sql.Types.BIGINT);
            }
            
            pstmt.setObject(4, e.calcularValorProduto(), java.sql.Types.DECIMAL);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(5, e.getId());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT id, nome, precoBase, recheio_id, valorProduto, excluido FROM "
            + TABLE
            + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT * FROM "
            + TABLE
            + " WHERE excluido = false";
    }
    
    public List<Produto> FindProdutos() {
        
        final String SQL = "SELECT nome, precoBase, valorProduto"
            + " FROM " + TABLE;
        
        try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(SQL)) {

            // Show the full sentence
            System.out.println(">>FINDPRODUTOS SQL: " + preparedStatement);

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
    public String getMoveToTrashStatement() {
        return "UPDATE " 
            + TABLE 
            + " SET excluido = true"
            + " WHERE id = ?"; 
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE " 
            + TABLE 
            + " SET excluido = false"
            + " WHERE id = ?"; 
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "SELECT * FROM "
            + TABLE
            + " WHERE excluido = true";
    }

    public List<Produto> findProdutoByName (String nome) {
        final String SQL = "SELECT * FROM " + TABLE + " WHERE nome LIKE ?";
        
        try(PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(SQL)) {
            preparedStatement.setString(1, "%" + nome + "%");
            
            System.out.println(">> FINDBYNAME SQL: " + preparedStatement);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return extractObjects(resultSet);
        
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Produto extractObject(ResultSet resultSet) {
        Produto produto = null;
        Recheio recheio = null;
        
        try {
            produto = new Produto();
            recheio = new Recheio();

            produto.setId(resultSet.getLong("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPrecoBase(resultSet.getBigDecimal("precoBase"));
            
            recheio = new RecheioDao().findById(resultSet.getLong("recheio_id"));
            produto.setRecheio(recheio);
            
            produto.setValorProduto(resultSet.getBigDecimal("valorProduto"));
            produto.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
