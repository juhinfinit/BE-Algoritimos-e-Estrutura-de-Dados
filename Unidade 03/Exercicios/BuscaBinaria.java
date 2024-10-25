public class BuscaBinaria {

    // Método para realizar a busca binária
    public static int buscaBinaria(int[] array, int elemento) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            // Verifica se o elemento está no meio
            if (array[meio] == elemento) {
                return meio;
            }

            // Se o elemento for maior, ignorar a metade esquerda
            if (array[meio] < elemento) {
                inicio = meio + 1;
            } 
            // Se o elemento for menor, ignorar a metade direita
            else {
                fim = meio - 1;
            }
        }

        // Retorna -1 se o elemento não for encontrado
        return -1;
    }

    // Método principal para testar a busca binária
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int elemento = 10;

        int resultado = buscaBinaria(array, elemento);

        if (resultado == -1) {
            System.out.println("Elemento não encontrado.");
        } else {
            System.out.println("Elemento encontrado na posição: " + resultado);
        }
    }
}
