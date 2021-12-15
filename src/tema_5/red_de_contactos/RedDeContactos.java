package tema_5.red_de_contactos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RedDeContactos
{
    private boolean[][] adjMatrix;

    public int elQueMasPuedaAyudar(ArrayList<Integer> personas) //Las personas que necesitan un transplante
    {
        Integer[] numAyudas=new Integer[adjMatrix.length];
        for(int i:personas)
        {
            recAnchura(i, numAyudas);
        }

        int pos=0;
        int maxValue=0;
        for(int i=0; i<adjMatrix.length;i++)
        {
            if(numAyudas[i]>maxValue)
            {
                maxValue=numAyudas[i];
                pos=i;
            }
        }
        return pos;
    }

    private void recAnchura(int comienzo, Integer[] l)
    {
        Queue<Integer> porExplorar=new LinkedList<>();
        Boolean[] examinados=new Boolean[adjMatrix.length];

        porExplorar.add(comienzo);
        examinados[comienzo]=true;
        while(!porExplorar.isEmpty())
        {
            int act=porExplorar.remove();
            examinados[act]=true;

            for(int i=0; i<adjMatrix[act].length; i++)
            {
                if(adjMatrix[act][i])
                {
                    porExplorar.add(i);
                }

                if(sonCompatibles(act,i))
                {
                    l[i]=l[i]+1;
                }
            }
        }
    }

    private boolean sonCompatibles(Integer p1, Integer p2)
    {
        return false; //NO SE PIDE IMPLEMENTAR
    }
}
