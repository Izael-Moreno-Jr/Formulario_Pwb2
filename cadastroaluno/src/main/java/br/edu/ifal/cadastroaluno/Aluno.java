package br.edu.ifal.cadastroaluno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String sexo;
    private String modulo;
    private String[] areaDeAtuacao;
    private String senha;

    public Aluno(){
        super();
    }
    public Aluno(Long id, String nome, String email, String cpf, String sexo, String modulo, String[] areaDeAtuacao,
            String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.modulo = modulo;
        this.areaDeAtuacao = areaDeAtuacao;
        this.senha = senha;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String[] getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String[] areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTodosOsCampos(){
        return " Aluno cadastrado com sucesso.";
    }

    @Override
    public String toString(){
        return getTodosOsCampos();
    }

    public String getAreaPorString(){
        String areaPorString = "";

        for (String var : areaDeAtuacao) {
            areaPorString = areaPorString + var + ", ";
        }
        return areaPorString;
    }

    

    
}