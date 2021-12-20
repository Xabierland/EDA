package tema_2.part2.cola_de_grupos;

import java.util.LinkedList;
import java.util.Queue;

public class Cafeteria
{
    Queue<Queue<Integer>> cola=new LinkedList<>();

    public void insertar(Integer elem)
    {
        Queue<Queue<Integer>> c_aux= new LinkedList<Queue<Integer>>();
        boolean enc=false;

        while (!cola.isEmpty())
        {
            Queue<Integer>c=cola.remove();
            if(mismoGrupo(c.peek(), elem))
            {
                c.add(elem);
                enc=true;
            }
            c_aux.add(c);
        }
        if(!enc)
        {
            Queue<Integer>c=new LinkedList<>();
            c.add(elem);
            c_aux.add(c);
        }
        cola=c_aux;
    }

    public Integer borrar()
    {
        if(!cola.isEmpty())
        {
            Integer res=cola.peek().remove();
            if(cola.peek().isEmpty())
            {
                cola.remove();
            }
            return res;
        }
        else
        {
            return -999999;
        }
    }

    public boolean mismoGrupo(int p1, int p2)
    {
        return true;
        //YA ESTARIA IMPLEMENTADO
    }
}
