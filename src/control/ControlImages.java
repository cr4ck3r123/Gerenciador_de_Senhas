/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DaoImages;
import gerenciador_de_senhas.model.ModelImages;
import java.text.ParseException;


/**
 *
 * @author fernando.oliveira
 */
public class ControlImages {
    
     public void verificaImage(ModelImages image){     
                  
           DaoImages dao = new DaoImages();
           try {
               dao.save(image);
         } catch (Exception e) {
         }
         
        
    }
}
