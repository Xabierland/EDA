package tema_4.BinTree;

public class BTN<T> {
    protected T content;
    protected BTN<T> left;
    protected BTN<T> right;

    public BTN(T elem)
    {
        content=elem;
        left=null;
        right=null;
    }
}
