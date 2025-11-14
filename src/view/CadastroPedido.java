package view;

import dao.PizzariaDAO;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Aluno;

public class CadastroPedido extends javax.swing.JFrame {

    private final Aluno aluno;

    // pizzas fixas
    private final Map<String, String> pizzas = new HashMap<>();

    // DAO
    private final PizzariaDAO pizzariaDAO = new PizzariaDAO();

    public CadastroPedido(Aluno aluno) {
        initComponents();
        this.aluno = aluno;
        setLocationRelativeTo(null);

        cadastrarPizzasFixas();
        configurarEventos();
    }

    private void configurarEventos() {

        jButton1.addActionListener(e -> adicionarPizza());
        jButton2.addActionListener(e -> removerUltimoItem());
        jButton3.addActionListener(e -> salvarPedido());

        jButton4.addActionListener(e -> { // VOLTAR
            new Logado(aluno).setVisible(true);
            this.dispose();
        });

        jRadioButton1.addActionListener(e -> abrirPersonalizar());
    }

    private void cadastrarPizzasFixas() {
        pizzas.put("calabresa", "Calabresa");
        pizzas.put("portuguesa", "Portuguesa");
        pizzas.put("marguerita", "Marguerita");
        pizzas.put("frango", "Frango com Catupiry");
        pizzas.put("4 queijos", "Quatro Queijos");
    }

    // ABRIR PIZZA PERSONALIZADA
    private void abrirPersonalizar() {
        PersonalizarPedido tela = new PersonalizarPedido(this);
        tela.setVisible(true);
        this.setVisible(false);
    }

    private void adicionarPizza() {

        String sabor = jTextField1.getText().trim().toLowerCase();
        String qtd = jTextField2.getText().trim();

        if (sabor.isEmpty() || qtd.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha o sabor e a quantidade.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // tenta personalizada primeiro
        String personalizada = pizzariaDAO.buscarPizza(sabor);

        if (personalizada != null) {
            jTextArea1.append(
                "• Ingredientes: " + personalizada + "\n" +
                "  Quantidade: " + qtd + "\n\n"
            );

            jTextField1.setText("");
            jTextField2.setText("");
            return;
        }

        // não existe
        if (!pizzas.containsKey(sabor)) {
            JOptionPane.showMessageDialog(this,
                    "Sabor não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        jTextArea1.append(
            "• " + pizzas.get(sabor) + "\n" +
            "  Quantidade: " + qtd + "\n\n"
        );

        jTextField1.setText("");
        jTextField2.setText("");
    }

    // usado pela tela de personalização
    public void adicionarPizzaPersonalizada(String nome, String ingredientes) {

        jTextArea1.append(
            "• Ingredientes: " + ingredientes + "\n" +
            "  Quantidade: 1\n\n"
        );
    }

    private void removerUltimoItem() {

        String texto = jTextArea1.getText().trim();

        if (texto.isEmpty()) return;

        String[] linhas = texto.split("\n");

        if (linhas.length <= 1) {
            jTextArea1.setText("");
            return;
        }

        StringBuilder novo = new StringBuilder();

        for (int i = 0; i < linhas.length - 2; i++) {
            novo.append(linhas[i]).append("\n");
        }

        jTextArea1.setText(novo.toString());
    }

    private void salvarPedido() {

        if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum item no pedido.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // AVALIAÇÃO DO PEDIDO
        Integer nota = escolherNota();

        if (nota == null) {
            JOptionPane.showMessageDialog(this,
                    "Avaliação cancelada.",
                    "Cancelado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Pedido salvo com sucesso!\nAvaliação: " + nota + " estrelas.",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // POP-UP DE ESTRELAS
    private Integer escolherNota() {
        String[] opcoes = { "1", "2", "3", "4", "5" };

        String resposta = (String) JOptionPane.showInputDialog(
                this,
                "Avalie o pedido:",
                "Avaliação",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                "5"
        );

        if (resposta == null) return null;

        return Integer.parseInt(resposta);
    }

    public Aluno getAluno() {
        return aluno;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SELECIONAR PIZZA E QUANTIDADE");

        jLabel2.setText("Pizza:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("ADICIONAR PEDIDO");

        jLabel4.setText("Itens do pedido:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("REMOVER");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("SALVAR");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Personalizar pedido");
        jRadioButton1.setToolTipText("");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                            .addComponent(jButton3)
                            .addGap(62, 62, 62)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private static class aluno {

        public aluno() {
        }
    }
}
