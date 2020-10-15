/**
 *  Projeto de LPOO - Lig4 (Parte II)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Tabuleiro {


	int x = 6, y = 7;
	int[][] tab = new int[x][y];
	
	public Tabuleiro() { //no construtor preenchemos todo o tabuleiro 6x7 com "0" em cada "casa"
		for (int linha = 0; linha < x; linha++) {
			for (int coluna = 0; coluna < y; coluna++) {
				tab[linha][coluna] = 0;
			}
		}
	}
	
	public boolean preencher(int posicaoX, int valor) { //esse método encontra uma posição vazia
		
		int linhaAux = 0; // a linha Auxiliar é para "escanear" a linha após a linha atual
		
		while (linhaAux < x && tab[linhaAux][posicaoX] == 0) { //o while é utilizado para incrementar a linha auxilixar que verifica se a próxima linha está vazia ou não
			linhaAux ++;
		}

		
		if (linhaAux != 0 ) { //se a próxima linha estiver vazia entao, um numero é printado nela, 1 ou 2 dependendo do valor jogador da vez
		 tab [linhaAux -1][posicaoX] = valor;
		 return true;
		}
		else {
			System.out.println("A coluna " +posicaoX+ " já está preenchida. Jogue novamente."); //essa mensagem é printada caso a coluna escolhida ja esteja cheia e nao hajam posições disponiveis
			return false;
		}
	}
	
	@Override
	public String toString() { //o toString aqui printa o tabuleiro bonitinho
		String str = " (0) (1) (2) (3) (4) (5) (6) \n"; //linha fixa
		for (int linha = 0; linha < x; linha++) {
			str += "|---.---.---.---.---.---.---|\n"; //linhas fixas
			for (int coluna = 0; coluna < y; coluna++) {
				if(tab[linha][coluna] == 0) { //o if é para quando o espaço tiver vazio
					str += "|   "; 
				}
				else {
					str += "| " +tab[linha][coluna]+ " "; //o else é para quando tiver algum número printado (1 ou 2 no caso)
				}
			}
			str += "|\n";
		}
		str += "|===.===.===.===.===.===.===|"; //inha fixa
		return str; //retorna o tabuleiro
	}
	
	
}
