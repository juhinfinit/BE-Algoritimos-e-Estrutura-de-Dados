import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RepresentacaoGrafos {

    // Lista de adjacência
    private List<List<Integer>> listaAdjacencia;
    private int numVertices;

    // Construtor para inicializar o grafo
    public RepresentacaoGrafos(int numVertices) {
        this.numVertices = numVertices;
        listaAdjacencia = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            listaAdjacencia.add(new LinkedList<>());
        }
    }

    // Adiciona uma aresta no grafo
    public void adicionarAresta(int origem, int destino) {
        listaAdjacencia.get(origem).add(destino);
        listaAdjacencia.get(destino).add(origem); // Para grafo não-direcionado
    }

    // Exibe o grafo como lista de adjacências
    public void mostrarListaAdjacencia() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            for (Integer vertice : listaAdjacencia.get(i)) {
                System.out.print(vertice + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RepresentacaoGrafos grafo = new RepresentacaoGrafos(5);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 4);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);

        grafo.mostrarListaAdjacencia();
    }
}
