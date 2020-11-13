package br.com.poli.interfaceGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaException extends JFrame {

    JPanel panel = new JPanel();
    JLabel aviso = new JLabel("Erro! A coluna escolhida já está ocupada.");

    JButton jogarButton = new JButton("OK");


    public TelaException(){
        configurarJanela();
        conteudoTelaInicio();
    }

    public void configurarJanela(){
        setTitle("Lig4");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void conteudoTelaInicio(){
        add(panel);
        panel.setLayout(null);

        aviso.setBounds(20, 20, 240, 25);
        panel.add(aviso);

        panel.add(jogarButton);

        jogarButton.setBounds(100, 100, 80, 25);
        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicou");

                setVisible(false);

            }
        });

    }


}
