package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;

public class AlunoDAO {

    private final Connection conn;

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    /** INSERIR CADASTRO */
    public void inserir(Aluno aluno) throws SQLException {
        final String sql = "INSERT INTO alunos (nome, usuario, senha) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getUsuario());
            ps.setString(3, aluno.getSenha());
            ps.executeUpdate();
        }
    }

    /** AUTENTICAR LOGIN */
    public boolean autenticar(String usuario, String senha) throws SQLException {
        final String sql = "SELECT 1 FROM alunos WHERE usuario = ? AND senha = ? LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    /** BUSCAR ALUNO POR USUARIO */
    public Aluno buscarPorUsuario(String usuario) throws SQLException {
        final String sql = "SELECT nome, usuario, senha FROM alunos WHERE usuario = ? LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Aluno(
                        rs.getString("nome"),
                        rs.getString("usuario"),
                        rs.getString("senha")
                    );
                }
                return null;
            }
        }
    }

    /** EXCLUIR ALUNO */
    public int excluirPorUsuario(String usuario) throws SQLException {
        final String sql = "DELETE FROM alunos WHERE usuario = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            return ps.executeUpdate();
        }
    }

    /** ALTERAR SENHA */
    public int alterarSenha(String usuario, String novaSenha) throws SQLException {
        final String sql = "UPDATE alunos SET senha = ? WHERE usuario = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novaSenha);
            ps.setString(2, usuario);
            return ps.executeUpdate();
        }
    }
}
