package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Login;
import view.Logado;

public class ControleLogado {

    private final Logado tela;

    public ControleLogado(Logado tela) {
        this.tela = tela;
    }

    public void excluirConta() {
        Aluno a = tela.getAluno();

        int opc = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir sua conta (" + a.getUsuario() + ")?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (opc != JOptionPane.YES_OPTION) return;

        try (Connection c = Conexao.getConnection()) {
            AlunoDAO dao = new AlunoDAO(c);

            int linhas = dao.excluirPorUsuario(a.getUsuario());

            if (linhas > 0) {
                JOptionPane.showMessageDialog(tela, "Conta excluída com sucesso!");
                new Login().setVisible(true);
                tela.dispose();
            } else {
                JOptionPane.showMessageDialog(tela, "Erro: usuário não encontrado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao excluir: " + e.getMessage());
        }
    }
}
