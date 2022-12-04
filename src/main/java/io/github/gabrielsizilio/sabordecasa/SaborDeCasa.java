/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa;

import io.github.yodemisj.sabordecasa.funcionario.CredencialDao;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.Endereco;
import io.github.rianal25.sabordecasa.cliente.Telefone;
import io.github.gabrielsizilio.sabordecasa.produto.Item;
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.ProdutoDao;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import io.github.yodemisj.sabordecasa.funcionario.Credencial;
import io.github.yodemisj.sabordecasa.funcionario.Credencial;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class SaborDeCasa {

    public static void main(String[] args) throws Exception {
        Credencial cred = new Credencial("Yodemis@gmail.com","12345");
        Funcionario func = new Funcionario(1l,"Yodemis",cred,true,true);
        Long id;
        
        System.out.println(">> " + func);
        
        id = new FuncionarioDao().saveOrUpdate(func);
        func.setId(id);
        
        id = new CredencialDao().saveOrUpdate(cred);
        cred.setId(id);
        //System.out.println(">> "+ new FuncionarioDao().findById(1l));
        /*Recheio recheio = new Recheio(1L, "Recheio de carne", "Carne com molho", new BigDecimal("2"));
        Produto produto = new Produto(2L, "Mineirinho", new BigDecimal("10"), recheio);
        Item item = new Item(produto, 3);
=======
//=================================================================================================================
//        TESTE PARA PRODUTOS
>>>>>>> Produto
        
        Recheio recheioGoiaba = new Recheio(null, "goiaba", "Goiabada com creme de leite", new BigDecimal("1.5"));
        Produto produtoPaoDeQueijo = new Produto(null, "Pão de queijo", new BigDecimal("2"), recheioGoiaba);
        
//        SAVE
        Long idRecheioGoiaba = new RecheioDao().saveOrUpdate(recheioGoiaba);
        recheioGoiaba.setId(idRecheioGoiaba);
        
//        FIND
//        Recheio recheioRecuperado = new RecheioDao().findById(idRecheioGoiaba);
//        System.out.println("--- RecheioRecuperado(pré-atualização): " + recheioRecuperado);
//        
////        UPDATE
//        recheioRecuperado.setDescricao(recheioRecuperado.getDescricao() + ", SÓ VEM!!!");
//        new RecheioDao().saveOrUpdate(recheioRecuperado);
//        
//        System.out.println("--- RecheioRecuperado(pós-atualização): " + recheioRecuperado);
//        
////        FIND ALL
//        List<Recheio> recheios = new RecheioDao().findAll();
//        System.out.println("--- Lista de todos os recheios: "+recheios);
//        
////        MOVE TO TRASH
//        new RecheioDao().moveToTrash(recheioGoiaba);
//        List<Recheio> recheioRecuperadoDaLixeira = new RecheioDao().findAllOnTrashStatement();
//        System.out.println("--- Movido para lixeira: " + recheioRecuperadoDaLixeira);
//
////        RESTORE FROM TO TRASH
//        new RecheioDao().restoreFromTrash(recheioGoiaba);
//        
////        FIND BY DESCRIPTION
//        recheios = new RecheioDao().findByDescription("VEM");
//        System.out.println("--- Lista com a descricao: " + recheios);

<<<<<<< HEAD
/*        Endereco endereco1 = new Endereco("18", (short)80, "Village", "casa");
        Telefone telefone1 = new Telefone((byte)38, 12341234, false);
=======
//        SAVE
        Long idProdutoPaoDeQueijo = new ProdutoDao().saveOrUpdate(produtoPaoDeQueijo);
        produtoPaoDeQueijo.setId(idRecheioGoiaba);

//        FIND
        Produto produtoRecuperado = new ProdutoDao().findById(idProdutoPaoDeQueijo);
        System.out.println("--- Recuperado(pré-atualização): " + produtoRecuperado);
>>>>>>> Produto
        
//        UPDATE
        produtoRecuperado.setNome("TESTE ");
        produtoRecuperado.setPrecoBase(new BigDecimal("5"));
        new ProdutoDao().saveOrUpdate(produtoRecuperado);
        
        System.out.println("--- Recuperado(pós-atualização): " + produtoRecuperado);
        
<<<<<<< HEAD
        System.out.println(">>" + cliente1);
*/        
/*        
//        FIND ALL
        List<Produto> produtos = new ProdutoDao().findAll();
        System.out.println("--- Lista de todos os produtos: "+produtos);
        
//        MOVE TO TRASH
        System.out.println(">>>" + produtoPaoDeQueijo.getId());
        new ProdutoDao().moveToTrash(produtoPaoDeQueijo);
        List<Produto> produtoRecuperadoDaLixeira = new ProdutoDao().findAllOnTrashStatement();
        System.out.println("--- Movido para lixeira: " + produtoRecuperadoDaLixeira);

//        RESTORE FROM TO TRASH
        new ProdutoDao().restoreFromTrash(produtoPaoDeQueijo);
        
//        FIND BY NAME
         produtos = new ProdutoDao().findProdutoByName("ES");
        System.out.println("--- Lista com o nome: " + produtos);

//        UPDATE

//        FIND ALL

//        MOVE TO TRASH

//        RESTORE FROM TRASH

//        FIND BY DESCRIPTION
        
        
        

//=================================================================================================================
//        TESTE PARA CLIENTES

//        Endereco endereco1 = new Endereco("18", (short)80, "Village", "casa");
//        Telefone telefone1 = new Telefone((byte)38, 12341234, false);
//        
//        Endereco endereco2 = new Endereco("17", (short)81, "Minas Gerais", "apt 101");
//        Telefone telefone2 = new Telefone((byte)38, 12344444, true);
//        
//        Cliente cliente1 = new Cliente("Rian");
//        cliente1.addTelefone(telefone1);
//        cliente1.addTelefone(telefone2);
//        cliente1.addEndereco(endereco1);
//        cliente1.addEndereco(endereco2);
//        
//        System.out.println(">>" + cliente1);

//=================================================================================================================
*/        
    }
}
