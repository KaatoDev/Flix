package flix.util;

import flix.enums.Classificacao;
import flix.enums.Genero;
import flix.enums.Sexo;
import flix.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbManager {
    public static boolean exists(Usuario user) throws Exception {
        String sql = "select nome from usuarios where nome=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static boolean registrarUsusario(String nome, int cpf, String email, String senha, Date nascimento, Sexo sexo, boolean kid, int icon, Genero genFav1, Genero genFav2) {
        if (registrarPerfil(nome, cpf, kid, icon, genFav1, genFav2)) {
            String sqlfind = "select * from perfis where nome=? and cpf=:?";
            String sqluser = "insert into usuarios values(default, ?, ?, ?, ?, ?, ?, ?, null, null)";
            try (Connection c = Database.connect();
                 PreparedStatement ps = c.prepareStatement(sqlfind);
                 PreparedStatement ps2 = c.prepareStatement(sqluser)) {
                ps.setString(1, nome);
                ps.setInt(2, cpf);
                ResultSet rs = ps.executeQuery();

                ps2.setString(1, nome);
                ps2.setInt(2, cpf);
                ps2.setString(3, email);
                ps2.setString(4, senha);
                ps2.setDate(5, nascimento);
                ps2.setInt(6, sexo.id());
                ps2.setInt(7, rs.getInt("id"));

                ps2.executeQuery();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else return false;
    }

    public static boolean registrarPerfil(String nome, int cpf, boolean kid, int icon, Genero genFav1, Genero genFav2) {
        String sqlprofile = "insert into perfis values(default, ?, ?, ?, ?, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps1 = c.prepareStatement(sqlprofile)) {

            ps1.setString(1, nome);
            ps1.setInt(2, cpf);
            ps1.setBoolean(3, kid);
            ps1.setInt(4, icon);
            ps1.setInt(5, genFav1.id());
            ps1.setInt(6, genFav2.id());
            ps1.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Usuario getUsuario(String email, String senha) {
        String sql = "select * from usuarios where email=? and senha=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                int id = rs.getInt("id");
                int cpf = rs.getInt("cpf");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                Date nascimento = rs.getDate("nascimento");
                Sexo sexo = Sexo.NAO_BINARIO;
                for (Sexo s : Sexo.values())
                    if (s.id() == rs.getInt("sexo"))
                        sexo = s;
                return new Usuario(id, cpf, nome, sobrenome, email, senha, nascimento, sexo);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean registrarFilme(Usuario user, String nome, String sinopse, String capa, String icone, int ano, double nota, Classificacao classificacao, boolean kid, Genero genero1, Genero genero2) {
        String sql;
        if (genero2 == null)
            sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
        else sql = "insert into filmes values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, nome);
            ps.setString(3, sinopse);
            ps.setString(4, capa);
            ps.setString(5, icone);
            ps.setInt(6, ano);
            ps.setDouble(7, nota);
            ps.setInt(8, classificacao.id());
            ps.setBoolean(9, kid);
            ps.setInt(10, genero1.id());
            if (genero2 != null) ps.setInt(11, genero2.id());

            ps.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
