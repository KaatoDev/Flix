package flix.model;

import flix.enums.Genero;

import java.sql.Date;

public class Usuario {
    private final int id, cpf;
    private String nome, sobrenome, email;
    private Date nascimento;
    private Genero genero;
    private Perfil perfil1, perfil2, perfil3;

    public Usuario(int id, int cpf, String nome, String sobrenome, String email, Date nascimento, Genero genero) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.nascimento = nascimento;
        this.genero = genero;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Genero getSexo() {
        return genero;
    }

    public void setSexo(Genero genero) {
        this.genero = genero;
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
