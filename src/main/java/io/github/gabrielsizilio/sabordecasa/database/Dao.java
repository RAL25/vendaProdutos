/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.database;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe $(Gabriel)
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public abstract class Dao<T> implements IDao<T> {

    public static final String DB = "sistemasabordecasa";

    @Override
    public Long saveOrUpdate(T e) {

        // Primary key
        Long id = 0L;

        if (((Entity) e).getId() == null
                || ((Entity) e).getId() == 0) {

            // Insert a new register
            // try-with-resources
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getSaveStatement(),
                            Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    // Retrieve the returned primary key
                    id = resultSet.getLong(1);
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
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = ((Entity) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }

        return id;
    }

    @Override
    public T findById(Long id) {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindByIdStatement(), Statement.RETURN_GENERATED_KEYS)) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public List<T> findAll() {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatement())) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

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
    public void moveToTrash(T e) {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getMoveToTrashStatement())) {
            // Assemble the SQL statement with the data (->?)
            preparedStatement.setLong(1, ((Entity) e).getId());

            // Show the full sentence
            System.out.println(">> TRASH SQL: " + preparedStatement);

            // Performs the update on the database
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    @Override
    public List<T> findAllOnTrashStatement() {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllOnTrashStatement())) {

            // Show the full sentence
            System.out.println(">>TRASH SQL: " + preparedStatement);

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
    public void restoreFromTrash(T e) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getRestoreFromTrashStatement())) {

            // Assemble the SQL statement with the data (->?)
            composeSaveOrUpdateStatement(preparedStatement, findById(((Entity) e).getId()));

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the update on the database
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    @Override
    public List<T> extractObjects(ResultSet resultSet) {
        List<T> objects = new ArrayList<>();

        try {
            while (resultSet.next()) {
                objects.add(extractObject(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects.isEmpty() ? null : objects;

    }
}
