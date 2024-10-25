import java.util.HashMap;
import java.util.Map;

public class MesclarMapas {

    // Método que mescla dois HashMaps e lida com conflitos de chaves
    public static <K, V> Map<K, V> mesclarMapas(Map<K, V> mapa1, Map<K, V> mapa2) {
        Map<K, V> resultado = new HashMap<>(mapa1);

        // Itera sobre o segundo mapa
        for (Map.Entry<K, V> entrada : mapa2.entrySet()) {
            K chave = entrada.getKey();
            V valor = entrada.getValue();

            // Verifica se a chave já existe no mapa1
            if (resultado.containsKey(chave)) {
                // Lógica para lidar com o conflito de chaves (Aqui você pode modificar conforme necessário)
                System.out.println("Conflito de chave detectado: " + chave);
                // Exemplo de resolução de conflito: escolher o valor do segundo mapa
                resultado.put(chave, valor); // ou aplique outra lógica personalizada
            } else {
                // Adiciona ao mapa se não houver conflito
                resultado.put(chave, valor);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Map<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("A", 1);
        mapa1.put("B", 2);

        Map<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("B", 3); // Conflito de chave "B"
        mapa2.put("C", 4);

        Map<String, Integer> resultado = mesclarMapas(mapa1, mapa2);

        // Imprime o mapa mesclado
        System.out.println("Mapa mesclado: " + resultado);
    }
}