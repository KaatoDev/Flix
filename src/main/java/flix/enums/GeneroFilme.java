package flix.enums;

public enum GeneroFilme {
    ADMIN(1), ACAO(2), COMEDIA(3), ROMANCE(4), SUSPENSE(5), TERROR(6);
    final int id;
    GeneroFilme(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
