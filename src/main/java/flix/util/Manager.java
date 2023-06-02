package flix.util;

import flix.model.Filme;

import java.util.List;

import static flix.util.DbManager.genFilmes;


public class Manager {
    public static boolean cpf(String cpf) {
        String a = cpf.substring(0, 10);
        int t=0, w=10, a1, a2;
        for (int i=0; i<9; i++) {
            t += Integer.parseInt(a.split("")[i]) * w--;
        }
        w=10;
        a1 = t%11;
        if (a1 == 1)
            a1 = 0;
        else if (a1 != 0)
            a1 = 11-a1;
        t=0;
        for (int i=1; i<9; i++)
            t += Integer.parseInt(a.split("")[i]) * w--;
        t+= a1*w;
        a2 = t%11;
        if (a2 == 1)
            a2 = 0;
        else if (a2 != 0)
            a2 = 11-a2;
        return Integer.parseInt(String.valueOf(cpf.charAt(9))) == a1 && Integer.parseInt(String.valueOf(cpf.charAt(10))) == a2;
    }
    public static Object[][] getFilmes() {
        List<Filme> filmes = genFilmes();
        Object[][] a = new Object[filmes.size()][10];
        for (int i=0; i<filmes.size(); i++) {
            Filme s = filmes.get(i);
            a[i][0] = s.getNome();
            a[i][1] = s.getSinopse();
            a[i][2] = s.getAno();
            a[i][3] = s.getNota_IMDB();
            a[i][4] = s.getNota();
            a[i][5] = s.getAvaliacoes();
            a[i][6] = s.getGenero1();
            a[i][7] = s.getGenero2();
            a[i][8] = s.getClassificacao();
            a[i][9] = s.isKid();
            a[i][10] = s.getUsuario();
        }
        return a;
    }
}