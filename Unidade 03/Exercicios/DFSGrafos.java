import java.util.*;

public class DFSGrafos {
    // Representação do grafo usando um Map de listas adjacentes
    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    // Adiciona uma aresta entre dois vértices
    public void adicionarAresta(int origem, int destino) {
        grafo.putIfAbsent(origem, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origem).add(destino);
    }

    // Realiza a DFS a partir de um vértice inicial
    public void dfs(int verticeInicial) {
        Set<Integer> visitados = new HashSet<>();
        dfsRecursivo(verticeInicial, visitados);
    }

    // Função auxiliar recursiva para a DFS
    private void dfsRecursivo(int vertice, Set<Integer> visitados) {
        // Marca o vértice atual como visitado
        visitados.add(vertice);
        System.out.print(vertice + " "); // Exibe o vértice visitado

        // Explora todos os vizinhos do vértice atual
        for (int vizinho : grafo.getOrDefault(vertice, new ArrayList<>())) {
            if (!visitados.contains(vizinho)) {
                dfsRecursivo(vizinho, visitados);
            }
        }
    }

    public static void main(String[] args) {
        DFSGrafos grafo = new DFSGrafos();

        // Exemplo de construção do grafo
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 3);

        // Realiza a DFS a partir do vértice 2
        System.out.println("Vértices visitados na DFS a partir do vértice 2:");
        grafo.dfs(2);
    }
}