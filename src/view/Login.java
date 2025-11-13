package view;

import controller.ControleLogin;  // Para chamar o controlador de login

public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    public Login() {
        initComponents();  // Código gerado automaticamente pelo NetBeans
        ControleLogin c = new controller.ControleLogin(this);  // Inicializando o controlador com a tela de login

        // Adicionando o evento para o botão "Entrar"
        jButton1.addActionListener(e -> c.entrar());  // Quando clicado, chama o método 'entrar' do controlador

        // Adicionando o evento para o botão "Cadastrar"
        jButton2.addActionListener(e -> {
            new view.Cadastro().setVisible(true);  // Abre a tela de cadastro
            this.dispose();  // Fecha a tela de login
        });
    }

    // Métodos para pegar os valores dos campos de texto
    public String getUsuario() {
        return jTextField1.getText();  // Campo de texto onde o usuário digita o nome de usuário
    }

    public String getSenha() {
        return jTextField2.getText();  // Campo de texto onde o usuário digita a senha
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("ENTRAR");
        getContentPane().add(jButton1);
        jButton1.setBounds(113, 187, 164, 38);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("CADASTRAR");
        getContentPane().add(jButton2);
        jButton2.setBounds(113, 231, 164, 38);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(58, 56, 46, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(58, 124, 37, 16);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(23, 187, 37, 0);

        jTextField1.setToolTipText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 50, 220, 40);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(150, 110, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}