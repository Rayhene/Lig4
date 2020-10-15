/**
 *  Projeto de LPOO - Lig4 (Parte II)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Partida {

		Jogador jogadorUm;
		Jogador jogadorDois;
		
		private boolean fim;
		private boolean vencedor;
		private int jogadorDaVez;
		
		Tabuleiro tabuleiro;

	public Partida(String nomeJogadorUm, String nomeJogadorDois) {
		this.jogadorUm = new Jogador(nomeJogadorUm, 1);
		this.jogadorDois = new Jogador(nomeJogadorDois, 2);
		this.fim = false;
		this.jogadorDaVez = jogadorUm.getValor();
		this.tabuleiro = new Tabuleiro();
	}

	public int getJogadorDaVez() {
		if(jogadorDaVez == 1){
			System.out.println();
		}
		return jogadorDaVez;
	}

	public void fazerJogada(int x){

			if(!(tabuleiro.preencher(x, jogadorDaVez)))
				return;

			System.out.println("O jogador " +jogadorDaVez+ " fez a jogada " +x);
			System.out.println(getStringTabuleiro());
			trocaJogador();

		}

	public String getStringTabuleiro(){
		return tabuleiro.toString();
	}

	public void trocaJogador(){
		if(jogadorDaVez == jogadorUm.getValor()) {
			jogadorDaVez = jogadorDois.getValor();
		}
		else {
			jogadorDaVez = jogadorUm.getValor();
		}
	}

}
