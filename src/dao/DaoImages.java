/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import gerenciador_de_senhas.model.ModelImages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoImages {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // METODO PARA SALVAR IMAGES
    public void save(ModelImages image) throws ParseException {
        conexao = Conexao.conector();
        String sql = "insert into images(title,image) values(?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, image.getTitle());
            pst.setString(2, image.getImage());
            pst.execute();
           
            String sql1 = "select max(id_images) from images ";
            pst = conexao.prepareStatement(sql1);
            pst.execute();
            String id = null;
            while (pst.getResultSet().next()) {
                id = pst.getResultSet().getString(1);
            }
            String sql2 = "UPDATE infraestrutura SET id_images = ? ORDER BY id DESC LIMIT 1;";
            pst = conexao.prepareStatement(sql2);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImages.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //METODO PARA BUSCAR IMAGES
    public ModelImages findOne(Integer id) throws SQLException {
        ModelImages book = new ModelImages();

        pst = conexao.prepareStatement("SELECT * from images where id=?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setImage(rs.getString("image"));
        }
        return book;
    }

    // LISTAR IMAGES
    public List<ModelImages> findAll() throws SQLException {
        List<ModelImages> listOfBook = new ArrayList<ModelImages>();

        pst = conexao.prepareStatement("select * from images");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            ModelImages book = new ModelImages();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setImage(rs.getString("image"));
            listOfBook.add(book);
        }
        return listOfBook;
    }
}
