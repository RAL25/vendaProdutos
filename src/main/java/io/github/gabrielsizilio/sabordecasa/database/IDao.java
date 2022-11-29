/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public interface IDao<T> {
    
    //save
    public String getSaveStatement();
    public String getUpdateStatement();
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, T e);
    public Long saveOrUpdate(T e);
    
    //Get find by Id
    public String getFindByIdStatement();
    public T findById(Long id);
    
    //Get find all
    public String getFindAllStatement();
    public List<T> findAll();
    
    //Trash
    public String getMoveToTrashStatement();
    public void moveToTrash(T e);
    public String getRestoreFromTrashStatement();
    public void restoreFromTrash(T e);
    public String getFindAllOnTrashStatement();
    public List<T> findAllOnTrashStatement();
    
    //Assembly objects
    public T extractObject(ResultSet resultSet);
    public List<T> extractObjects(ResultSet resultSet);
}
