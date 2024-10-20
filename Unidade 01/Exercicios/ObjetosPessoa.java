import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Pessoa
class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    // Construtor
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método para representar a Pessoa como String
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}

// Classe principal
public class ObjetosPessoa {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    pessoas.add(new Pessoa(nome, idade, endereco));
                    System.out.println("Pessoa adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de Pessoas:");
                    for (Pessoa pessoa : pessoas) {
                        System.out.println(pessoa);
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
    }
}
