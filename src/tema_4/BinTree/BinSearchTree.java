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
                return findRecursively(elem, a.right);
            }
            else
            {
                return findRecursively(elem, a.left);
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

    public void addElementIterable(T elem)
    {
        if(root==null)
        {
            root=new BTN<>(elem);
        }
        else
        {
            BTN<T> act=root;
            Comparable<T> comp = (Comparable<T>) elem;
            boolean enc=false;
            while (!enc)
            {
                if (comp.compareTo(act.content)<0)
                {
                    if(act.left==null)
                    {
                        act.left=new BTN<>(elem);
                        enc=true;
                    }
                    else
                    {
                        act=act.left;
                    }
                }
                else
                {
                    if(act.right==null)
                    {
                        act.right=new BTN<>(elem);
                        enc=true;
                    }
                    else
                    {
                        act=act.right;
                    }
                }
            }
            count++;
        }
    }

    public void addElementRecursively(T elem)
    {
        if(root==null)
        {
            root=new BTN<>(elem);
        }
        else
        {
            addElementRecursively(elem, root);
        }
        count++;
    }

    private void addElementRecursively(T elem, BTN<T> a)
    {
        if(a==null)
        {
            a = new BTN<>(elem);
        }
        else
        {
            Comparable<T> comp=(Comparable<T>) elem;
            if(comp.compareTo(elem)<0)
            {
               if(a.left==null)
                   a.left=new BTN<>(elem);
               else
                   addElementRecursively(elem,a.left);
            }
            else
            {
                if(a.right==null)
                    a.right=new BTN<>(elem);
                else
                    addElementRecursively(elem, a.right);
            }
        }
    }

    public T findMinIterable()
    {
        BTN<T> act=root;
        while(act.left!=null)
        {
            act=act.left;
        }
        return act.content;
    }

    public T findMaxIterable()
    {
        BTN<T> act=root;
        while(act.right!=null)
        {
            act=act.right;
        }
        return act.content;
    }

    public T removeMin()
    {
        BTN<T> act=root;
        BTN<T> ant=root;

        while (act.left!=null)
        {
            ant=act;
            act=act.left;
        }
        if(ant==root)
        {
            root=root.right;
        }
        ant.left=act.right;
        return act.content;
    }

    public T removeMax()
    {
        BTN<T> act=root;
        BTN<T> ant=root;

        while (act.right!=null)
        {
            ant=act;
            act=act.right;
        }
        if(ant==root)
        {
            root=root.left;
        }
        ant.right=act.left;
        return act.content;
    }
}
