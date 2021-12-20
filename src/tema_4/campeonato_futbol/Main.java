package tema_4.campeonato_futbol;

import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
    private class Marcador{
        String ganador;
        Integer golesIzq;
        Integer golesDer;
    }

    private class Nodo
    {
        Marcador info;
        Nodo izq, der;
    }

    private class Campeonato
    {
        private Nodo root;

        public String campeon()
        {
            Iterator<Nodo> itr=iteratorPostOrden();
            Nodo act = null;
            while (itr.hasNext())
            {
                act=itr.next();
                if(act.info.ganador.equals(""))
                {
                    if(act.info.golesDer>act.info.golesIzq)
                    {
                        act.info.ganador=act.der.info.ganador;
                    }
                    else
                    {
                        act.info.ganador=act.izq.info.ganador;
                    }
                }
            }
            return root.info.ganador;
        }

        private Iterator<Nodo> iteratorPostOrden()
        {
            ArrayList<Nodo> lista=new ArrayList<>();
            iteratorPostOrden(root,lista);
            return lista.iterator();
        }

        private void iteratorPostOrden(Nodo a, ArrayList<Nodo> l)
        {
            if(a==null)
            {

            }
            else
            {
                iteratorPostOrden(a.izq,l);
                iteratorPostOrden(a.der,l);
                l.add(a);
            }
        }
    }
}
