package tema_2.part1.reemplazar_por_secuencias;

public class Main {
    public static void main(String[] args)
    {
        DoubleLinkedList l=new DoubleLinkedList();
        l.addInOrden("ama");
        l.addInOrden("col");
        l.addInOrden("mar");
        l.addInOrden("rio");
        l.addInOrden("zar");

        l.print();

        Pareja[] parejas=new Pareja[3];

        String[] s1=new String[3];
        s1[0]="cola";s1[1]="colar";s1[2]="color";
        Pareja p1=new Pareja("col",s1);
        parejas[0]=p1;

        String[] s2=new String[3];
        s2[0]="mara";s2[1]="marte";s2[2]="marzo";
        Pareja p2=new Pareja("mar",s2);
        parejas[1]=p2;

        String[] s3=new String[2];
        s3[0]="zara";s3[1]="zarza";
        Pareja p3=new Pareja("zar",s3);
        parejas[2]=p3;

        l.reemplazar(parejas);
        l.print();
    }
}
