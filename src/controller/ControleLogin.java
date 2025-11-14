package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Login;
import view.Logado;
import model.Aluno;

public class ControleLogin {

    private final Login telaLogin;

    public ControleLogin(Login telaLogin) {
        this.telaLogin = telaLogin;
    }

    public void entrar() {
        String usuario = telaLogin.getUsuario();
        String senha   = telaLogin.getSenha();

        try (Connection c = Conexao.getConnection()) {
            AlunoDAO dao = new AlunoDAO(c);

            if (dao.autenticar(usuario, senha)) {
                Aluno a = dao.buscarPorUsuario(usuario);
                Logado tela = new Logado(a);
                tela.setVisible(true);
                telaLogin.dispose();
            } else {
                JOptionPane.showMessageDialog(telaLogin, "Usuário ou senha inválidos!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaLogin, "Erro de conexão: " + e.getMessage());
        }
    }
}
