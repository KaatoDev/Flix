package flix.util;

import flix.enums.Classificacao;
import flix.enums.Filtro;
import flix.enums.Genero;
import flix.enums.GeneroFilme;
import flix.model.Filme;
import flix.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static flix.Main.usuario;
import static flix.util.DbManager.genFilmes;
import static flix.util.DbManager.genUsuarios;


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
    public static String[] users() {
        List<String> a = new ArrayList<>();
        a.add("Selecione o usuário");
        for (Usuario w : genUsuarios())
            a.add(w.getNome());
        return a.toArray(new String[0]);
    }
    public static Filme filme(String nome) {
        for (Filme s : genFilmes())
            if (s.getNome().equals(nome))
                return s;
        return null;
    }
    public static String[] filmes(String nome) {
        List<String> a = new ArrayList<>();
        a.add("Selecione o filme");
        if (nome == null)
            for (Filme w : genFilmes())
                a.add(w.getNome());
        else for (Filme w : genFilmes())
            if (w.getNome().contains(nome)) a.add(w.getNome());
        return a.toArray(new String[0]);
    }
    public static String[] anos() {
        List<String> a = new ArrayList<>();
        a.add("Ano");
        for (Filme w : genFilmes())
            a.add(String.valueOf(w.getAno()));
        return a.toArray(new String[0]);
    }
    public static Object[][] getFilmes(HashMap<Filtro, String> filtros) {
        List<Filme> filmes;
        if (filtros != null) {
            filmes = genFilmes(filtros);
        } else filmes = genFilmes();
        if (filmes == null)
            return new Object[][] {};
        Object[][] a = new Object[filmes.size()][10];
        for (int i = 0; i < filmes.size(); i++) {
            Filme s = filmes.get(i);
            a[i][0] = s.getNome();
            a[i][1] = s.getSinopse();
            a[i][2] = s.getAno();
            a[i][3] = s.getNota_IMDB();
            a[i][4] = s.getNota();
            a[i][5] = s.getGenero1().nome();
            a[i][6] = s.getGenero2().nome();
            a[i][7] = s.getClassificacao().nome();
            a[i][8] = s.isKid();
            a[i][9] = s.getUsuario();
            /*jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    getFilmes(),
                    new String [] {
                            "Nome", "Sinopse", "Ano", "Nota IMDB", "Nota público", "Gênero", "Subgênero", "Classificação", "Infantil", "Adicionado por"
                    }
            ));*/
        }
        return a;
    }
    public static Object[][] getUsuarios(String nome, String email) {
        List<Usuario> usuarios;
        if (nome == null && email == null)
            usuarios = genUsuarios();
        else {
            if (nome.equals(""))
                nome = null;
            if (email.equals(""))
                email = null;
            usuarios = genUsuarios(nome, email);
        }
        if (usuarios == null)
            return null;
        Object[][] a = new Object[usuarios.size()][8];
        for (int i=0; i<usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            a[i][0] = u.getNome();
            a[i][1] = u.getSobrenome();
            a[i][2] = u.getCpf();
            a[i][3] = u.getEmail();
            a[i][4] = Period.between(u.getNascimento().toLocalDate(), LocalDate.now()).getYears() + " anos";
            a[i][5] = u.getGenero();
            a[i][6] = u.getGenero1();
            a[i][7] = u.getGenero2();
            /*jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    getFilmes(),
                    new String [] {
                        "Nome", "Sobrenome", "CPF", "Email", "Idade", "Gênero", "Gênero favotiro 1", "Gênero favotiro 2"
                    }
            ));*/
        }
        return a;
    }
    public static Image icon(Class classe) {
        return new ImageIcon(classe.getResource("/others/icon1.png")).getImage();
    }
    public static Enum getE(String a) {
        for (Genero s : Genero.values())
            if (s.nome().equals(a))
                return s;
        for (GeneroFilme s : GeneroFilme.values())
            if (s.nome().equals(a))
                return s;
        for (Classificacao s : Classificacao.values())
            if (s.nome().equals(a))
                return s;
        return null;
    }public static Enum getE(int a) {
        for (Genero s : Genero.values())
            if (s.id() == a)
                return s;
        for (GeneroFilme s : GeneroFilme.values())
            if (s.id() == a)
                return s;
        for (Classificacao s : Classificacao.values())
            if (s.id() == a)
                return s;
        return null;
    }
    public static String nulo() {
        if (usuario == null)
            return "null";
        else return usuario.getNome();
    }
}
