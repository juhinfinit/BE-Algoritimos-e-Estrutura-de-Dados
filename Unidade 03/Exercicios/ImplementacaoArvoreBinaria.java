class Nodo {
    int valor;
    Nodo esquerdo, direito;

    public Nodo(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class ImplementacaoArvoreBinaria {
    Nodo raiz;

    // Construtor
    public ImplementacaoArvoreBinaria() {
        raiz = null;
    }

    // Método para inserir elementos na árvore
    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Função recursiva para inserir um novo nó na árvore
    Nodo inserirRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        else if (valor > raiz.valor)
            raiz.direito = inserirRecursivo(raiz.direito, valor);

        return raiz;
    }

    // Percurso em pré-ordem (raiz, esquerda, direita)
    void preOrdem() {
        preOrdemRecursivo(raiz);
    }

    void preOrdemRecursivo(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRecursivo(raiz.esquerdo);
            preOrdemRecursivo(raiz.direito);
        }
    }

    // Percurso em ordem (esquerda, raiz, direita)
    void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    void emOrdemRecursivo(Nodo raiz) {
        if (raiz != null) {
            emOrdemRecursivo(raiz.esquerdo);
            System.out.print(raiz.valor + " ");
            emOrdemRecursivo(raiz.direito);
        }
    }

    // Percurso em pós-ordem (esquerda, direita, raiz)
    void posOrdem() {
        posOrdemRecursivo(raiz);
    }

    void posOrdemRecursivo(Nodo raiz) {
        if (raiz != null) {
            posOrdemRecursivo(raiz.esquerdo);
            posOrdemRecursivo(raiz.direito);
            System.out.print(raiz.valor + " ");
        }
    }

    // Programa principal para testar a implementação
    public static void main(String[] args) {
        ImplementacaoArvoreBinaria arvore = new ImplementacaoArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Percurso em pré-ordem:");
        arvore.preOrdem();

        System.out.println("\n\nPercurso em ordem:");
        arvore.emOrdem();

        System.out.println("\n\nPercurso em pós-ordem:");
        arvore.posOrdem();
    }
}
