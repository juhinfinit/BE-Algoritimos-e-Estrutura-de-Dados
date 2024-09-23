public class Lacos {
    
    public static void main(String[] args){
        //Laço for repete numero determinado de vezes
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        // Laço while, repete N vezes até que não seja mais verdade 

        int x = 6;
        while (x <= 5){
            System.out.println(x);
            x++;
            
        }

        // Laço do while, repete N vezes até que não seja mais verdade, mas acontece pelo menos uma vez 

        int j = 6;
        do{
            System.out.println(j);
            j++;
        }while (j <= 5);
    }
}
