/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.rianal25.sabordecasa.cliente;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;

/**
 *
 * @author Rian Alves <Rian at IFNMG>
 */
public class Endereco extends Entity{
    private String rua;
    private Short numero;
    private String bairro;
    private String complemento;
    private Cliente cliente = new Cliente();

    //<editor-fold defaultstate="collapsed" desc="contrutor">
    
    public Endereco() {
    }
    
    public Endereco(Long id,String rua, Short numero, String bairro, String complemento, Cliente cliente) {
        setId(id);
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cliente = cliente;
    }
//</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="getters e setters">

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua
                + ", numero=" + numero
                + ", bairro=" + bairro
                + ", complemento=" + complemento + '}';
    }
    
    
    
}