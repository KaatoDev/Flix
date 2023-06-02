package flix.enums;

public enum GeneroFilme {
    ACAO(1), COMEDIA(2), ROMANCE(3), SUSPENSE(4), TERROR(5);
    final int id;
    GeneroFilme(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
