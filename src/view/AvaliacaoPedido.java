package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvaliacaoPedido extends JDialog {

    private int nota = 0;
    private final JLabel[] bolinhas = new JLabel[5];

    public AvaliacaoPedido(JFrame parent) {
        super(parent, "Avaliar Pedido", true);
        setSize(350, 180);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Avalie o pedido:", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        JPanel painelBolinhas = new JPanel();
        painelBolinhas.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        // Criar as bolinhas
        for (int i = 0; i < 5; i++) {
            bolinhas[i] = new JLabel("○");  
            bolinhas[i].setFont(new Font("Segoe UI", Font.PLAIN, 40));
            final int index = i;

            bolinhas[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nota = index + 1;
                    atualizarBolinhas();
                }
            });

            painelBolinhas.add(bolinhas[i]);
        }

        add(painelBolinhas, BorderLayout.CENTER);

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> dispose());
        add(confirmar, BorderLayout.SOUTH);
    }

    private void atualizarBolinhas() {
        for (int i = 0; i < bolinhas.length; i++) {
            bolinhas[i].setText(i < nota ? "●" : "○");
        }
    }

    public int getNota() {
        return nota;
    }
}
