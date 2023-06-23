/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador_de_senhas;

import java.security.*;
import java.math.*;
import control.ControlSenha;
import dao.Conexao;
import gerenciador_de_senhas.model.ModelCategoria;
import gerenciador_de_senhas.model.ModelSenha;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sun.security.provider.MD5;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PC
 */
public class ViewPass extends javax.swing.JFrame {

    Date now = new Date(System.currentTimeMillis());
    ArrayList<ModelSenha> listamModelApp = new ArrayList<ModelSenha>();
    ArrayList<ModelCategoria> listaCategoria = new ArrayList<ModelCategoria>();
    ControlSenha controlSenha = new ControlSenha();
     private static ViewPass instance;
    
    
       public static ViewPass getInstance() throws ParseException {
        try {
            if (instance == null) {
                instance = new ViewPass();
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);

        }
        return instance;
    }
    
    public void setarData() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = agora.format(formatter);
        data.setText(hojeFormatado);
    }

    public void copy() {
        Clipboard clipBoard = getToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(pass1.getText());
        clipBoard.setContents(ss, ss);
    }

    private void carregarApp() throws SQLException {

        listamModelApp = controlSenha.getListaAppControl();
        DefaultTableModel modelo = (DefaultTableModel) tabelaApp.getModel();

        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listamModelApp.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listamModelApp.get(i).getId(),
                listamModelApp.get(i).getAplicacao(),
                listamModelApp.get(i).getUsuario(),
                listamModelApp.get(i).getEndereco(),
                listamModelApp.get(i).getData()
            });

        }

    }

    private void listarCategoria(){

 //          return listaCategoria;
//
//
////            rs.first();
//            do {
//              //  cbCategoria.addItem(rs.getString("descricao"));
//            } while (rs.next());
        
    }
    
    
    
    
    
    public void selecao() {
        btnAdd.setEnabled(false);
        btnVisu.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDel.setEnabled(true);
    }

    public void btnEdit() {
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnVisu.setEnabled(false);
    }

    /**
     * Creates new form ViewPrincipal
     */
    public ViewPass() throws ParseException, SQLException {
        //data.setText(agora);

        initComponents();
        setarData();
        carregarApp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaApp = new javax.swing.JTable();
        pass1 = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();
        pass2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVisu = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        aplicacao = new javax.swing.JTextField();
        data = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDel1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbcategoria = new javax.swing.JComboBox<>();
        btnEdit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("BANCO DE SENHA MSTEC");

        pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarKeyReleased(evt);
            }
        });

        tabelaApp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Aplicação", "Usuario", "Endereço", "Data"
            }
        ));
        tabelaApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAppMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaAppMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaApp);
        if (tabelaApp.getColumnModel().getColumnCount() > 0) {
            tabelaApp.getColumnModel().getColumn(0).setMinWidth(30);
            tabelaApp.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaApp.getColumnModel().getColumn(0).setMaxWidth(50);
            tabelaApp.getColumnModel().getColumn(1).setMinWidth(150);
            tabelaApp.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelaApp.getColumnModel().getColumn(1).setMaxWidth(200);
            tabelaApp.getColumnModel().getColumn(4).setMinWidth(80);
            tabelaApp.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabelaApp.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        pass1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/marca-de-verificacao.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        pass2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Digite a Senha");

        jLabel3.setText("Confirme a Senha");

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
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel4.setText("Aplicação");

        aplicacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jLabel5.setText("Usuario");

        jLabel6.setText("Data");

        endereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("Endereço");

        btnDel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/editar-texto.png"))); // NOI18N
        btnDel1.setText("Copiar");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Categoria");

        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        btnEdit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciador_de_senhas/img/ID-Card-icon.png"))); // NOI18N
        btnEdit1.setText("Novo");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnDel1)
                .addGap(89, 89, 89)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisu)
                .addGap(26, 26, 26)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(330, 330, 330))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jButton1)))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(aplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnVisu)
                    .addComponent(btnEdit)
                    .addComponent(btnDel)
                    .addComponent(btnDel1)
                    .addComponent(btnEdit1))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(843, 424));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (pass1.getText().equals(pass2.getText())) {
            try {
                ModelSenha modeloSenha = new ModelSenha();
                modeloSenha.setAplicacao(aplicacao.getText().toUpperCase());
                modeloSenha.setUsuario(user.getText());
                modeloSenha.setSenha(pass1.getText());
                modeloSenha.setEndereco(endereco.getText());
                modeloSenha.setData(data.getText());

                ControlSenha control = new ControlSenha();
                control.verificaSenha(modeloSenha);
                carregarApp();
            } catch (ParseException ex) {
                Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.printf("As senhas não são iguais");
        }

        aplicacao.setText("");
        user.setText("");
        pass1.setText("");
        pass2.setText("");
        endereco.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void tabelaAppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAppMouseClicked
        try {
            // TODO add your handling code here:
            setarCampos();
        } catch (ParseException ex) {
            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelaAppMouseClicked

    private void btnVisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisuActionPerformed
        // TODO add your handling code here:
    if(btnVisu.getText().equals("Visualizar")){
             visiblePass();
             btnVisu.setText("Ocultar");
        }else{
            hidePass();
            btnVisu.setText("Visualizar");
        }  
    }//GEN-LAST:event_btnVisuActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (pass1.getText().equals(pass2.getText())) {
            try {
                int selecao = tabelaApp.getSelectedRow();
                int id = Integer.parseInt(tabelaApp.getModel().getValueAt(selecao, 0).toString());
                ModelSenha modeloSenha = new ModelSenha();
                modeloSenha.setId(id);
                modeloSenha.setAplicacao(aplicacao.getText().toUpperCase());
                modeloSenha.setUsuario(user.getText());
                modeloSenha.setSenha(pass1.getText());
                modeloSenha.setEndereco(endereco.getText());
                modeloSenha.setData(data.getText());

                ControlSenha control = new ControlSenha();
                control.controlEdit(modeloSenha);
                carregarApp();
            } catch (ParseException ex) {
                Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.printf("As senhas não são iguais");
        }

        aplicacao.setText("");
        user.setText("");
        pass1.setText("");
        pass2.setText("");
        endereco.setText("");

        btnEdit();

    }//GEN-LAST:event_btnEditActionPerformed

    private void pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarKeyReleased
     //   ControlSenha control = new ControlSenha();
        //System.err.print(pesquisar.getText());

//        try {
//
//            if (pesquisar.getText().equals("")) {
//                carregarApp();
//            } else {
//                ModelSenha rs;
//                rs = control.controlPesquisar(pesquisar.getText());
//                DefaultTableModel modelo = (DefaultTableModel) tabelaApp.getModel(); //tabelaApp.getModel();
//                modelo.setNumRows(0);
//                //CARREGA OS DADOS DA LISTA NA TABELA
//                modelo.addRow(new Object[]{
//                    rs.getId(),
//                    rs.getAplicacao(),
//                    rs.getUsuario(),
//                    rs.getEndereco(),
//                    rs.getData()
//                });
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
//        }

    ControlSenha control = new ControlSenha();
      
        try {
            String aplicacao = pesquisar.getText();
            tabelaApp.setModel(DbUtils.resultSetToTableModel(control.controlSelect(aplicacao)));
            //System.out.print());
        } catch (SQLException ex) {
            Logger.getLogger(ViewUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ControlSenha control = new ControlSenha();
        //System.err.print(pesquisar.getText());

        try {

            if (pesquisar.getText().equals("")) {
                carregarApp();
            } else {
                ModelSenha rs;
                rs = control.controlPesquisar(pesquisar.getText());
                DefaultTableModel modelo = (DefaultTableModel) tabelaApp.getModel(); //tabelaApp.getModel();
                modelo.setNumRows(0);
                //CARREGA OS DADOS DA LISTA NA TABELA
                modelo.addRow(new Object[]{
                    rs.getId(),
                    rs.getAplicacao(),
                    rs.getUsuario(),
                    rs.getEndereco(),
                    rs.getData()
                });
            }
        } catch (ParseException ex) {
            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
        // TODO add your handling code here:
        copy();
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void tabelaAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAppMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAppMouseEntered

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        aplicacao.setText("");
        user.setText("");
        pass1.setText("");
        pass2.setText("");
        endereco.setText("");
        btnAdd.setEnabled(true);
    }//GEN-LAST:event_btnEdit1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewPass().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aplicacao;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnVisu;
    private javax.swing.JComboBox<String> cbcategoria;
    private javax.swing.JTextField data;
    private javax.swing.JTextField endereco;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JTable tabelaApp;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    private void setarCampos() throws ParseException {
        int setar = tabelaApp.getSelectedRow();
        ControlSenha control = new ControlSenha();
        ModelSenha modelsenha = new ModelSenha();
        aplicacao.setText(tabelaApp.getModel().getValueAt(setar, 1).toString());
        String app = aplicacao.getText();
        modelsenha = control.controlSet(app);
        user.setText(modelsenha.getUsuario());
        pass1.setText(modelsenha.getSenha());
        pass2.setText(modelsenha.getSenha());
        endereco.setText(modelsenha.getEndereco());

        selecao();

    }

   public void visiblePass() {
        pass1.setEchoChar('\u0000');
        pass2.setEchoChar('\u0000');
    }
    public void hidePass() {
    pass1.setEchoChar('*');
    pass2.setEchoChar('*');
}
}
