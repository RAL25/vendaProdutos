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
public class Produto extends Entity{
    private String nome;
    private BigDecimal precoBase;
    private Recheio recheio;
    private BigDecimal valorProduto;
    
    //<editor-fold defaultstate="collapsed" desc="construtctor">
    
    public Produto() {
    }
    
    public Produto(Long id, String nome, BigDecimal precoBase, Recheio recheio) {
        setId(id);
        
        this.nome = nome;
        this.precoBase = precoBase;
        this.recheio = recheio;
        calcularValorProduto();
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

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) throws Exception {
        
        if(precoBase==BigDecimal.ZERO && recheio.getPreco()==BigDecimal.ZERO) {
            throw new Exception("Produto não pode ser gratuito");
        }
        this.precoBase = precoBase;
    }

    public Recheio getRecheio() {
        return recheio;
    }

    public void setRecheio(Recheio recheio) {
        this.recheio = recheio;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto() {
        this.valorProduto = precoBase.add(recheio.getPreco());
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="toString">
    
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome 
                + ", precoBase=" + precoBase 
                + ", recheio=" + recheio 
                + ", valorProduto=" + valorProduto 
                + '}';
//</editor-fold>
    }
    
    public void calcularValorProduto() {
        valorProduto = precoBase.add(recheio.getPreco());
    }
}
