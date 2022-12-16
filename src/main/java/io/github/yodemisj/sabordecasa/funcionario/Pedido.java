/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemisj.sabordecasa.funcionario;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            this.valorTotal = BigDecimal.ZERO;
        } catch (Exception ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, "Erro no calculo do valor total", ex);
        }
    }

    public Pedido(Long id, Funcionario funcionario, ArrayList<Item> itens, Boolean delivery, Cliente cliente) throws Exception{
        this();
        this.setId(id);
        this.funcionario = funcionario;
        this.itens = itens;
        this.delivery = delivery;
        this.cliente = cliente;
        setValorTotal(calcularTotal());
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
    
    public void addItem(Item itemNovo) throws Exception {
        System.out.println("ADD ITEM");
        for(Item item : itens) {
            if(item.getProduto().getNome() == itemNovo.getProduto().getNome()) {
                System.out.println("ITEM JA EXISTE");
                item.setQuantidade(item.getQuantidade()+itemNovo.getQuantidade());
                calcularTotal();
                return;
            }
        }
        itens.add(itemNovo);
        calcularTotal();
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
    
    public BigDecimal calcularTotal() throws Exception {
        System.out.println("CALCULAR TOTAL EM PEDIDO");
        valorTotal = BigDecimal.ZERO;
        for(Item item:itens) {
            valorTotal = valorTotal.add(item.calcularTotal());
            System.out.println("->"+valorTotal);
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" 
                + "funcionario=" + funcionario 
                + ", itens=" + itens 
                + ", valorTotal=" + valorTotal 
                + ", delivery=" + delivery 
                + ", cliente=" + cliente 
                + '}';
    }
    
}
