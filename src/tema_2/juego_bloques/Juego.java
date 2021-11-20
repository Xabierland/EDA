package tema_2.juego_bloques;

import java.util.Stack;

public class Juego {
    Stack<Bloque>[] tablero;
    public static int numColumnas;

    public Juego()
    {
        tablero=(Stack<Bloque>[]) new Stack[numColumnas];
        for (int i=0;i<numColumnas;i++)
        {
            tablero[i]=new Stack<>();
        }
        //METEMOS DATOS EN EL TABLERO
        
    }

    public int jugar()
    {
        int p=0;
        int i=numColumnas/2;

        while (!estaFuera(i)&&!tablero[i].isEmpty())
        {
            Bloque b=tablero[i].pop();
            i+=b.salto;
            p+=b.puntos;
        }
        if(estaFuera(i))
        {
            System.out.print("La bola a caido fuera");
            return p;
        }
        else
        {
            System.out.print("Has ganado");
            return p;
        }
    }

    private boolean estaFuera(int i) {
        return 0 <= i && i < numColumnas;
    }
}
