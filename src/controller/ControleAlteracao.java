package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Alteracao;
import view.Logado;

public class ControleAlteracao {

    private final Alteracao tela;
    private final Aluno aluno;

    public ControleAlteracao(Alteracao tela, Aluno aluno) {
        this.tela = tela;
        this.aluno = aluno;
    }

    public void alterar() {
        String novaSenha = tela.getNovaSenha();

        if (novaSenha.isBlank()) {
            JOptionPane.showMessageDialog(tela, "A nova senha não pode estar vazia!");
            return;
        }

        try (Connection c = Conexao.getConnection()) {
            AlunoDAO dao = new AlunoDAO(c);
            int linhas = dao.alterarSenha(aluno.getUsuario(), novaSenha);

            if (linhas > 0) {
                aluno.setSenha(novaSenha);
                JOptionPane.showMessageDialog(tela, "Senha alterada com sucesso!");

                // Volta para a tela Logado
                new Logado(aluno).setVisible(true);
                tela.dispose();
            } else {
                JOptionPane.showMessageDialog(tela, "Usuário não encontrado para alterar senha.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao alterar: " + e.getMessage());
        }
    }
}
