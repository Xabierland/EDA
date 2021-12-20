package tema_2.part1.reemplazar_por_secuencias;

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
                if(act.data.compareTo(elem)>0)
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

    public void remove(String elem)
    {
        if(first==null){}
        else
        {
            DoubleNode<String> act=first;
            DoubleNode<String> pos=first;
            boolean enc=false;
            while (!enc && act!=null)
            {
                if(act.data.compareTo(elem) == 0)
                {
                    enc=true;
                }
                else
                {
                    pos = act;
                    act = act.next;
                }
            }
            if(enc)
            {
                if(act==first) //Primer elemento
                {
                    act.next.prev=null;
                    first=act.next;
                }
                else if(act.next==null) //Ultimo elemento
                {
                    pos.next=null;
                }
                else
                {
                    act = act.next;
                    pos.next = act;
                    act.prev = pos;
                }
            }
        }
    }

    public void reemplazar(Pareja[] parejas)
    {
        for(Pareja p:parejas)
        {
            for(String s:p.replacement)
            {
                addInOrden(s);
            }
            remove(p.target);
        }
    }

    public void print()
    {
        DoubleNode<String> act=first;
        while (act!=null)
        {
            System.out.print(act.data+", ");
            act=act.next;
        }
        System.out.print("\n");
    }
}
