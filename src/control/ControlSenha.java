/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoSenha;
import gerenciador_de_senhas.model.ModelSenha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ControlSenha {
    
   
    
    public void verificaSenha(ModelSenha modelosenha) throws ParseException{
     
        if(!modelosenha.getAplicacao().isEmpty() && !modelosenha.getSenha().isEmpty()){
           System.out.printf("camada de controle"); 
           DaoSenha dao = new DaoSenha();
           dao.inserir(modelosenha);
        }
    }
    
    
       public void controlEdit(ModelSenha modelosenha) throws ParseException{
     
        if(!modelosenha.getAplicacao().isEmpty() && !modelosenha.getSenha().isEmpty()){
           System.out.printf("camada de controle"); 
           DaoSenha dao = new DaoSenha();
           dao.Editar(modelosenha);
        }        
    }
        public ResultSet controlSelect(String pesquisar) throws ParseException, SQLException{         
        DaoSenha dao = new DaoSenha();   
        return  dao.selectResult(pesquisar);
    }
//       public ModelSenha controlPesquisar(String pesquisar) throws ParseException{
//           DaoSenha dao = new DaoSenha();
//           ModelSenha resultado = dao.select(pesquisar);
//           return resultado;           
//       }
       
    
     
    public ModelSenha control(String app) throws ParseException{
    
        ModelSenha modelsenha = new ModelSenha();
        DaoSenha dao = new DaoSenha();
        modelsenha =  dao.select(app);
        return modelsenha;
    }
    
     public ArrayList<ModelSenha> getListaAppControl() throws SQLException{ 
         DaoSenha dao = new DaoSenha();
        return dao.getListaAppDAO();
    }
    
     
     
     
}
