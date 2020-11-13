package br.com.poli.interfaceGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    JPanel panel = new JPanel();
    JLabel jogadorLabel1 = new JLabel("Nome do Jogador 1: ");
    JLabel jogadorLabel2 = new JLabel("Nome do Jogador 2: ");

    JTextField jogadorNome1 = new JTextField();
    JTextField jogadorNome2 = new JTextField();

    JButton jogarButton = new JButton("Jogar");


    public TelaInicial(){
        configurarJanela();
        conteudoTelaInicio();
    }

    public void configurarJanela(){
        setTitle("Lig4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void conteudoTelaInicio(){
        add(panel);
        panel.setLayout(null);

        jogadorLabel1.setBounds(10, 20, 300, 25);
        panel.add(jogadorLabel1);

        jogadorNome1.setBounds(10, 45, 260, 25);
        panel.add(jogadorNome1);


        jogadorLabel2.setBounds(10, 80, 300, 25);
        panel.add(jogadorLabel2);

        jogadorNome2.setBounds(10, 105, 260, 25);
        panel.add(jogadorNome2);

        jogarButton.setBounds(100, 180, 80, 25);
        jogarButton.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicou");
                String nomeJogadorUm = jogadorNome1.getText();
                String nomeJogadorDois = jogadorNome2.getText();

                setVisible(false);

                new TelaTabuleiro(nomeJogadorUm, nomeJogadorDois);

            }
        });
        panel.add(jogarButton);
    }


}
