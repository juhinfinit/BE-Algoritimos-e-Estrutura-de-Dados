import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EstruturasCondicionaisListas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de números que você deseja inserir:");
        int n = scanner.nextInt(); // Lê a quantidade de números

        int[] numeros = new int[n];
        System.out.println("Digite os números inteiros:");

        // Lê os números inteiros do usuário
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        // Chama o método para encontrar o número que mais se repete
        int numeroMaisRepetido = encontrarNumeroMaisRepetido(numeros);

        System.out.println("O número que mais se repete é: " + numeroMaisRepetido);
        
        scanner.close(); // Fecha o scanner
    }

    // Método para encontrar o número que mais se repete
    public static int encontrarNumeroMaisRepetido(int[] numeros) {
        HashMap<Integer, Integer> contagem = new HashMap<>(); // Armazena a contagem dos números

        // Contar a frequência de cada número
        for (int numero : numeros) {
            contagem.put(numero, contagem.getOrDefault(numero, 0) + 1);
        }

        int numeroMaisRepetido = numeros[0];
        int maxContagem = 0;

        // Encontrar o número com a maior frequência
        for (Map.Entry<Integer, Integer> entrada : contagem.entrySet()) {
            if (entrada.getValue() > maxContagem) {
                maxContagem = entrada.getValue();
                numeroMaisRepetido = entrada.getKey();
            }
        }

        return numeroMaisRepetido; // Retorna o número mais repetido
    }
}