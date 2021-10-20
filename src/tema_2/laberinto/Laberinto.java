package tema_2.laberinto;

import java.util.Stack;

public class Laberinto
{
    private final int[][] laberinto={{1,1,1,0,0,1,1},{0,0,1,1,1,0,1}};

    public boolean hayCamino()
    {
        //Inicializaciones
        Stack<Casilla> porExaminar=new Stack<Casilla>();
        porExaminar.push(new Casilla(0,0));
        Casilla fin=new Casilla(laberinto.length-1,laberinto[0].length-1);
        boolean[][] visitado=new boolean[laberinto.length][laberinto[0].length];
        visitado[0][0]=true;
        boolean enc=false;

        while(!enc && !porExaminar.isEmpty())
        {
            Casilla act=porExaminar.pop();
            if(act.equals(fin))
            {
                enc=true;
            }
            else
            {
                procesarCasilla(act.x-1, act.y, porExaminar,visitado);
                procesarCasilla(act.x, act.y-1, porExaminar, visitado);
                procesarCasilla(act.x+1, act.y, porExaminar, visitado);
                procesarCasilla(act.x, act.y+1, porExaminar, visitado);
            }
        }

        return false;
    }

    private void procesarCasilla(int pX, int pY,Stack<Casilla> porExaminar, boolean[][] visitado)
    {
        Casilla nueva=new Casilla(pX,pY);

        if(dentro(nueva) && !pared(nueva) && !visitado[nueva.x][nueva.y])
        {
            porExaminar.push(nueva);
            visitado[nueva.x][nueva.y]=true;
        }
    }

    private boolean pared(Casilla nueva)
    {
        return laberinto[nueva.x][nueva.y] == 1;
    }

    private boolean dentro(Casilla nueva)
    {
        return true;
    }
}