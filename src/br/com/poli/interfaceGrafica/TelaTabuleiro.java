package br.com.poli.interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import br.com.poli.lig4.Partida;
import br.com.poli.exceptions.ColunaOcupadaException;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TelaTabuleiro {
	
    private JFrame frame;

    public TelaTabuleiro(String nomeUm, String nomeDois) {
        frame = new JFrame("Lig4");
        frame.setSize(680, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.add(new TabuleiroGUI(frame.getSize(), nomeUm, nomeDois));
        frame.pack();

        frame.setVisible(true);

    }

    public class TabuleiroGUI extends JPanel  implements MouseListener {
        private int startX = 10;
        private int startY = 10;
        private final int peçaTamanho = 60;   //tamanho dos "quadradinhos" que recebem as peças
        private final int linhas = 6;
        private final int colunas = 7;
        private final Partida partida;   //declarando um atributo partida do tipo partida
        private String corAtual = "";



        Color[][] tab = new Color[linhas][colunas];  //tabuleiro, onde cada espaço recebe uma "cor"
        public TabuleiroGUI(Dimension dimension, String nomeJogadorUm, String nomeJogadorDois) {     //construtor da classe tabuleiroGUI
        	 //uma dimensao do tipo dimension que encapsula a largura e a altura de um componente em um objeto
        	//as Strings com o nome dos jogadores 1 e 2
        	
        	setSize(dimension);
            setPreferredSize(dimension);
            
            this.partida = new Partida(nomeJogadorUm, nomeJogadorDois); //instanciando a classe Partida
            System.out.println(nomeJogadorUm);
            System.out.println(nomeJogadorDois);
            
            addMouseListener(this);

            
            //1. inicializando o array aqui
            //int x = 0;
            for (int linha = 0; linha < tab.length; linha++) {
                for (int coluna = 0; coluna < tab[0].length; coluna++) {
                    //Color c; não precisa tbm pq a gente compara a cor direto

                    tab[linha][coluna] = Color.white;

                    //x++; não precisa

                }

            }
        }

        @Override
        public void paintComponent(Graphics g) {  
        	//Os elementos internos do sistema GUI chamam esse método e passam no parâmetro Graphics como um contexto gráfico no qual você pode desenhar.
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(102,205,170));
            g2.fillRect(0,0,d.width,d.height);
            startX = 0;
            startY = 0;

            //desenhando o tabuleiro aqui
            for (int linha = 0; linha < tab.length; linha++) {
                for (int col = 0; col < tab[0].length; col++) {

                    g2.setColor(tab[linha][col]);
                    g2.fillRect(startX,startY,peçaTamanho,peçaTamanho);
                    g2.setColor(Color.black);
                    g2.drawRect(startX,startY,peçaTamanho,peçaTamanho);
                    startX += peçaTamanho;
                }
                startY += peçaTamanho;
                startX = 0;
            }

            g2.setColor(new Color(255, 250, 255));



            if(!partida.getVencedor()){

                if(partida.isFim()){
                    g2.setFont(new Font("Arial", 1, 19));
                    g2.drawString("Deu empate",465,200);
                    g2.drawString("O jogo terminou",455,225);
                }else if(partida.getJogadorDaVez() == 1){
                    g2.setFont(new Font("Arial", 1, 19));
                    g2.drawString("Vez do jogador 1" ,465,200);
                }else{
                    g2.setFont(new Font("Arial", 1, 19));
                    g2.drawString("Vez do jogador 2",465,200);
                }
            }else{
                if(partida.getJogadorDaVez() == 1){
                    g2.setFont(new Font("Arial", 1, 19));
                    g2.drawString("Vencedor: " + partida.getNomeJogadorDois(), 465, 200);
                    g2.drawString("Jogador 2 - " + corAtual, 465, 225);
                }else{
                    g2.setFont(new Font("Arial", 1, 19));
                    g2.drawString("Vencedor: " + partida.getNomeJogadorUm(), 465, 200);
                    g2.drawString("Jogador 1 - " + corAtual, 465, 225);
                }

            }

        }


        public void mousePressed(MouseEvent e) {
            int x = e.getX(); //pega a posição x que o mouse clicou
            int y = e.getY(); // pega a posição y que o mouse clicou


                if(!partida.getVencedor()){

                if(x<(peçaTamanho*tab[0].length) && y<(peçaTamanho*tab.length)) {

                    System.out.println(x);
                    System.out.println(peçaTamanho);
                    int colunaClicada = x / peçaTamanho;
                    System.out.println(colunaClicada);

                    int retornoY = 0;

                    try {
                        retornoY = partida.fazerJogada(colunaClicada);
                    } catch (ColunaOcupadaException colunaOcupadaException) {
                        System.out.println("EXCEPTION");
                        new TelaException();
                    }

                    System.out.println("retorno: " + retornoY);


                    if (partida.getJogadorDaVez() == 1) {
                        tab[retornoY][colunaClicada] = Color.pink;
                        corAtual = "rosa";

                    } else {
                        tab[retornoY][colunaClicada] = Color.yellow;
                        corAtual = "amarelo";
                    }

                }

                repaint();
            }
        }



        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {

        }





    }
}