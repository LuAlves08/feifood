package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;

public class AlunoDAO {

    private final Connection conn;

    // Construtor da classe que recebe a conexão com o banco de dados
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir um aluno no banco de dados
    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, usuario, senha) VALUES (?, ?, ?)";  // Query para inserir no banco

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());  // Define o nome na consulta
            ps.setString(2, aluno.getUsuario()); // Define o usuário na consulta
            ps.setString(3, aluno.getSenha());   // Define a senha na consulta
            ps.executeUpdate();  // Executa a inserção no banco
        }
    }

    // Método para autenticar o login
public boolean autenticar(String usuario, String senha) throws SQLException {
    String sql = "SELECT 1 FROM alunos WHERE usuario = ? AND senha = ? LIMIT 1";  // Query SQL para verificar o login
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, usuario);  // Define o nome de usuário
        ps.setString(2, senha);     // Define a senha
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next();  // Se encontrar o usuário e senha, retorna true
        }
    }
}

}
