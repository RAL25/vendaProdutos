/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package io.github.yodemisj.sabordecasa.GUI;

import io.github.yodemisj.sabordecasa.funcionario.Credencial;
import io.github.yodemisj.sabordecasa.funcionario.CredencialDao;
import io.github.yodemisj.sabordecasa.funcionario.Funcionario;
import io.github.yodemisj.sabordecasa.funcionario.FuncionarioDao;
import java.awt.Component;
import java.awt.SystemColor;
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
public class EditaFuncionario extends javax.swing.JInternalFrame {
    
    //private static EditaFuncionario instance;
    private Funcionario funcionarioSelecionado;

    private static final DefaultListModel<Funcionario> allFunc
            = new DefaultListModel<>();
    public EditaFuncionario() {
        initComponents();
        lstFuncionario.setModel(allFunc);
        lstFuncionario.setCellRenderer(new FuncionarioRenderer());
        allFunc.clear();
        allFunc.addAll(new FuncionarioDao().findAll());
        funcionarioSelecionado = new Funcionario();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuncionario = new javax.swing.JList<>();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pwdSenha = new javax.swing.JPasswordField();
        chkAdministrador = new javax.swing.JCheckBox();
        pwdConfirmarSenha = new javax.swing.JPasswordField();
        lblCadastrarSenha = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        chkAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        lstFuncionario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFuncionarioMouseClicked(evt);
            }
        });
        lstFuncionario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFuncionarioValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFuncionario);

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setText("Nome:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSenha.setText("Senha:");

        pwdSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdSenhaActionPerformed(evt);
            }
        });
        pwdSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwdSenhaKeyReleased(evt);
            }
        });

        chkAdministrador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkAdministrador.setText("Administrador");
        chkAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAdministradorActionPerformed(evt);
            }
        });

        pwdConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdConfirmarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdConfirmarSenhaActionPerformed(evt);
            }
        });
        pwdConfirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwdConfirmarSenhaKeyReleased(evt);
            }
        });

        lblCadastrarSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCadastrarSenha.setText("Confirmar Senha:");

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        chkAtivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkAtivo.setSelected(true);
        chkAtivo.setText("Ativo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCadastrarSenha)
                                .addGap(14, 14, 14)
                                .addComponent(pwdConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSenha)
                                .addGap(20, 20, 20)
                                .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkAdministrador)
                            .addComponent(chkAtivo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAdministrador))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadastrarSenha)
                    .addComponent(pwdConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAtivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
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

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        funcionarioSelecionado.setExcluido(true);
        new FuncionarioDao().moveToTrash(funcionarioSelecionado);
        allFunc.clear();
        allFunc.addAll(new FuncionarioDao().findAll());
        
        txtNome.setText(null);
        txtEmail.setText(null);
        pwdSenha.setText(null);
        pwdConfirmarSenha.setText(null);
        chkAdministrador.setSelected(false);
        chkAtivo.setSelected(false);
        txtNome.requestFocus();
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        Funcionario funcionario = funcionarioSelecionado;
        Credencial credencial = funcionarioSelecionado.getCredencial();
        funcionario.setNome(txtNome.getText());
        credencial.setEmail(txtEmail.getText());
        credencial.setSenha(String.valueOf(pwdSenha.getPassword()));
        funcionario.setCredencial(credencial);
        funcionario.setAdministrador(chkAdministrador.isSelected());
        funcionario.setAtivo(chkAtivo.isSelected());
        new FuncionarioDao().saveOrUpdate(funcionario);
        new CredencialDao().saveOrUpdate(credencial);

        txtNome.setText(null);
        txtEmail.setText(null);
        pwdSenha.setText(null);
        pwdConfirmarSenha.setText(null);
        chkAdministrador.setSelected(false);
        chkAtivo.setSelected(false);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void pwdConfirmarSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdConfirmarSenhaKeyReleased
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_pwdConfirmarSenhaKeyReleased

    private void pwdConfirmarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdConfirmarSenhaActionPerformed
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_pwdConfirmarSenhaActionPerformed

    private void chkAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAdministradorActionPerformed

    private void pwdSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdSenhaKeyReleased
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_pwdSenhaKeyReleased

    private void pwdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdSenhaActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void lstFuncionarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFuncionarioValueChanged
//        funcionarioSelecionado = lstFuncionario.getSelectedValue();
//        txtNome.setText(funcionarioSelecionado.getNome());
//        txtEmail.setText(funcionarioSelecionado.getCredencial().getEmail());
//        chkAdministrador.setSelected(funcionarioSelecionado.getAdministrador());
//        chkAtivo.setSelected(funcionarioSelecionado.getAtivo());
//        pwdSenha.setText(funcionarioSelecionado.getCredencial().getSenha());
//        pwdConfirmarSenha.setText(funcionarioSelecionado.getCredencial().getSenha());
//
//        if (String.valueOf(pwdSenha.getPassword())
//            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
//            && !txtNome.getText().trim().isEmpty()
//            && !txtEmail.getText().trim().isEmpty()){
//            btnAtualizar.setEnabled(true);
//        } else {
//            btnAtualizar.setEnabled(false);
//        }
    }//GEN-LAST:event_lstFuncionarioValueChanged

    private void lstFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFuncionarioMouseClicked
        funcionarioSelecionado = lstFuncionario.getSelectedValue();
        txtNome.setText(funcionarioSelecionado.getNome());
        txtEmail.setText(funcionarioSelecionado.getCredencial().getEmail());
        chkAdministrador.setSelected(funcionarioSelecionado.getAdministrador());
        chkAtivo.setSelected(funcionarioSelecionado.getAtivo());
        pwdSenha.setText(funcionarioSelecionado.getCredencial().getSenha());
        pwdConfirmarSenha.setText(funcionarioSelecionado.getCredencial().getSenha());

        if (String.valueOf(pwdSenha.getPassword())
            .equals(String.valueOf(pwdConfirmarSenha.getPassword()))
            && !txtNome.getText().trim().isEmpty()
            && !txtEmail.getText().trim().isEmpty()){
            btnAtualizar.setEnabled(true);
        } else {
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_lstFuncionarioMouseClicked

    private class FuncionarioRenderer
            extends JLabel
            implements ListCellRenderer<Funcionario> {

        @Override
        public Component getListCellRendererComponent(
                JList<? extends Funcionario > list, Funcionario value,
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

            // The value to be rendered on the combo box
            setText(value.getNome());

            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JCheckBox chkAdministrador;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCadastrarSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JList<Funcionario> lstFuncionario;
    private javax.swing.JPasswordField pwdConfirmarSenha;
    private javax.swing.JPasswordField pwdSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}