
public class Tabuleiro {

	int x = 6, y = 7;
	int tab[][] = new int[x][y];
	
	public Tabuleiro() {
		for (int linha = 0; linha < x; linha++) {
			for (int coluna = 0; coluna < y; coluna++) {
				tab[linha][coluna] = 0;
			}
		}
	}
	
	public void preencher(int posicaoX, int numero) {
		
		int linhaAux = 0;
		
		while (linhaAux < x && tab[linhaAux][posicaoX] == 0) {
			linhaAux ++;
		}
		
		if (linhaAux != 0 ) {
		 tab [linhaAux -1][posicaoX] = numero;
		}
		else {
			System.out.println("A coluna" +posicaoX+ "já está preenchida");
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
	public String toString() {
		String str = " (0) (1) (2) (3) (4) (5) (6) \n";
		for (int linha = 0; linha < x; linha++) {
			str += "|---.---.---.---.---.---.---|\n";
			for (int coluna = 0; coluna < y; coluna++) {
				if(tab[linha][coluna] == 0) {
					str += "|   "; // sao 3 espaçcos
				}
				else {
					str += "| " +tab[linha][coluna]+ " "; //perguntar pq n entra no else
				}
			}
			str += "|\n";
		}
		str += "|===.===.===.===.===.===.===|";
		return str;
	}
}
