/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Cliente;
import controller.ControllerCliente;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.table.TableRowSorter;

/**
 *
 * @author marin
 */
public class ListarClientes extends javax.swing.JFrame {

    
    
    /**
     * Creates new form VerClientes
     */
    public ListarClientes() throws IOException {
        initComponents();
        this.buscaTabelaInteira();
        TabelaClientes.setEnabled(false);
    }

    private void buscaTabelaInteira() throws IOException{
            String[] colunas = {"Codigo", "Nome", "RG", "CPF", "Telefone", "Endereco", "Email"};
            DefaultTableModel modelo = (DefaultTableModel) TabelaClientes.getModel();
            modelo.setRowCount(0);
            modelo.setColumnIdentifiers(colunas);

            ControllerCliente controller = new ControllerCliente();
            controller.CriaConexao();
            List<Cliente> listaClientes = controller.BuscaTudo();
            controller.FechaConexao();
      

           
            listaClientes.forEach((t) -> {
                System.out.println(t);
            });
        for (Cliente cliente : listaClientes) {
            Object[] dataRow = {
                cliente.getCodCli(),
                cliente.getNome(),
                cliente.getRg(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.geteMail()
            };
            modelo.addRow(dataRow);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        EntradaPesquisar = new javax.swing.JTextField();
        BtnPesquisar = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Clientes");

        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaClientesMouseClicked(evt);
            }
        });
        TabelaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaClientes);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPesquisar)
                .addGap(18, 18, 18)
                .addComponent(BtnLimpar)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EntradaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        
        try {
            this.buscaTabelaInteira();
            
            Vector originalTableModel = (Vector) ((DefaultTableModel) TabelaClientes.getModel()).getDataVector().clone();
            
            Vector registrosEncontrados = new Vector();
            
            //Verificando se o campo está vazio
            if (EntradaPesquisar.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha o campo vazio!", "Dados Incompletos", JOptionPane.OK_OPTION);
                EntradaPesquisar.requestFocus();
                return;
            }
            
            
            
            DefaultTableModel modelo = (DefaultTableModel) TabelaClientes.getModel();
            modelo.setRowCount(0);
            ControllerCliente controllerCliente = new ControllerCliente();
            controllerCliente.CriaConexao();
            List<Cliente> listaClientes = controllerCliente.BuscaParametro(EntradaPesquisar.getText());
            controllerCliente.FechaConexao();
            
             for (Cliente cliente : listaClientes) {
            Object[] dataRow = {
                cliente.getCodCli(),
                cliente.getNome(),
                cliente.getRg(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.geteMail()
            };
            modelo.addRow(dataRow);
         }
        } catch (IOException ex) {
            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void TabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClientesMouseClicked
        
        if (TabelaClientes.getSelectedRow() != -1){
            
            try {
                
                EntradaPesquisar.setText(String.valueOf(TabelaClientes.getModel().getValueAt(TabelaClientes.getSelectedRow(), 1)));
                
            } catch (Exception e){
                
                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                e.printStackTrace();
                
            }
            
        }
        
    }//GEN-LAST:event_TabelaClientesMouseClicked

    private void TabelaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaClientesKeyReleased
        
        if (TabelaClientes.getSelectedRow() != -1){
            
            try {
                
                EntradaPesquisar.setText(String.valueOf(TabelaClientes.getModel().getValueAt(TabelaClientes.getSelectedRow(), 1)));
                
            } catch (Exception e){
                
                JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
                e.printStackTrace();
                
            }
            
        }
        
    }//GEN-LAST:event_TabelaClientesKeyReleased

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        try {
            EntradaPesquisar.setText("");
            EntradaPesquisar.requestFocus();
            buscaTabelaInteira();
        } catch (IOException ex) {
            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListarClientes().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLimpar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTextField EntradaPesquisar;
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
