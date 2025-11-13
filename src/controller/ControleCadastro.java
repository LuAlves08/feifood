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

    // Método para salvar o aluno no banco de dados
    public void salvarAluno() {
        // Pega os dados da tela usando os métodos que VOCÊ criou (getNome, getUsuario, getSenha)
        String nome = tela.getNome();
        String usuario = tela.getUsuario();
        String senha = tela.getSenha();

        Aluno aluno = new Aluno(nome, usuario, senha);

        try {
            // Conexão com o banco de dados
            Connection conn = Conexao.getConnection();  // Chama o método estático
            AlunoDAO dao = new AlunoDAO(conn);

            // Chama o método para salvar no banco
            dao.inserir(aluno);  // Insere o aluno no banco de dados

            JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            tela.dispose(); // Fecha a tela de cadastro

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao cadastrar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
