package flix.model;

import flix.enums.Genero;
import flix.enums.GeneroFilme;

import java.sql.Blob;
import java.sql.Date;

public class Usuario {
    private final long cpf;
    private final int id;
    private GeneroFilme genero1, genero2;
    private Genero genero;
    private String nome, sobrenome, email;
    private Date nascimento;
    private Blob icon;

    public Usuario(int id, long cpf, String nome, String sobrenome, String email, Date nascimento, Genero genero, Blob icon, GeneroFilme genero1, GeneroFilme genero2) {
        this.cpf = cpf;
        this.id = id;
        this.genero1 = genero1;
        this.genero2 = genero2;
        this.genero = genero;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.nascimento = nascimento;
        this.icon = icon;
    }

    public Blob getIcon() {
        return icon;
    }

    public void setIcon(Blob icon) {
        this.icon = icon;
    }

    public long getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public GeneroFilme getGenero1() {
        return genero1;
    }

    public void setGenero1(GeneroFilme genero1) {
        this.genero1 = genero1;
    }

    public GeneroFilme getGenero2() {
        return genero2;
    }

    public void setGenero2(GeneroFilme genero2) {
        this.genero2 = genero2;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
}
