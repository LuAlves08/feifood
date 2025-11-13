package controller;

import dao.AlunoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Login;

public class ControleLogin {
    private final Login telaLogin;

    public ControleLogin(Login telaLogin) {
        this.telaLogin = telaLogin;  // Construtor que recebe a tela de login
    }

    public void login() {
        // Pega os dados inseridos na tela de login
        String usuario = telaLogin.getUsuario();  // Chama o método getUsuario() para pegar o valor do campo usuário
        String senha = telaLogin.getSenha();      // Chama o método getSenha() para pegar o valor do campo senha

        try {
            AlunoDAO dao = new AlunoDAO();
            ResultSet rs = dao.consultar(usuario, senha);  // Consulta no banco de dados

            if (rs.next()) {
                JOptionPane.showMessageDialog(telaLogin, "Login bem-sucedido!");
                // Caso o login seja bem-sucedido, abre uma nova tela ou continua com o fluxo
                // Exemplo: new TelaLogada().setVisible(true);
                // telaLogin.dispose();  // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(telaLogin, "Usuário ou senha inválidos!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaLogin, "Erro no login: " + e.getMessage());
        }
    }
}
