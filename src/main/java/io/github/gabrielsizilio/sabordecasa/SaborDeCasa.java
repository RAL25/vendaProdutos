/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.Endereco;
import io.github.rianal25.sabordecasa.cliente.Telefone;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.ProdutoDao;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import io.github.yodemisj.sabordecasa.funcionario.Credencial;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.gabrielsizilio.sabordecasa.produto.RecheioDao;
import io.github.yodemisj.sabordecasa.funcionario.CredencialDao;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class SaborDeCasa {

    public static void main(String[] args) throws Exception {
        Credencial cred = new Credencial(null,"Yodemis@gmail.com","12345");
        
        Long id = new CredencialDao().saveOrUpdate(cred);
        cred.setId(id);
        
        Funcionario func = new Funcionario(null,cred.getId(),"Yodemis",cred,true,true);
        System.out.println(">> " + func);
        
        id = new FuncionarioDao().saveOrUpdate(func);
        func.setId(id);
        
        
        //System.out.println(">> "+ new FuncionarioDao().findById(1l));
        /*Recheio recheio = new Recheio(1L, "Recheio de carne", "Carne com molho", new BigDecimal("2"));
        Produto produto = new Produto(2L, "Mineirinho", new BigDecimal("10"), recheio);
        Item item = new Item(produto, 3);
=======
*/        
    }
}
