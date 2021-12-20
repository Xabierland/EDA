package tema_2.part2.poker;

import java.util.ArrayList;
import java.util.Stack;

public class Juego
{
    public int jugar(int nJugadores, int nBilletesInicial, ArrayList<Pago> pagos)
    {
        //Creamos la estructura de datos
        Stack<Boolean>[] partida= new Stack[nJugadores];
        for(int i=0; i<nJugadores;i++)
        {
            partida[i]=new Stack<Boolean>();
        }

        //Iniciamos la partida con las codiciones recividas
        for(int i=0; i<nJugadores; i++)
        {
            for(int j=0; j<nBilletesInicial; j++)
            {
                if(i==0)
                {
                    partida[i].push(Boolean.FALSE);
                }
                else
                {
                    partida[i].push(Boolean.TRUE);
                }
            }
        }

        //Se ejecutan las ordenes de pago
        for(Pago p:pagos)
        {
            for(int n=p.cantidad;n>0;n--)
            {
                partida[p.cobrador].push(partida[p.pagador].pop());
            }
        }

        //Se cuentan los trues
        int cont=0;
        while (!partida[0].empty())
        {
            if(partida[0].pop()==Boolean.TRUE)
            {
                cont++;
            }
        }
        return cont;
    }
}
