// Nome do arquivo: MatrizArrays.java
public class MatrizArrays {
    public static void main(String[] args) {
        // Definindo um array de números inteiros
        int[] numeros = {3, 9, 4, 15, 6, 12};

        // Variável para armazenar o maior valor, inicializada com o primeiro valor do array
        int maior = numeros[0];

        // Iterando sobre o array para encontrar o maior valor
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i]; // Atualizando o maior valor
            }
        }

        // Imprimindo o maior valor encontrado
        System.out.println("O maior valor na matriz é: " + maior);
    }
}
