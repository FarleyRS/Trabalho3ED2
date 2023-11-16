package Model;

import java.util.ArrayList;

public class Cidade {

	private String nome;
	private ArrayList<Aresta> aresta;

	public Cidade(String nome) {
		this.nome = nome;
		this.aresta = new ArrayList<Aresta>();
	}

	public void addAresta(Cidade cidade, double peso) {
		this.aresta.add(new Aresta(this, cidade, peso));
	}
	
	public void removerAresta(Cidade cidade) {
		this.aresta.removeIf(aresta -> aresta.getFim().equals(cidade));
	}
	
	public ArrayList<Aresta> getAresta(){
		return this.aresta;
	}

	public String getNome() {
		return nome;
	}
	
}
