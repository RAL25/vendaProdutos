/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import java.math.BigDecimal;
import java.math.BigInteger;

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
    
    public Produto(Long id, String nome, BigDecimal precoBase, Recheio recheio) throws Exception {
        setId(id);
        
        this.nome = nome;
        this.precoBase = precoBase;
        this.recheio = recheio;
        this.valorProduto = calcularValorProduto();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome==null || nome.length()>50) {
            throw new Exception("Nome precisa de no mínimo 50 caracteres!");
        }
        this.nome = nome;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) throws Exception {
        
//        EQUALS NÃO ESTA FUNCIONANDO. TODA VEZ QUE ELE CHEGA AQUI DA ERRO!
//        if(calcularValorProduto().equals(BigDecimal.ZERO)) {
//            throw new IllegalArgumentException("Produto não pode ser gratuito!");
//        }
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

    public void setValorProduto(BigDecimal valorProduto) throws Exception {
        if(precoBase.equals(BigDecimal.ZERO) && recheio.getPreco().equals(BigDecimal.ZERO)) {
            throw new Exception("Valor produto não pode ser 0!");
        }
        this.valorProduto = valorProduto;
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
    
    public BigDecimal calcularValorProduto() throws Exception {
        if(precoBase.equals(BigDecimal.ZERO) && recheio.getPreco().equals(BigDecimal.ZERO)) {
            throw new Exception("Valor produto não pode ser 0!");
        }
        return precoBase.add(recheio.getPreco());
    }
}
