/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.gabrielsizilio.sabordecasa.database.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class RecheioDao extends Dao<Recheio>{
        
    public static final String TABLE = "recheio";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " 
                + TABLE
                + " (nome, descricao, preco)"
                + " VALUES (?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " 
                + TABLE 
                + " SET nome = ?, descricao = ?, preco = ?"
                + " WHERE id = ?"; 
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Recheio e) {
        try {
            pstmt.setString(1, e.getNome());
    
            pstmt.setObject(2, e.getDescricao(), java.sql.Types.VARCHAR);

            // LocalDate
            pstmt.setObject(3, e.getPreco(), java.sql.Types.DECIMAL);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecheioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT id, nome, descricao, excluido FROM "
                + TABLE
                + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT id, nome, descricao, excluido FROM "
                + TABLE
                + " WHERE exlcluido = false";
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
        return "SELECT id, nome, descricao, excluido FROM "
                + TABLE
                +" WHERE excluido = true";
    }

    @Override
    public Recheio extractObject(ResultSet resultSet) {
        Recheio recheio = null;

        try {
            recheio = new Recheio();
            recheio.setId(resultSet.getLong("id"));
            recheio.setNome(resultSet.getString("nome"));
            recheio.setDescricao(resultSet.getString("descricao"));
            recheio.setExcluido(resultSet.getBoolean("excluido"));
            } catch (SQLException ex) {
                Logger.getLogger(RecheioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RecheioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return recheio;
    }
}
