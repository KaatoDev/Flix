package flix.util;

import flix.model.Perfil;
import flix.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbManager {
    public static boolean exists(Usuario user) throws Exception {
        String sql = "select nome from usuarios where nome=?";
        try(Connection c = Database.connect();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    public static boolean registerProfile(String display, int cpf) {
        String sqlperfil = "insert into perfis values(default, ?, ?, false, 0)";
        try(Connection c = Database.connect();
            PreparedStatement ps = c.prepareStatement(sqlperfil)) {
            ps.setString(1, display);
            ps.setInt(2, cpf);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean registerUser(String nome, int cpf, String email, String senha, Date nascimento) {
        registerProfile(nome, cpf);
        String sqluser = "insert into usuarios values(default, ?, ?, ?, ?, ?, ?, null, null)";
        try(Connection c = Database.connect();
            PreparedStatement ps = c.prepareStatement(sqluser)) {
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, email);
            ps.setString(4, email);
            ps.setDate(5, nascimento);
            ps.setInt(6, getFirstProfile(cpf));
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static int getFirstProfile(int cpf) throws Exception {
        String sql = "select cpf from perfis where cpf=?";
        try(Connection c = Database.connect();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, cpf);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.getInt("id");
            }
    }
}
