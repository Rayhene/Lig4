
public class Pessoa {

	String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}
		
	@Override
	public String toString() {
		return "O nome do jogador é: " + nome;
	}

}
