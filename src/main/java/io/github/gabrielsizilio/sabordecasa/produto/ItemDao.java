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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `item` (
  `produto_id` bigint(20) unsigned NOT NULL,
  `pedido_id` bigint(20) unsigned NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`produto_id`,`pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1</pre>
* 
* 
 * 
 *
 * 
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class ItemDao extends Dao<Item>{

    public static final String TABLE = "item";
    
    public void SaveOrUpdateItem (Item item, Long fk) {

        if (item.getId() == null || item.getId() == 0) {

            // Insert a new register
            // try-with-resources
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getSaveStatement(),Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateWithFkStatement(preparedStatement, item, fk);

                // Show the full sentence
                System.out.println(">>SAVE SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    // Retrieve the returned primary key
                    // id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            // Update existing record
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getUpdateStatement())) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateWithFkStatement(preparedStatement, item, fk);

                // Show the full sentence
                System.out.println(">>UPDATE SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                //id = (item.getId());

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
        
       }
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE
                + " (produto_id, quantidade, pedido_id)"
                + " VALUES (?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE 
            + " SET produto_id = ?, quantidade = ?"
            + " WHERE pedido_id = ?"; 
    }

    public void composeSaveOrUpdateWithFkStatement(PreparedStatement pstmt, Item e, Long fk) {
        try {
            pstmt.setObject(1, e.getProduto().getId(), java.sql.Types.INTEGER);
            pstmt.setObject(2, e.getQuantidade(), java.sql.Types.INTEGER);
            pstmt.setObject(3, fk, java.sql.Types.DECIMAL);

            // Just for the update
//            if (fk != null) {
//                pstmt.setLong(5, e.getId());
//            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, "Erro no composeSaveOrUpdateWithFk", ex);
        }
    }
    
    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Item e) {
        try {
            pstmt.setObject(1, e.getProduto().getId(), java.sql.Types.INTEGER);
            pstmt.setObject(2, e.getQuantidade(), java.sql.Types.INTEGER);

            // Just for the update
//            if (fk != null) {
//                pstmt.setLong(5, e.getId());
//            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Item> findByPedidoId (Long pedido_id) {
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindByIdStatement())) {
            
            preparedStatement.setLong(1, pedido_id);

            // Show the full sentence
            System.out.println(">>FINDALL SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return (ArrayList<Item>) extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }
    
    @Override
    public String getFindByIdStatement() {
        return "SELECT * FROM " + TABLE
            + " WHERE pedido_id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT * FROM "
            + TABLE
            + " WHERE excluido = false";
    }
    
    @Override
    public String getMoveToTrashStatement() {
        return "UPDATE " 
            + TABLE 
            + " SET excluido = true"
            + " WHERE produto_id = ?"; 
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE " 
            + TABLE 
            + " SET excluido = false"
            + " WHERE produto_id = ?"; 
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "SELECT * FROM "
            + TABLE
            + " WHERE excluido = true";
    }
    
    @Override
    public Item extractObject(ResultSet resultSet) {
        Item item = null;
        Produto produto = null;
        
        try {
            item = new Item();
            produto = new Produto();
            
            item.setId(resultSet.getLong("pedido_id"));
            
            produto = new ProdutoDao().findById(resultSet.getLong("produto_id"));
            item.setProduto(produto);
            
            item.setQuantidade(resultSet.getInt("quantidade"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) { 
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
}
