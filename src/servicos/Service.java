/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.Conexao;
import gerenciador_de_senhas.model.ModelImages;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import dao.DaoImages;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Acer Pc
 */
public class Service {
     Connection connection;
     Connection conexao = null;
     DaoImages dao = new DaoImages();
     
    public Service(MysqlDataSource dataSource) throws SQLException{
        this.connection=dataSource.getConnection();
        DaoImages dao =new DaoImages();
       // dao.setConnection(connection);
    }
    
    public void save(ModelImages book) throws ParseException{
        try{
            connection.setAutoCommit(false);
            dao.save(book);
            connection.commit();
            connection.setAutoCommit(true);
        } catch(SQLException exception){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<ModelImages> findAll(){
        try {
            return dao.findAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }    
}
