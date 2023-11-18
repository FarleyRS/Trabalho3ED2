package Model;

import java.util.ArrayList;
import java.util.List;

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

	public int[][] matrizAdjacente() {
		this.size = cidades.size();
		int matrix[][] = new int[this.size][this.size];

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				Aresta aresta = getArestaEntreCidades(cidades.get(i), cidades.get(j));
				if (aresta != null) {
					matrix[i][j] = (int) aresta.getPeso();
				} else {
					matrix[i][j] = 0;
				}
			}
		}

		// Imprimir a matriz com os nomes das cidades
		System.out.print("  ");
		for (int i = 0; i < this.size; i++) {
			System.out.print(cidades.get(i).getNome() + "  ");
		}
		System.out.println();
		for (int i = 0; i < this.size; i++) {
			System.out.print(cidades.get(i).getNome() + " ");
			for (int j = 0; j < this.size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		return matrix;
	}

	private Aresta getArestaEntreCidades(Cidade cidade1, Cidade cidade2) {
		for (Aresta aresta : cidade1.getAresta()) {
			if (aresta.getFim().equals(cidade2)) {
				return aresta;
			}
		}
		return null;
	}

	/*
	 * public void dijkstra(String cidade1, String cidade2) { int matrix[][] =
	 * matrizAdjacente();
	 * 
	 * List<Boolean> visitada = new ArrayList<>(); int m = Integer.MAX_VALUE,
	 * m_index = 0; Boolean spSet[] = new Boolean[this.size];
	 * 
	 * int distancia[] = new int[this.size];
	 * 
	 * for (int j = 0; j < this.size; j++) { distancia[j] = Integer.MAX_VALUE;
	 * spSet[j] = false; }
	 * 
	 * for (int vx = 0; vx < this.size; vx++) { if (spSet[vx] == false &&
	 * distancia[vx] <= m) { m = distancia[vx]; m_index = vx; } }
	 * 
	 * int i = 0; while (i < this.size) { if
	 * (cidades.get(i).getNome().equals(cidade1)) { distancia[i] = 0; } i++; }
	 * 
	 * for (int cnt = 0; cnt < this.size; cnt++) { spSet[m_index] = true; for (int
	 * vx = 0; vx < this.size; vx++) { if (!spSet[vx] && matrix[m_index][vx] != 0 &&
	 * distancia[m_index] != Integer.MAX_VALUE && distancia[m_index] +
	 * matrix[m_index][vx] < distancia[vx]) {
	 * 
	 * } } }
	 * 
	 * // Imprimir a menor distância até a cidade2 for (int vx = 0; vx < this.size;
	 * vx++) { if (cidades.get(vx).getNome().equals(cidade2)) {
	 * System.out.println("A menor distância de " + cidade1 + " para " + cidade2 +
	 * " é " + distancia[vx]); } } }
	 */
	public void dijkstra(String cidade1, String cidade2) {
		int matrix[][] = matrizAdjacente();

		int m = Integer.MAX_VALUE, m_index = 0;
		Boolean spSet[] = new Boolean[this.size];

		int distancia[] = new int[this.size];

		for (int j = 0; j < this.size; j++) {
			distancia[j] = Integer.MAX_VALUE;
			spSet[j] = false;
		}

		for (int vx = 0; vx < this.size; vx++) {
			if (spSet[vx] == false && distancia[vx] <= m) {
				m = distancia[vx];
				m_index = vx;
			}
		}

		int i = 0;
		while (i < this.size) {
			if (cidades.get(i).getNome().equals(cidade1)) {
				distancia[i] = 0;
			}
			i++;
		}

		for (int cnt = 0; cnt < this.size; cnt++) {
			spSet[m_index] = true;
			for (int vx = 0; vx < this.size; vx++) {
				if (!spSet[vx] && matrix[m_index][vx] != 0 && distancia[m_index] != Integer.MAX_VALUE
						&& distancia[m_index] + matrix[m_index][vx] < distancia[vx]) {
					distancia[vx] = distancia[m_index] + matrix[m_index][vx];
				}
			}
			m = Integer.MAX_VALUE;
			for (int vx = 0; vx < this.size; vx++) {
				if (spSet[vx] == false && distancia[vx] <= m) {
					m = distancia[vx];
					m_index = vx;
				}
			}
		}

		// Imprimir a menor distância até a cidade2
		for (int vx = 0; vx < this.size; vx++) {
			if (cidades.get(vx).getNome().equals(cidade2)) {
				System.out.println("A menor distância de " + cidade1 + " para " + cidade2 + " é " + distancia[vx]);
			}
		}
	}

}
