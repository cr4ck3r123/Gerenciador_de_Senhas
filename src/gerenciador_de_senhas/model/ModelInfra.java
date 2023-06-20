/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciador_de_senhas.model;

/**
 *
 * @author fernando.oliveira
 */
public class ModelInfra extends ModelImages{
    int id_infra;
    String equipamento;
    String usuario;
    String senha;
    String endereco;
    String descricao;
    int id_images;
    
    public ModelInfra() {
    }

    public int getId_infra() {
        return id_infra;
    }

    public void setId_infra(int id_infra) {
        this.id_infra = id_infra;
    }
   
    
//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_images() {
        return id_images;
    }

    public void setId_images(int id_images) {
        this.id_images = id_images;
    }
    
    
}
