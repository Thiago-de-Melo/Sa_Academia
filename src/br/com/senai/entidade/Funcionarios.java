package br.com.senai.entidade;


public class Funcionarios {
    
    
    private Integer matricula;
    private String nome;
    private String sobrenome;
    private Integer telefone;
    private String bairro;
    private String rua;
    private String dataEntrada;

    public Funcionarios() {
    }

    public Funcionarios(Integer matricula, String nome, 
                       String sobrenome, Integer telefone, 
                       String bairro, String rua, String dataEntrada) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.bairro = bairro;
        this.rua = rua;
        this.dataEntrada = dataEntrada;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
}
