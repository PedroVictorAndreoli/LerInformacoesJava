/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import controller.ControllerLocacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marin
 */
public class ExcluirLocacoes extends javax.swing.JFrame {

    private final String filePath = System.getProperty("user.dir")+"\\Arquivos\\locacoes.txt";
    private final File file = new File(filePath);
    
    /**
     * Creates new form ExcluirLocacoes
     */
    public ExcluirLocacoes() {
        initComponents();
        this.buscaTabelaInteira(file);
        TabelaLocacao.setEnabled(false);
    }
    
    private void buscaTabelaInteira(File file){
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] colunas = {"Nº do Contrato","Data de Início","Data Final","Cod. do Cliente", "Filme"};
            DefaultTableModel modelo = (DefaultTableModel) TabelaLocacao.getModel();
            modelo.setRowCount(0);
            modelo.setColumnIdentifiers(colunas);

            Object[] linhas = br.lines().toArray();

            for (int i=0; i<linhas.length; i++){
                String line = linhas[i].toString().trim();
                String[] dataRow = line.split(";");
                modelo.addRow(dataRow);
            }

            return;

        } catch (Exception ex) {

            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
            return;

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

        jLabel1 = new javax.swing.JLabel();
        EntradaPesquisar = new javax.swing.JTextField();
        BtnPesquisar = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLocacao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        EntradaCodLocacao = new javax.swing.JTextField();
        BtnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exclusão de Locações");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Exclusão de Locações");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nº do contrato");

        EntradaCodLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaCodLocacaoActionPerformed(evt);
            }
        });

        BtnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnExcluir.setText("Excluir");
        BtnExcluir.setToolTipText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
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
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(EntradaCodLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(BtnExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimpar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtnLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EntradaCodLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(BtnExcluir)
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed

        this.buscaTabelaInteira(file);

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
        EntradaPesquisar.setText("");
        EntradaCodLocacao.requestFocus();
        buscaTabelaInteira(file);
    }//GEN-LAST:event_BtnLimparActionPerformed

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

    private void EntradaCodLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaCodLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaCodLocacaoActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed

        //Verificando se algum campo está vazio
        if (EntradaCodLocacao.getText().isEmpty()){
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
        
        String mensagem = "Deseja excluir os dados?";
        String title = "Confirmar operação";
        int res = JOptionPane.showConfirmDialog(null, mensagem, title, JOptionPane.YES_NO_OPTION);

        if (res == 0) {

            try {

                ControllerLocacao controller = new ControllerLocacao();
                controller.deletaLocacao(EntradaCodLocacao.getText());
                EntradaCodLocacao.setText("");
                EntradaPesquisar.setText("");
                EntradaCodLocacao.requestFocus();
                this.buscaTabelaInteira(file);

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                ex.printStackTrace();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Operação cancelada!", "", JOptionPane.OK_OPTION);

        }

    }//GEN-LAST:event_BtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ExcluirLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluirLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluirLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluirLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirLocacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnLimpar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTextField EntradaCodLocacao;
    private javax.swing.JTextField EntradaPesquisar;
    private javax.swing.JTable TabelaLocacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
