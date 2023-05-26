package flix.model;

import flix.enums.Genero;

import java.sql.Date;

public class Filme {
    private final int id;
    private String nome, sinopse;
    private float nota;
    private Date ano;
    private int classificacao;
    private Genero genero1, genero2;

    public Filme(int id, String nome, String sinopse, float nota, Date ano, int classificacao, Genero genero1, Genero genero2) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.nota = nota;
        this.ano = ano;
        this.classificacao = classificacao;
        this.genero1 = genero1;
        this.genero2 = genero2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Genero getGenero1() {
        return genero1;
    }

    public void setGenero1(Genero genero1) {
        this.genero1 = genero1;
    }

    public Genero getGenero2() {
        return genero2;
    }

    public void setGenero2(Genero genero2) {
        this.genero2 = genero2;
    }
    
}