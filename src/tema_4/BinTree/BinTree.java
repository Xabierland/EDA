package tema_4.BinTree;

public class BinTree {
    BTN<T> root;
    int count;

    public boolean isEmpty()
    {
        return root==null;
    }

    public T find(T elem)
    {
        return find(elem, root);
    }

    private T find(T elem, BTN<T> a)
    {
        if(isEmpty())
        {
            return null;
        }
        else if(root(a)==elem)
        {
            return root(a);
        }
        else
        {
            
        }
    }

    public boolean contains(T elem)
    {
        return find(elem)!=null;
    }
}
