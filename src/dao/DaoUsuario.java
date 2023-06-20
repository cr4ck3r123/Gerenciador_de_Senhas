/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class DaoUsuario {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //LISTA USUARIO    
    public ModelUsuario selectUser(String nome) throws ParseException {
        conexao = Conexao.conector();
        ModelUsuario modeluser = new ModelUsuario();
        String sql = "select * from usuario where tag = ?";
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
                modeluser.setContato(pst.getResultSet().getString(10));
            }
            return modeluser;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

//LISTA USUARIO    
    public ModelUsuario select(String app) throws ParseException {
        conexao = Conexao.conector();
        ModelUsuario modeluser = new ModelUsuario();
        String sql = "select * from usuario where grupo = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, app);
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
                modelusuario.setLocalidade(pst.getResultSet().getString(7));
                modelusuario.setEmail(pst.getResultSet().getString(8));
                modelusuario.setTag(pst.getResultSet().getString(9));
                listamodelusuario.add(modelusuario);
            }

            return listamodelusuario;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//PESQUISAR USUARIO
    public ResultSet pesquisar_usuario(String pesquisar, String column) {

        String sql = "select id, nome, grupo, maquina, tag from usuario where " + column + " like ?";

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

    public void inserir(ModelUsuario modelusuario) throws ParseException {

        try {
            conexao = Conexao.conector();
            String sql1 = "select * from usuario where tag = ?";
            pst = conexao.prepareStatement(sql1);
            pst.setString(1, modelusuario.getTag());
            pst.execute();
            String nome = null;
            while (pst.getResultSet().next()) {
                nome = pst.getResultSet().getString(2);
            }

            System.out.printf("nome = " + nome);
            if (nome == null ? modelusuario.getNome() != null : !nome.equals(modelusuario.getNome())) {

                String sql = "insert into usuario(nome, grupo, maquina, anydesk ,descrição, localidade, email, tag, contato) values (?,?,?,?,?,?,?,?,?)";
                pst = conexao.prepareStatement(sql);

                pst.setString(1, modelusuario.getNome());
                pst.setString(2, modelusuario.getGrupo());
                pst.setString(3, modelusuario.getMaquina());
                pst.setString(4, modelusuario.getAnydesk());
                pst.setString(5, modelusuario.getDescricacao());
                pst.setString(6, modelusuario.getLocalidade());
                pst.setString(7, modelusuario.getEmail());
                pst.setString(8, modelusuario.getTag());
                pst.setString(9, modelusuario.getContato());
                pst.execute();

                JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso...");

            } else {
                JOptionPane.showMessageDialog(null, "Usuario já cadastrado...");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //EDITAR
    public void Editar(ModelUsuario modelusuario) throws ParseException {
        conexao = Conexao.conector();
        String sql = "UPDATE usuario SET nome = ?, grupo = ?, maquina = ?, anydesk = ?, descrição = ?, localidade = ?, email = ?, tag = ?, contato = ? WHERE id = ?;";
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, modelusuario.getNome());
            pst.setString(2, modelusuario.getGrupo());
            pst.setString(3, modelusuario.getMaquina());
            pst.setString(4, modelusuario.getAnydesk());
            pst.setString(5, modelusuario.getDescricacao());
            pst.setString(6, modelusuario.getLocalidade());
            pst.setString(7, modelusuario.getEmail());
            pst.setString(8, modelusuario.getTag());
            pst.setString(9, modelusuario.getContato());
            pst.setInt(10, modelusuario.getId());
            System.out.print(pst);
            pst.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Remover
    public void Remover(ModelUsuario modelusuario) throws ParseException {
        conexao = Conexao.conector();
        String sql = "delete from usuario where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, modelusuario.getId());
            pst.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*public int VerficaServiceTag(String tag) {
        conexao = Conexao.conector();
        ModelUsuario modeluser = new ModelUsuario();
        String sql = "select * from usuario where tag = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tag);
            rs = pst.executeQuery();

            if (rs.next() == true) {
                return 1;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }
*/
    
    public int verificaTagExistente(String tag) {
    String sql = "SELECT COUNT(*) FROM usuario WHERE tag = ?";
    
    try (Connection conexao = Conexao.conector();
         PreparedStatement pst = conexao.prepareStatement(sql)) {
         pst.setString(1, tag);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return 1;
                }
            }
        }
    } catch (SQLException e) {
        // Trate a exceção de forma apropriada, como imprimir o stack trace ou lançar uma nova exceção personalizada.
        JOptionPane.showMessageDialog(null, e);
        e.printStackTrace();
    }
    
    return 0;
}

}
