package flix.enums;

public enum GeneroFilme {
    ACAO(1, "Ação"), COMEDIA(2, "Comédia"), ROMANCE(3, "Romance"), SUSPENSE(4, "Suspense"), TERROR(5, "Terror");
    final int id;
    final String nome;
    GeneroFilme(int i, String a) {
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
