public class ExemploDadosNPrimitivos {

    public static void main(String[] args){
        //tipos caracter PRIMITIVO
        char caracter = 'A';

       //tipos caracter PRIMITIVO não PRIMITIVO
       String nome = "Juliana";
       nome = "Juliana S.";

       //tipo Enum
       enum DiaDaSemana{
           DOMINGO, SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SABADO
       }
       DiaDaSemana dia = DiaDaSemana.DOMINGO;

       //tipo array
       int[] numeros = {1,2,3,4,5}; // começa sempre em 0, 1, 2, 3, 4

       System.out.println(nome);
       System.out.println(dia);
       System.out.println(numeros[0]);
    }
}