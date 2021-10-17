package fusionar_secuencias;

public class Main
{
    public static void main(String[] args)
    {
        DoubleCircularLinkedList l=new DoubleCircularLinkedList();
        String[] s1,s2;

        System.out.println("===TEST 1 - Listas Vacia===");
        s1 = new String[0];s2 = new String[0];
        l.fusionarSecuencias(s1,s2);
        l.print();

        System.out.println("===TEST 2 - Lista s1 vacia===");
        

    }
}
