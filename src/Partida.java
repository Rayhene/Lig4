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


		public void fazerJogada(int x){
					
			System.out.println("O jogador " +jogadorDaVez+ " fez a jogada " +x);


			tabuleiro.preencher(x, jogadorDaVez);

			if(jogadorDaVez == jogadorUm.getValor()) {
				jogadorDaVez = jogadorDois.getValor();
			}
			else {
				jogadorDaVez = jogadorUm.getValor();
			}
			
			System.out.println(tabuleiro.toString());
			
		}


}
