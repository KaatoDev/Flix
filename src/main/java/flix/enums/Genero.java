package flix.enums;

public enum Genero {
    NAO_BINARIO(1, "Não-binário"), MASCULINO(2, "Masculino"), FEMININO(3, "Feminino");
    final int id;
    final String nome;
    Genero(int i, String a) {
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
