package flix.model;

import flix.enums.Sexo;

import java.sql.Date;

public class Usuario {
    private final int id, cpf;
    private String nome, sobrenome, email, senha;
    private Date nascimento;
    private Sexo sexo;
    private Perfil perfil1, perfil2, perfil3;

    public Usuario(int id, int cpf, String nome, String sobrenome, String email, String senha, Date nascimento, Sexo sexo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public int getCpf() {
        return cpf;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Perfil getPerfil1() {
        return perfil1;
    }

    public void setPerfil1(Perfil perfil1) {
        this.perfil1 = perfil1;
    }

    public Perfil getPerfil2() {
        return perfil2;
    }

    public void setPerfil2(Perfil perfil2) {
        this.perfil2 = perfil2;
    }

    public Perfil getPerfil3() {
        return perfil3;
    }

    public void setPerfil3(Perfil perfil3) {
        this.perfil3 = perfil3;
    }
}
