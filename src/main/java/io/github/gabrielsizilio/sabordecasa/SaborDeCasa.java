/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa;

import io.github.gabrielsizilio.sabordecasa.cliente.Cliente;
import io.github.gabrielsizilio.sabordecasa.cliente.Endereco;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class SaborDeCasa {

    public static void main(String[] args) throws Exception {
        
        /*Recheio recheio = new Recheio(1L, "Recheio de carne", "Carne com molho", new BigDecimal("2"));
        Produto produto = new Produto(2L, "Mineirinho", new BigDecimal("10"), recheio);
        Item item = new Item(produto, 3);
        
        System.out.println(">>" + item);
        System.out.println(">>" + item.calcularTotal());*/
        
        Cliente cliente = new Cliente();
        cliente.setNome("Rian");
        
        Endereco e = new Endereco("18",(short)80,"village","c");
        cliente.setEndereco((List<Endereco>) e);
        
        System.out.println(">> "+ e);
        
        
        
    }
}
