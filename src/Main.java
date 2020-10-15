/**
 *  Projeto de LPOO - Lig4 (Parte II)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Partida partida = new Partida("Sarah", "Rayhene");

        System.out.println(partida.jogadorUm);
        System.out.println(partida.jogadorDois);

        while(true){
            System.out.println("O jogador da vez é: " + partida.getJogadorDaVez());
            int posicao = input.nextInt();
            partida.fazerJogada(posicao);
        }


    }


}
