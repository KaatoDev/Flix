package flix.enums;

public enum Genero {
    NAO_BINARIO(1), MASCULINO(2), FEMININO(3);
    final int id;
    Genero(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
