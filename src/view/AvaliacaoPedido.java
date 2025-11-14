package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvaliacaoPedido extends JDialog {

    private int nota = 0;
    private final JLabel[] estrelas = new JLabel[5];

    public AvaliacaoPedido(JFrame parent) {
        super(parent, "Avaliar Pedido", true);
        setSize(350, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Avalie o pedido:", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JPanel painelEstrelas = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        // cria 5 estrelas clicáveis
        for (int i = 0; i < 5; i++) {
            estrelas[i] = new JLabel("☆");
            estrelas[i].setFont(new Font("Segoe UI", Font.PLAIN, 40));

            final int index = i;

            estrelas[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nota = index + 1;
                    atualizarEstrelas();
                }
            });

            painelEstrelas.add(estrelas[i]);
        }

        add(painelEstrelas, BorderLayout.CENTER);

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> dispose());

        add(confirmar, BorderLayout.SOUTH);
    }

    private void atualizarEstrelas() {
        for (int i = 0; i < estrelas.length; i++) {
            estrelas[i].setText(i < nota ? "★" : "☆"); // preta = selecionada
        }
    }

    public int getNota() {
        return nota;
    }
}

