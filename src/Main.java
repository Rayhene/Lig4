public class Main {
    public static void main(String[] args) {
        Jogador jogadorUm = new Jogador();
        Jogador jogadorDois = new Jogador();

        Partida partida = new Partida(jogadorUm, jogadorDois);

        partida.Jogada(0);
        partida.Jogada(1);
        partida.Jogada(2);
        partida.Jogada(3);
        partida.Jogada(4);

    }
}
