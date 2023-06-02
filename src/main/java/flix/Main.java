package flix;

import flix.frames.Login;
import flix.model.Filme;
import flix.model.Usuario;
import flix.util.Database;

import java.sql.Connection;
import java.util.List;

import static flix.util.DbManager.genFilmes;
import static flix.util.DbManager.getUsuario;

public class Main {
    public static Connection db;
    public static Usuario usuario;
    public static void main(String[] args) {
        System.out.println("Inicializando aplicação...");
        iniciarDatabase();

        int s = genFilmes().size();
        new Login().setVisible(true);
    }

        public static void iniciarDatabase() {
        if (Database.connect() == null) System.out.println("Não foi possível conectar ao banco de dados!");
        else {
            System.out.println("Banco de dados conectada com sucesso!");
            db = Database.connect();
        }
    }
    public static void cadUser(String nome, String senha) {
        try {
            usuario = getUsuario(nome, senha);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}