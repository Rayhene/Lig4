
public class Pessoa {

	private final String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}
		
	@Override
	public String toString() {
		return "Nome do jogador é: " + nome;
	}

}
