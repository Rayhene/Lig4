
public class Tabuleiro {


	int x = 6, y = 7;
	int tab[][] = new int[x][y];
	
	public Tabuleiro() { //no construtor preenchemos todo o tabuleiro 6x7 com "0" em cada "casa"
		for (int linha = 0; linha < x; linha++) {
			for (int coluna = 0; coluna < y; coluna++) {
				tab[linha][coluna] = 0;
			}
		}
	}
	
	public void preencher(int posicaoX, int valor) { //esse método encontra uma posição vazia
		
		int linhaAux = 0; // a linha Auxiliar é para "escanear" a linha após a linha atual
		
		while (linhaAux < x && tab[linhaAux][posicaoX] == 0) { //o while é utilizado para incrementar a linha auxilixar que verifica se a próxima linha está vazia ou não
			linhaAux ++;
		}
		
		if (linhaAux != 0 ) { //se a próxima linha estiver vazia entao, um numero é printado nela, 1 ou 2 dependendo do valor jogador da vez
		 tab [linhaAux -1][posicaoX] = valor;
		}
		else {
			System.out.println("A coluna " +posicaoX+ " já está preenchida"); //essa mensagem é printada caso a coluna escolhida ja esteja cheia e nao hajam posições disponiveis
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
	
	
	/*public int verificarVencedor() {
		
		int j1=0, j2=0;
		
		//verficando as linhas
		for(int linha = 0; linha < x ; linha++) {
			 j1=0;
			 j2=0;
			for(int coluna = 0; coluna < y ; coluna++) {
				if( tab[linha][coluna] == 1) {
					j1++;
					j2 = 0;
					
				}
				else if(tab[linha][coluna] == 2){
					j2++;
					j1 = 0;
				}
				else {
					j1 = 0;
					j2 = 0;
				}
			}
			if(j1 >= 4) {
				return 1;
			}
			else if (j2 >= 4) {
				return 2;
			}
		}
		//verificando as colunas
		for(int coluna = 0; coluna < y ; coluna++) {
			 j1=0;
			 j2=0;
			for(int linha = 0; linha < x ; linha++) {
				if( tab[linha][coluna] == 1) {
					j1++;
					j2 = 0;
					
				}
				else if(tab[linha][coluna] == 2){
					j2++;
					j1 = 0;
				}
				else {
					j1 = 0;
					j2 = 0;
				}
			}
			if(j1 >= 4) {
				return 1;
			}
			else if (j2 >= 4) {
				return 2;
			}
		}
		return 0;
	}*/
		
	/*public boolean existePosicaoDisponivel() {
		
		//verficando as linhas e colunas
		for(int linha = 0; linha < x ; linha++) {

			for(int coluna = 0; coluna < y ; coluna++) {
				if( tab[linha][coluna] == 0) {
					return true;
				}
			}
		}
		
		return false;
	}	*/	
}
