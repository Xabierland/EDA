package tema_2.reemplazar_por_secuencias;

public class DoubleLinkedList
{
    DoubleNode<String> first;

    public void addInOrden(String elem)
    {
        if(first==null)
        {
            first=new DoubleNode<>(elem);
            first.prev=null;
            first.next=null;
        }
        else
        {
            DoubleNode<String> act=first;
            DoubleNode<String> pos=first;
            boolean enc=false;
            while (!enc && act!=null)
            {
                if(act.data.compareTo(elem)<0)
                {
                    enc=true;
                }
                else
                {
                    pos = act;
                    act = act.next;
                }
            }
            if(enc) //Si se encuentra se mete en su posicion
            {
                pos.next = new DoubleNode<>(elem);
                pos.next.prev=pos;
                pos.next.next=act;
                act.prev=pos.next;
            }
            else //Si no se encuentra se mete al final
            {
                pos.next=new DoubleNode<>(elem);
                pos.next.prev=pos;
            }
        }
    }

    public void reemplazar(Pareja[] parejas)
    {
        
    }
}
