package flix.util;

import flix.enums.Classificacao;
import flix.enums.Genero;
import flix.enums.Ordem;
import flix.enums.Sexo;
import flix.model.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Arrays;

public class DbManager {
    public static boolean isAdmin(Usuario user) {
        String sql = "select nome from usuarios where nome=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getNome());
            try (ResultSet rs = ps.executeQuery()) {
                return Arrays.equals(rs.getString("email").getBytes(), user.getEmail().getBytes()) &&
                    Arrays.equals(rs.getString("nome").getBytes(), user.getNome().getBytes()) &&
                    Arrays.equals(rs.getString("senha").getBytes(), user.getSenha().getBytes()) &&
                    Integer.parseInt(rs.getString("id")) == user.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public static boolean exists(String user) {
        String sql = "select nome from usuarios where nome=?";
        if (user.contains("@"))
            sql = "select email from usuarios where email=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean catalogoGeral(Ordem ordem) {
        String sql = "select * from filmes";
        switch (ordem) {
            case NOME -> sql = "select * from filmes order by nome";
            case NOME_DE -> sql = "select * from filmes order by nome";
            case NOTA_IMDB -> sql = "select * from filmes order by notaimdb";
            case NOTA_IMDB_DE -> sql = "select * from filmes order by notaimdb";
            case NOTA_USER -> sql = "select * from filmes order by nota";
            case NOTA_USER_DE -> sql = "select * from filmes order by nota";
            case ANO -> sql = "select * from filmes order by ano";
            case ANO_DE -> sql = "select * from filmes order by ano";
        }
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean usuarios() {
        String sql = "select * from usuarios";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean deletarUsuario(Usuario user) {
        if (logar())
        String sql = "";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean logar(String user, String senha) {
        String sql = "select * from usuarios where nome=?";
        if (user.contains("@"))
            sql = "select * from usuarios where email=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                System.out.println(senha);
                System.out.println(rs.getString("senha"));
                return Arrays.equals(senha.getBytes(), rs.getString("senha").getBytes());
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean registrarUsuario(String nome, String sobrenome, long cpf, String email, String senha, LocalDate nascimento, Sexo sexo, Genero genFav1, Genero genFav2) {
        System.out.println("bbbbbb");
        if (registrarPerfil(nome, cpf, false, 1, genFav1, genFav2)) {
            String sqlfind = "select * from perfis where display=? and cpf=?";
            String sqluser = "insert into usuarios values(default, ?, ?, ?, ?, ?, ?, ?, ?, null, null)";
            System.out.println("cccccccc");
            try (Connection c = Database.connect();
                 PreparedStatement ps = c.prepareStatement(sqlfind);
                 PreparedStatement ps2 = c.prepareStatement(sqluser)) {
                System.out.println("ddddddd");
                ps.setString(1, nome);
                ps.setLong(2, cpf);
                ResultSet rs = ps.executeQuery();
                rs.next();
                ps2.setString(1, nome);
                ps2.setString(2, sobrenome);
                ps2.setLong(3, cpf);
                ps2.setString(4, email);
                ps2.setString(5, senha);
                ps2.setDate(6, Date.valueOf(nascimento));
                ps2.setInt(7, sexo.id());
                ps2.setInt(8, rs.getInt("id"));

                ps2.execute();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else return false;
    }

    public static boolean registrarPerfil(String nome, long cpf, boolean kid, int icon, Genero genFav1, Genero genFav2) {
        System.out.println("eeeeeee");
        String sqlprofile = "insert into perfis values(default, ?, ?, ?, ?, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps1 = c.prepareStatement(sqlprofile)) {
            System.out.println("fffffff");

            ps1.setString(1, nome);
            ps1.setLong(2, cpf);
            ps1.setBoolean(3, kid);
            ps1.setInt(4, icon);
            ps1.setInt(5, genFav1.id());
            ps1.setInt(6, genFav2.id());
            ps1.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Usuario getUsuario(String user, String senha) throws Exception {
        String sql = "select * from usuarios where nome=?";
        if (exists(user)) {
            try (Connection c = Database.connect();
                 PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, user);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    String pass = rs.getString("senha");
                    System.out.println("asdasd2");
                    if (!pass.equals(senha)) {
                        System.out.println("asdasd");
                        return null;
                    }
                    int id = rs.getInt("id");
                    int cpf = rs.getInt("cpf");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String sobrenome = rs.getString("sobrenome");
                    Date nascimento = rs.getDate("nascimento");
                    Sexo sexo = Sexo.NAO_BINARIO;
                    for (Sexo s : Sexo.values())
                        if (s.id() == rs.getInt("sexo"))
                            sexo = s;
                    return new Usuario(id, cpf, nome, sobrenome, email, pass, nascimento, sexo);
                }
            }
        } return null;
    }

    public static boolean registrarFilme(Usuario user, String nome, String sinopse, String capa, String icone, int ano, double nota, String classificacao, boolean kid, Genero genero1, Genero genero2) {
        String sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        if (genero1 == genero2)
            sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, nome);
            ps.setString(3, sinopse);
            ps.setString(4, capa);
            ps.setString(5, icone);
            ps.setInt(6, ano);
            ps.setDouble(7, nota);
            ps.setInt(8, Classificacao.valueOf(classificacao).id());
            ps.setBoolean(9, kid);
            ps.setInt(10, genero1.id());
            if (genero1 != genero2) ps.setInt(11, genero2.id());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
