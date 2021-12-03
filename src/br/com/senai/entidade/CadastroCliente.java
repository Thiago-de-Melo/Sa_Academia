

package br.com.senai.entidade;


public class CadastroCliente {
    
    private Long cpf;
    private String nome;
    private String sobrenome;
    private String rua;
    private String bairro;
    private Integer telefone;
    private Integer whatsapp;
    private String dataNascimento;
    private String senha;
    private Plano plano;
    private Treino treino;
    private TreinoAparelhos treinoAparelhos;
    private AparelhosAcademia aparelhosAcademia;
    private Funcionarios funcionarios;

    public TreinoAparelhos getTreinoAparelhos() {
        return treinoAparelhos;
    }

    public void setTreinoAparelhos(TreinoAparelhos treinoAparelhos) {
        this.treinoAparelhos = treinoAparelhos;
    }

    public AparelhosAcademia getAparelhosAcademia() {
        return aparelhosAcademia;
    }

    public void setAparelhosAcademia(AparelhosAcademia aparelhosAcademia) {
        this.aparelhosAcademia = aparelhosAcademia;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
    
    
    public CadastroCliente(){        
    }

    public CadastroCliente(Long cpf, String nome, 
                           String sobrenome, String rua, 
                           String bairro, Integer telefone, 
                           Integer whatsapp, String dataNascimento, 
                           String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rua = rua;
        this.bairro = bairro;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
    
    public CadastroCliente(String nome, 
                           String sobrenome, String rua, 
                           String bairro, Integer telefone, 
                           Integer whatsapp, String dataNascimento, 
                           String senha) {
        
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rua = rua;
        this.bairro = bairro;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }    
    
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Integer whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
