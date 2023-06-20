/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DaoSenha {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void inserir(ModelSenha modelsenha) throws ParseException{
        conexao = Conexao.conector();
        String sql="insert into senha(aplicacao, usuario, senha, endereco ,data) values (?,?,?,?,?)";
       try {
            pst = conexao.prepareStatement(sql);
          
            pst.setString(1, modelsenha.getAplicacao());
            pst.setString(2, modelsenha.getUsuario());
            pst.setString(3, modelsenha.getSenha());
            pst.setString(4, modelsenha.getEndereco());
            pst.setString(5, modelsenha.getData());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso...");
                     
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);        }
          }
    
    
       public void Editar(ModelSenha modelsenha) throws ParseException{
        conexao = Conexao.conector();
        String sql="update senha set aplicacao = ?, usuario = ?, senha = ?, endereco = ?, data = ? where id = ?";
       try {
            pst = conexao.prepareStatement(sql);
          
            pst.setString(1, modelsenha.getAplicacao());
            pst.setString(2, modelsenha.getUsuario());
            pst.setString(3, modelsenha.getSenha());
            pst.setString(4, modelsenha.getEndereco());
            pst.setString(5, modelsenha.getData());
            pst.setInt(6, modelsenha.getId());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados Editados com sucesso...");
                     
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);        }
          }
    
    
      public ResultSet selectResult(String app) throws ParseException{
        conexao = Conexao.conector();
        ModelSenha modelsenha = new ModelSenha();
        String sql = "select id, aplicacao, usuario, endereco, data from senha where aplicacao  like ?";
       // String sql="select * from senha where aplicacao = ?";
       try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, app + "%");
            rs = pst.executeQuery();  
          
            return rs;
                     
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);        }
        return null;
          }
       
       
       
    public ModelSenha select(String app) throws ParseException{
        conexao = Conexao.conector();
        ModelSenha modelsenha = new ModelSenha();
        String sql = "select * from senha where aplicacao  like ?";
       // String sql="select * from senha where aplicacao = ?";
       try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, app + "%");
            pst.execute();
            
            while(pst.getResultSet().next()){
                 modelsenha.setId(pst.getResultSetType());
                 modelsenha.setAplicacao(pst.getResultSet().getString(2));
                 modelsenha.setUsuario(pst.getResultSet().getString(3));
                 modelsenha.setSenha(pst.getResultSet().getString(4));
                 modelsenha.setEndereco(pst.getResultSet().getString(5));
                 modelsenha.setData(pst.getResultSet().getString(6));           
            }
            return modelsenha;
                     
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);        }
        return null;
          }

//LISTA POR CATEGORIA 
public ArrayList<ModelSenha> getListaAppDAO() throws SQLException{
          
        try {
            conexao = Conexao.conector();
            ArrayList<ModelSenha> listamodelsenha = new ArrayList();
                       
            String sql="Select * from senha";
            pst = conexao.prepareStatement(sql);
            pst.execute(); 
            
            while(pst.getResultSet().next()){
                 ModelSenha modelsenha = new ModelSenha();
                 modelsenha.setId(pst.getResultSet().getInt(1));
                 modelsenha.setAplicacao(pst.getResultSet().getString(2));
                 modelsenha.setUsuario(pst.getResultSet().getString(3));
                 modelsenha.setSenha(pst.getResultSet().getString(4));
                 modelsenha.setEndereco(pst.getResultSet().getString(5));
                 modelsenha.setData(pst.getResultSet().getString(6));           
                 listamodelsenha.add(modelsenha);
            }
        
          return listamodelsenha;
        }catch(Exception e){
            e.printStackTrace();
        }        
        return null;
    }

//LISTAR CATEGORIA
   public void listar_categoria() {
        String sql = "select descricao from categoria";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            do {
              //  cbCategoria.addItem(rs.getString("descricao"));
            } while (rs.next());

        } catch (Exception e) {
        //    JOptionPane.showMessageDialog(rootPane, "Erro ao preencher " + e);
        }
    }




  public ModelSenha pesquisar_app(String pesquisar) {        
        String sql = "select * from senha where aplicacao = ?";
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1,  pesquisar);           
            pst.execute(); 
            ModelSenha modelsenha = new ModelSenha();
                 while(pst.getResultSet().next()){                 
                 modelsenha.setId(pst.getResultSet().getInt(1));
                 modelsenha.setAplicacao(pst.getResultSet().getString(2));
                 System.out.print(modelsenha.getAplicacao());
                 modelsenha.setUsuario(pst.getResultSet().getString(3));
                 modelsenha.setSenha(pst.getResultSet().getString(4));
                 modelsenha.setEndereco(pst.getResultSet().getString(5));
                 modelsenha.setData(pst.getResultSet().getString(6));                            
            }
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            return modelsenha;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
    
