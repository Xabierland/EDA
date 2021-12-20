package tema_2.part1.multiplicar_elementos;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("===Lista1===");
        Lista<String> l1= new Lista<>();
        l1.anadirNodo("5");l1.anadirNodo("7");l1.anadirNodo("2");
        l1.imprimirLista();
        l1.multiplicar(5);
        l1.imprimirLista();
        l1.reset();
    }
}
