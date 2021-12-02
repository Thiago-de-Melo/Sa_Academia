package br.com.senai.entidade;


public class Cargos {
    
    
    private Integer idCargo;
    private String nomeCargo;

    public Cargos() {
    }

    public Cargos(Integer idCargo, String nomeCargo) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
    }

    public Cargos(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
    
}
