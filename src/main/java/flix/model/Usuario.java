package flix.model;

import java.sql.Date;

public class Usuario {
    private final int id, cpf;
    private String nome, email, senha;
    private Date nascimento;
    private Perfil perfil1, perfil2, perfil3;

    public Usuario(int id, String nome, int cpf, String email, String senha, Date nascimento, Perfil perfil1, Perfil perfil2, Perfil perfil3) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.perfil1 = perfil1;
        this.perfil2 = perfil2;
        this.perfil3 = perfil3;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public Perfil getPerfil1() {
        return perfil1;
    }

    public Perfil getPerfil2() {
        return perfil2;
    }

    public Perfil getPerfil3() {
        return perfil3;
    }

    public void setPerfil1(Perfil perfil1) {
        this.perfil1 = perfil1;
    }

    public void setPerfil2(Perfil perfil2) {
        this.perfil2 = perfil2;
    }

    public void setPerfil3(Perfil perfil3) {
        this.perfil3 = perfil3;
    }
    
}
