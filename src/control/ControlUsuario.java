/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DaoUsuario;
import gerenciador_de_senhas.model.ModelUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando.oliveira
 */
public class ControlUsuario {
     ResultSet rs = null;
   
    public ModelUsuario controlSelectUser(String nome) throws ParseException{
        ModelUsuario modelusuario = new ModelUsuario();
        DaoUsuario dao = new DaoUsuario();
        modelusuario =  dao.selectUser(nome);
        return modelusuario;
    }
     
     
     
     public ResultSet controlSelect(String usuario, String column) throws ParseException, SQLException{         
        DaoUsuario dao = new DaoUsuario();     
        return  dao.pesquisar_usuario(usuario, column);
    }
       
    public ArrayList<ModelUsuario> getListaAppControl(String grupo) throws SQLException{ 
         DaoUsuario dao = new DaoUsuario();
        return dao.getListaUsuarioDao(grupo);
    }
    
        public void verificaUsuario(ModelUsuario modelousuario) throws ParseException{
              
        if(!modelousuario.getTag().isEmpty() && !modelousuario.getMaquina().isEmpty()){
           System.out.printf("camada de controle"); 
        
           DaoUsuario dao = new DaoUsuario();
           if(dao.verificaTagExistente(modelousuario.getTag()) == 0){
           dao.inserir(modelousuario);
           }else{
              JOptionPane.showMessageDialog(null, "Este service Tag já esta cadastrado!");;
           }
        }
    }
     
   public void controlEditUsuario(ModelUsuario modelUsuario) throws ParseException{
     
        if(!modelUsuario.getNome().isEmpty() && !modelUsuario.getAnydesk().isEmpty()){
           DaoUsuario dao = new DaoUsuario();
           dao.Editar(modelUsuario);
        } 
       
       
   }

    public void controlRemoveUsuario(ModelUsuario modelUsuario) throws ParseException {
         if(!modelUsuario.getNome().isEmpty()){
           System.out.printf("camada de controle"); 
           DaoUsuario dao = new DaoUsuario();
           dao.Remover(modelUsuario);
        } 
        
    }
}
