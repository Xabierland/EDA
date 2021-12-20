package tema_2.part1.multiplicar_elementos;

public class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T pData)
    {
        this.data=pData;
    }
}
