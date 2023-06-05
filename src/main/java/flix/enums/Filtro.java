package flix.enums;

public enum Filtro {
    NOME(" and nome like %"), USERID(" and userid ="), ANO(" and ano ="), GENERO(" and genero1 ="), CLASSIFICACAO(" and classificacao ="), KID(" and kid =");
    final String sql;
    Filtro(String a) {
        sql = a;
    }
    public String sql() {
        return sql;
    }
}
