package tema_2.part1.cartas;

public class Bicola<T> {
    Node<T> first=null;
    Node<T> last=null;

    public boolean estavacia()
    {
        return (first==null && last==null);
    }

    public void insetarIzq(T elem)
    {
        if(estavacia())
        {
            first=new Node<T>(elem);
            last=first;
        }
        else
        {
            Node<T> act=first;
            act.prev=new Node<T>(elem);
            act.prev.next=first;
            first=act.prev;
        }
    }

    public void insertarDer(T elem)
    {
        if(estavacia())
        {
            first=new Node<>(elem);
            last=first;
        }
        else
        {
            Node<T> act=last;
            act.next=new Node<>(elem);
            act.next.prev=act;
            last=act.next;
        }
    }

    public void eliminarIzq()
    {
        if(!estavacia())
        {
            Node<T> act=first;
            act.next.prev=null;
            first=act.next;
        }
    }

    public void eliminarDer()
    {
        if(!estavacia())
        {
            Node<T> act=last;
            act.prev.next=null;
            last=act.prev;
        }
    }

    public T obtenerIzq()
    {
        return first.data;
    }

    public T obtenerDer()
    {
        return last.data;
    }
}