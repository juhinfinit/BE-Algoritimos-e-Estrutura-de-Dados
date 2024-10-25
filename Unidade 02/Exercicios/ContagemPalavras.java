import java.util.*;

public class ContagemPalavras {
    public static void main(String[] args) {
        String frase = "No meio do caminho tinha uma pedra\r\n" + //
                        "tinha uma pedra no meio do caminho\r\n" + //
                        "tinha uma pedra\r\n" + //
                        "no meio do caminho tinha uma pedra.\r\n" + //
                        "\r\n" + //
                        "Nunca me esquecerei desse acontecimento\r\n" + //
                        "na vida de minhas retinas tão fatigadas.\r\n" + //
                        "Nunca me esquecerei que no meio do caminho\r\n" + //
                        "tinha uma pedra\r\n" + //
                        "tinha uma pedra no meio do caminho\r\n" + //
                        "no meio do caminho tinha uma pedra.";

        // Removendo pontuações e convertendo para minúsculas
        frase = frase.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        
        String[] palavras = frase.split(" ");

        HashMap<String, Integer> frequenciaPalavras = new HashMap<>();

        // Contagem da frequência das palavras
        for (String palavra : palavras) {
            if (frequenciaPalavras.containsKey(palavra)) {
                frequenciaPalavras.put(palavra, frequenciaPalavras.get(palavra) + 1);
            } else {
                frequenciaPalavras.put(palavra, 1);
            }
        }

        // Exibição da frequência das palavras
        for (Map.Entry<String, Integer> entry : frequenciaPalavras.entrySet()) {
            System.out.println("Palavra: " + entry.getKey() + " - Frequência: " + entry.getValue());
        }
    }
}