package flix;

import flix.util.Database;

import java.sql.Connection;

public class Main {
    public static Connection db;
    public static void main(String[] args) {
        System.out.println("Inicializando aplicação...");
        db = null;
        if (Database.connect() == null) System.out.println("Não foi possível conectar ao banco de dados!");
        else {
            System.out.println("Banco de dados conectado com sucesso!");
            db = Database.connect();
        }
    }
}