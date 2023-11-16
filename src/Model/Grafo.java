package Model;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Cidade> cidades;
	private int size = 0;

	public Grafo() {
		this.cidades = new ArrayList<Cidade>();
	}

	public Cidade addCidade(String nome) {

		Cidade cidade = new Cidade(nome);
		this.cidades.add(cidade);

		return cidade;
	}

	public void addAresta(Cidade cidade1, Cidade cidade2, double peso) {
		cidade1.addAresta(cidade2, peso);
		cidade2.addAresta(cidade1, peso);
	}

	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public void matrizAdjacente() {
		this.size = cidades.size();
		String matrix[][] = new String[this.size][this.size];

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				Aresta aresta = getArestaEntreCidades(cidades.get(i), cidades.get(j));
				if (aresta != null) {
					matrix[i][j] = String.valueOf(aresta.getPeso());
				} else {
					matrix[i][j] = " ##";
				}
			}
		}

		// Imprimir a matriz com os nomes das cidades
		System.out.print("  ");
		for (int i = 0; i < this.size; i++) {
			System.out.print(" " + cidades.get(i).getNome() + "  ");
		}
		System.out.println();
		for (int i = 0; i < this.size; i++) {
			System.out.print(cidades.get(i).getNome() + " ");
			for (int j = 0; j < this.size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private Aresta getArestaEntreCidades(Cidade cidade1, Cidade cidade2) {
		for (Aresta aresta : cidade1.getAresta()) {
			if (aresta.getFim().equals(cidade2)) {
				return aresta;
			}
		}
		return null;
	}

	public void getDistancia(String cidade1, String cidade2) {
	int i=0;
	
			for (Cidade cidade : cidades) {
				if (cidade.getNome().equals(cidade1) || cidade.getAresta().get(i++).equals(cidade2)) {
					System.out.println(" - ");
			
				}
			

		}

		// System.out.println(getArestaEntreCidades(null, null));
	}

}
