import java.util.ArrayList;

public class InversaoLista {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(0);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);

        System.out.println("Lista original: " + numeros);

        int tamanho = numeros.size();

        for (int i = 0; i < tamanho / 2; i++) {
            int temp = numeros.get(i);
            numeros.set(i, numeros.get(tamanho - i - 1));
            numeros.set(tamanho - i - 1, temp);
        }

        System.out.println("Lista invertida: " + numeros);
    }
}