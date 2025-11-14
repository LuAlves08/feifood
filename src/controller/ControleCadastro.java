package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Cadastro;

public class ControleCadastro {

    private final Cadastro tela;

    public ControleCadastro(Cadastro tela) {
        this.tela = tela;
    }

    public void salvarAluno() {

        String nome = tela.getNome();
        String usuario = tela.getUsuario();
        String senha = tela.getSenha();

        Aluno aluno = new Aluno(nome, usuario, senha);

        try {
            Connection conn = Conexao.getConnection();
            AlunoDAO dao = new AlunoDAO(conn);

            dao.inserir(aluno);

            JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso!");
            tela.dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao cadastrar: " + e.getMessage());
        }
    }
}
