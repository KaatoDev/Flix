package flix.enums;

public enum Sexo {
    NAO_BINARIO(1), MASCULINO(2), FEMININO(3);
    final int id;
    Sexo(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
