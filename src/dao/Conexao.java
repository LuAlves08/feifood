package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() throws SQLException {
        // Se está usando trust, deixe senha vazia ("")
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/alunos",
            "postgres",
            ""
        );
    }
}
