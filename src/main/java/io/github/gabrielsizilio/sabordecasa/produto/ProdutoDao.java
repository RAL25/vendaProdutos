/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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

            pstmt.setObject(3, e.getRecheio().getId(), java.sql.Types.BIGINT);
            
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
        return "SELECT * FROM "
            + TABLE
            + " WHERE id = ?";
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

    @Override
    public Produto extractObject(ResultSet resultSet) {
        Produto produto = null;
        
        try {
            produto = new Produto();

            produto.setId(resultSet.getLong("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPrecoBase(resultSet.getBigDecimal("precoBase"));
            produto.setValorProduto(resultSet.getBigDecimal("valorProduto"));
            produto.setExcluido(resultSet.getBoolean("excluido"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
