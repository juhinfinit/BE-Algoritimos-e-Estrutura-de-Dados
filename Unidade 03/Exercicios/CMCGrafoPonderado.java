import java.util.*;

class CMCGrafoPonderado {

    // Classe para representar uma aresta no grafo
    static class Edge {
        int targetNode;
        int weight;

        Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }

    // Classe para representar um nó e a distância até ele
    static class NodeDistance implements Comparable<NodeDistance> {
        int node;
        int distance;

        NodeDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        // Implementação da comparação para ordenar os nós pela menor distância
        @Override
        public int compareTo(NodeDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Função que implementa o algoritmo de Dijkstra
    public static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end) {
        // Inicializando distâncias com um valor infinito
        Map<Integer, Integer> distances = new HashMap<>();
        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0); // A distância até o nó inicial é 0

        // Fila de prioridade para escolher o nó com a menor distância
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>();
        pq.add(new NodeDistance(start, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            int currentNode = current.node;

            // Se chegamos ao nó de destino, retornamos a distância
            if (currentNode == end) {
                return current.distance;
            }

            // Verifica todas as arestas do nó atual
            for (Edge edge : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int newDist = current.distance + edge.weight;
                
                // Se uma distância menor for encontrada, atualizamos e adicionamos à fila
                if (newDist < distances.get(edge.targetNode)) {
                    distances.put(edge.targetNode, newDist);
                    pq.add(new NodeDistance(edge.targetNode, newDist));
                }
            }
        }
        // Se não houver caminho, retornamos -1
        return -1;
    }

    public static void main(String[] args) {
        // Exemplo de grafo com 5 nós
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // Adiciona as arestas (nós conectados e seus pesos)
        graph.put(0, Arrays.asList(new Edge(1, 10), new Edge(2, 3)));
        graph.put(1, Arrays.asList(new Edge(2, 1), new Edge(3, 2)));
        graph.put(2, Arrays.asList(new Edge(1, 4), new Edge(3, 8), new Edge(4, 2)));
        graph.put(3, Arrays.asList(new Edge(4, 7)));
        graph.put(4, Arrays.asList(new Edge(3, 9)));

        // Encontrar o caminho mais curto de 0 a 3
        int start = 0;
        int end = 3;
        int shortestPath = dijkstra(graph, start, end);

        if (shortestPath != -1) {
            System.out.println("O caminho mais curto de " + start + " para " + end + " tem comprimento: " + shortestPath);
        } else {
            System.out.println("Não existe caminho entre " + start + " e " + end);
        }
    }
}