public class EstruturasCondicionaisELaços {
    public static void main(String[] args) {
        System.out.println("Números primos entre 1 e 100:");
        
        for (int num = 2; num <= 100; num++) {
            boolean isPrimo = true;

            // Verifica se o número é primo
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrimo = false;
                    break;
                }
            }

            if (isPrimo) {
                System.out.print(num + " ");
            }
        }
    }
}
