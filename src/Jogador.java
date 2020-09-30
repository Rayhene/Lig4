public class Jogador extends Pessoa {

	
	public Jogador(String nome) {
		super(nome);
	}
	
	public int numero;
	
	@Override
	public String toString() {
		return "(" + numero + ") " + super.toString() ;
	}
	

}
