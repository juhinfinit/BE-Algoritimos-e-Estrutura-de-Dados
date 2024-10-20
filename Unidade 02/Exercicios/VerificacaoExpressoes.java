import java.util.Stack;

public class VerificacaoExpressoes {
    
    public static boolean estaBalanceada(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char ch : expressao.toCharArray()) {
            // Se for um parêntese de abertura, empilha
            if (ch == '(') {
                pilha.push(ch);
            }
            // Se for um parêntese de fechamento
            else if (ch == ')') {
                // Se a pilha estiver vazia, não há parênteses de abertura
                if (pilha.isEmpty()) {
                    return false;
                }
                // Remove o parêntese de abertura correspondente
                pilha.pop();
            }
        }

        // Se a pilha estiver vazia, todos os parênteses estão balanceados
        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        String expressao = "(a + b) * (c - d) / (e + f)";

        if (estaBalanceada(expressao)) {
            System.out.println("A expressão está balanceada.");
        } else {
            System.out.println("A expressão não está balanceada.");
        }
    }
}
