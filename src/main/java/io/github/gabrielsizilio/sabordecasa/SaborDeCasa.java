/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.Endereco;
import io.github.rianal25.sabordecasa.cliente.Telefone;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.rianal25.sabordecasa.cliente.EnderecoDao;
import io.github.rianal25.sabordecasa.cliente.TelefoneDao;

import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.ItemDao;
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.ProdutoDao;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import io.github.gabrielsizilio.sabordecasa.produto.RecheioDao;

import io.github.yodemisj.sabordecasa.funcionario.CredencialDao;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
import io.github.yodemisj.sabordecasa.funcionario.Credencial;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.yodemisj.sabordecasa.funcionario.Pedido;
import io.github.yodemisj.sabordecasa.funcionario.PedidoDao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class SaborDeCasa {

    public static void main(String[] args) throws Exception {

        /*System.out.println("PRODUTO");
        Recheio r1 = new Recheio(null, "Recheio 1", "Recheio 1 de hortelã", new BigDecimal("2"));
        Long id = new RecheioDao().saveOrUpdate(r1);
        r1.setId(id);
        
        Produto p1 = new Produto(null, "Produto 1", new BigDecimal("5"), r1);
        id = new ProdutoDao().saveOrUpdate(p1);
        p1.setId(id);
        
        Credencial credencial1 = new Credencial(null, "gerente@mail.com","123451234");
        Funcionario funcionario1 = new Funcionario(null, 1L, "Gerente", credencial1, Boolean.TRUE, Boolean.TRUE);
        id = new FuncionarioDao().saveOrUpdate(funcionario1);
        funcionario1.setId(id);
        id = new CredencialDao().saveOrUpdate(credencial1);
        System.out.println(">>>" + id);
        credencial1.setId(id);
        
        Cliente cliente1 = new Cliente(null, "Cliente");
        id = new ClienteDao().saveOrUpdate(cliente1);
        cliente1.setId(id);
        
        Item item1 = new Item(p1, 10);
        
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        
        Pedido pedido1 = new Pedido(null, funcionario1, itens, BigDecimal.ZERO, Boolean.FALSE, cliente1);
        pedido1.calcularTotal();
        id = new PedidoDao().saveOrUpdate(pedido1);
        pedido1.setId(id);
        
        new ItemDao().SaveOrUpdateItem(item1, pedido1.getId());

        Pedido p2 = new PedidoDao().findById(pedido1.getId());
        
        System.out.println(">>"+ p2);*/
        
        Cliente c = new Cliente(null,"Rian");
        Telefone t = new Telefone(null, (byte)38, 123456, true, c);
        t.getId();
        Endereco e = new Endereco(null, "Dezoito", (short)80, "village", "c", c);
        e.getId();
        
        c.addTelefone(t);
        c.addEndereco(e);
        
        System.out.println(">>" + c);
        
        
        
        
        
    }
}
