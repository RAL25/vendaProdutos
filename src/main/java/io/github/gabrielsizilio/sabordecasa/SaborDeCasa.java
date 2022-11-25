/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa;

import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import java.math.BigDecimal;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class SaborDeCasa {

    public static void main(String[] args) {
        
        Recheio recheio = new Recheio(1L, "Recheio de carne", "Carne com molho", new BigDecimal("2"));
        Produto produto = new Produto(2L, "Mineirinho", new BigDecimal("10"), recheio);
        Item item = new Item(produto, 3);
        
        System.out.println(">>" + item);
        System.out.println(">>" + item.calcularTotal());
        

    }
}
