package tema_2.radixSort;

import java.util.LinkedList;
import java.util.Queue;

public class radixSort {
    public void radixSort(Integer[] seq, int maxDig)
    {
        Queue<Integer>[] colas=new LinkedList[10];
        for(int i=0;i< colas.length;i++)
        {
            colas[i]=new LinkedList<Integer>();
        }
        for (int d=0; d<maxDig ;d++)
        {
            for(int i : seq)
            {
                colas[i/10^d % 10].add(i);
            }
            int j=0;
            for (Queue<Integer> cola : colas) {
                while (!cola.isEmpty()) {
                    seq[j] = cola.remove();
                    j++;
                }
            }
        }
    }
}

