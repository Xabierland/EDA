package tema_2.cartas;

public class Node<T>
{
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T pData)
    {
        this.data=pData;
    }
}
