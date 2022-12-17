/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class VendaPrincipal extends javax.swing.JInternalFrame {
    
    private static VendaPrincipal instance;
    private static final DefaultComboBoxModel<Cliente> boxModelCliente = new DefaultComboBoxModel<>();
    private static final DefaultComboBoxModel<Produto> boxModelProduto = new DefaultComboBoxModel<>();
    private static final DefaultComboBoxModel<Item> boxModelResumoPedido = new DefaultComboBoxModel<>();
    
    private static Funcionario funcionario;
    private ArrayList<Item> itens;

    /**
     * Creates new form VendaPrincipal
     */
    public VendaPrincipal(Funcionario funcionarioSistema) {
        initComponents();
        
        this.funcionario = funcionarioSistema;
        
        itens = new ArrayList<>();
        
        clienteReload();
        cboCliente.setModel(boxModelCliente);
        cboCliente.setRenderer(new ClienteRender());
        
        produtoReload();
        cboProduto.setModel(boxModelProduto);
        cboProduto.setRenderer(new ProdutoRender());
        
        try {
            cboCliente.setSelectedIndex(0);
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    
     public VendaPrincipal getIInstance() {
        if(instance == null) {
            instance = new VendaPrincipal(funcionario);
        }
        
//        clienteReload();
//        produtoReload();
        return instance;
    }
    
    private static void produtoReload() {
        try {
            int selectedIdx = boxModelProduto.getIndexOf(boxModelProduto.getSelectedItem());
            boxModelProduto.removeAllElements();
            
            boxModelProduto.addAll(new ProdutoDao().findAll());
            
            boxModelProduto.setSelectedItem(boxModelProduto.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    private static void clienteReload() {
        try {
            int selectedIdx = boxModelCliente.getIndexOf(boxModelCliente.getSelectedItem());
            boxModelCliente.removeAllElements();
            
            boxModelCliente.addAll(new ClienteDao().findAll());
            
            boxModelCliente.setSelectedItem(boxModelCliente.getElementAt(selectedIdx));
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
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new javax.swing.JPanel();
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

        lblCliente.setText("Cliente:");

        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        lblProduto.setText("Produto");

        lblQuantidade.setText("Quantidade");

        txtQuantidade.setText("0");

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

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCliente)
                            .addComponent(lblProduto))
                        .addGap(18, 18, 18)
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCliente, 0, 323, Short.MAX_VALUE)
                            .addComponent(cboProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResumo)
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntAdicionar)))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(lblResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void bntAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdicionarActionPerformed
        // TODO add your handling code here:

        Produto produtoSelected = (Produto)cboProduto.getSelectedItem();
        Integer quantidade = new Integer(txtQuantidade.getText());
        Item item = new Item(produtoSelected, quantidade);

        itens.add(item);

        //        new ItemDao().SaveOrUpdateItem(item, Long.MIN_VALUE);

        System.out.println("---"+itens);

        //        System.out.println("---"+new Integer(txtQuantidade.getText()) +(Produto)cboProduto.getSelectedItem());
        //        Item e = cboProduto.getSelectedItem();
        //        itens.add(e)

    }//GEN-LAST:event_bntAdicionarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
        //        CANCELAR VENDA
        itens.clear();
        dispose();
        
    }//GEN-LAST:event_bntCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdicionar;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntFinalizar;
    private javax.swing.JComboBox<Cliente> cboCliente;
    private javax.swing.JComboBox<Produto> cboProduto;
    private javax.swing.JPanel dskPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblResumo;
    private javax.swing.JList<String> lstItem;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
