package flix.util;

import flix.enums.Classificacao;
import flix.enums.Filtro;
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
import java.util.HashMap;
import java.util.List;

import static flix.util.Manager.getE;

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

    public static boolean avaliar(Filme filme, double nota) {
        String sql = "insert into notas values (default, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, nota);
            ps.setInt(2, filme.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean avaliar(int filme, double nota) {
        String sql = "insert into notas values (default, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, nota);
            ps.setInt(2, filme);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static int getFilmeId(String nome2) {
        String sql = "select * from filmes where nome=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nome2);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
                    boolean adm = rs.getBoolean("adm");
                    long cpf = rs.getLong("cpf");
                    Date nascimento = rs.getDate("nascimento");
                    int icon = rs.getInt("icon");
                    Genero genero = (Genero) getE(rs.getInt("genero"), "genero");
                    GeneroFilme genero1 = (GeneroFilme) getE(rs.getInt("genero1"), "generofilme");
                    GeneroFilme genero2 = (GeneroFilme) getE(rs.getInt("genero2"), "generofilme");
                    if (genero1 == genero2) genero2 = null;
                    usuarios.add(new Usuario(id, adm, cpf, nome, sobrenome, email, nascimento, genero, icon, genero1, genero2));
                }
                return usuarios;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Usuario> genUsuarios(String nome2, String email2) {
        String sql = "select * from usuarios";
        if (nome2 != null && email2 != null)
            sql += " where nome like '%" + nome2 + "%'" + " and email like '%" + email2 + "%' or sobrenome like '%" + nome2 + "%' and email like '%" + email2 + "%'";
        else if (nome2 != null && email2 == null)
            sql += " where nome like '%" + nome2 + "%'" + " or sobrenome like '%" + nome2 + "%'";
        else if (nome2 == null && email2 != null)
            sql += " where email like '%" + email2 + "%'";
        System.out.println(sql);
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Usuario> usuarios = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome"), sobrenome = rs.getString("sobrenome"),
                            email = rs.getString("email");
                    boolean adm = rs.getBoolean("adm");
                    long cpf = rs.getLong("cpf");
                    Date nascimento = rs.getDate("nascimento");
                    int icon = rs.getInt("icon");
                    Genero genero = (Genero) getE(rs.getInt("genero"), "genero");
                    GeneroFilme genero1 = (GeneroFilme) getE(rs.getInt("genero1"), "generofilme");
                    GeneroFilme genero2 = (GeneroFilme) getE(rs.getInt("genero2"), "generofilme");
                    if (genero1 == genero2) genero2 = null;
                    usuarios.add(new Usuario(id, adm, cpf, nome, sobrenome, email, nascimento, genero, icon, genero1, genero2));
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
        if (exists(nome) && exists(email))
            return false;
        String sql = "insert into usuarios values(default, false, ?, ?, ?, ?, ?, ?, ?, 2, ?, null)";
        if (genero2 != null)
            sql = "insert into usuarios values(default, false, ?, ?, ?, ?, ?, ?, ?, 2, ?, ?)";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
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
            JOptionPane.showMessageDialog(null, "Usuário <" + nome + "> cadastrado com sucesso!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<Filme> genFilmes() {
        String sql = "select (select count(notas.id) from notas where notas.filmeId = filmes.id) quantidade_notas, nota_imdb, filmes.id, nome, sinopse, ano, userId, capa, icon, classificacao, kid, genero1, genero2, (select avg(notas.nota) from notas where notas.filmeId = filmes.id) nota_publico, nota_imdb from notas inner join filmes where notas.filmeId = filmes.id group by filmes.id order by nota_publico desc";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Filme> filmes = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id"), ano = rs.getInt("ano"), userId = rs.getInt("userId"), qtt = rs.getInt("quantidade_notas");
                    String nome = rs.getString("nome"), sinopse = rs.getString("sinopse"), capa = rs.getString("capa"), icon = rs.getString("icon");
                    double imdb = rs.getDouble("nota_imdb"), nota = rs.getDouble("nota_publico");
                    boolean kid = rs.getBoolean("kid");
                    Classificacao classificacao = (Classificacao) getE(rs.getInt("classificacao"), "classificacao");
                    GeneroFilme genero1 = (GeneroFilme) getE(rs.getInt("genero1"), "generofilme");
                    GeneroFilme genero2 = (GeneroFilme) getE(rs.getInt("genero2"), "generofilme");
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
    public static List<Filme> genFilmes(HashMap<Filtro, String> filtros) {
        StringBuilder sb = new StringBuilder();
        for (Filtro f : filtros.keySet()) {
            sb.append(f.sql()).append(filtros.get(f));
            switch (f) {
                case GENERO -> sb.append(" and genero1 =").append(filtros.get(f));
                case NOME -> sb.append("%'");
            }
        }
        String sql = "select (select count(notas.id) from notas where notas.filmeId = filmes.id) quantidade_notas, nota_imdb, filmes.id, nome, sinopse, ano, userId, capa, icon, classificacao, kid, genero1, genero2, (select avg(notas.nota) from notas where notas.filmeId = filmes.id) nota_publico, nota_imdb from notas inner join filmes where notas.filmeId = filmes.id "
                + sb + " group by filmes.id order by nota_publico desc";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Filme> filmes = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id"), ano = rs.getInt("ano"), userId = rs.getInt("userId"), qtt = rs.getInt("quantidade_notas");
                    String nome = rs.getString("nome"), sinopse = rs.getString("sinopse"), capa = rs.getString("capa"), icon = rs.getString("icon");
                    double imdb = rs.getDouble("nota_imdb"), nota = rs.getDouble("nota_publico");
                    boolean kid = rs.getBoolean("kid");
                    Classificacao classificacao = (Classificacao) getE(rs.getInt("classificacao"), "classificacao");
                    GeneroFilme genero1 = (GeneroFilme) getE(rs.getInt("genero1"), "generofilme");
                    GeneroFilme genero2 = (GeneroFilme) getE(rs.getInt("genero2"), "generofilme");
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
    public static int getIdFrom(String usuario) {
        String sql = "select id from usuarios where nome=?";
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
                    int id = rs.getInt("id"), icone = rs.getInt("icon");
                    long cpf = rs.getLong("cpf");
                    boolean adm = rs.getBoolean("adm");
                    String nome = rs.getString("nome"), email = rs.getString("email"), sobrenome = rs.getString("sobrenome"),
                            pass = rs.getString("senha");
                    Date nascimento = rs.getDate("nascimento");
                    Genero genero = (Genero) getE(rs.getInt("genero"), "genero");
                    GeneroFilme genero1 = (GeneroFilme) getE(rs.getInt("genero1"), "generofilme"),
                            genero2 = (GeneroFilme) getE(rs.getInt("genero2"), "generofilme");
                    if (genero1 == genero2) genero2 = null;
                    return new Usuario(id, adm, cpf, nome, sobrenome, email, nascimento, genero, icone, genero1, genero2);
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
        StringBuilder sql = new StringBuilder("insert into filmes values (default, ?, ?, ?");
        if (!capa.equals("")) sql.append(", ?");
        else sql.append(", null");
        if (!icon.equals("")) sql.append(", ?");
        else sql.append(", null");
        sql.append(", ?, ?, ?");
        if (kid) sql.append(", true");
        else sql.append(", false");
        sql.append(", ?");
        if (genero1 != genero2) sql.append(", ?);");
        else sql.append(", null)");
        try (Connection c = Database.connect();
             PreparedStatement ps = c.prepareStatement(sql.toString())) {

            int i=4;
            ps.setInt(1, user.getId());
            ps.setString(2, nome);
            ps.setString(3, sinopse);
            if (!capa.equals("")) ps.setString(i++, capa);
            if (!icon.equals("")) ps.setString(i++, icon);
            ps.setInt(i++, ano);
            ps.setDouble(i++, nota);
            Classificacao a = (Classificacao) getE(classificacao);
            ps.setInt(i++, a.id());
            ps.setInt(i++, genero1.id());
            if (genero1 != genero2) ps.setInt(i, genero2.id());
            ps.execute();
            return avaliar(getFilmeId(nome), nota);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
