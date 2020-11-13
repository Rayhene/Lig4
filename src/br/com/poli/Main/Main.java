package br.com.poli.Main;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
import java.util.Scanner;

import br.com.poli.lig4.Jogador;
import br.com.poli.lig4.Tabuleiro;
import br.com.poli.interfaceGrafica.TelaInicial;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Instanciando a classe Jogador para o Jogador
         TelaInicial telaInicial = new TelaInicial();

        System.out.println("Olá, bem vindo a Lig-4, digite seu nome jogador 1: ");
        String nomeJogadorUm = input.nextLine();

        System.out.println("Agora digite seu nome jogador 2: ");
        String nomeJogadorDois = input.nextLine();

        Jogador jogadorUm = new Jogador(nomeJogadorUm, 1);
        Jogador jogadorDois = new Jogador(nomeJogadorDois, 2);
        Tabuleiro tabuleiro = new Tabuleiro();


    }
}