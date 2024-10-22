/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;


import io.github.gabrielsizilio.sabordecasa.database.Dao;
import io.github.gabrielsizilio.sabordecasa.database.DbConnection;
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
 * Classe FuncionarioDao
 * @author yodemis
 */
public class FuncionarioDao extends Dao<Funcionario> {
    public static final String TABLE = "funcionario";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (nome, matricula, ativo, administrador) values (?,?,?,?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE +" set nome = ?, matricula = ?, ativo = ?, administrador = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Funcionario e) {
        try{
            pstmt.setString(1, e.getNome());       
            pstmt.setObject(2, e.getMatricula());
            pstmt.setObject(3, e.getAtivo());
            pstmt.setObject(4, e.getAdministrador());
            
            if(e.getId() != null) {
                pstmt.setObject(5, e.getId());
            }

        } catch(SQLException ex){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public Funcionario extractObject(ResultSet resultSet) {
        Funcionario funcionario = null;
        Credencial credencial = null;

        try {
            funcionario = new Funcionario();
            credencial = new Credencial();
            
            funcionario.setId(resultSet.getLong("id"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setMatricula(resultSet.getLong("matricula"));
            
            credencial = new CredencialDao().findById(funcionario.getId());
            funcionario.setCredencial(credencial);

            funcionario.setAtivo(resultSet.getBoolean("ativo"));
            funcionario.setAdministrador(resultSet.getBoolean("administrador"));
            funcionario.setExcluido(resultSet.getBoolean("excluido"));

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionario;
    }
    
    public Funcionario autenticar(Credencial credencial) {
        Credencial credencialAutenticada = new CredencialDao().autenticar(credencial);
        if(credencialAutenticada != null){
            try (PreparedStatement pstmt
                = DbConnection.getConnection().prepareStatement(
                        // Sentença SQL para validação de usuário
                        "SELECT * "
                        + "FROM funcionario "
                        + "WHERE id = ? "
                        + "AND excluido = 0")) {

            // Prepara a declaração com os dados do objeto passado
                pstmt.setLong(1, credencialAutenticada.getId());

                // Executa o comando SQL
                ResultSet resultSet = pstmt.executeQuery();

                // Se há resultado retornado...
                if (resultSet.next()) {
                    // ... implica que email e senha estão corretos 
                    // para o usuário e devolve os dados completos deste
                    return extractObject(resultSet);
                }

            } catch (Exception e) {
            
            }

        }
        
        return null;
    }
}
