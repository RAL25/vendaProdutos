/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.gabrielsizilio.sabordecasa.produto;

import static io.github.gabrielsizilio.sabordecasa.produto.Venda.pedido;
import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.rianal25.sabordecasa.cliente.Endereco;
import io.github.rianal25.sabordecasa.cliente.EnderecoDao;
import io.github.yodemisj.sabordecasa.GUI.PainelPrincipal;
import io.github.yodemisj.sabordecasa.funcionario.Pedido;
import io.github.yodemisj.sabordecasa.funcionario.PedidoDao;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class FinalizaPedido extends javax.swing.JFrame {
    private static FinalizaPedido instance;
    private static DefaultComboBoxModel<Cliente> boxModelCliente = new DefaultComboBoxModel<>();
    private static DefaultComboBoxModel<Endereco> boxModelEndereco = new DefaultComboBoxModel<>();
    
    public static Pedido pedido;
    public static Cliente cliente;
    public static Venda venda;
    
    /**
     * Creates new form FinalizaPedidos
     */
    
    public FinalizaPedido(Pedido pedidoCriado, Venda venda) {
        initComponents();
        
        this.venda = venda;
        pedido = pedidoCriado;
        pedido.setDelivery(ckbDelivery.isSelected());

        ftfTotal.setValue(pedido.getValorTotal());
        
        clienteReload();
        cboCliente.setModel(boxModelCliente);
        cboCliente.setRenderer(new ClienteRender());
        
        cboEndereco.setModel(boxModelEndereco);
        cboEndereco.setRenderer(new EnderecoRender());
    }
    
    public static FinalizaPedido getInstance() {
        if(instance == null) {
        instance = new FinalizaPedido(pedido, venda);
        }
        return instance;
    }
    
    public static void clienteReload() {
        try{
            int selectedIdx = boxModelCliente.getIndexOf(boxModelCliente.getSelectedItem());

            boxModelCliente.removeAllElements();
            boxModelCliente.addAll(new ClienteDao().findAll());
            
            boxModelCliente.setSelectedItem(boxModelCliente.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }
    public static void enderecoReload() {
        try{
            int selectedIdx = boxModelEndereco.getIndexOf(boxModelEndereco.getSelectedItem());

            boxModelEndereco.removeAllElements();
            boxModelEndereco.addAll(new EnderecoDao().findByClienteId(pedido.getCliente().getId()));
            
            boxModelCliente.setSelectedItem(boxModelCliente.getElementAt(selectedIdx));
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
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
    private class EnderecoRender extends JLabel implements ListCellRenderer<Endereco> {
        
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Endereco> list, Endereco value, 
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
            
            setText(value.getRua());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboEndereco = new javax.swing.JComboBox<>();
        ftfTotal = new javax.swing.JFormattedTextField();
        bntFinalizar = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        cboCliente = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        ckbDelivery = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar pedido");

        jLabel2.setText("Endereço: ");

        cboEndereco.setEnabled(false);
        cboEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEnderecoActionPerformed(evt);
            }
        });

        ftfTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$ #,##0.00 "))));
        ftfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfTotal.setToolTipText("");
        ftfTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ftfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTotalActionPerformed(evt);
            }
        });

        bntFinalizar.setText("Finalizar");
        bntFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFinalizarActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        lblCliente.setText("Cliente:");

        ckbDelivery.setSelected(true);
        ckbDelivery.setText("Delivery");
        ckbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ckbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(18, 18, 18)
                                .addComponent(cboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 137, Short.MAX_VALUE)
                                .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(ckbDelivery)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(ftfTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

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

    private void ftfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfTotalActionPerformed

    private void bntFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFinalizarActionPerformed
        // TODO add your handling code here:
        System.out.println("pedido>>>>"+ pedido);
        Long idPedido = new PedidoDao().saveOrUpdate(pedido);
        for(Item item:pedido.getItens()) {
            new ItemDao().SaveOrUpdateItem(item, idPedido);
        }
        
        dispose();
        new Venda(pedido.getFuncionario()).setVisible(true);
    }//GEN-LAST:event_bntFinalizarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
        //        CANCELAR VENDA
        System.out.println("Venda cancelada");
        dispose();
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
//        enderecoReload();
        
        cliente = (Cliente)cboCliente.getSelectedItem();
        pedido.setCliente(cliente);
        System.out.println("pedido>>"+pedido.getCliente());
        
        enderecoReload();
        cboEndereco.setEnabled(true);
    }//GEN-LAST:event_cboClienteActionPerformed

    private void cboEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEnderecoActionPerformed

    private void ckbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDeliveryActionPerformed
        // TODO add your handling code here:
        pedido.setDelivery(ckbDelivery.isSelected());
    }//GEN-LAST:event_ckbDeliveryActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(FinalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalizaPedido(pedido, venda).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntFinalizar;
    private javax.swing.JComboBox<Cliente> cboCliente;
    private javax.swing.JComboBox<Endereco> cboEndereco;
    private javax.swing.JCheckBox ckbDelivery;
    private javax.swing.JFormattedTextField ftfTotal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCliente;
    // End of variables declaration//GEN-END:variables
}
