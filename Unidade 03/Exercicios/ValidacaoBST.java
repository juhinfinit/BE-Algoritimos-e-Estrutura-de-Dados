// Definição da classe TreeNode (nó da árvore)
class TreeNode {
    int valor;
    TreeNode esquerda;
    TreeNode direita;

    TreeNode(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

public class ValidacaoBST {

    // Método para verificar se a árvore é uma BST
    public static boolean ehBST(TreeNode raiz) {
        return validarBST(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Método auxiliar que verifica a propriedade do BST
    private static boolean validarBST(TreeNode no, int min, int max) {
        // Caso base: árvore vazia é uma BST
        if (no == null) {
            return true;
        }

        // Verifica se o valor do nó atual está fora dos limites permitidos
        if (no.valor <= min || no.valor >= max) {
            return false;
        }

        // Recursivamente verifica a subárvore esquerda e direita
        return validarBST(no.esquerda, min, no.valor) && validarBST(no.direita, no.valor, max);
    }

    // Método principal para testar o código
    public static void main(String[] args) {
        // Criando uma árvore de exemplo
        TreeNode raiz = new TreeNode(10);
        raiz.esquerda = new TreeNode(5);
        raiz.direita = new TreeNode(15);
        raiz.esquerda.esquerda = new TreeNode(2);
        raiz.esquerda.direita = new TreeNode(7);
        raiz.direita.direita = new TreeNode(17);

        // Verificando se a árvore é uma BST
        if (ehBST(raiz)) {
            System.out.println("A árvore é uma BST válida.");
        } else {
            System.out.println("A árvore não é uma BST.");
        }
    }
}
