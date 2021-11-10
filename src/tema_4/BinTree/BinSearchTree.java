package tema_4.BinTree;

public class BinSearchTree<T> extends  BinTree<T>
{
    public BinSearchTree(){
        super();
    }

    public T findRecursively(T elem)
    {
        return findRecursively(elem, root);
    }

    private T findRecursively(T elem, BTN<T> a)
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
            Comparable<T> comp=(Comparable<T>) elem;
            if (comp.compareTo(a.content)>0)
            {
                return find(elem, a.right);
            }
            else
            {
                return find(elem, a.left);
            }
        }
    }

    public T findIterable(T elem)
    {
        BTN<T> act=root;
        boolean enc=false;
        while(act!=null && !enc)
        {
            Comparable<T> comp = (Comparable<T>) elem;
            if(comp.compareTo(act.content)==0)
            {
                enc=true;
            }
            else if(comp.compareTo(act.content)>0)
            {
                act=act.right;
            }
            else
            {
                act=act.left;
            }
        }
        if(enc)
        {
            return act.content;
        }
        else
        {
            return null;
        }
    }
}
