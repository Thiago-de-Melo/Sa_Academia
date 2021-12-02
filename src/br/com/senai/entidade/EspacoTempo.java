package br.com.senai.entidade;


public class EspacoTempo {
    
    
    private Integer cpf;
    private Integer matricula;

    public EspacoTempo() {
    }

    public EspacoTempo(Integer cpf, Integer matricula) {
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }    
}
