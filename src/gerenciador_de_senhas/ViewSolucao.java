/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gerenciador_de_senhas;

import control.ControlSolucao;
import control.ControlUsuario;
import gerenciador_de_senhas.model.ModelSolucao;
import gerenciador_de_senhas.model.ModelUsuario;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fernando.oliveira
 */
public class ViewSolucao extends javax.swing.JFrame {
    
       ControlSolucao controlsolucao = new ControlSolucao();
       ArrayList<ModelSolucao> listamModelSolucao = new ArrayList<ModelSolucao>();
    
    /**
     * Creates new form ViewInfra
     */
    public ViewSolucao() throws SQLException, ParseException {
        initComponents();
             carregarSolucao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    //LISTAR SOLUÇÕES    
    private void carregarSolucao() throws SQLException, ParseException {

        listamModelSolucao = controlsolucao.getListaSolucaoControl();
        DefaultTableModel modelo = (DefaultTableModel) tblSolucao.getModel();

        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listamModelSolucao.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listamModelSolucao.get(i).getId(),
                listamModelSolucao.get(i).gettitle(),
                listamModelSolucao.get(i).getUrl(),
                listamModelSolucao.get(i).getDescricao()
                    
              
            });

        }

    }
    
    //ABRIR LINK
public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    
       //SETAR CAMPOS
    private void setarCampos() throws ParseException, SQLException {
        int setar = tblSolucao.getSelectedRow();
        ControlSolucao control = new ControlSolucao();
        ModelSolucao modelSolucao = new ModelSolucao();
        String id = tblSolucao.getModel().getValueAt(setar, 0).toString();        
        modelSolucao.setId(Integer.parseInt(id));
        modelSolucao =  controlsolucao.controlGetUser(modelSolucao);
        System.out.print(id);
        txtTitle.setText(modelSolucao.gettitle());
        url.setText(modelSolucao.getUrl());
        descricao.setText(modelSolucao.getDescricao());
//        txtDescricao.setText(modelusuario.getDescricacao());
//        txtLocalidade.setText(modelusuario.getLocalidade());
//        txtEmail.setText(modelusuario.getEmail());
//        txtTag.setText(modelusuario.getTag());

        //selecao();

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolucao = new javax.swing.JTable();
        pesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDel1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnVisu = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSolucao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblSolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Titulo", "URL"
            }
        ));
        tblSolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSolucaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSolucao);
        if (tblSolucao.getColumnModel().getColumnCount() > 0) {
            tblSolucao.getColumnModel().getColumn(0).setMinWidth(50);
            tblSolucao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSolucao.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSolucao.getColumnModel().getColumn(1).setMinWidth(300);
            tblSolucao.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblSolucao.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/pesquisa.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel4.setText("Titulo");

        url.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setText("Endereço");

        btnDel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/editar-texto.png"))); // NOI18N
        btnDel1.setText("Novo");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/marca-de-verificacao.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnVisu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVisu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/oculos-de-leitura-vintage.png"))); // NOI18N
        btnVisu.setText("Visualizar");
        btnVisu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisuActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/editar-texto.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/deletar-lixeira.png"))); // NOI18N
        btnDel.setText("Remover");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("GUIA DE RESOLUÇÃO");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane2.setViewportView(descricao);

        jLabel8.setText("Descrição");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(url)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(272, 272, 272)
                                        .addComponent(jButton1)))
                                .addGap(415, 415, 415))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnDel1)
                                .addGap(89, 89, 89)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisu)
                                .addGap(26, 26, 26)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel15)))
                        .addContainerGap())))
            .addComponent(txtTitle)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnVisu)
                    .addComponent(btnEdit)
                    .addComponent(btnDel)
                    .addComponent(btnDel1))
                .addGap(38, 38, 38))
        );

        setSize(new java.awt.Dimension(848, 646));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblSolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSolucaoMouseClicked
       try {
            // TODO add your handling code here:
            setarCampos();
        } catch (ParseException ex) {
            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_tblSolucaoMouseClicked

    private void pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarKeyReleased
     
    }//GEN-LAST:event_pesquisarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
       txtTitle.setText("");
       url.setText("");
       descricao.setText("");
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
              try {
                ModelSolucao modelSolucao = new ModelSolucao();
                ControlSolucao controlSolucao = new ControlSolucao();
                modelSolucao.settitle(txtTitle.getText().toUpperCase());
                modelSolucao.setUrl(url.getText());
                modelSolucao.setDescricao(descricao.getText().toUpperCase());               
                controlSolucao.verificaUsuario(modelSolucao);
                
                txtTitle.setText("");
              //  txtGrupo.setText("");
                url.setText("");
                descricao.setText("");
              
                //carregarUsuarios();
        } catch (Exception e) {
        }
     
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnVisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisuActionPerformed
        // TODO add your handling code here:
        String urlString = url.getText();
        
        openWebpage(urlString);
     
    }//GEN-LAST:event_btnVisuActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewSolucao().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewSolucao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewSolucao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnVisu;
    private javax.swing.JTextArea descricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JTable tblSolucao;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
