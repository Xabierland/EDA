package tema_4.BinTree;

public class BTN<T> {
    public T content;
    public BTN<T> left;
    public BTN<T> right;

    public BTN(T elem)
    {
        content=elem;
        left=null;
        right=null;
    }
}
