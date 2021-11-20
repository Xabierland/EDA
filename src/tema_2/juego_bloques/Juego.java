package tema_2.juego_bloques;

import java.util.Stack;

public class Juego {
    Stack<Bloque>[] tablero;
    public static int numColumnas=7;

    public Juego()
    {
        tablero=(Stack<Bloque>[]) new Stack[numColumnas];
        for (int i=0;i<numColumnas;i++)
        {
            tablero[i]=new Stack<>();
        }
        //METEMOS DATOS EN EL TABLERO
        Bloque b0=new Bloque(5,3);
        Bloque b1=new Bloque(5,2);
        Bloque b2=new Bloque(5,-3);
        Bloque b3=new Bloque(5,-1);
        Bloque b4=new Bloque(5,0);
        Bloque b5=new Bloque(5,-2);
        int i=0;
        tablero[i].push(b0);tablero[i].push(b0);tablero[i].push(b0);i++;//0
        tablero[i].push(b0);tablero[i].push(b3);tablero[i].push(b0);i++;//1
        tablero[i].push(b0);tablero[i].push(b0);tablero[i].push(b0);i++;//2
        tablero[i].push(b2);tablero[i].push(b4);tablero[i].push(b1);i++;//3
        tablero[i].push(b0);tablero[i].push(b0);tablero[i].push(b2);i++;//4
        tablero[i].push(b0);tablero[i].push(b5);tablero[i].push(b2);i++;//5
        tablero[i].push(b0);tablero[i].push(b0);tablero[i].push(b0);//6
    }

    public int jugar()
    {
        int p=0;
        int i=numColumnas/2;

        while (noEstaFuera(i)&&!tablero[i].isEmpty())
        {
            Bloque b=tablero[i].pop();
            i+=b.salto;
            p+=b.puntos;
        }
        if(!noEstaFuera(i))
        {
            System.out.println("La bola a caido fuera");
            return p;
        }
        else
        {
            System.out.println("Has ganado");
            return p;
        }
    }

    private boolean noEstaFuera(int i) {
        return 0 <= i && i < numColumnas;
    }
}
