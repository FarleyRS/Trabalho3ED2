package Model;

public class Aresta {

	private Cidade inicio;
	private Cidade fim;
	private double peso;

	public Aresta(Cidade inicio, Cidade fim, double peso) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.peso = peso;
	}

	public Cidade getInicio() {
		return inicio;
	}

	public Cidade getFim() {
		return fim;
	}

	public double getPeso() {
		return peso;
	}

}
