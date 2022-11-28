/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Yodemis;

import io.github.gabrielsizilio.sabordecasa.entity.Entity;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe Pedido
 * @author yodem
 */
public class Pedido extends Entity {
    private Funcionario funcionario;
    private ArrayList<Item> itens;
    private BigDecimal valorTotal;
    private Boolean delivery;
    
    public Pedido() {
        itens = new ArrayList<>(2);
    }

    public Pedido(Funcionario funcionario, ArrayList<Item> itens, BigDecimal valorTotal, Boolean delivery) {
        this.funcionario = funcionario;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.delivery = delivery;
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
    
    public void calcularTotal() {
        
    }
}
