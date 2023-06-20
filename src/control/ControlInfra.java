/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DaoInfra;
import gerenciador_de_senhas.model.ModelInfra;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author fernando.oliveira
 */
public class ControlInfra {
    
       public void controlInsere(ModelInfra infra){     
               
           try {
               System.out.printf("chegou!");
                    DaoInfra dao = new DaoInfra();
               dao.inserir(infra);
         } catch (Exception e) {
         }
         
        
    }
       
      public ArrayList<ModelInfra> getListaAppControl() throws SQLException, ParseException{ 
         DaoInfra dao = new DaoInfra();
        return dao.select();
    }
    
      public ModelInfra controlSelectInfra(int id) throws ParseException{
        ModelInfra modelinfra = new ModelInfra();
      
        DaoInfra dao = new DaoInfra();
        modelinfra =  dao.select(id);
        return modelinfra;
    }
}
