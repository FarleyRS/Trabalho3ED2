package main;

import Model.Grafo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		Grafo grafo = new Grafo();
		
		grafo.addCidade("A");
		grafo.addCidade("B");
		grafo.addCidade("C");
		grafo.addCidade("D");
		
		grafo.addAresta(grafo.getCidades().get(0),grafo.getCidades().get(1), 2);
		grafo.addAresta(grafo.getCidades().get(1),grafo.getCidades().get(2), 4);
		grafo.addAresta(grafo.getCidades().get(2),grafo.getCidades().get(3), 3);
		grafo.addAresta(grafo.getCidades().get(3),grafo.getCidades().get(1), 7);
		
		
		grafo.matrizAdjacente();
		grafo.getDistancia("B", "D");

	}

}
