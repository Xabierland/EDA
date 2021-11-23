package tema_4.arbol_tareas;

public class ArbolTareas
{
    BTN root;

    public void add(String id, int coste)
    {
        if(root==null)
        {
            root=new BTN(id, coste);
        }
        else
        {
            BTN act=root;
            boolean enc=false;
            while (!enc)
            {
                if(id.compareTo(act.element.id)<0)
                {
                    if(act.left==null)
                    {
                        act.left=new BTN(id,coste);
                        enc=true;
                    }
                    else
                    {
                        act=act.left;
                    }
                }
                else if(id.compareTo(act.element.id)>0)
                {
                    if(act.right==null)
                    {
                        act.right=new BTN(id,coste);
                        enc=true;
                    }
                    else
                    {
                        act=act.right;
                    }
                }
                else
                {
                    act.element.coste=coste;
                    enc=true;
                }
            }
        }
    }

    public int coste(String idTarea)
    {
        BTN tarea=findNode(idTarea, root);
        int sum=0;
        suma(tarea,sum);
        return sum;
    }

    private BTN findNode(String id, BTN a)
    {
        if(a==null)
        {
            return null;
        }
        else if(a.element.id.equals(id))
        {
            return a;
        }
        else
        {
            if(id.compareTo(a.element.id)>0)
            {
                return findNode(id, a.right);
            }
            else
            {
                return findNode(id, a.left);
            }
        }
    }

    private void suma(BTN a, int sum)
    {
        if(a==null){}
        else{
            sum+=a.element.coste;
            suma(a.left, sum);
            suma(a.right, sum);
        }
    }
}
