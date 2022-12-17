/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.produto;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.yodemisj.sabordecasa.GUI.Principal;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.yodemisj.sabordecasa.funcionario.Pedido;
import io.github.yodemisj.sabordecasa.funcionario.PedidoDao;
import java.awt.Component;
import java.awt.SystemColor;
import java.beans.PropertyVetoException;
import java.math.BigInteger;
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
public class Venda extends javax.swing.JInternalFrame {
    
    private static Venda instance;
    private static final DefaultComboBoxModel<Produto> boxModelProduto = new DefaultComboBoxModel<>();
    private static final DefaultComboBoxModel<Item> boxModelResumoPedido = new DefaultComboBoxModel<>();
    
    public static Pedido pedido;
    private static Funcionario funcionario;
    
    /**
     * Creates new form Venda
     */
    public Venda(Funcionario funcionarioSistema) {
        initComponents();
        
        pedido = new Pedido();
        pedido.setFuncionario(funcionarioSistema);
        funcionario = funcionarioSistema;
        
        produtoReload();
        cboProduto.setModel(boxModelProduto);
        cboProduto.setRenderer(new ProdutoRender());
        
        resumoPedidoReload();
        lstItem.setModel(boxModelResumoPedido);
        lstItem.setCellRenderer(new ResumoPedidoRender());
    }
    
    public static Venda getInstance() {
        if(instance == null) {
            instance = new Venda(funcionario);
        }
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
    public void resumoPedidoReload() {
        try {
            btnRemover.setEnabled(false);
            ftfTotal.setValue(pedido.calcularTotal());
            
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
            
            setText(value.getNome() 
                    + "     [R$ " + value.getValorProduto()
                    + "]");
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
                btnRemover.setEnabled(true);
            }
            
            try {
                setText("-  "+ value.getQuantidade() 
                        +"x     " 
                        + value.getProduto().getNome()
                        + "     (R$ " + value.getProduto().getValorProduto() 
                        + ")          =   R$ "
                        + value.calcularTotal());
            } catch (Exception ex) {
                Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        dskPrincipal = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        cboProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstItem = new javax.swing.JList<>();
        bntFinalizar = new javax.swing.JButton();
        lblResumo = new javax.swing.JLabel();
        bntCancelar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        ftfTotal = new javax.swing.JFormattedTextField();
        dskSecond = new javax.swing.JPanel();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuCadastrar = new javax.swing.JMenu();
        mnuCadastrarCliente = new javax.swing.JMenuItem();
        mnuCadastrarProduto = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda");

        lblProduto.setText("Produto");

        lblQuantidade.setText("Quantidade");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstItem);

        bntFinalizar.setText("Finalizar");
        bntFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFinalizarActionPerformed(evt);
            }
        });

        lblResumo.setText("Resumo do pedido");

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lblTotal.setText("Total: ");

        ftfTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$ #,##0.00 "))));
        ftfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfTotal.setToolTipText("");
        ftfTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ftfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dskSecondLayout = new javax.swing.GroupLayout(dskSecond);
        dskSecond.setLayout(dskSecondLayout);
        dskSecondLayout.setHorizontalGroup(
            dskSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dskSecondLayout.setVerticalGroup(
            dskSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblProduto)
                        .addGap(18, 18, 18)
                        .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(dskPrincipalLayout.createSequentialGroup()
                                .addComponent(lblResumo)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addComponent(dskSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(83, 83, 83)
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dskPrincipalLayout.createSequentialGroup()
                                .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dskPrincipalLayout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto))
                .addGap(61, 61, 61)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(lblTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(dskPrincipalLayout.createSequentialGroup()
                        .addComponent(dskSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarClienteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuCadastrarClienteActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        
        Produto produtoSelected = (Produto)cboProduto.getSelectedItem();
        Integer quantidade = new Integer(txtQuantidade.getText());
        Item itemNovo = new Item(produtoSelected, quantidade);
        
        try {
            pedido.addItem(itemNovo);
            
        } catch (Exception ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Item adicionado");
        resumoPedidoReload();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
//        CANCELAR VENDA
        System.out.println("Venda cancelada");
        pedido.getItens().clear();
        dispose();
        
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void mnuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarProdutoActionPerformed
        // TODO add your handling code here:
//        CADASTRA NOVO PRODUTO E FECHA DEPOIS
        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_mnuCadastrarProdutoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        Item item = lstItem.getSelectedValue();

        for (Item itemLista:pedido.getItens()){
            if(itemLista.getProduto().getNome() == item.getProduto().getNome()) {
                if(item.getQuantidade() == 1) {
                    pedido.getItens().remove(itemLista);
                    System.out.println("Elemento excluido da lista");
                    break;
                } else {
                    try {
                        item.setQuantidade(item.getQuantidade()-1);
                        System.out.println("1 unidade removida");
                    } catch (Exception ex) {
                        Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        }

        resumoPedidoReload();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void ftfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfTotalActionPerformed

    private void bntFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFinalizarActionPerformed
        // TODO add your handling code here:
        FinalizaPedido finalizaPedido = new FinalizaPedido(pedido);
        finalizaPedido.setVisible(true); 
    }//GEN-LAST:event_bntFinalizarActionPerformed
    
    private void attachInternalFrame(JInternalFrame window) {
        // Attach internal window to desktop pane
        if (!window.isVisible()) {
            window.setVisible(true);
            dskSecond.add(window);
        }

        // Focus and restore the internal window
        try {
            window.setSelected(true);
            window.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName())
                    .log(Level.INFO, null, ex);
        }
    }
    
    private void anexarJanela(JInternalFrame janela) {
        if (!janela.isVisible()) {
            dskPrincipal.add(janela);
            janela.setVisible(true);
        }

        try {
            // Restaura, se minimizada
            janela.setIcon(false);
            // Move o foco
            janela.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Traz para o primeiro plano
        janela.toFront();
    }
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
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntFinalizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<Produto> cboProduto;
    private javax.swing.JPanel dskPrincipal;
    private javax.swing.JPanel dskSecond;
    private javax.swing.JFormattedTextField ftfTotal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblResumo;
    private javax.swing.JLabel lblTotal;
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
