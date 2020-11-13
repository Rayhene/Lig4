package br.com.poli.lig4;

/**
 *  Projeto de LPOO - Lig4 (Parte II)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Jogador extends Pessoa {


	private int valor;
	
	public Jogador(String nome, int valor) {
		super(nome);
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	 public void setValor(int valor) {
	        this.valor = valor;
	    }
	
	@Override
	public String toString() {
		return "(" + this.valor + ") " + super.toString() ;
	}


}