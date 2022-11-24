/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import java.math.BigDecimal;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class Recheio extends Entity{
    private String nome;
    private String descricao;
    private BigDecimal preco;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Recheio() {
    }

    public Recheio(Long id, String nome, String descricao, BigDecimal preco) {
        setId(id);
        
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome==null) {
            throw new Exception("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        
        if(descricao==null) {
            throw new Exception("Descricao não pode ser vazia");
        }
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="toString">
    
    @Override
    public String toString() {
        return "Recheio{" + "nome=" + nome 
                + ", descricao=" + descricao 
                + ", preco=" + preco 
                + '}';
    }
//</editor-fold>
    
}
