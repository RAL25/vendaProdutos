/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */  
public class Cliente {
    private String nome;
    private ArrayList<Telefone> telefone;
    private List<Endereco> endereco;
    
    //todo criar classes abstratas pessoa fisica e juridica?

    //<editor-fold defaultstate="collapsed" desc="construtor">
    
    public Cliente() {
    }
    
    public Cliente(String nome, List<Telefone> telefone, List<Endereco> endereco) {
        this.nome = nome;
        this.telefone = (ArrayList<Telefone>) telefone;
        this.endereco = endereco;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == null || nome.length() > 50){
            throw new Exception ("Nome não pode ter mais do que 50 caracteres");   
        }
        this.nome = nome;
    }

    public ArrayList<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = (ArrayList<Telefone>) telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    //</editor-fold>
    
    
    
} 
