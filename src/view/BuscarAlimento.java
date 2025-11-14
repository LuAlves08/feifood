package view;

import java.util.Map;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import dao.PizzariaDAO;

public class BuscarAlimento extends javax.swing.JFrame {

    private final Map<String, String> pizzasPadrao;
    private final Aluno aluno;

    public BuscarAlimento(Aluno aluno) {
        initComponents();
        setLocationRelativeTo(null);

        this.aluno = aluno;

        pizzasPadrao = Map.of(
            "calabresa", "Calabresa",
            "frango", "Frango com catupiry",
            "portuguesa", "Portuguesa",
            "4 queijos", "Quatro queijos"
        );

        jButton2.addActionListener(e -> buscar());  // BUSCAR
        jButton1.addActionListener(e -> voltar());  // VOLTAR
    }

    private void voltar() {
        new Logado(aluno).setVisible(true);
        this.dispose();
    }

    private void buscar() {

        String pesquisa = jTextField1.getText().trim().toLowerCase();

        if (pesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Digite algo para pesquisar.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder resultado = new StringBuilder();
        boolean achou = false;

        // PIZZAS PADRÃO (aqui o "nome" já funciona como ingrediente)
        for (String chave : pizzasPadrao.keySet()) {
            String nome = pizzasPadrao.get(chave);

            if (chave.contains(pesquisa) || nome.toLowerCase().contains(pesquisa)) {
                if (resultado.length() > 0) {
                    resultado.append("\n");
                }
                resultado.append(nome);
                achou = true;
            }
        }

        // PIZZAS PERSONALIZADAS (nome – ingredientes)
        List<String> personalizadas = PizzariaDAO.listarPersonalizadas();

        for (String linha : personalizadas) {
            String[] partes = linha.split("–");

            if (partes.length == 2) {
                String nome = partes[0].trim().toLowerCase();
                String ingredientes = partes[1].trim();

                if (nome.contains(pesquisa)) {
                    if (resultado.length() > 0) {
                        resultado.append("\n");
                    }
                    resultado.append(ingredientes);
                    achou = true;
                }
            }
        }

        if (!achou) {
            resultado.append("Nenhum ingrediente encontrado.");
        }

        jTextArea1.setText(resultado.toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("VOLTAR");

        jLabel1.setText("Digite o sabor da pizza:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("BUSCAR");

        jLabel2.setText("Itens da pizza:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
