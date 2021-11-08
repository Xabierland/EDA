package tema_4.BinTree;

public class BinTree<T> {
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

    private T find(T elem, BTN<T> a) //Coste lineal O(n)
    {
        if(a==null)
        {
            return null;
        }
        else if(a.content.equals(elem))
        {
            return a.content;
        }
        else
        {
            T result=find(elem,a.left);
            if (result!=null)
            {
                return result;
            }
            else
            {
                return find(elem,a.right);
            }
        }
    }

    public void removeLeftSubTree()
    {
        //pre: arbol no vacio
        count=count-nNodos(root.left);
        root.left=null;
    }

    private int nNodos(BTN<T> a) //Coste lineal O(n)
    {
        if(a==null)
        {
            return 0;
        }
        else
        {
            return 1+nNodos(a.left)+nNodos(a.right);
        }
    }

    public boolean contains(T elem)
    {
        return find(elem)!=null;
    }
}
