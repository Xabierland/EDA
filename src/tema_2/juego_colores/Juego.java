package tema_2.juego_colores;

import java.util.*;

public class Juego {
    Queue<Integer>[] jugadores;
    Stack<Integer> mesa;

    public int juego(int n, ArrayList<Tirada> tiradas)
    {
        jugadores=new ArrayDeque[5];
        for(int i=0; i<5; i++)
        {
            jugadores[i] = new ArrayDeque<>();
            for(int j=0; j<n; j++)
            {
                jugadores[i].add(i);
            }
        }
        mesa=new Stack<>();

    }
}
