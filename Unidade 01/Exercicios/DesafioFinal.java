import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String nome;
    private int quantidade;
    private double preco;

    public Item(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}

public class DesafioFinal {
    private List<Item> estoque;

    public DesafioFinal() {
        estoque = new ArrayList<>();
    }

    public void adicionarItem(String nome, int quantidade, double preco) {
        Item item = new Item(nome, quantidade, preco);
        estoque.add(item);
        System.out.println("Item adicionado: " + item);
    }

    public void removerItem(String nome) {
        Item itemARemover = null;
        for (Item item : estoque) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itemARemover = item;
                break;
            }
        }

        if (itemARemover != null) {
            estoque.remove(itemARemover);
            System.out.println("Item removido: " + itemARemover);
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    public void atualizarItem(String nome, int novaQuantidade, double novoPreco) {
        for (Item item : estoque) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.setQuantidade(novaQuantidade);
                System.out.println("Item atualizado: " + item);
                return;
            }
        }
        System.out.println("Item não encontrado no estoque.");
    }

    public void listarEstoque() {
        System.out.println("Estoque:");
        for (Item item : estoque) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DesafioFinal sistemaEstoque = new DesafioFinal();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Atualizar item");
            System.out.println("4. Listar estoque");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    System.out.print("Preço: ");
                    double precoAdicionar = scanner.nextDouble();
                    sistemaEstoque.adicionarItem(nomeAdicionar, quantidadeAdicionar, precoAdicionar);
                    break;
                case 2:
                    System.out.print("Nome do item a remover: ");
                    String nomeRemover = scanner.nextLine();
                    sistemaEstoque.removerItem(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do item a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    sistemaEstoque.atualizarItem(nomeAtualizar, novaQuantidade, novoPreco);
                    break;
                case 4:
                    sistemaEstoque.listarEstoque();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

