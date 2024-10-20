import java.util.ArrayList;
import java.util.HashSet;

public class RemocaoElementosDuplicados {

    public static void main(String[] args) {
        // Exemplo de uso do método
        ArrayList<String> listaComDuplicados = new ArrayList<>();
        listaComDuplicados.add("maçã");
        listaComDuplicados.add("banana");
        listaComDuplicados.add("maçã");
        listaComDuplicados.add("laranja");
        listaComDuplicados.add("banana");

        System.out.println("Lista Original: " + listaComDuplicados);
        ArrayList<String> listaSemDuplicados = removerDuplicados(listaComDuplicados);
        System.out.println("Lista Sem Duplicados: " + listaSemDuplicados);
    }

    public static ArrayList<String> removerDuplicados(ArrayList<String> lista) {
        // Usando um HashSet para remover duplicados
        HashSet<String> conjunto = new HashSet<>(lista);
        return new ArrayList<>(conjunto);
    }
}
