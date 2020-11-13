package br.com.poli.lig4;

import br.com.poli.exceptions.ColunaOcupadaException;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Partida {

    Jogador jogadorUm;
    Jogador jogadorDois;
    private boolean fim;
    private boolean vencedor = false;
    private int jogadorDaVez;
    private final Tabuleiro tabuleiro;

    public Partida(String nomeJogadorUm, String nomeJogadorDois) {
        this.jogadorUm = new Jogador(nomeJogadorUm, 1);
        this.jogadorDois = new Jogador(nomeJogadorDois, 2);
        this.fim = false;
        this.jogadorDaVez = jogadorUm.getValor();
        this.tabuleiro = new Tabuleiro();
    }

    public int getJogadorDaVez() {
        return jogadorDaVez;
    }

    public String getNomeJogadorUm(){
        return jogadorUm.getNome();
    }

    public String getNomeJogadorDois(){
        return jogadorDois.getNome();
    }

    public int fazerJogada(int x) throws ColunaOcupadaException {

        int retorno;

        retorno = tabuleiro.preencher(x, getJogadorDaVez());

        System.out.println(getStringTabuleiro());

        verificarVencedor(retorno, x); //retorno é a posição y que o método preencher retornou

        trocaJogador();

        return retorno;
    }

    public String getStringTabuleiro(){
        return tabuleiro.toString();
    }

    public boolean isFim() {
        return fim;
    }


    public void verificarVencedor(int y, int x){

        if(tabuleiro.verificarEmpate()){
            fim = true;
        }

        if(tabuleiro.verificarVertical() == 1 || tabuleiro.verificarHorizontal() == 1) {
            System.out.println("     VITÓRIA DO JOGADOR 1");
            vencedor = true;
        }
        else if (tabuleiro.verificarVertical() == 2 || tabuleiro.verificarHorizontal() == 2) {
            System.out.println("     VITÓRIA DO JOGADOR 2");
            vencedor = true;
        }

        if(tabuleiro.verificarDiagonal(y, x) == 1) {
            System.out.println("     VITÓRIA DO JOGADOR 1");
            vencedor = true;
        }
        else if (tabuleiro.verificarDiagonal(y, x) == 2) {
            System.out.println("     VITÓRIA DO JOGADOR 2");
            vencedor = true;
        }



    }

    public void fim(){
        System.exit(0);
    }

    public void trocaJogador(){
        if(this.jogadorDaVez == jogadorUm.getValor()) {
            this.jogadorDaVez = jogadorDois.getValor();
        }
        else {
            this.jogadorDaVez = jogadorUm.getValor();
        }
    }

    public boolean getVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }

    public Jogador getJogadorUm() {
        return jogadorUm;
    }

    public void setJogadorUm(Jogador jogadorUm) {
        this.jogadorUm = jogadorUm;
    }

    public Jogador getJogadorDois() {
        return jogadorDois;
    }

    public void setJogadorDois(Jogador jogadorDois) {
        this.jogadorDois = jogadorDois;
    }

}