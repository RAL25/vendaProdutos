/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.rianal25.sabordecasa.cliente;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rian Alves <Rian at IFNMG>
 */
public class Cliente extends Entity{
    private String nome;
//    private ArrayList<Telefone> telefone;
    private ArrayList<Telefone> telefones;
//    private List<Endereco> endereco;
    private ArrayList<Endereco> enderecos;

    //<editor-fold defaultstate="collapsed" desc="construtor">
    
    public Cliente() {
        enderecos = new ArrayList<>();
        telefones = new ArrayList<>();
    }
    
    public Cliente(Long id,String nome){
        this();
        setId(id);
        
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

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    public Telefone getTelefone1(){
        return telefones.get(0);
    }
    public Telefone getTelefone2(){
        return telefones.get(1);
    }
    
    public Endereco getEndereco1(){
        return enderecos.get(0);
    }
    public Endereco getEndereco2(){
        return enderecos.get(1);
    }
    //</editor-fold>
    
    public void addTelefone(Telefone telefone) {    //cada cliente tem no máximo 2 telefones
        
        if(telefones.size() <= 2) {
            telefones.add(telefone);
        }
    }
    
    public void addEndereco(Endereco endereco) {    //cada cliente tem no máximo 2 endereços
        
        if(enderecos.size() <= 2) {
           enderecos.add(endereco);
        }
        
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome 
                + ", telefone=" + telefones
                + ", endereco=" + enderecos
                + '}';
    }
    
} 