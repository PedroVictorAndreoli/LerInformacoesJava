/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        String basePath = System.getProperty("user.dir") + "\\Arquivos\\";
        
        criarArquivoBinario(basePath + "clientes.dat");
        criarArquivoBinario(basePath + "filmes.dat");
        criarArquivoBinario(basePath + "locacoes.dat");
        
        initComponents();
    }
    
    private static void criarArquivoBinario(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(new byte[0]);  // Escreve um arquivo binário vazio
                fos.close();
                System.out.println("Arquivo criado em " + filePath);
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o arquivo.");
                e.printStackTrace();
            }
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        jMenuItemListarCliente = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAtualizarClientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExcluirClientes = new javax.swing.JMenuItem();
        jMenuFilmes = new javax.swing.JMenu();
        jMenuItemListarFilmes = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarFilmes = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAtualizarFilmes = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExcluirFilmes = new javax.swing.JMenuItem();
        jMenuLocacoes = new javax.swing.JMenu();
        jMenuItemListarLocacoes = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarLocacoes = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAtualizarLocacoes = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExcluirLocacoes = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Locadora de Filmes");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Locadora de Filmes");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuClientes.setText("Clientes");
        jMenuClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuClientesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jMenuItemListarCliente.setText("Listar");
        jMenuItemListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarClienteActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemListarCliente);
        jMenuClientes.add(jSeparator4);

        jMenuItemCadastrarCliente.setText("Cadastrar");
        jMenuItemCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarClienteActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemCadastrarCliente);
        jMenuClientes.add(jSeparator1);

        jMenuItemAtualizarClientes.setText("Atualizar");
        jMenuItemAtualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarClientesActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemAtualizarClientes);
        jMenuClientes.add(jSeparator2);

        jMenuItemExcluirClientes.setText("Excluir");
        jMenuItemExcluirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirClientesActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemExcluirClientes);

        jMenuBar1.add(jMenuClientes);

        jMenuFilmes.setText("Filmes");
        jMenuFilmes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuFilmesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenuFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuFilmesMouseClicked(evt);
            }
        });

        jMenuItemListarFilmes.setText("Listar");
        jMenuItemListarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFilmesActionPerformed(evt);
            }
        });
        jMenuFilmes.add(jMenuItemListarFilmes);
        jMenuFilmes.add(jSeparator3);

        jMenuItemCadastrarFilmes.setText("Cadastrar");
        jMenuItemCadastrarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarFilmesActionPerformed(evt);
            }
        });
        jMenuFilmes.add(jMenuItemCadastrarFilmes);
        jMenuFilmes.add(jSeparator5);

        jMenuItemAtualizarFilmes.setText("Atualizar");
        jMenuItemAtualizarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarFilmesActionPerformed(evt);
            }
        });
        jMenuFilmes.add(jMenuItemAtualizarFilmes);
        jMenuFilmes.add(jSeparator6);

        jMenuItemExcluirFilmes.setText("Excluir");
        jMenuItemExcluirFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirFilmesActionPerformed(evt);
            }
        });
        jMenuFilmes.add(jMenuItemExcluirFilmes);

        jMenuBar1.add(jMenuFilmes);

        jMenuLocacoes.setText("Locações");
        jMenuLocacoes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuLocacoesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenuLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuLocacoesMouseClicked(evt);
            }
        });

        jMenuItemListarLocacoes.setText("Listar");
        jMenuItemListarLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarLocacoesActionPerformed(evt);
            }
        });
        jMenuLocacoes.add(jMenuItemListarLocacoes);
        jMenuLocacoes.add(jSeparator7);

        jMenuItemCadastrarLocacoes.setText("Cadastrar");
        jMenuItemCadastrarLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarLocacoesActionPerformed(evt);
            }
        });
        jMenuLocacoes.add(jMenuItemCadastrarLocacoes);
        jMenuLocacoes.add(jSeparator8);

        jMenuItemAtualizarLocacoes.setText("Atualizar");
        jMenuItemAtualizarLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarLocacoesActionPerformed(evt);
            }
        });
        jMenuLocacoes.add(jMenuItemAtualizarLocacoes);
        jMenuLocacoes.add(jSeparator9);

        jMenuItemExcluirLocacoes.setText("Excluir");
        jMenuItemExcluirLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirLocacoesActionPerformed(evt);
            }
        });
        jMenuLocacoes.add(jMenuItemExcluirLocacoes);

        jMenuBar1.add(jMenuLocacoes);

        jMenuSair.setText("Sair");
        jMenuSair.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuSairAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuClientesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuClientesAncestorAdded

    private void jMenuItemCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarClienteActionPerformed
        CadastraClientes clientes = new CadastraClientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarClienteActionPerformed

    private void jMenuItemListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarClienteActionPerformed
        ListarClientes listarCli = new ListarClientes();
        listarCli.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarClienteActionPerformed

    private void jMenuFilmesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuFilmesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFilmesAncestorAdded

    private void jMenuFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuFilmesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFilmesMouseClicked

    private void jMenuLocacoesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuLocacoesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuLocacoesAncestorAdded

    private void jMenuLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuLocacoesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuLocacoesMouseClicked

    private void jMenuItemExcluirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirClientesActionPerformed
        ExcluirClientes excluir = new ExcluirClientes();
        excluir.setVisible(true);
    }//GEN-LAST:event_jMenuItemExcluirClientesActionPerformed

    private void jMenuItemCadastrarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarFilmesActionPerformed
        CadastraFilmes cadastrar = new CadastraFilmes();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarFilmesActionPerformed

    private void jMenuSairAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuSairAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuSairAncestorAdded

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        String mensagem = "Deseja fechar o sistema?";
        String title = "Confirmar operação";
        int res = JOptionPane.showConfirmDialog(null, mensagem, title, JOptionPane.YES_NO_OPTION);

        if (res == 0)
            System.exit(0);
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItemAtualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarClientesActionPerformed
        AtualizarClientes atualizar = null;
        try {
            atualizar = new AtualizarClientes();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizar.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarClientesActionPerformed

    private void jMenuItemListarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFilmesActionPerformed
        ListarFilmes listar = new ListarFilmes();
        listar.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarFilmesActionPerformed

    private void jMenuItemAtualizarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarFilmesActionPerformed
        AtualizarFilmes atualizar = new AtualizarFilmes();
        atualizar.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarFilmesActionPerformed

    private void jMenuItemExcluirFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirFilmesActionPerformed
        ExcluirFilmes excluir = new ExcluirFilmes();
        excluir.setVisible(true);
    }//GEN-LAST:event_jMenuItemExcluirFilmesActionPerformed

    private void jMenuItemListarLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarLocacoesActionPerformed
        ListarLocacoes listar = new ListarLocacoes();
        listar.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarLocacoesActionPerformed

    private void jMenuItemCadastrarLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarLocacoesActionPerformed
        CadastraLocacoes cadastrar = new CadastraLocacoes();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarLocacoesActionPerformed

    private void jMenuItemAtualizarLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarLocacoesActionPerformed
        AtualizarLocacoes atualizar = new AtualizarLocacoes();
        atualizar.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarLocacoesActionPerformed

    private void jMenuItemExcluirLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirLocacoesActionPerformed
        ExcluirLocacoes excluir = new ExcluirLocacoes();
        excluir.setVisible(true);
    }//GEN-LAST:event_jMenuItemExcluirLocacoesActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAtualizarClientes;
    private javax.swing.JMenuItem jMenuItemAtualizarLocacoes;
    private javax.swing.JMenuItem jMenuItemAtualizarFilmes;
    private javax.swing.JMenuItem jMenuItemCadastrarCliente;
    private javax.swing.JMenuItem jMenuItemCadastrarLocacoes;
    private javax.swing.JMenuItem jMenuItemCadastrarFilmes;
    private javax.swing.JMenuItem jMenuItemExcluirClientes;
    private javax.swing.JMenuItem jMenuItemExcluirLocacoes;
    private javax.swing.JMenuItem jMenuItemExcluirFilmes;
    private javax.swing.JMenuItem jMenuItemListarCliente;
    private javax.swing.JMenuItem jMenuItemListarLocacoes;
    private javax.swing.JMenuItem jMenuItemListarFilmes;
    private javax.swing.JMenu jMenuLocacoes;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuFilmes;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
