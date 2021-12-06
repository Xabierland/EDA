package tema_4.arbol_tareas;

public class ArbolTareas
{
    BTN root;

    public int coste(String idTarea)
    {
        BTN tarea=findNode(idTarea, root);
        return suma(tarea);
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
            BTN resDer=findNode(id, a.right);
            if(resDer!=null)
            {
                return resDer;
            }
            else
            {
                return findNode(id, a.left);
            }
        }
    }

    private int suma(BTN a)
    {
        if(a==null){return 0;}
        else{
            return a.element.coste+suma(a.left)+suma(a.right);
        }
    }
}
