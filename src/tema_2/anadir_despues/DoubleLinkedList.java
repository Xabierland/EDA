package tema_2.anadir_despues;

public class DoubleLinkedList<T>
{
    DoubleNode<T> first;

    public void addNode(T pData)
    {
        DoubleNode<T> actual;
        if(first==null)
        {
            first=new DoubleNode<>(pData);
            first.next=first;
            first.prev=first;
        }
        else
        {
            actual=first.prev;

            actual.next=new DoubleNode<>(pData);
            actual.next.next=first;
            actual.next.prev=actual;
            first.prev=actual.next;
        }
    }

    public void printNodeList()
    {
        if(first==null)
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            DoubleNode<T> actual=first;
            while(actual.next!=first)
            {
                System.out.print(actual.data+", ");
                actual=actual.next;
            }
            System.out.print(actual.data+".\n");
        }
    }

    public void reset()
    {
        first=null;
    }

    public void addAfter(T elem, T target)
    {
        DoubleNode<T> actual=first;
        DoubleNode<T> previo=first.prev;
        boolean esta=false;
        if(target!=first.data) {
            previo = actual;
            actual=actual.next;
            while (actual != first && actual.data!=target)
            {
                previo=actual;
                actual=actual.next;
                if(actual.data==target)
                {
                    esta=true;
                }
            }
            if(esta)
            {
                previo=actual;
                actual=actual.next;

                actual.prev=new DoubleNode<>(elem);
                actual.prev.next=actual;
                actual.prev.prev=previo;
                previo.next=actual.prev;
            }
            else
            {
                actual.prev=new DoubleNode<>(elem);
                actual.prev.next=actual;
                actual.prev.prev=previo;
                first=actual.prev;
                previo.next=first;
            }
        }
        else
        {
            previo=actual;
            actual=actual.next;

            actual.prev=new DoubleNode<>(elem);
            actual.prev.next=actual;
            actual.prev.prev=previo;
            previo.next=actual.prev;
        }
    }

}
