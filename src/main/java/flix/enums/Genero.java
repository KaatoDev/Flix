package flix.enums;

public enum Genero {
    ADMIN(1), ACAO(2), COMEDIA(3), ROMANCE(4), SUSPENSE(5), TERROR(6);
    final int id;
    Genero(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
