import java.util.ArrayList;
import java.util.Collections;

public class ImplementacaoOrdenacao {
    
    // Método principal para executar o algoritmo de ordenação
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        
        // Adicionando alguns números ao ArrayList
        Collections.addAll(numeros, 10, 7, 8, 9, 1, 5);
        
        System.out.println("Antes da ordenação: " + numeros);
        
        // Chamando o método de ordenação
        quickSort(numeros, 0, numeros.size() - 1);
        
        System.out.println("Depois da ordenação: " + numeros);
    }

    // Método para realizar o Quick Sort
    public static void quickSort(ArrayList<Integer> lista, int baixo, int alto) {
        if (baixo < alto) {
            int p = particionar(lista, baixo, alto);
            quickSort(lista, baixo, p - 1); // Recursão para a parte esquerda
            quickSort(lista, p + 1, alto);  // Recursão para a parte direita
        }
    }

    // Método de partição para o Quick Sort
    private static int particionar(ArrayList<Integer> lista, int baixo, int alto) {
        int pivô = lista.get(alto); // Escolhendo o pivô como o último elemento
        int i = baixo - 1; // Índice do menor elemento

        for (int j = baixo; j < alto; j++) {
            // Se o elemento atual for maior que o pivô
            if (lista.get(j) > pivô) {
                i++;
                // Troca lista[i] e lista[j]
                Collections.swap(lista, i, j);
            }
        }
        
        // Troca lista[i + 1] e lista[alto] (ou seja, o pivô)
        Collections.swap(lista, i + 1, alto);
        return i + 1; // Retorna o índice do pivô
    }
}
