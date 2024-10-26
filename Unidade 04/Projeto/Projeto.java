package Projeto;

import java.util.*;
import Projeto.Pizza.TamanhoPizza;

public class Projeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1 -> fazerPedido(scanner, listaPedidos, listaClientes);
                case 2 -> alterarPedido(scanner, listaPedidos);
                case 3 -> {
                    listaClientes.add(adicionarCliente(scanner));
                    System.out.println("Cliente adicionado com sucesso!");
                }
                case 4 -> gerarRelatorio(listaPedidos);
                case 5 -> gerarListaClientes(listaClientes);
                case 9 -> {
                    System.out.println("Até amanhã...");
                    continuar = false;
                    scanner.close();
                }
                default -> {
                }
            }
        }
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO");

        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(x + " - " + cliente.getNome());
            x++;
        }
        System.out.print("Opção: ");
        int cliente = scanner.nextInt();
        scanner.nextLine();

        boolean continuar = true;
        while (continuar) {
            x = 1;
            System.out.println("Qual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho: ");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + " - " + tamanhos);
                x++;
            }
            System.out.print("Opção: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores: 1 - 4 ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> saboresSelect = new ArrayList<>();

            for (int i = 0; i < quantiSabores; i++) {
                System.out.println("Selecione um sabor: ");

                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x + " - " + sabor);
                    x++;
                }
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                saboresSelect.add(saboresList.get(opcao - 1));
            }

            Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), TamanhoPizza.getByIndex(tamanho - 1));
            pizzas.add(pizza);

            System.out.println("Pizza cadastrada com sucesso!");
            System.out.println();
            System.out.println("Deseja cadastrar mais uma pizza no pedido?");
            System.out.print("1 - Sim, 2 - Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao != 1) {
                continuar = false;
            }
        }

        double valorTotal = somarPizzas(pizzas);
        double frete = calcularFrete(pizzas.size(), cliente); // Método de cálculo do frete
        Pedido pedido = new Pedido(listaPedidos.size() + 1, listaClientes.get(cliente - 1), pizzas, valorTotal + frete);
        listaPedidos.add(pedido);

        System.out.println("Valor total do pedido (com frete): R$ " + (valorTotal + frete));
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos) {
        System.out.print("Digite o ID do pedido ou nome do cliente para buscar: ");
        String busca = scanner.nextLine();
        Pedido pedido = null;

        for (Pedido p : listaPedidos) {
            if (((Cliente) p.getCliente()).getNome().equalsIgnoreCase(busca) || String.valueOf(p.getId()).equals(busca)) {
                pedido = p;
                break;
            }
        }

        if (pedido != null) {
            System.out.println("Pedido encontrado. O que deseja alterar?");
            System.out.println("1 - Adicionar pizza");
            System.out.println("2 - Remover pizza");
            System.out.println("3 - Alterar sabor da pizza");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, List.of(pedido.getCliente())); // Reutiliza o método de fazer pedido
                    break;
                case 2:
                    System.out.println("Removendo pizza do pedido...");
                    // Implemente a lógica de remoção aqui
                    break;
                case 3:
                    System.out.println("Alterando sabores...");
                    // Implemente a lógica de alteração de sabor aqui
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("ADICIONAR CLIENTE");
        System.out.println();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return cliente;
    }

    private static void gerarRelatorio(List<Pedido> listaPedidos) {
        System.out.println("Relatório de Vendas");
        double faturamentoTotal = 0;
        Map<String, Integer> saboresMaisPedidos = new HashMap<>();

        for (Pedido pedido : listaPedidos) {
            faturamentoTotal += pedido.getValorTotal();
            for (Pizza pizza : pedido.getPizzas()) {
                for (String sabor : pizza.getSabores()) {
                    saboresMaisPedidos.put(sabor, saboresMaisPedidos.getOrDefault(sabor, 0) + 1);
                }
            }
        }

        System.out.println("Faturamento total: R$ " + faturamentoTotal);
        System.out.println("Sabores mais pedidos:");
        saboresMaisPedidos.forEach((sabor, quantidade) -> System.out.println(sabor + ": " + quantidade + " pedidos"));

        gerarGrafosSabores(saboresMaisPedidos); // Método para gerar grafos de sabores
    }

    private static void gerarGrafosSabores(Map<String, Integer> saboresMaisPedidos) {
        // Implemente aqui a lógica para gerar grafos que mostrem as relações entre os sabores mais pedidos.
        System.out.println("Ligação entre os sabores mais pedidos gerada.");
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        int x = 1;
        if (listaClientes.isEmpty()) {
            System.out.println("Lista de clientes está vazia.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Cliente " + x);
                System.out.println(cliente.getNome());
                System.out.println(cliente.getEndereco());
                System.out.println(cliente.getTelefone());
                System.out.println(cliente.getEmail());
                System.out.println();
                x++;
            }
        }
    }

    private static double calcularFrete(int quantidadePizzas, int distancia) {
        double freteBase = 5.0;
        double valorPorKm = 1.5;
        double valorPorPizza = 2.0;
        return freteBase + (valorPorKm * distancia) + (valorPorPizza * quantidadePizzas);
    }

    @Override
    public String toString() {
        return "Projeto []";
    }
}