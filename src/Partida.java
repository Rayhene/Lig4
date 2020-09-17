public class Partida {
    Jogador jogadorUm;
    Jogador jogadorDois;
    boolean fim;
    boolean temVencedor;
    int jogadorDaVez = 1;

    public Partida(Jogador jogadorUm, Jogador jogadorDois) {
        this.jogadorUm = jogadorUm;
        this.jogadorDois = jogadorDois;
    }

    public void Jogada(int x) {

        System.out.println("Agora é a vez do jogador: " + jogadorDaVez);
        System.out.println("O jogador " + jogadorDaVez + " fez a jogada " + x + '\n');

        if (jogadorDaVez == 1) jogadorDaVez += 1;
        else jogadorDaVez -= 1;


    }
}
