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
//    private ArrayList<Telefone> telefone;
    private ArrayList<Telefone> telefones;
//    private List<Endereco> endereco;
    private ArrayList<Endereco> enderecos;
    //todo criar classes abstratas pessoa fisica e juridica?

    //<editor-fold defaultstate="collapsed" desc="construtor">
    
    public Cliente() {
        enderecos = new ArrayList<>();
        telefones = new ArrayList<>();
    }
    
    public Cliente(String nome) {
        this();
        this.nome = nome;
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

//    public ArrayList<Telefone> getTelefone() {
//        return telefones;
//    }
//
//    public void setTelefone(List<Telefone> telefone) {
//        this.telefone = (ArrayList<Telefone>) telefone;
//    }
//
//    public List<Endereco> getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(List<Endereco> endereco) {
//        this.endereco = endereco;
//    }
    //</editor-fold>
    
    public void addTelefone(Telefone telefone) {
        
        if(telefones.size() <= 2) {
            telefones.add(telefone);
        }
    }
    
    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome 
                + ", telefone=" + telefones
                + ", endereco=" + enderecos
                + '}';
    }
    
} 
