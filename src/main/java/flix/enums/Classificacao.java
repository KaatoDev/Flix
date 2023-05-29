package flix.enums;

public enum Classificacao {
    AL(1), A10(2), A12(3), A14(4), A16(5), A18(6);
    final int id;
    Classificacao(int i) {
        id = i;
    }
    public int id() {
        return id;
    }
}
