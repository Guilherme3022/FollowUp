package br.com.megacomex.Domain.entities;

public class Funcionario {

    private String nome;
    private String cargo;
    private  int id;
    private String senha;
    private int live;

    public int isLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getLive() {
        return live;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
