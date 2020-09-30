public class Partida {

		Jogador jogadorUm;
		Jogador jogadorDois;
		
		boolean fim;
		boolean vencedor;
		int jogadorDaVez;
		
		Tabuleiro tabuleiro;

		public Partida(Jogador jogadorUm, Jogador jogadorDois) {
			this.jogadorUm = jogadorUm;
			this.jogadorDois = jogadorDois;
			this.fim = false;
			this.jogadorDaVez = 1;
			this.tabuleiro = new Tabuleiro();
		}



		public void fazerJogada(int x){
					
			System.out.println("O jogador " +jogadorDaVez+ " fez a jogada " +x);
			
			if(jogadorDaVez == 1) {
				jogadorDaVez = 2;
			}
			else {
				jogadorDaVez = 1;
			}
			
			System.out.println(tabuleiro.toString());
			
		}
		
}
