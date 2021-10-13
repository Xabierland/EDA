package tema_2.multiplicar_elementos;

public class Lista<T>
{
    Node<T> first;

    public void anadirNodo(T pData)
    {
        Node<T> actual=first;
        if(first==null)
        {
            first=new Node<>(pData);
            first.next=first;
            first.prev=first;
        }
        else
        {
            actual=first.prev;

            actual.next=new Node<>(pData);
            actual.next.next=first;
            actual.next.prev=actual;
            first.prev=actual.next;
        }
    }

    public void multiplicar(Integer n)
    {
        Node<T> actual=first;
        Node<T> previo=first;
        Node<T> pFirst=null;
        Node<T> pActual=null;

        while(actual.next!=first)
        {
            previo=actual;
            actual=actual.next;
            for(int i=1; i<n;i++)
            {
                if(i==1)
                {
                    pFirst = new Node<>(previo.data);
                    pFirst.prev = pFirst;
                    pFirst.next = pFirst;
                }
                else
                {
                    pActual=pFirst.prev;

                    pActual.next=new Node<>(previo.data);
                    pActual.next.next=pFirst;
                    pActual.next.prev=pActual;
                    pFirst.prev=pActual.next;
                }
            }
            previo.next=pFirst;
            actual.prev=pFirst.prev;
            pFirst.prev.next=actual;
            pFirst.prev=previo;
        }
        previo=actual;
        actual=actual.next;
        for(int i=1; i<n;i++)
        {
            if(i==1)
            {
                pFirst = new Node<>(previo.data);
                pFirst.prev = pFirst;
                pFirst.next = pFirst;
            }
            else
            {
                pActual=pFirst.prev;

                pActual.next=new Node<>(previo.data);
                pActual.next.next=pFirst;
                pActual.next.prev=pActual;
                pFirst.prev=pActual.next;
            }
        }
        previo.next=pFirst;
        actual.prev=pFirst.prev;
        pFirst.prev.next=actual;
        pFirst.prev=previo;
    }

    public void imprimirLista()
    {
        Node<T> actual=first;
        if(first==null)
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            while(actual.next!=first)
            {
                System.out.print(actual.data + ", ");
                actual=actual.next;
            }
            System.out.print(actual.data+".\n");
        }
    }

    public void reset()
    {
        first=null;
    }
}
