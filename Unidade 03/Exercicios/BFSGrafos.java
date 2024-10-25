import java.util.*;

public class BFSGrafos {

    // Classe para representar um grafo
    static class Grafo {
        private int V; // Número de vértices
        private LinkedList<Integer>[] adj; // Lista de adjacências

        // Construtor do grafo
        public Grafo(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        // Método para adicionar uma aresta ao grafo
        public void adicionarAresta(int v, int w) {
            adj[v].add(w);
            adj[w].add(v); // Como o grafo é não direcionado
        }

        // Método BFS para encontrar o caminho mais curto entre dois nós
        public List<Integer> BFS(int origem, int destino) {
            boolean[] visitado = new boolean[V];
            int[] anterior = new int[V]; // Para armazenar o caminho

            LinkedList<Integer> fila = new LinkedList<>();
            visitado[origem] = true;
            fila.add(origem);

            // Inicializar o array anterior com -1 para identificar o início do caminho
            Arrays.fill(anterior, -1);

            while (!fila.isEmpty()) {
                int noAtual = fila.poll();

                if (noAtual == destino) {
                    return reconstruirCaminho(anterior, origem, destino);
                }

                for (int vizinho : adj[noAtual]) {
                    if (!visitado[vizinho]) {
                        visitado[vizinho] = true;
                        anterior[vizinho] = noAtual;
                        fila.add(vizinho);
                    }
                }
            }

            // Se não houver caminho entre origem e destino, retornar lista vazia
            return new ArrayList<>();
        }

        // Método para reconstruir o caminho a partir do array anterior
        private List<Integer> reconstruirCaminho(int[] anterior, int origem, int destino) {
            LinkedList<Integer> caminho = new LinkedList<>();
            for (int no = destino; no != -1; no = anterior[no]) {
                caminho.addFirst(no);
            }

            // Verificar se o caminho começa na origem
            if (caminho.getFirst() != origem) {
                return new ArrayList<>(); // Não há caminho
            }

            return caminho;
        }
    }

    // Exemplo de uso do algoritmo BFS
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        // Adicionar arestas
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 5);

        // Definir origem e destino
        int origem = 0;
        int destino = 5;

        // Encontrar o caminho mais curto usando BFS
        List<Integer> caminho = grafo.BFS(origem, destino);

        if (!caminho.isEmpty()) {
            System.out.println("Caminho mais curto de " + origem + " até " + destino + ": " + caminho);
        } else {
            System.out.println("Não há caminho entre " + origem + " e " + destino);
        }
    }
}