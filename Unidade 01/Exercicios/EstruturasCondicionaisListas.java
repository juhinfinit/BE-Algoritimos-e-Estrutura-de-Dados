import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EstruturasCondicionaisListas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> numberCount = new HashMap<>();

        System.out.println("Insira a quantidade de números que deseja inserir:");
        int n = scanner.nextInt();

        System.out.println("Por favor, insira " + n + " números inteiros:");
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
        }

        int mostFrequentNumber = -1;
        int highestCount = 0;

        for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostFrequentNumber = entry.getKey();
            }
        }

        if (highestCount > 0) {
            System.out.println("O número que mais se repete é: " + mostFrequentNumber);
        } else {
            System.out.println("Nenhum número foi inserido.");
        }

        scanner.close();
    }
}
