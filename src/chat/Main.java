package chat;


public class Main {

	  public static void main(String[] args) {
	        Grafo graph = new Grafo();
	        graph.addNode("A");
	        graph.addNode("B");
	        graph.addNode("C");
	        graph.addEdge("A", "B", 1);
	        graph.addEdge("B", "C", 2);
	     

	        System.out.println(graph.dijkstra("A", "C"));  // A -> B -> C
	    }

}
