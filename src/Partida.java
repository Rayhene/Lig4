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

			boolean jogada; //variável para armazenar o retorno de preencher, true se o jogador fez a jogada e false se não fez ainda

			jogada = tabuleiro.preencher(x, jogadorDaVez);

			if(jogada){
				System.out.println("O jogador " +jogadorDaVez+ " fez a jogada " +x);
			}else{
				controleJogador(); // troca de jogador pra ele não perder a vez quando tentar jogar em uma posição já preenchida  
			}

			controleJogador(); //troca o jogador da vez
			
			System.out.println(tabuleiro.toString());
		}


		public void controleJogador(){
			if(jogadorDaVez == jogadorUm.getValor()) {
				jogadorDaVez = jogadorDois.getValor();
			}
			else {
				jogadorDaVez = jogadorUm.getValor();
			}
		}


}
