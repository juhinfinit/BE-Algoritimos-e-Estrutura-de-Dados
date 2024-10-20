import java.util.ArrayList;
import java.util.Stack;

public class InversaoComPilhas {
    
    public static <T> ArrayList<T> inverterLista(ArrayList<T> lista) {
        Stack<T> pilha = new Stack<>();
        
        // Adiciona todos os elementos da lista à pilha
        for (T elemento : lista) {
            pilha.push(elemento);
        }
        
        ArrayList<T> listaInvertida = new ArrayList<>();
        
        // Remove os elementos da pilha e os adiciona à nova lista
        while (!pilha.isEmpty()) {
            listaInvertida.add(pilha.pop());
        }
        
        return listaInvertida;
    }
    
    public static void main(String[] args) {
        // Exemplo de uso
        ArrayList<String> listaOriginal = new ArrayList<>();
        listaOriginal.add("A");
        listaOriginal.add("B");
        listaOriginal.add("C");
        listaOriginal.add("D");
        
        System.out.println("Lista Original: " + listaOriginal);
        
        ArrayList<String> listaInvertida = inverterLista(listaOriginal);
        
        System.out.println("Lista Invertida: " + listaInvertida);
    }
}
