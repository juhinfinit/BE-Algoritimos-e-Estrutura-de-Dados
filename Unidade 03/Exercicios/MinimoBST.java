// Classe que define a estrutura de um nó na árvore binária de busca (BST)
class Node {
    int valor;
    Node esquerda, direita;

    // Construtor do nó
    public Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

// Classe que contém o método para encontrar o mínimo em uma BST
public class MinimoBST {
    Node raiz;

    // Construtor que inicializa a raiz como nula
    public MinimoBST() {
        raiz = null;
    }

    // Método para inserir um novo valor na BST
    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Método auxiliar para inserir recursivamente na árvore
    Node inserirRecursivo(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = inserirRecursivo(raiz.direita, valor);

        return raiz;
    }

    // Método para encontrar o menor valor na BST
    int encontrarMinimo() {
        if (raiz == null) {
            throw new RuntimeException("A árvore está vazia.");
        }
        Node atual = raiz;

        // Percorre até o nó mais à esquerda
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual.valor;
    }

    public static void main(String[] args) {
        MinimoBST arvore = new MinimoBST();

        // Inserindo valores na árvore
        arvore.inserir(20);
        arvore.inserir(10);
        arvore.inserir(30);
        arvore.inserir(5);
        arvore.inserir(15);

        // Encontrar o valor mínimo na árvore
        System.out.println("O menor valor na árvore é: " + arvore.encontrarMinimo());
    }
}
