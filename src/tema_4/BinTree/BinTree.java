package tema_4.BinTree;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void printInOrden()
    {
        printInOrden(root);
    }

    private void printInOrden(BTN<T> a)
    {
        if(a==null) {}
        else
        {
            printInOrden(a.left);
            System.out.println(a.content);
            printInOrden(a.right);
        }
    }

    public Iterator<T> iteratorInOrden()
    {
        ArrayList<T> lista=new ArrayList<>();
        iteratorInOrden(root, lista);
        return lista.iterator();
    }

    private void iteratorInOrden(BTN<T> a, ArrayList<T> l)
    {
        if(a==null){}
        else
        {
            iteratorInOrden(a.left,l);
            l.add(a.content);
            iteratorInOrden(a.right,l);
        }
    }
}
