import java.util.Scanner;

public class ListasMatriz {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual;
    private static String jogador1;
    private static String jogador2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inicializa o tabuleiro
        inicializarTabuleiro();
        
        // Obtém os nomes dos jogadores
        System.out.print("Digite o nome do Jogador 1 (X): ");
        jogador1 = scanner.nextLine();
        System.out.print("Digite o nome do Jogador 2 (O): ");
        jogador2 = scanner.nextLine();
        
        jogadorAtual = 'X'; // Jogador 1 começa
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            imprimirTabuleiro();
            System.out.println("É a vez de " + (jogadorAtual == 'X' ? jogador1 : jogador2) + " (" + jogadorAtual + ")");
            System.out.print("Escolha a linha (0, 1, 2) e a coluna (0, 1, 2): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificarVitoria()) {
                    imprimirTabuleiro();
                    System.out.println("Parabéns " + (jogadorAtual == 'X' ? jogador1 : jogador2) + "! Você ganhou!");
                    jogoAtivo = false;
                } else if (verificarEmpate()) {
                    imprimirTabuleiro();
                    System.out.println("É um empate!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; // Troca o jogador
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void imprimirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean verificarVitoria() {
        // Verifica linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }
        return (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
               (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual);
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaços disponíveis
                }
            }
        }
        return true; // Sem espaços disponíveis, é um empate
    }
}
