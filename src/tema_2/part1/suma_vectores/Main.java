package tema_2.part1.suma_vectores;

public class Main
{
    public class Node
    {
        Integer dato;
        Integer posicion;
        Node next;

        public Node(Integer pos, Integer pDato)
        {
            posicion=pos;dato=pDato;next=null;
        }
    }

    public class Vector
    {
        Node first;

        public Vector suma(Vector v1, Vector v2)
        {
            Vector v_aux=new Vector();
            Node act1,act2,act_aux;
            act1=v1.first;
            act2=v2.first;
            v_aux.first=new Node(0,act1.dato+ act2.dato);
            act_aux=v_aux.first;
            int i=0;


            while (act1!=null && act2!=null)
            {
                act1=act1.next;
                act2=act2.next;
                act_aux=act_aux.next;
                i++;
                act_aux=new Node(i,act1.dato+ act2.dato);
            }
            return v_aux;
        }
    }
}
