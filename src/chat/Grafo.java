package chat;

import java.util.*;

import java.util.*;

public class Grafo {
	private Map<String, Map<String, Integer>> nodes = new HashMap<>();

	public void addNode(String node) {
		nodes.put(node, new HashMap<>());
	}

	public void addEdge(String node1, String node2, int weight) {
		nodes.get(node1).put(node2, weight);
		nodes.get(node2).put(node1, weight);
	}

	public int[][] buildAdjacencyMatrix() {
		int size = nodes.size();
		int[][] adjacencyMatrix = new int[size][size];
		List<String> nodeList = new ArrayList<>(nodes.keySet());

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				String node1 = nodeList.get(i);
				String node2 = nodeList.get(j);
				adjacencyMatrix[i][j] = nodes.get(node1).getOrDefault(node2, 0);
			}
		}

		return adjacencyMatrix;
	}

	public String dijkstra(String startNode, String endNode) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> previousNodes = new HashMap<>();
		PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
		Set<String> visited = new HashSet<>();

		for (String node : nodes.keySet()) {
			distances.put(node, node.equals(startNode) ? 0 : Integer.MAX_VALUE);
		}

		queue.add(startNode);

		while (!queue.isEmpty()) {
			String currentNode = queue.poll();
			visited.add(currentNode);

			for (Map.Entry<String, Integer> entry : nodes.get(currentNode).entrySet()) {
				String neighbor = entry.getKey();
				int weight = entry.getValue();

				if (!visited.contains(neighbor)) {
					int oldDistance = distances.get(neighbor);
					int newDistance = distances.get(currentNode) + weight;

					if (newDistance < oldDistance) {
						distances.put(neighbor, newDistance);
						previousNodes.put(neighbor, currentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		List<String> path = new ArrayList<>();
		String currentNode = endNode;

		while (currentNode != null && !currentNode.equals(startNode)) {
			path.add(currentNode);
			currentNode = previousNodes.get(currentNode);
		}

		if (currentNode == null) {
			return "No path found";
		} else {
			path.add(startNode);
			Collections.reverse(path);
			return String.join(" -> ", path);
		}
	}
}