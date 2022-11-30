/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.cliente;

/**
 *
 * @author User
 */
public class Telefone {
    private Byte ddd;
    private Integer numero;
    private Boolean mensageiro;

    //<editor-fold defaultstate="collapsed" desc="construtor">
    public Telefone(Byte ddd, Integer numero, Boolean mensageiro) {
        this.ddd = ddd;
        this.numero = numero;
        this.mensageiro = mensageiro;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters e setters">

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getMensageiro() {
        return mensageiro;
    }

    public void setMensageiro(Boolean mensageiro) {
        this.mensageiro = mensageiro;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Telefone{" + "ddd=" + ddd
                + ", numero=" + numero
                + ", mensageiro=" + mensageiro + '}';
    }
    
    
}
