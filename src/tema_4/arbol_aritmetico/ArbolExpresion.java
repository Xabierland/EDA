package tema_4.arbol_aritmetico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ArbolExpresion
{
    BTN<InfoElemExp> root;

    public Integer evaluar(HashMap<String, Integer> tHash)
    {
        return 1;       //SIN TERMINAR
    }

    public Iterator<InfoElemExp> iteratorPostOrden()
    {
        ArrayList<InfoElemExp> lista=new ArrayList<>();
        iteratorPostOrden(root, lista);
        return lista.iterator();
    }

    private void iteratorPostOrden(BTN<InfoElemExp> a, ArrayList<InfoElemExp> l)
    {
        if(a==null){}
        else
        {
            iteratorPostOrden(a.left,l);
            iteratorPostOrden(a.right,l);
            l.add(a.element);
        }
    }
}
