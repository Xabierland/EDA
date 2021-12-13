package tema_5.cena_de_negocios;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    protected int numVertices=0;
    protected LinkedList<Integer>[] adjList;

    public boolean separar_cena(int comienzo)
    {
        Queue<Integer> porEx=new LinkedList<Integer>();
        boolean[] examinados=new boolean[numVertices];
        boolean posible=true;

        porEx.add(comienzo);
        examinados[comienzo]=true;
        int[] comedor=new int[numVertices];
        comedor[comienzo]=-1;

        while(!porEx.isEmpty()&&posible)
        {
            int act=porEx.remove();
            for(int x:adjList[act])
            {
                if(examinados[x])
                {
                    porEx.add(x);
                    examinados[x]=true;
                    comedor[x]-=comedor[act];
                }
                else if(comedor[x]==comedor[act])
                {
                   posible=false;
                }
            }
        }
        return posible;
    }


}
