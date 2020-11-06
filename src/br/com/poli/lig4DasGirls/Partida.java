package br.com.poli.lig4DasGirls;

import br.com.poli.exceptions.colunaOcupadaException;
import br.com.poli.exceptions.posicaoInvalidaException;

import java.util.Scanner;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Partida {

	Jogador jogadorUm;
	Jogador jogadorDois;
	private boolean fim; //precisa disso?
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
		if (jogadorDaVez == 1) {
			System.out.println();
		}
		return this.jogadorDaVez;
	}

	public int fazerJogada(int x) throws colunaOcupadaException {

		int retorno;

		int tmpJogador = getJogadorDaVez();


		retorno = tabuleiro.preencher(x, getJogadorDaVez());


		System.out.println(getStringTabuleiro());

		this.verificarVencedor(retorno, x); //retorno é a posição y que o método preencher retornou

		this.trocaJogador();

		return tmpJogador;
	}

	public String getStringTabuleiro(){
		return tabuleiro.toString();
	}

	public void verificarVencedor(int y, int x){
		tabuleiro.verificarEmpate();

		if(tabuleiro.verificarVertical() == 1 || tabuleiro.verificarHorizontal() == 1) {
			System.out.println("     VITÓRIA DO JOGADOR 1 - " + jogadorUm.getNome());
			vencedor = true;
		}
		else if (tabuleiro.verificarVertical() == 2 || tabuleiro.verificarHorizontal() == 2) {
			System.out.println("     VITÓRIA DO JOGADOR 2 - " + jogadorDois.getNome());
			vencedor = true;
		}

		if(tabuleiro.verificarDiagonal(y, x) == 1) {
			System.out.println("     VITÓRIA DO JOGADOR 1 - " + jogadorUm.getNome());
			vencedor = true;
		}
		else if (tabuleiro.verificarDiagonal(y, x) == 2) {
			System.out.println("     VITÓRIA DO JOGADOR 2 - " + jogadorDois.getNome());
			vencedor = true;
		}

		if(vencedor){
			fim();
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

	public void inputJogada() throws posicaoInvalidaException, colunaOcupadaException {
		Scanner input = new Scanner(System.in);
		int posicao = input.nextInt();

		if(posicao < 0 || posicao > 6){
			int jogadorAtual =  fazerJogada(posicao);
		}else{
			posicaoInvalidaException e = new posicaoInvalidaException();
			throw e;
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