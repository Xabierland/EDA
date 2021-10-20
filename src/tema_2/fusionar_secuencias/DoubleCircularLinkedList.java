package tema_2.fusionar_secuencias;

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
            first.prev.next.prev=first.prev;
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
            DoubleNode<String> actual=first;
            while (!actual.equals(first.prev))
            {
                System.out.print(actual.data+", ");
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
            int i=0,j=0; //i para s1; j para s2
            while(i!=s1.length || j!=s2.length)
            {
                if(i!=s1.length && j!=s2.length)
                {
                    if (s1[i].compareTo(s2[j])<0)
                    {
                        addNode(s1[i]);
                        i++;
                    } else
                    {
                        addNode(s2[j]);
                        j++;
                    }
                }
                if(i==s1.length)
                {
                    addNode(s2[j]);
                    j++;
                }
                else if(i==s2.length)
                {
                    addNode(s1[i]);
                    i++;
                }
            }
        }
    }
}
