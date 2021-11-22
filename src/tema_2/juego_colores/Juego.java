package tema_2.juego_colores;

import java.util.*;

public class Juego {
    static int numJugadores=5;
    Deque<Integer>[] jugadores;
    Stack<Integer> mesa;

    public int juego(int n, ArrayList<Tirada> tiradas)
    {
        jugadores=new ArrayDeque[numJugadores+1];
        for(int i=0; i<numJugadores+1; i++)
        {
            jugadores[i] = new ArrayDeque<>();
            for(int j=0; j<n; j++)
            {
                jugadores[i].add(i);
            }
        }
        mesa=new Stack<>();

        int i=0;
        boolean fin=false;
        Tirada t;
        while (i<tiradas.size()&&!fin)
        {
            t=tiradas.get(i);
            if(t.dado1==6)
            {
                fin=true;
            }
            else if(t.dado1%2==0)
            {
                if(!jugadores[t.dado2-1].isEmpty())
                {
                    mesa.push(jugadores[t.dado2-1].removeLast());
                }
            }
            else
            {
                if(!mesa.isEmpty())
                {
                    jugadores[t.dado2-1].addFirst(mesa.pop());
                }
            }
            i++;
        }
        int ganador=0;
        int puntos=0;
        int aux_puntos;
        for(int x=1;x<numJugadores;x++)
        {
            aux_puntos=0;
            Deque<Integer> qi=jugadores[x];
            for(Integer z:qi)
            {
                if(z==0)
                    aux_puntos++;
            }
            if(aux_puntos>puntos)
            {
                ganador=x;
                puntos=aux_puntos;
            }
        }
        return ganador;
    }
}
