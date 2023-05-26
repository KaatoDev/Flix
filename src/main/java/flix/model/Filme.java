package flix.model;

import java.sql.Date;

public class Filme {
    private String nome, sinopse;
    private float nota;
    private Date ano;
    private int classificacao, genero1, genero2;

    public Filme(String nome, String sinopse, float nota, Date ano, int classificacao, int genero1, int genero2) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.nota = nota;
        this.ano = ano;
        this.classificacao = classificacao;
        this.genero1 = genero1;
        this.genero2 = genero2;
    }
}