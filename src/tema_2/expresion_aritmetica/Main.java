package tema_2.expresion_aritmetica;

public class Main {
    public static void main(String[] args) {
        String exp="(1+((2+3)*(4*5)))";
        Djikstra d=new Djikstra();
        System.out.print(d.evaluar(exp));
    }
}
