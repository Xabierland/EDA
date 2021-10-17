package fusionar_secuencias;

public class DoubleCircularLinkedList
{
    DoubleNode<String> first;

    public void addNode(String elem)
    {
        if(first==null)
        {
            first=new DoubleNode<>(elem);
            first.next=first;
            first.prev=first;
        }
        else
        {
            first.prev.next=new DoubleNode<>(elem);
            first.prev.next.next=first;
            first.prev=first.prev.next;
        }
    }

    public void print()
    {
        if(first==null)
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            DoubleNode<String> actual=first.next;
            while (actual.equals(first))
            {
                System.out.println(actual.data+", ");
                actual=actual.next;
            }
            System.out.println(actual.data+".");
        }
    }

    public void reset()
    {
        first=null;
    }

    public void fusionarSecuencias(String[] s1,String[] s2)
    {
        if(s1.length==0 && s2.length==0)
        {
            first=null;
        }
        else if(s1.length!=0 && s2.length==0)
        {
            for(String s:s1)
            {
                addNode(s);
            }
        }
        else if(s1.length==0 && s2.length!=0)
        {
            for(String s:s2)
            {
                addNode(s);
            }
        }
        else
        {

        }
    }
}
