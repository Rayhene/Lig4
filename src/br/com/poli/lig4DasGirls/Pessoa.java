package br.com.poli.lig4DasGirls;
/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Pessoa {

	private String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}
		
	@Override
	public String toString() {
		return "Nome do jogador é: " + this.nome;
	}
	
	  public String getNome() {
	        return this.nome;
	    }

	    public void setName(String nome) {
	        this.nome = nome;
	    }

}