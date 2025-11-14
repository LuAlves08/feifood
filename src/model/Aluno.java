package model;

public class Aluno {

    private String nome;
    private String usuario;
    private String senha;

    public Aluno(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getUsuario() { return usuario; }
    public String getSenha() { return senha; }

    public void setNome(String nome) { this.nome = nome; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setSenha(String senha) { this.senha = senha; }
}
