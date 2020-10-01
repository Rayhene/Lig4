
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
	
	public void preencher(int posicaoX, int numero) { //esse método encontra uma posição vazia
		
		int linhaAux = 0; // a linha Auxiliar é para "escanear" a linha após a linha atual
		
		while (linhaAux < x && tab[linhaAux][posicaoX] == 0) { //o while é utilizado para incrementar a linha auxilixar que verifica se a próxima linha está vazia ou não
			linhaAux ++;
		}
		
		if (linhaAux != 0 ) { //se a próxima linha estiver vazia entao, um numero é printado nela, 1 ou 2 dependendo do jogador da vez
		 tab [linhaAux -1][posicaoX] = numero;
		}
		else {
			System.out.println("A coluna" +posicaoX+ "já está preenchida"); //essa mensagem é printada caso a coluna escolhida ja esteja cheia e nao hajam posições disponiveis
		}
	}
	
	
	
	public static void main(String[] args)  {
		
		Tabuleiro t = new Tabuleiro();
		System.out.println(t.toString());

		t.preencher(3, 1);
		System.out.println(t.toString());
		t.preencher(2, 2);
		System.out.println(t.toString());
		t.preencher(3, 1);
		System.out.println(t.toString());
		t.preencher(3, 2);
		System.out.println(t.toString());
			
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
		str += "|===.===.===.===.===.===.===|"; //linha fixa
		return str;
	}
}