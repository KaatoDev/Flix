package flix.model;

import flix.enums.Classificacao;
import flix.enums.GeneroFilme;

import java.sql.Blob;

public class Filme {
    private final int id;
    private final Classificacao classificacao;
    private final boolean kid;
    private final String usuario;
    private final int ano;
    private GeneroFilme genero1, genero2;
    private String nome, sinopse;
    private double nota_IMDB, nota;
    private Blob icone, capa;
    private int avaliacoes;

    public Filme(int id, String nome, String sinopse, double nota_IMDB, double nota, int avaliacoes, int ano, String usuario, Blob icone, Blob capa, boolean kid, Classificacao classificacao, GeneroFilme genero1, GeneroFilme genero2) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.nota_IMDB = nota_IMDB;
        this.nota = nota;
        this.avaliacoes = avaliacoes;
        this.ano = ano;
        this.kid = kid;
        this.usuario = usuario;
        this.icone = icone;
        this.capa = capa;
        this.classificacao = classificacao;
        this.genero1 = genero1;
        this.genero2 = genero2;
    }

    public boolean isKid() {
        return kid;
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getId() {
        return id;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getAno() {
        return ano;
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

    public double getNota_IMDB() {
        return nota_IMDB;
    }

    public void setNota_IMDB(double nota_IMDB) {
        this.nota_IMDB = nota_IMDB;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Blob getIcone() {
        return icone;
    }

    public void setIcone(Blob icone) {
        this.icone = icone;
    }

    public Blob getCapa() {
        return capa;
    }

    public void setCapa(Blob capa) {
        this.capa = capa;
    }
}