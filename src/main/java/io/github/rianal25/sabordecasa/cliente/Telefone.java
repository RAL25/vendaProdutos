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
public class Telefone extends Entity{
    private Byte ddd;
    private Integer numero;
    private Boolean mensageiro;
    //private Cliente cliente = new Cliente();

    //<editor-fold defaultstate="collapsed" desc="construtor">
    public Telefone(){
        
    }
    
    public Telefone(Long id,Byte ddd, Integer numero, Boolean mensageiro) {
        setId(id);
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