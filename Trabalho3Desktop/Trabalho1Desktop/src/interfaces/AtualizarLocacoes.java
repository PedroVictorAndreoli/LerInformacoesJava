/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Filme;
import classes.Locacao;
import controller.ControllerLocacao;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marin
 */
public class AtualizarLocacoes extends javax.swing.JFrame {
    
    /**
     * Creates new form AtualizarLocacoes
     */
    public AtualizarLocacoes() throws IOException, ClassNotFoundException {
        initComponents();
        this.buscaTabelaInteira();
        TabelaLocacao.setEnabled(false);
    }
    
    private void buscaTabelaInteira() throws IOException, ClassNotFoundException{
            String[] colunas = {"Nº do Contrato","Data de Início","Data Final","Cod. do Cliente", "Filme"};
            DefaultTableModel modelo = (DefaultTableModel) TabelaLocacao.getModel();
            modelo.setRowCount(0);
            modelo.setColumnIdentifiers(colunas);
            ControllerLocacao controllerLocacao = new ControllerLocacao();
            controllerLocacao.CriaConexao();
            List<Locacao> listaClientes = controllerLocacao.BuscaTudo();
            controllerLocacao.FechaConexao();
            
        for (Locacao cliente : listaClientes) {
            Object[] dataRow = {
                cliente.getCodLocacao(),
                cliente.getDataInicio(),
                cliente.getDataFinal(),
                cliente.getCodigoCliente(),
                cliente.getFilme().getTitulo()
            };
            modelo.addRow(dataRow);

        } 
        
        
    }
    
    public boolean temNumeros(String str) {

        try {

            int valor = Integer.parseInt(str);
            return true;

        } catch (NumberFormatException e) {

            return false;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLocacao = new javax.swing.JTable();
        EntradaPesquisar = new javax.swing.JTextField();
        BtnPesquisar = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EntradaCodLocacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EntradaDataInicio = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        EntradaDataFinal = new javax.swing.JFormattedTextField();
        BtnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualização de Locações");

        TabelaLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaLocacaoMouseClicked(evt);
            }
        });
        TabelaLocacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaLocacaoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaLocacao);

        EntradaPesquisar.setToolTipText("Insira o nome da pesquisa");

        BtnPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnPesquisar.setText("Pesquisar");
        BtnPesquisar.setToolTipText("Pesquisar");
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });

        BtnLimpar.setText("Limpar");
        BtnLimpar.setToolTipText("Limpar dados");
        BtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atualização de Locações");

        EntradaCodLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaCodLocacaoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nº do contrato:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data de Início:");

        try {
            EntradaDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Data Final:");

        try {
            EntradaDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BtnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnAtualizar.setText("Atualizar");
        BtnAtualizar.setToolTipText("Atualizar");
        BtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EntradaDataInicio)
                            .addComponent(jLabel4)
                            .addComponent(EntradaCodLocacao)
                            .addComponent(EntradaDataFinal, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimpar)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtnPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(BtnLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EntradaCodLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(EntradaDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(EntradaDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaLocacaoMouseClicked

        if (TabelaLocacao.getSelectedRow() != -1){

            try {

                EntradaPesquisar.setText(String.valueOf(TabelaLocacao.getModel().getValueAt(TabelaLocacao.getSelectedRow(), 1)));

            } catch (Exception e){

                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                e.printStackTrace();

            }

        }
    }//GEN-LAST:event_TabelaLocacaoMouseClicked

    private void TabelaLocacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaLocacaoKeyReleased

        if (TabelaLocacao.getSelectedRow() != -1){

            try {

                EntradaPesquisar.setText(String.valueOf(TabelaLocacao.getModel().getValueAt(TabelaLocacao.getSelectedRow(), 1)));

            } catch (Exception e){

                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                e.printStackTrace();

            }

        }
    }//GEN-LAST:event_TabelaLocacaoKeyReleased

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed

        try {
            this.buscaTabelaInteira();
        } catch (IOException ex) {
            Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        Vector originalTableModel = (Vector) ((DefaultTableModel) TabelaLocacao.getModel()).getDataVector().clone();

        Vector registrosEncontrados = new Vector();

        if (!EntradaPesquisar.getText().isEmpty()){

            DefaultTableModel modelo = (DefaultTableModel) TabelaLocacao.getModel();
            modelo.setRowCount(0);

            for (Object linhas : originalTableModel){
                Vector rowVector = (Vector) linhas;
                for (Object colunas : rowVector){
                    if (colunas.toString().contains(EntradaPesquisar.getText())){
                        registrosEncontrados.add(rowVector);
                    }
                }
            }

            for (Object cliente: registrosEncontrados){
                modelo.addRow((Vector<?>) cliente);
            }
        }
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        EntradaCodLocacao.setText("");
        EntradaDataInicio.setText("");
        EntradaDataFinal.setText("");
        EntradaPesquisar.setText("");
        EntradaCodLocacao.requestFocus();
        try {
            buscaTabelaInteira();
        } catch (IOException ex) {
            Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnLimparActionPerformed

    private void EntradaCodLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaCodLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaCodLocacaoActionPerformed

    private void BtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtualizarActionPerformed

        //Verificando se algum campo está vazio
        if (EntradaCodLocacao.getText().isEmpty() || EntradaDataInicio.getText().isEmpty() || EntradaDataFinal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos vazios!", "Dados incompletos", JOptionPane.OK_OPTION);
            EntradaCodLocacao.requestFocus();
            return;
        }
        
        //Verificando se "Nº do Contrato" é composto apenas por números
        if (!temNumeros(EntradaCodLocacao.getText())){
            JOptionPane.showMessageDialog(null, "Valores inseridos incorretamente!", "Falha Encontrada", JOptionPane.OK_OPTION);
            EntradaCodLocacao.requestFocus();
            return;
        }
        
        String mensagem = "Deseja atualizar os dados?";
        String title = "Confirmar operação";
        int res = JOptionPane.showConfirmDialog(null, mensagem, title, JOptionPane.YES_NO_OPTION);

        if (res == 0) {

            try {

                ControllerLocacao controller = new ControllerLocacao();
                Locacao l = new Locacao();
                l.setCodLocacao(Integer.parseInt(EntradaCodLocacao.getText()));
                l.setDataInicio(EntradaDataInicio.getText());
                l.setDataFinal(EntradaDataFinal.getText());
                controller.CriaConexao();
                controller.Atualizar(l);
                controller.FechaConexao();
                EntradaCodLocacao.setText("");
                EntradaDataInicio.setText("");
                EntradaDataFinal.setText("");
                EntradaPesquisar.setText("");
                EntradaCodLocacao.requestFocus();
                this.buscaTabelaInteira();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                ex.printStackTrace();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Operação cancelada!", "", JOptionPane.OK_OPTION);

        }
    }//GEN-LAST:event_BtnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(AtualizarLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AtualizarLocacoes().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AtualizarLocacoes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizar;
    private javax.swing.JButton BtnLimpar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTextField EntradaCodLocacao;
    private javax.swing.JFormattedTextField EntradaDataFinal;
    private javax.swing.JFormattedTextField EntradaDataInicio;
    private javax.swing.JTextField EntradaPesquisar;
    private javax.swing.JTable TabelaLocacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
