package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;

public class AlunoDAO {
    private final Connection conn;

    public AlunoDAO() throws SQLException {
        this.conn = new Conexao().getConnection();  // Conecta ao banco de dados
    }

    public ResultSet consultar(String usuario, String senha) throws SQLException {
        String sql = "SELECT * FROM tbalunos WHERE usuario = ? AND senha = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, senha);
        return ps.executeQuery();  // Retorna o ResultSet com os dados do banco
    }

    public void inserir(Aluno a) throws SQLException {
        String sql = "INSERT INTO tbalunos (nome, usuario, senha) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getSenha());
            ps.executeUpdate();  // Insere o aluno no banco
        }
    }
}
