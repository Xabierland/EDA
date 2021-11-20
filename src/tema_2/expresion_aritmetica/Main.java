package tema_2.expresion_aritmetica;

public class Main {
    public static void main(String[] args) {
        String exp="(1+((2+3)*(4*5)))";
        Djikstra d=new Djikstra();
        System.out.print("El resultado es:\t\t\t"+d.evaluar(exp)+"\n");
        System.out.print("El resultado deberia ser:\t101.0");
    }
}
