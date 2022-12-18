/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package io.github.yodemisj.sabordecasa.GUI;

import io.github.rianal25.sabordecasa.cliente.Cliente;
import io.github.rianal25.sabordecasa.cliente.ClienteDao;
import io.github.rianal25.sabordecasa.cliente.Endereco;
import io.github.rianal25.sabordecasa.cliente.EnderecoDao;
import io.github.rianal25.sabordecasa.cliente.Telefone;
import io.github.rianal25.sabordecasa.cliente.TelefoneDao;
import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author yodem
 */
public class EditaCliente extends javax.swing.JInternalFrame {

    private Cliente clienteSelecionado = new Cliente();
    
    private static final DefaultListModel<Cliente> allClient
            = new DefaultListModel<>();
    public EditaCliente() {
        initComponents();
        lstCliente.setModel(allClient);
        lstCliente.setCellRenderer(new ClienteRenderer());
        allClient.clear();
        allClient.addAll(new ClienteDao().findAll());
        clienteSelecionado = new Cliente();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCliente = new javax.swing.JList<>();
        btnCancelar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        txtComplemento2 = new javax.swing.JFormattedTextField();
        txtNumero2 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBairro2 = new javax.swing.JFormattedTextField();
        txtLogradouro2 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JFormattedTextField();
        ckbMensageiro2 = new javax.swing.JCheckBox();
        ckbDados2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtBairro1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtComplemento1 = new javax.swing.JFormattedTextField();
        txtNumero1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLogradouro1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        ckbMensageiro1 = new javax.swing.JCheckBox();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();

        lstCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstCliente);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtComplemento2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNumero2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Número:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Complemento:");

        txtBairro2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtLogradouro2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLogradouro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouro2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Logradouro:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Bairro:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Fone:");

        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        ckbMensageiro2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbMensageiro2.setText("Mensageiro");

        ckbDados2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbDados2.setText("Deseja editar a segunda fonte de dados? ");
        ckbDados2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDados2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Campo opcional");

        txtBairro1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Bairro:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Complemento:");

        txtComplemento1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtComplemento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplemento1ActionPerformed(evt);
            }
        });

        txtNumero1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Número:");

        txtLogradouro1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLogradouro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouro1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Logradouro:");

        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Fone:");

        ckbMensageiro1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbMensageiro1.setText("Mensageiro");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setText("Rian");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Campo obrigatório");

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLogradouro2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtComplemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAtualizar)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(222, 222, 222)
                                        .addComponent(ckbMensageiro2))
                                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel3)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLogradouro1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtComplemento1))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(ckbMensageiro1))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(ckbDados2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbMensageiro1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ckbDados2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbMensageiro2))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtComplemento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addGap(0, 21, Short.MAX_VALUE))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        ArrayList<Endereco> enderecos = (ArrayList<Endereco>) new EnderecoDao().findByClienteId(clienteSelecionado.getId());
        ArrayList<Telefone> telefones = (ArrayList<Telefone>) new TelefoneDao().findByClienteId(clienteSelecionado.getId());
        clienteSelecionado.setEnderecos(enderecos);
        clienteSelecionado.setTelefones(telefones);
           
        try {
            clienteSelecionado.setNome(txtNome.getText());
            clienteSelecionado.getEndereco1().setRua(txtLogradouro1.getText());
            clienteSelecionado.getEndereco1().setNumero(Short.valueOf(txtNumero1.getText()));
            clienteSelecionado.getEndereco1().setBairro(txtBairro1.getText());
            clienteSelecionado.getEndereco1().setComplemento(txtComplemento1.getText());

            clienteSelecionado.getTelefone1().setDdd(Byte.valueOf(txtTelefone1.getText()
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "")
                .replace("-", "")
                .substring(0, 2)));
            clienteSelecionado.getTelefone1().setNumero(Integer.valueOf(txtTelefone1.getText()
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "")
                .replace("-", "")
                .substring(2, 11)));
            clienteSelecionado.getTelefone1().setMensageiro(ckbMensageiro1.isSelected());

            new ClienteDao().saveOrUpdate(clienteSelecionado);
            
            clienteSelecionado.getTelefone1().setCliente(clienteSelecionado);
            clienteSelecionado.getEndereco1().setCliente(clienteSelecionado);
            System.out.println("Cliente id " + clienteSelecionado.getEndereco1().getCliente().getId());
            System.out.println("Cliente id " + clienteSelecionado.getTelefone1().getCliente().getId());

            new TelefoneDao().saveOrUpdate(clienteSelecionado.getTelefone1());
            new EnderecoDao().saveOrUpdate(clienteSelecionado.getEndereco1());

            if(ckbDados2.isSelected()){
                clienteSelecionado.getEndereco2().setRua(txtLogradouro2.getText());
                clienteSelecionado.getEndereco2().setNumero(Short.valueOf(txtNumero2.getText()));
                clienteSelecionado.getEndereco2().setBairro(txtBairro2.getText());
                clienteSelecionado.getEndereco2().setComplemento(txtComplemento2.getText());
                clienteSelecionado.getTelefone2().setDdd(Byte.valueOf(txtTelefone2.getText()
                    .replace("(", "")
                    .replace(")", "")
                    .replace(" ", "")
                    .replace("-", "")
                    .substring(0, 2)));
                clienteSelecionado.getTelefone2().setNumero(Integer.valueOf(txtTelefone2.getText()
                    .replace("(", "")
                    .replace(")", "")
                    .replace(" ", "")
                    .replace("-", "")
                    .substring(2, 11)));
                clienteSelecionado.getTelefone2().setMensageiro(ckbMensageiro2.isSelected());

                clienteSelecionado.getTelefone2().setCliente(clienteSelecionado);
                clienteSelecionado.getEndereco2().setCliente(clienteSelecionado);
                new TelefoneDao().saveOrUpdate(clienteSelecionado.getTelefone2());
                new EnderecoDao().saveOrUpdate(clienteSelecionado.getEndereco2());

            }

        txtNome.setText(null);
        txtTelefone1.setText(null);
        ckbMensageiro1.setSelected(false);
        txtLogradouro1.setText(null);
        txtNumero1.setText(null);
        txtBairro1.setText(null);
        txtComplemento1.setText(null);
        txtTelefone2.setText(null);
        ckbMensageiro2.setSelected(false);
        txtLogradouro2.setText(null);
        txtNumero2.setText(null);
        txtBairro2.setText(null);
        txtComplemento2.setText(null);
        ckbDados2.setSelected(false);
        txtNome.requestFocus();

        } catch (Exception ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(">> "+ clienteSelecionado);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtLogradouro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouro2ActionPerformed

    private void txtComplemento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplemento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplemento1ActionPerformed

    private void txtLogradouro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouro1ActionPerformed

    private void lstClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClienteMouseClicked
        txtNome.setText(null);
        txtTelefone1.setText(null);
        ckbMensageiro1.setSelected(false);
        txtLogradouro1.setText(null);
        txtComplemento1.setText(null);
        txtBairro1.setText(null);
        txtNumero1.setText(null);
        txtTelefone2.setText(null);
        ckbMensageiro2.setSelected(false);
        txtLogradouro2.setText(null);
        txtComplemento2.setText(null);
        txtBairro2.setText(null);
        txtNumero2.setText(null);
        
        clienteSelecionado = lstCliente.getSelectedValue();
        ArrayList<Endereco> enderecos = (ArrayList<Endereco>) new EnderecoDao().findByClienteId(clienteSelecionado.getId());
        ArrayList<Telefone> telefones = (ArrayList<Telefone>) new TelefoneDao().findByClienteId(clienteSelecionado.getId());
        clienteSelecionado.setEnderecos(enderecos);
        clienteSelecionado.setTelefones(telefones);
        String Telefone1,Telefone2;
        
        txtNome.setText(clienteSelecionado.getNome());
        if(!telefones.isEmpty()){
            Telefone1 = String.valueOf(clienteSelecionado.getTelefone1().getDdd()) + String.valueOf(clienteSelecionado.getTelefone1().getNumero());
            txtTelefone1.setText(Telefone1);
            ckbMensageiro1.setSelected(clienteSelecionado.getTelefone1().getMensageiro());
        }
        if(telefones.size() > 1) {
            Telefone2 = String.valueOf(clienteSelecionado.getTelefone2().getDdd()) + String.valueOf(clienteSelecionado.getTelefone2().getNumero());
            txtTelefone2.setText(Telefone2);
            ckbMensageiro2.setSelected(clienteSelecionado.getTelefone2().getMensageiro());
        }   
        
        if(!enderecos.isEmpty()){
            txtLogradouro1.setText(clienteSelecionado.getEndereco1().getRua());
            txtComplemento1.setText(clienteSelecionado.getEndereco1().getComplemento());
            txtBairro1.setText(clienteSelecionado.getEndereco1().getBairro());
            txtNumero1.setText(String.valueOf(clienteSelecionado.getEndereco1().getNumero())); 
        }
        if(enderecos.size() > 1) {
            txtLogradouro2.setText(clienteSelecionado.getEndereco2().getRua());
            txtComplemento2.setText(clienteSelecionado.getEndereco2().getComplemento());
            txtBairro2.setText(clienteSelecionado.getEndereco2().getBairro());
            txtNumero2.setText(String.valueOf(clienteSelecionado.getEndereco2().getNumero()));
        }    
        

    }//GEN-LAST:event_lstClienteMouseClicked

    private void txtNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero2ActionPerformed

    private void ckbDados2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDados2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbDados2ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        clienteSelecionado.setExcluido(true);
        clienteSelecionado.getEndereco1().setExcluido(true);
        clienteSelecionado.getEndereco2().setExcluido(true);
        clienteSelecionado.getTelefone1().setExcluido(true);
        clienteSelecionado.getTelefone2().setExcluido(true);

        
        new ClienteDao().moveToTrash(clienteSelecionado);
        new EnderecoDao().moveToTrash(clienteSelecionado.getEndereco1());
        new EnderecoDao().moveToTrash(clienteSelecionado.getEndereco2());
        new TelefoneDao().moveToTrash(clienteSelecionado.getTelefone1());
        new TelefoneDao().moveToTrash(clienteSelecionado.getTelefone2());
        
        allClient.clear();
        allClient.addAll(new ClienteDao().findAll());
        
        txtNome.setText(null);
        txtTelefone1.setText(null);
        ckbMensageiro1.setSelected(false);
        txtLogradouro1.setText(null);
        txtComplemento1.setText(null);
        txtBairro1.setText(null);
        txtNumero1.setText(null);
        txtTelefone2.setText(null);
        ckbMensageiro2.setSelected(false);
        txtLogradouro2.setText(null);
        txtComplemento2.setText(null);
        txtBairro2.setText(null);
        txtNumero2.setText(null);
    }//GEN-LAST:event_btnExcluirActionPerformed

    
    private class ClienteRenderer
            extends JLabel
            implements ListCellRenderer<Cliente> {

        @Override
        public Component getListCellRendererComponent(
                JList<? extends Cliente > list, Cliente value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value == null) {
                return this;
            }

            setOpaque(true);
            setForeground(SystemColor.textText);
            setBackground(SystemColor.text);
            if (isSelected) {
                setForeground(SystemColor.textHighlightText);
                setBackground(SystemColor.textHighlight);
            }

            setText(value.getNome());

            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JCheckBox ckbDados2;
    private javax.swing.JCheckBox ckbMensageiro1;
    private javax.swing.JCheckBox ckbMensageiro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Cliente> lstCliente;
    private javax.swing.JFormattedTextField txtBairro1;
    private javax.swing.JFormattedTextField txtBairro2;
    private javax.swing.JFormattedTextField txtComplemento1;
    private javax.swing.JFormattedTextField txtComplemento2;
    private javax.swing.JFormattedTextField txtLogradouro1;
    private javax.swing.JFormattedTextField txtLogradouro2;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero1;
    private javax.swing.JFormattedTextField txtNumero2;
    private javax.swing.JFormattedTextField txtTelefone1;
    private javax.swing.JFormattedTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables
}
