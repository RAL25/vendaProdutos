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
public class Item extends Entity{
    private Produto produto;
    private Integer quantidade;
    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Item() {
    }

    public Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) throws Exception {
        if(produto == null) {
            throw new Exception("É necessário ter um produto!");
            
        }
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) throws Exception {
        if(quantidade<1){
            throw new Exception("Quantidade inválida!");
        }
        this.quantidade = quantidade;
    }
//</editor-fold>
        
    public BigDecimal calcularTotal(){
        return produto.calcularValorProduto().multiply(new BigDecimal(quantidade));
    }
    
    //<editor-fold defaultstate="collapsed" desc="toString">
    
    @Override
    public String toString() {
        return "Item{" + "produto=" + produto 
                + ", quantidade=" + quantidade
                + '}';
    }
//</editor-fold>
}
