/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe Pedido
 * @author yodemis
 */
public class Pedido extends Entity {
    private Funcionario funcionario;
    private ArrayList<Item> itens;
    private BigDecimal valorTotal;
    private Boolean delivery;
    private Cliente cliente;
    
    public Pedido() {
        itens = new ArrayList<>();
        cliente = new Cliente();
    }

    public Pedido(Long id, Funcionario funcionario, ArrayList<Item> itens, BigDecimal valorTotal, Boolean delivery, Cliente cliente) {
        this();
        this.setId(id);
        this.funcionario = funcionario;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.delivery = delivery;
        this.cliente = cliente;
    }

    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public void addItem(Item item) {
        itens.add(item);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" 
                + "funcionario=" + funcionario 
                + ", itens=" + itens 
                + ", valorTotal=" + valorTotal 
                + ", delivery" + delivery 
                + ", cliente=" + cliente + '}';
    }
    
    
    
    
    public void calcularTotal() throws Exception {
        for(Item item:itens) {
            valorTotal.add(item.calcularTotal());
        }
    }
}
