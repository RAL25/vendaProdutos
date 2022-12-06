/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;

/**
 * Classe Funcionario
 * @author yodemis
 * 
 */
public class Funcionario extends Entity {
    private Long matricula;
    private String nome;
    private Credencial credencial;
    private Boolean ativo;
    private Boolean Administrador;
    
    public Funcionario () {
        
    }

    public Funcionario(Long id, Long matricula, String nome, Credencial credencial, Boolean ativo, Boolean Administrador) {
        this.setId(id);
        this.matricula = matricula;
        this.nome = nome;
        this.credencial = credencial;
        this.ativo = ativo;
        this.Administrador = Administrador;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAdministrador() {
        return Administrador;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", nome=" + nome + ", credencial=" + credencial + ", ativo=" + ativo + ", Administrador=" + Administrador + '}';
    }
    
    
    
    public void setAdministrador(Boolean Administrador) {
        this.Administrador = Administrador;
    }
    
    
}
