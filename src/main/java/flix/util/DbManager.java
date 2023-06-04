package flix.util;

import flix.enums.Classificacao;
import flix.enums.Genero;
import flix.enums.GeneroFilme;
import flix.model.Filme;
import flix.model.Usuario;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbManager {
    public static boolean isAdmin(Usuario user) {
        String sql = "select nome from usuarios where nome=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getNome());
            try (ResultSet rs = ps.executeQuery()) {
                return Arrays.equals(rs.getString("email").getBytes(), user.getEmail().getBytes()) &&
                    Arrays.equals(rs.getString("nome").getBytes(), user.getNome().getBytes()) &&
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
    /*public static boolean catalogoGeral(Ordem ordem) {
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
    }*/
    public static List<Usuario> genUsuarios() {
        String sql = "select * from usuarios";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Usuario> usuarios = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome"), sobrenome = rs.getString("sobrenome"),
                            email = rs.getString("email");
                    long cpf = rs.getLong("cpf");
                    Date nascimento = rs.getDate("nascimento");
                    int icon = rs.getInt("icon");
                    Genero genero = Arrays.stream(Genero.values()).toList().get(rs.getInt("genero"));
                    GeneroFilme genero1 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero1"));
                    GeneroFilme genero2 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero2"));
                    if (genero1 == genero2) genero2 = null;
                    usuarios.add(new Usuario(id, cpf, nome, sobrenome, email, nascimento, genero, icon, genero1, genero2));
                }
                return usuarios;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean deletarUsuario(Usuario user) {
        if (!exists(user.getNome()))
            return false;
        String sql = "delete from usuarios where nome=? and id=? and cpf=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getNome());
            ps.setInt(2, user.getId());
            ps.setLong(2, user.getCpf());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean cadUsuario(String nome, String sobrenome, long cpf, String email, String senha, LocalDate nascimento, Genero genero, GeneroFilme genero1, GeneroFilme genero2) {

        if (!exists(nome) && !exists(email))
            return false;
        String sql = "insert into usuarios values(default, ?, ?, ?, ?, ?, ?, ?, 1, ?, null)";
        if (genero2 == null)
            sql = "insert into usuarios values(default, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setLong(2, cpf);
            ResultSet rs = ps.executeQuery();
            rs.next();
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            ps.setLong(3, cpf);
            ps.setString(4, email);
            ps.setString(5, senha);
            ps.setDate(6, Date.valueOf(nascimento));
            ps.setInt(7, genero.id());
            ps.setInt(8, genero1.id());
            if (genero2 != null) ps.setInt(9, genero2.id());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<Filme> genFilmes() {
        String sql = "select (select count(notas.id) from notas where notas.filmeId = filmes.id) quantidade_notas, filmes.id, nome, sinopse, ano, userId, capa, icon, classificacao, kid, genero1, genero2, (select avg(notas.nota) from notas where notas.filmeId = filmes.id) nota_publico, filmes.nota nota_IMDB from notas inner join filmes where notas.filmeId = filmes.id group by filmes.id order by filmes.id";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Filme> filmes = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id"), ano = rs.getInt("ano"), userId = rs.getInt("userId"), qtt = rs.getInt("quantidade_notas");
                    String nome = rs.getString("nome"), sinopse = rs.getString("sinopse"), capa = rs.getString("capa"), icon = rs.getString("icon");
                    double imdb = rs.getDouble("nota_IMDB"), nota = rs.getDouble("nota_publico");
                    boolean kid = rs.getBoolean("kid");
                    Classificacao classificacao = Arrays.stream(Classificacao.values()).toList().get(rs.getInt("classificacao"));
                    GeneroFilme genero1 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero1"));
                    GeneroFilme genero2 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero2"));
                    if (genero1 == genero2) genero2 = null;
                    filmes.add(new Filme(id, nome, sinopse, imdb, nota, qtt, ano, getNome(userId), icon, capa, kid, classificacao, genero1, genero2));
                }
                return filmes;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getNome(int usuarioId) {
        String sql = "select nome from usuarios where id=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
                return senha.equals(rs.getString("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Usuario getUsuario(String user, String senha) {
        String sql = "select * from usuarios where nome=?";
        if (user.contains("@"))
            sql = "select * from usuarios where email=?";
        if (exists(user)) {
            try (Connection c = Database.connect();
                 PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, user);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    String pass = rs.getString("senha");
                    int id = rs.getInt("id");
                    long cpf = rs.getLong("cpf");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String sobrenome = rs.getString("sobrenome");
                    Date nascimento = rs.getDate("nascimento");
                    int icone = rs.getInt("icon");
                    Genero genero = Arrays.stream(Genero.values()).toList().get(rs.getInt("genero"));
                    GeneroFilme genero1 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero1"));
                    GeneroFilme genero2 = Arrays.stream(GeneroFilme.values()).toList().get(rs.getInt("genero2"));
                    if (genero1 == genero2) genero2 = null;
                    return new Usuario(id, cpf, nome, sobrenome, email, nascimento, genero, icone, genero1, genero2);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } return null;
    }

    public static URL genIcone(int icone) {
        String sql = "select * from icones where id=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, icone);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new URL(rs.getString("imagem"));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean registrarFilme(Usuario user, String nome, String sinopse, String capa, String icon, int ano, double nota, String classificacao, boolean kid, GeneroFilme genero1, GeneroFilme genero2) {
        String sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        if (genero1 == genero2)
            sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, nome);
            ps.setString(3, sinopse);
            ps.setString(4, capa);
            ps.setString(5, icon);
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
