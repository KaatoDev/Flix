package flix.enums;

public enum Classificacao {
    AL(1, "Livre"), A10(2, "10+"), A12(3, "12+"), A14(4, "14+"), A16(5, "16+"), A18(6, "18+");
    final int id;
    final String nome;
    Classificacao(int i, String a) {
        id = i;
        nome = a;
    }
    public int id() {
        return id;
    }
    public String nome() {
        return nome;
    }
}
