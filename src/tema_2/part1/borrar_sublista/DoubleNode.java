package tema_2.part1.borrar_sublista;


public class DoubleNode<T>
{
    T data;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    public DoubleNode(T pData)
    {
        this.data=pData;
    }
}

