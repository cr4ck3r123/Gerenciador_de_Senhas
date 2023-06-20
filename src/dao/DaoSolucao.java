/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gerenciador_de_senhas.model.ModelSolucao;
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
public class DaoSolucao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //LISTA USUARIO    
    public ModelUsuario selectUser(String nome) throws ParseException {
        conexao = Conexao.conector();
        ModelUsuario modeluser = new ModelUsuario();
        String sql = "select * from usuario where nome = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();

            while (pst.getResultSet().next()) {
                modeluser.setId(pst.getResultSetType());
                modeluser.setNome(pst.getResultSet().getString(2));
                modeluser.setGrupo(pst.getResultSet().getString(3));
                modeluser.setMaquina(pst.getResultSet().getString(4));
                modeluser.setAnydesk(pst.getResultSet().getString(5));
                modeluser.setDescricacao(pst.getResultSet().getString(6));
                modeluser.setLocalidade(pst.getResultSet().getString(7));
                modeluser.setEmail(pst.getResultSet().getString(8));
                modeluser.setTag(pst.getResultSet().getString(9));
            }
            return modeluser;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

//LISTA SOLUCAO    
    public ArrayList<ModelSolucao> selectSolucao() throws ParseException {
        conexao = Conexao.conector();
        ArrayList<ModelSolucao> listasolucao = new ArrayList();
        String sql = "select * from solucoes;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.execute();

            while (pst.getResultSet().next()) {
                ModelSolucao solucao = new ModelSolucao();
                solucao.setId(pst.getResultSet().getInt(1));
                solucao.settitle(pst.getResultSet().getString(2));
                solucao.setUrl(pst.getResultSet().getString(3));
                solucao.setDescricao(pst.getResultSet().getString(4));
                listasolucao.add(solucao);
            }

            return listasolucao;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    //LISTA POR GRUPO
    public ArrayList<ModelUsuario> getListaUsuarioDao(String grupo) throws SQLException {

        try {
            conexao = Conexao.conector();
            ArrayList<ModelUsuario> listamodelusuario = new ArrayList();

            String sql = "Select * from usuario where grupo = ? order by nome asc";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, grupo);
            pst.execute();

            while (pst.getResultSet().next()) {
                ModelUsuario modelusuario = new ModelUsuario();
                modelusuario.setId(pst.getResultSet().getInt(1));
                modelusuario.setNome(pst.getResultSet().getString(2));
                modelusuario.setGrupo(pst.getResultSet().getString(3));
                modelusuario.setMaquina(pst.getResultSet().getString(4));
                modelusuario.setAnydesk(pst.getResultSet().getString(5));
                modelusuario.setDescricacao(pst.getResultSet().getString(6));
                modelusuario.setTag(pst.getResultSet().getString(7));
                listamodelusuario.add(modelusuario);
            }

            return listamodelusuario;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//PESQUISAR USUARIO
    public ResultSet pesquisar_usuario(String pesquisar) {
        String sql = "select id, nome, grupo, maquina, anydesk from usuario where nome like ?";
        try {
            conexao = Conexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pesquisar + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public void inserir(ModelSolucao modelSolucao) throws ParseException {

        try {
            conexao = Conexao.conector();
            String sql1 = "select * from solucoes where titulo = ?";
            pst = conexao.prepareStatement(sql1);
            pst.setString(1, modelSolucao.gettitle());
            pst.execute();
            String title = null;
            while (pst.getResultSet().next()) {
                title = pst.getResultSet().getString(2);
            }

            System.out.printf("title = " + title);
            if (title == null ? modelSolucao.gettitle() != null : !modelSolucao.equals(modelSolucao.gettitle())) {

                String sql = "insert into solucoes(titulo, url, descricao) values (?,?,?)";
                pst = conexao.prepareStatement(sql);

                pst.setString(1, modelSolucao.gettitle());
                pst.setString(2, modelSolucao.getUrl());
                pst.setString(3, modelSolucao.getDescricao());

                pst.execute();

                JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso...");

            } else {
                JOptionPane.showMessageDialog(null, "Usuario já cadastrado...");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSolucao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //EDITAR
    public void Editar(ModelUsuario modelusuario) throws ParseException {
        conexao = Conexao.conector();
        String sql = "update usuario set nome = ?, grupo = ?, maquina = ?, anydesk = ?, descrição = ?, localidade = ?, email = ? where id = ?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, modelusuario.getNome());
            pst.setString(2, modelusuario.getGrupo());
            pst.setString(3, modelusuario.getMaquina());
            pst.setString(4, modelusuario.getAnydesk());
            pst.setString(5, modelusuario.getDescricacao());
            pst.setString(6, modelusuario.getLocalidade());
            pst.setString(7, modelusuario.getEmail());
            pst.setInt(8, modelusuario.getId());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados Editados com sucesso...");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //GET USER FROM ID
    public ModelSolucao getUserId(ModelSolucao modelSolucao) {
        conexao = Conexao.conector();
        String sql = "select * from solucoes where id = ?";
        
        try {
            pst = conexao.prepareStatement(sql);            
            pst.setInt(1, modelSolucao.getId());
            pst.execute();
          
            while (pst.getResultSet().next()) {
                modelSolucao.setId(pst.getResultSet().getInt(1));
                modelSolucao.settitle(pst.getResultSet().getString(2));
                modelSolucao.setUrl(pst.getResultSet().getString(3));
                modelSolucao.setDescricao(pst.getResultSet().getString(4));
               
            }
            return modelSolucao;
        } catch (SQLException ex) {
            Logger.getLogger(DaoSolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
