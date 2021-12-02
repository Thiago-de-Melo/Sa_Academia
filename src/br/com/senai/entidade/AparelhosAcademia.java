package br.com.senai.entidade;

import java.sql.Date;

public class AparelhosAcademia {
    
    private Integer idAparelhos;
    private String nomeAparelhos;
    private Date dataCompra;  
    

    public AparelhosAcademia() {
    }
    
    public AparelhosAcademia(String nomeAparelhos, Date dataCompra) {
        this.nomeAparelhos = nomeAparelhos;
        this.dataCompra = dataCompra;
    }

    public Integer getIdAparelhos() {
        return idAparelhos;
    }

    public void setIdAparelhos(Integer idAparelhos) {
        this.idAparelhos = idAparelhos;
    }

    public String getNomeAparelhos() {
        return nomeAparelhos;
    }

    public void setNomeAparelhos(String nomeAparelhos) {
        this.nomeAparelhos = nomeAparelhos;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    
}
