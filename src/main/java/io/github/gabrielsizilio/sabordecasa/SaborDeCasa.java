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
import io.github.gabrielsizilio.sabordecasa.produto.Produto;
import io.github.gabrielsizilio.sabordecasa.produto.ProdutoDao;
import io.github.gabrielsizilio.sabordecasa.produto.Recheio;
import io.github.gabrielsizilio.sabordecasa.produto.RecheioDao;
import io.github.gabrielsizilio.sabordecasa.produto.RecheioDao;

import io.github.yodemisj.sabordecasa.funcionario.CredencialDao;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
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

        Credencial cred = new Credencial(null,"Yodemis@gmail.com","12345");        
        Long id = new CredencialDao().saveOrUpdate(cred);
        cred.setId(id);
        
        id = new CredencialDao().saveOrUpdate(cred);
        cred.setId(id);
        
        Funcionario func = new Funcionario(null,cred.getId(),"Yodemis",cred,true,true);
        /*Credencial cred = new Credencial("Yodemis@gmail.com","12345");
        Funcionario func = new Funcionario(1l,"Yodemis",cred,true,true);
        Long id;
        
>>>>>>> Cliente
        System.out.println(">> " + func);
        
        id = new FuncionarioDao().saveOrUpdate(func);
        func.setId(id);
        
        
        //System.out.println(">> "+ new FuncionarioDao().findById(1l));
        /*Recheio recheio = new Recheio(1L, "Recheio de carne", "Carne com molho", new BigDecimal("2"));
        Produto produto = new Produto(2L, "Mineirinho", new BigDecimal("10"), recheio);
        Item item = new Item(produto, 3);
<<<<<<< HEAD
        */
       
/*        
=======
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
//        FIND ALL
       /* List<Produto> produtos = new ProdutoDao().findAll();
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
        System.out.println("--- Lista com o nome: " + produtos);*/

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
        //Teste com cliente, telefone e endereço
        /*Cliente cliente = new Cliente (null,"Rian");
        Long id = new ClienteDao().saveOrUpdate(cliente);
        Cliente c1 = new ClienteDao().findById(id);*/
        Cliente cliente = new Cliente(null,"PaO");
        Long id1 = new ClienteDao().saveOrUpdate(cliente);
        cliente.setId(id1);
        
        Telefone telefone = new Telefone (null, (byte)38, (int)123456, false, cliente);
        Telefone telefone1 = new Telefone (null, (byte)37, (int)654321, false, cliente);
//        Telefone telefone1 = new Telefone();
        Long id =new TelefoneDao().saveOrUpdate(telefone);
        Long id3 =new TelefoneDao().saveOrUpdate(telefone1);
//        telefone.setId(id);
        
        Endereco enedereco = new Endereco(null, "rua 18", (short)80, "village", "c", cliente);
        Endereco enedereco1 = new Endereco(null, "rua 17", (short)28, "village 1", "apertamento", cliente);
        Long id2 = new EnderecoDao().saveOrUpdate(enedereco);
        Long id5 = new EnderecoDao().saveOrUpdate(enedereco1);
//        endereco.setId(id2);
        
        cliente.addEndereco(enedereco);
        cliente.addEndereco(enedereco1);
        cliente.addTelefone(telefone);
        cliente.addTelefone(telefone1);
        System.out.println(">> "+ cliente);
        /*System.out.println(">>"+new TelefoneDao().findById(id));
        System.out.println(">>"+new EnderecoDao().findById(id2));*/
        
//>>>>>>> Cliente
    }
}
