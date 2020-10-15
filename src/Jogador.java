/**
 *  Projeto de LPOO - Lig4 (Parte II)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Jogador extends Pessoa {


	private final int valor;
	
	public Jogador(String nome, int valor) {
		super(nome);
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "(" + valor + ") " + super.toString() ;
	}


}
