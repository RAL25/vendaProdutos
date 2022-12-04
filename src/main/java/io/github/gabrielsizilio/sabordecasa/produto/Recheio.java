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
        if(nome == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        } else if(nome.length() > 30) {
            throw new IllegalArgumentException("Nome não pode ultrapassar 30 caracteres!");
        }
            this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        
        if(descricao == null) {
            throw new IllegalArgumentException("Descricao não pode ser vazia");
        } else if(descricao.length() > 150) {
            throw new IllegalArgumentException("Descrição não pode ultrapassar 150 caracteres!");
        }
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        
        if(preco == null) {
            throw new IllegalArgumentException("Preço mínimo 0,00 reais! Não pode ser vazio");
        }
        
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
