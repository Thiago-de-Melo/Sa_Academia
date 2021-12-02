package br.com.senai.entidade;

import java.util.List;


public class Treino {    
    
    private Integer idTreino;
    private String treinos;
    private String descricao;
    private CadastroCliente cadastroCliente;
    private List<AparelhosAcademia> aparelhos;

    public Treino() {
    }

    public Treino(Integer idTreino, String treinos, String descricao) {
        this.idTreino = idTreino;
        this.treinos = treinos;
        this.descricao = descricao;
    }
    
    public Treino(String treinos, String descricao) {
        this.treinos = treinos;
        this.descricao = descricao;
    }

    public Integer getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Integer idTreino) {
        this.idTreino = idTreino;
    }

    public String getTreinos() {
        return treinos;
    }

    public void setTreinos(String treinos) {
        this.treinos = treinos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public CadastroCliente getCadastroCliente() {
        return cadastroCliente;
    }

    public void setCadastroCliente(CadastroCliente cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
    }
    
    public List<AparelhosAcademia> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(List<AparelhosAcademia> aparelhos) {
        this.aparelhos = aparelhos;
    }
    
}
