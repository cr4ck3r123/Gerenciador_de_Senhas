/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DaoCategoria;
import gerenciador_de_senhas.model.ModelCategoria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando.oliveira
 */
public class ControlCategoria {
    
     public ArrayList<ModelCategoria> getListaAppControl() throws SQLException{ 
         DaoCategoria dao = new DaoCategoria();
        return dao.listar_categoria();
    }
    
}
