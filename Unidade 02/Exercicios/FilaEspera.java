import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaEspera {
    private Queue<String> fila;

    public FilaEspera() {
        fila = new LinkedList<>();
    }

    // Método para adicionar um elemento à fila
    public void adicionar(String nome) {
        fila.add(nome);
        System.out.println(nome + " foi adicionado à fila.");
    }

    // Método para remover um elemento da fila
    public void remover() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia. Nenhum elemento para remover.");
        } else {
            String nomeRemovido = fila.poll();
            System.out.println(nomeRemovido + " foi removido da fila.");
        }
    }

    // Método para exibir os elementos da fila
    public void exibir() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Elementos na fila: " + fila);
        }
    }

    public static void main(String[] args) {
        FilaEspera filaEspera = new FilaEspera();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar à fila");
            System.out.println("2. Remover da fila");
            System.out.println("3. Exibir fila");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome para adicionar à fila: ");
                    String nome = scanner.nextLine();
                    filaEspera.adicionar(nome);
                    break;
                case 2:
                    filaEspera.remover();
                    break;
                case 3:
                    filaEspera.exibir();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
