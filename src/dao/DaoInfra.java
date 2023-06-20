/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gerenciador_de_senhas.model.ModelInfra;
import gerenciador_de_senhas.model.ModelUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando.oliveira
 */
public class DaoInfra {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //INSERIR
    public void inserir(ModelInfra modelinfra) throws ParseException, SQLException {

        try {
            conexao = Conexao.conector();
            String sql = "insert into infraestrutura(equipamento, usuario, senha, endereco ,descricao) values (?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);

            pst.setString(1, modelinfra.getEquipamento());
            pst.setString(2, modelinfra.getUsuario());
            pst.setString(3, modelinfra.getSenha());
            pst.setString(4, modelinfra.getEndereco());
            pst.setString(5, modelinfra.getDescricao());
            pst.execute();
            //   JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso...");             

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //LIST
    //LISTA USUARIO    
    public ArrayList<ModelInfra> select() throws ParseException {

        try {
            conexao = Conexao.conector();
            ArrayList<ModelInfra> listainfra = new ArrayList();
            String sql = "SELECT * FROM infraestrutura INNER JOIN images ON infraestrutura.id_images = images.id_images;";
            pst = conexao.prepareStatement(sql);
            pst.execute();

            while (pst.getResultSet().next()) {
                ModelInfra modelinfra = new ModelInfra();
                modelinfra.setId_infra(pst.getResultSet().getInt(1));
                modelinfra.setEquipamento(pst.getResultSet().getString(2));
                modelinfra.setUsuario(pst.getResultSet().getString(3));
                modelinfra.setSenha(pst.getResultSet().getString(4));
                modelinfra.setEndereco(pst.getResultSet().getString(5));
                modelinfra.setDescricao(pst.getResultSet().getString(6));
                modelinfra.setId_images(pst.getResultSet().getInt(7));
                modelinfra.setId(pst.getResultSet().getInt(8));
                modelinfra.setTitle(pst.getResultSet().getString(9));
                modelinfra.setImage(pst.getResultSet().getString(10));
                listainfra.add(modelinfra);
            }
            return listainfra;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    //LISTA USUARIO    
    public ArrayList<ModelInfra> selectPorId(int id) throws ParseException {

        try {
            conexao = Conexao.conector();
            ArrayList<ModelInfra> listainfra = new ArrayList();
            String sql = "SELECT * FROM infraestrutura INNER JOIN images ON infraestrutura.id_images = images.id_images WHERE infraestrutura.id = ?;";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            while (pst.getResultSet().next()) {
                ModelInfra modelinfra = new ModelInfra();
                modelinfra.setId_infra(pst.getResultSet().getInt(1));
                modelinfra.setEquipamento(pst.getResultSet().getString(2));
                modelinfra.setUsuario(pst.getResultSet().getString(3));
                modelinfra.setSenha(pst.getResultSet().getString(4));
                modelinfra.setEndereco(pst.getResultSet().getString(5));
                modelinfra.setDescricao(pst.getResultSet().getString(6));
                modelinfra.setId_images(pst.getResultSet().getInt(7));
                modelinfra.setId(pst.getResultSet().getInt(8));
                modelinfra.setTitle(pst.getResultSet().getString(9));
                modelinfra.setImage(pst.getResultSet().getString(10));
                listainfra.add(modelinfra);
            }
            return listainfra;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public ModelInfra select(int id) throws ParseException {
        conexao = Conexao.conector();
        ModelInfra modelinfra = new ModelInfra();
        String sql = "SELECT * FROM infraestrutura INNER JOIN images ON infraestrutura.id_images = images.id_images WHERE infraestrutura.id = ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            while (pst.getResultSet().next()) {
            modelinfra.setId_infra(pst.getResultSet().getInt(1));
            modelinfra.setEquipamento(pst.getResultSet().getString(2));
            System.out.print("chegou aki " + modelinfra.getEquipamento());
            modelinfra.setUsuario(pst.getResultSet().getString(3));
            modelinfra.setSenha(pst.getResultSet().getString(4));
            modelinfra.setEndereco(pst.getResultSet().getString(5));
            modelinfra.setDescricao(pst.getResultSet().getString(6));
            modelinfra.setId_images(pst.getResultSet().getInt(7));
            modelinfra.setId(pst.getResultSet().getInt(8));
            modelinfra.setTitle(pst.getResultSet().getString(9));
            modelinfra.setImage(pst.getResultSet().getString(10));
            }
            return modelinfra;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

      //Remover
    public void Remover(ModelInfra modelinfra) throws ParseException {
        conexao = Conexao.conector();
        String sql = "delete from infraestrutura where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, modelinfra.getId());
            pst.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
