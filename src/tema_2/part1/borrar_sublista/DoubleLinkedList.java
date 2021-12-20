package tema_2.part1.borrar_sublista;

public class DoubleLinkedList<T>
{
    DoubleNode<T> first;

    public DoubleLinkedList()
    {}

    public void anadirNodo(T pData)
    {
        DoubleNode<T> actual=first;
        if(first==null)
        {
            first= new DoubleNode<T>(pData);
            first.next=first;
            first.prev=first;
        }
        else
        {
            actual=first.prev;

            actual.next= new DoubleNode<T>(pData);
            actual.next.next=first;
            actual.next.prev=actual;
            first.prev=actual.next;
        }
    }

    public void imprimirNodo()
    {
        DoubleNode<T> actual=first;
        if(first==null)
        {
            System.out.println("El nodo esta vacio");
        }
        else
        {
            System.out.print(actual.data+", ");
            actual=actual.next;
            while(actual!=first)
            {
                System.out.print(actual.data+", ");
                actual=actual.next;
            }
            System.out.println("\n");
        }
    }

    public int size()
    {
        int i=1;
        DoubleNode<T> actual=first;
        if(first==null)
        {
            i=0;
        }
        else
        {
            while (actual.next != first) {
                i++;
                actual = actual.next;
            }
        }

        return i;
    }

    /**
     *
     * @param subLista tiene que ser una parte de la lista y los elementos de sublista estan en el mismo orden que en la lista principal
     */
    public void borrarLista(DoubleLinkedList<T> subLista)
    {
        DoubleNode<T> actual=first;
        DoubleNode<T> anterior=first;
        boolean esp=false;

        if(subLista.first!=null) {
            while (!actual.data.equals(subLista.first.data) && !anterior.equals(first.prev)) {
                anterior = actual;
                actual = actual.next;
            }
            if (!anterior.equals(first.prev)) {
                if (actual.equals(first)) {
                    if (subLista.size() == size()) {
                        first = null;
                    } else {
                        anterior = anterior.prev;
                        esp = true;
                    }
                }
                for (int i = 0; i < subLista.size(); i++) {
                    actual = actual.next;
                    if (actual == first) {
                        esp = true;
                    }
                }
                actual.prev = anterior;
                anterior.next = actual;
                if (esp) {
                    first = actual;
                }
            }
        }
    }

    public void reset()
    {
        first=null;
    }
}
