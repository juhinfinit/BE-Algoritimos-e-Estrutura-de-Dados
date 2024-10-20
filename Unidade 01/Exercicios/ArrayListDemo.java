import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Criando uma ArrayList de números inteiros
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Loop para mostrar o menu até o usuário sair
        while (option != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar número");
            System.out.println("2. Remover número");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Adicionar número à lista
                    System.out.print("Digite o número para adicionar: ");
                    int numberToAdd = scanner.nextInt();
                    numbers.add(numberToAdd);
                    System.out.println("Número adicionado com sucesso.");
                    break;

                case 2:
                    // Remover número da lista
                    System.out.print("Digite o número para remover: ");
                    int numberToRemove = scanner.nextInt();
                    if (numbers.remove((Integer) numberToRemove)) {
                        System.out.println("Número removido com sucesso.");
                    } else {
                        System.out.println("Número não encontrado na lista.");
                    }
                    break;

                case 3:
                    // Mostrar a lista de números
                    System.out.println("Números na lista: " + numbers);
                    break;

                case 4:
                    // Sair do programa
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
