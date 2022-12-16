/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.yodemisj.sabordecasa.funcionario.Pedido;
import io.github.yodemisj.sabordecasa.funcionario.PedidoDao;
import java.awt.Component;
import java.awt.SystemColor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class Venda extends javax.swing.JFrame {
    
    private static Venda instance;
    private static final DefaultComboBoxModel<Cliente> boxModelCliente = new DefaultComboBoxModel<>();
    private static final DefaultComboBoxModel<Produto> boxModelProduto = new DefaultComboBoxModel<>();
    private static final DefaultComboBoxModel<Item> boxModelResumoPedido = new DefaultComboBoxModel<>();
    
    private static Pedido pedido;
    private static Funcionario funcionario;
    private static ArrayList<Item> itens;
    
    /**
     * Creates new form Venda
     */
    public Venda(Funcionario funcionarioSistema) {
        initComponents();
        
        pedido = new Pedido();
        pedido.setFuncionario(funcionarioSistema);
        
        itens = new ArrayList<>();
        
        clienteReload();
        cboCliente.setModel(boxModelCliente);
        cboCliente.setRenderer(new ClienteRender());
        
        produtoReload();
        cboProduto.setModel(boxModelProduto);
        cboProduto.setRenderer(new ProdutoRender());
        
        resumoPedidoReload();
        lstItem.setModel(boxModelResumoPedido);
        lstItem.setCellRenderer(new ResumoPedidoRender());
        
        
        
        try {
            cboCliente.setSelectedIndex(0);
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    
    public static Venda getInstance() {
        if(instance == null) {
            instance = new Venda(funcionario);
        }
        clienteReload();
        produtoReload();
        return instance;
    }
    
    public static void produtoReload() {
        try {
            int selectedIdx = boxModelProduto.getIndexOf(boxModelProduto.getSelectedItem());
            boxModelProduto.removeAllElements();
            
            boxModelProduto.addAll(new ProdutoDao().findAll());
            
            boxModelProduto.setSelectedItem(boxModelProduto.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    public static void clienteReload() {
        try {
            int selectedIdx = boxModelCliente.getIndexOf(boxModelCliente.getSelectedItem());
            boxModelCliente.removeAllElements();
            
            boxModelCliente.addAll(new ClienteDao().findAll());
            
            boxModelCliente.setSelectedItem(boxModelCliente.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    public static void resumoPedidoReload() {
        try {
            int selectedIdx = boxModelResumoPedido.getIndexOf(boxModelResumoPedido.getSelectedItem());
            boxModelResumoPedido.removeAllElements();
            
            boxModelResumoPedido.addAll(pedido.getItens());
            
            boxModelResumoPedido.setSelectedItem(boxModelResumoPedido.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    
    private void clear() {
        txtQuantidade.setText("0");
    }
    
    private class ProdutoRender extends JLabel implements ListCellRenderer<Produto> {
        
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Produto> list, Produto value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            if(value == null) {
                return this;
            }
            
            setOpaque(true);
            setForeground(SystemColor.textText);
            setBackground(SystemColor.text);
            if(isSelected) {
                setForeground(SystemColor.textHighlightText);
                setBackground(SystemColor.textHighlight);
            }
            
            setText(value.getNome());
            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }
    }
    private class ClienteRender extends JLabel implements ListCellRenderer<Cliente> {
        
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Cliente> list, Cliente value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            if(value == null) {
                return this;
            }
            
            setOpaque(true);
            setForeground(SystemColor.textText);
            setBackground(SystemColor.text);
            if(isSelected) {
                setForeground(SystemColor.textHighlightText);
                setBackground(SystemColor.textHighlight);
            }
            
            setText(value.getNome());
            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }
    }
    private class ResumoPedidoRender extends JLabel implements ListCellRenderer<Item> {
        
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Item> list, Item value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            if(value == null) {
                return this;
            }
            
            setOpaque(true);
            setForeground(SystemColor.textText);
            setBackground(SystemColor.text);
            if(isSelected) {
                setForeground(SystemColor.textHighlightText);
                setBackground(SystemColor.textHighlight);
            }
            
            setText(value.getProduto().getNome());
            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        lblProduto = new javax.swing.JLabel();
        cboProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        bntAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstItem = new javax.swing.JList<>();
        bntFinalizar = new javax.swing.JButton();
        lblResumo = new javax.swing.JLabel();
        bntCancelar = new javax.swing.JButton();
        ckbDelivery = new javax.swing.JCheckBox();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuCadastrar = new javax.swing.JMenu();
        mnuCadastrarCliente = new javax.swing.JMenuItem();
        mnuCadastrarProduto = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");

        lblCliente.setText("Cliente:");

        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        lblProduto.setText("Produto");

        lblQuantidade.setText("Quantidade");

        bntAdicionar.setText("Adicionar");
        bntAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstItem);

        bntFinalizar.setText("Finalizar");

        lblResumo.setText("Resumo do pedido");

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        ckbDelivery.setText("Delivery");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(ckbDelivery)
                .addGap(18, 18, 18)
                .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCliente)
                            .addComponent(lblProduto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCliente, 0, 323, Short.MAX_VALUE)
                            .addComponent(cboProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntAdicionar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblResumo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ckbDelivery))
                    .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        mnuFile.setText("File");

        mnuCadastrar.setText("Cadastrar");

        mnuCadastrarCliente.setText("Novo cliente");
        mnuCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarClienteActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadastrarCliente);

        mnuCadastrarProduto.setText("Novo produto");
        mnuCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarProdutoActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadastrarProduto);

        mnuFile.add(mnuCadastrar);

        mnuBar.add(mnuFile);

        mnuEdit.setText("Edit");
        mnuBar.add(mnuEdit);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarClienteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuCadastrarClienteActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void bntAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdicionarActionPerformed
        // TODO add your handling code here:
        
        Produto produtoSelected = (Produto)cboProduto.getSelectedItem();
        Integer quantidade = new Integer(txtQuantidade.getText());
        Item itemNovo = new Item(produtoSelected, quantidade);
        
        Cliente cliente = (Cliente)cboCliente.getSelectedItem();
        pedido.setCliente(cliente);
        
        pedido.setDelivery(ckbDelivery.isSelected());
        
        try {
            pedido.addItem(itemNovo);
            
        } catch (Exception ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resumoPedidoReload();
    }//GEN-LAST:event_bntAdicionarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
//        CANCELAR VENDA
        itens.clear();
        dispose();
        
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void mnuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarProdutoActionPerformed
        // TODO add your handling code here:
//        CADASTRA NOVO PRODUTO E FECHA DEPOIS
        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_mnuCadastrarProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda(funcionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdicionar;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntFinalizar;
    private javax.swing.JComboBox<Cliente> cboCliente;
    private javax.swing.JComboBox<Produto> cboProduto;
    private javax.swing.JCheckBox ckbDelivery;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblResumo;
    private javax.swing.JList<Item> lstItem;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuCadastrar;
    private javax.swing.JMenuItem mnuCadastrarCliente;
    private javax.swing.JMenuItem mnuCadastrarProduto;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
