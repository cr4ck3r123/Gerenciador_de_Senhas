/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gerenciador_de_senhas.model.ModelCategoria;
import gerenciador_de_senhas.model.ModelSenha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DaoCategoria {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
//LISTAR CATEGORIA
   public ArrayList<ModelCategoria> listar_categoria() {
        String sql = "select descricao from categoria";
      //  conexao = Conexao.conector();
      
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
             pst.execute(); 
              ArrayList<ModelCategoria> listaCategoria = new ArrayList();
            while(pst.getResultSet().next()){
                 ModelCategoria categoria = new ModelCategoria();
                 categoria.setId(pst.getResultSet().getInt(1));
                 categoria.setNome(pst.getResultSet().getString(2));
                 listaCategoria.add(categoria);
            }
        

        } catch (Exception e) {
        //    JOptionPane.showMessageDialog(rootPane, "Erro ao preencher " + e);
        }
        return null;
   }





}
    
