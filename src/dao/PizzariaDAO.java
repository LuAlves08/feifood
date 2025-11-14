package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PizzariaDAO {


    public static void salvarPizza(String nome, String ingredientes) {
        String sql = "INSERT INTO pizzas_personalizadas (nome, ingredientes) VALUES (?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, ingredientes);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String buscarPizza(String nome) {
        String sql = "SELECT ingredientes FROM pizzas_personalizadas WHERE LOWER(nome) = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome.toLowerCase());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("ingredientes");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> listarNomes() {
        List<String> lista = new ArrayList<>();

        String sql = "SELECT nome FROM pizzas_personalizadas";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<String> listarPersonalizadas() {
        List<String> lista = new ArrayList<>();

        String sql = "SELECT nome, ingredientes FROM pizzas_personalizadas";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String ingredientes = rs.getString("ingredientes");

                lista.add(nome + " – " + ingredientes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
