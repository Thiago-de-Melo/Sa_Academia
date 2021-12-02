package br.com.senai.entidade;


public class TreinoAparelhos {
    
    
    private Integer idTreino;
    private Integer IdAparelho;

    public TreinoAparelhos() {
    }

    public TreinoAparelhos(Integer idTreino, Integer IdAparelho) {
        this.idTreino = idTreino;
        this.IdAparelho = IdAparelho;
    }

    public Integer getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Integer idTreino) {
        this.idTreino = idTreino;
    }

    public Integer getIdAparelho() {
        return IdAparelho;
    }

    public void setIdAparelho(Integer IdAparelho) {
        this.IdAparelho = IdAparelho;
    }
    
}
