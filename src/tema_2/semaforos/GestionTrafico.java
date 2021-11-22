package tema_2.semaforos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GestionTrafico {
    int NSEMAFOROS=20;
    int N=5;
    int SALIDA=99999;

    public Integer aDonde(String matricula)
    {
        //NO SE IMPLEMENTA
        return 1;
    }

    public void simularTrafico(ArrayList<Evento> eventos)
    {
        //INIT
        HashMap<String, Integer> cocheSemaforo=new HashMap<>();
        Queue<String>[] semaforos=new LinkedList[NSEMAFOROS];
        for(int i=0;i<NSEMAFOROS;i++)
        {
            semaforos[i]=new LinkedList<>();
        }

        //PROGRAMA
        for(Evento ev:eventos)
        {
            if(ev.tipo=='E')
            {
                semaforos[0].add(ev.valor);
                cocheSemaforo.put(ev.valor,0);
                System.out.println("El coche "+ev.valor+" llega al semaforo S0");
            }
            else if(ev.tipo=='V')
            {
                int semaforo=Integer.parseInt(ev.valor);
                for(int i=0;i<N;i++)
                {
                    String mat=semaforos[semaforo].remove();
                    int destino=aDonde(mat);
                    if(destino!=SALIDA)
                    {
                        semaforos[destino].add(mat);
                        cocheSemaforo.put(mat,destino);
                        System.out.println("El coche "+mat+" llega al semaforo S"+destino);
                    }
                    else
                    {
                        cocheSemaforo.remove(mat);
                        System.out.println("El coche "+mat+" sale de la ciudad");
                    }
                }
            }
            else if(ev.tipo=='A')
            {
                int semaforo=cocheSemaforo.get(ev.valor);
                Queue<String> aux_queue=new LinkedList<>();
                while (!semaforos[semaforo].isEmpty())
                {
                    String mat=semaforos[semaforo].remove();
                    if(!mat.equals(ev.valor))
                    {
                        aux_queue.add(mat);
                    }
                }
                while(!aux_queue.isEmpty())
                {
                    semaforos[semaforo].add(aux_queue.remove());
                }
                System.out.println("El coche "+ev.valor+" se ha averiado en el semaforo S"+semaforo+". Se ha avisado a la grua");
            }
            else
            {
                int semaforo=cocheSemaforo.get(ev.valor);
                semaforos[semaforo].add(ev.valor);
                System.out.println("El coche "+ev.valor+" se ha reparado y se incorpora al semaforo S"+semaforo);
            }
        }
    }
}
