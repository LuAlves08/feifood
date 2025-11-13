package controller;

import dao.AlunoDAO;
import dao.Conexao;
import javax.swing.JOptionPane;
import view.Login;
import view.Logado;

public class ControleLogin {

    private final Login telaLogin;

    public ControleLogin(Login telaLogin) {
        this.telaLogin = telaLogin;
    }

    public void entrar() {
        String usuario = telaLogin.getUsuario();  // Pega o nome de usuário
        String senha = telaLogin.getSenha();      // Pega a senha

        try {
            // Conexão com o banco de dados e autenticação do usuário
            AlunoDAO dao = new AlunoDAO(Conexao.getConnection());
            boolean autenticado = dao.autenticar(usuario, senha);  // Verifica no banco de dados

            if (autenticado) {
                JOptionPane.showMessageDialog(telaLogin, "Login bem-sucedido!");
                Logado telaLogado = new Logado();  // Cria a tela "Logado"
                telaLogado.setVisible(true);       // Exibe a tela "Logado"
                telaLogin.dispose();               // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(telaLogin, "Usuário ou senha inválidos!");
            }
        } catch (java.sql.SQLException ex) {
            System.getLogger(ControleLogin.class.getName()).log(System.Logger.Level.ERROR, "Erro de autenticação", ex);
        }
    }
}
