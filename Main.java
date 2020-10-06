public class Main {
    public static void main(String[] args) {

        Partida partida = new Partida("Sarah", "Rayhene");

        System.out.println(partida.jogadorUm);
        System.out.println(partida.jogadorDois);

        System.out.println();
        partida.fazerJogada(0);
        partida.fazerJogada(0);
        partida.fazerJogada(0);
        partida.fazerJogada(0);
        partida.fazerJogada(1);
        partida.fazerJogada(1);
        partida.fazerJogada(1);
        partida.fazerJogada(4);


    }
}
