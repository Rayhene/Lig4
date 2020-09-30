public class Main {
    public static void main(String[] args) {
        Jogador jogadorUm = new Jogador("sarah");
        Jogador jogadorDois = new Jogador("rayhene");

        Partida partida = new Partida(jogadorUm, jogadorDois);

        partida.fazerJogada(0);
        partida.fazerJogada(1);
        partida.fazerJogada(2);
        partida.fazerJogada(3);
        partida.fazerJogada(4);

    }
}
