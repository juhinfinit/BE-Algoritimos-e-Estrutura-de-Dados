import java.util.*;

// Classe para representar o grafo
class Grafo {
    private int numVertices; // Número de vértices
    private LinkedList<Integer>[] listaAdj; // Lista de adjacências
    
    // Construtor do grafo
    Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdj = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }
    
    // Adicionar uma aresta ao grafo
    void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
    }
    
    // Método auxiliar usado pela ordenação topológica
    private void ordenacaoTopologicaAux(int vertice, boolean[] visitado, Stack<Integer> pilha) {
        // Marca o vértice atual como visitado
        visitado[vertice] = true;
        
        // Recursivamente visitar todos os vértices adjacentes
        for (int adj : listaAdj[vertice]) {
            if (!visitado[adj]) {
                ordenacaoTopologicaAux(adj, visitado, pilha);
            }
        }
        
        // Após visitar todos os vizinhos, empilha o vértice
        pilha.push(vertice);
    }
    
    // Função principal para realizar a ordenação topológica
    void ordenacaoTopologica() {
        Stack<Integer> pilha = new Stack<>();
        boolean[] visitado = new boolean[numVertices];
        
        // Chama a função auxiliar para cada vértice que ainda não foi visitado
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                ordenacaoTopologicaAux(i, visitado, pilha);
            }
        }
        
        // Imprime a ordenação topológica
        System.out.println("Ordenação Topológica:");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
    }
}

public class OrdenacaoGrafos {
    public static void main(String[] args) {
        // Criar um grafo de exemplo com 6 vértices
        Grafo grafo = new Grafo(6);
        
        // Adicionar arestas ao grafo (direcionadas)
        grafo.adicionarAresta(5, 2);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(4, 1);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);
        
        // Executar a ordenação topológica
        grafo.ordenacaoTopologica();
    }
}