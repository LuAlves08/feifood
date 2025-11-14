package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Login;
import view.Logado;

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
                if (a == null) {
                    JOptionPane.showMessageDialog(telaLogin, "Erro ao carregar dados do usuário.");
                    return;
                }

                // Abre a tela LOGADO como menu do usuário
                new Logado(a).setVisible(true);
                telaLogin.dispose();
            } else {
                JOptionPane.showMessageDialog(telaLogin, "Usuário ou senha inválidos!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaLogin, "Erro de conexão: " + e.getMessage());
        }
    }
}
