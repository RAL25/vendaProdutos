/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.rianal25.sabordecasa.cliente;

/**
 *
 * @author User
 */
public class Endereco {
    private String rua;
    private Short numero;
    private String bairro;
    private String complemento;

    //<editor-fold defaultstate="collapsed" desc="contrutor">
    
    public Endereco() {
    }
    
    public Endereco(String rua, Short numero, String bairro, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
    }
//</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    
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
