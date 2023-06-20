/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DaoSolucao;
import gerenciador_de_senhas.model.ModelSolucao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author fernando.oliveira
 */
public class ControlSolucao {
     ResultSet rs = null;
   
        
      public ArrayList<ModelSolucao> getListaSolucaoControl() throws SQLException, ParseException{ 
          DaoSolucao dao = new DaoSolucao();
        return dao.selectSolucao();
    }
      
      //Verified User
      public void verificaUsuario(ModelSolucao modelSolucao) throws ParseException{     
        if(!modelSolucao.gettitle().isEmpty() && !modelSolucao.getUrl().isEmpty()){
           System.out.printf("camada de controle"); 
           DaoSolucao dao = new DaoSolucao();
           dao.inserir(modelSolucao);
        }
    }
     

      public ModelSolucao controlGetUser(ModelSolucao modelSolucao){
          DaoSolucao dao = new DaoSolucao();
          modelSolucao =  dao.getUserId(modelSolucao);
       return modelSolucao;    
      }
      
}
