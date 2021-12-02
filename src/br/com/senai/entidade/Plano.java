package br.com.senai.entidade;


public class Plano {
    
    
    private Integer idPlano;
    private String planos;
    private String descricao;
    private Integer valorPlano;

    public Plano() {
    }

    public Plano(Integer idPlano, String planos, String descricao, Integer valorPlano) {
        this.idPlano = idPlano;
        this.planos = planos;
        this.descricao = descricao;
        this.valorPlano = valorPlano;
    }
    
    public Plano(String planos, String descricao, Integer valorPlano) {
        this.planos = planos;
        this.descricao = descricao;
        this.valorPlano = valorPlano;
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public String getPlanos() {
        return planos;
    }

    public void setPlanos(String planos) {
        this.planos = planos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(Integer valorPlano) {
        this.valorPlano = valorPlano;
    }
    
}
