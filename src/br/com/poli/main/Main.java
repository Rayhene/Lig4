package br.com.poli.main;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
import java.util.Scanner;

import br.com.poli.exceptions.colunaOcupadaException;
import br.com.poli.exceptions.posicaoInvalidaException;
import br.com.poli.lig4DasGirls.*;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {

        Scanner input = new Scanner(System.in);
        
        //Instanciando a classe Jogador para o Jogador 
        
        System.out.println("Olá, bem vindo a Lig-4, digite seu nome jogador 1: ");
        String nomeJogadorUm = input.nextLine();
        
        System.out.println("Agora digite seu nome jogador 2: ");
        String nomeJogadorDois = input.nextLine();
        
        Jogador jogadorUm = new Jogador(nomeJogadorUm, 1);
        Jogador jogadorDois = new Jogador(nomeJogadorDois, 2);
        Tabuleiro tabuleiro = new Tabuleiro();


        Partida partida = new Partida(nomeJogadorUm, nomeJogadorDois);
        
        System.out.println(partida.getJogadorUm());
        System.out.println(partida.getJogadorDois());
        
        System.out.println("O jogo iniciou, este é o tabuleiro");
        System.out.println(tabuleiro.toString());


        while(true){
            System.out.println("O jogador da vez é: " + partida.getJogadorDaVez());
            int posicao = input.nextInt();

            try{
                if(posicao < 0 || posicao > 6){
                    throw new posicaoInvalidaException();
                }

                int jogadorDaVez =  partida.fazerJogada(posicao);
                System.out.println("Jogador " + (jogadorDaVez ) + " fez a jogada " + posicao);


            } catch (posicaoInvalidaException e) {
                System.out.println("Posição inválida, por favor digite novamente uma coluna entre 0 a 6.");
                System.out.println(partida.getStringTabuleiro());

            }catch (colunaOcupadaException e){
                System.out.println("A coluna " + posicao + " já está preenchida. Jogue novamente.");
                System.out.println(partida.getStringTabuleiro());

            }




        }
 

    
}
}