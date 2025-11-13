package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private final String USUARIO = "postgres";  // Usuário do banco
    private final String SENHA = "senha";      // Senha do banco
    private final String URL = "jdbc:postgresql://localhost:5432/alunos";  // URL de conexão com o banco de dados

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Retorna a conexão com o banco
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/alunos", "postgres", "senha");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver do PostgreSQL não encontrado.");
            throw new SQLException("Driver do PostgreSQL não encontrado: " + e.getMessage());
        }
    }
}
