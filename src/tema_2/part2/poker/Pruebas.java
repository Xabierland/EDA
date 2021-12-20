package tema_2.part2.poker;

import java.util.ArrayList;

public class Pruebas
{
    public static void main(String[] args)
    {
        Juego game = new Juego();
        ArrayList<Pago> pagos=new ArrayList<>();
        Pago p1=new Pago(0,1,10);
        Pago p2=new Pago(1,2,15);
        Pago p3=new Pago(2,0,2);
        Pago p4=new Pago(1,2,20);
        Pago p5=new Pago(1,0,2);
        Pago p6=new Pago(2,0,5);
        pagos.add(p1);pagos.add(p2);pagos.add(p3);
        pagos.add(p4);pagos.add(p5);pagos.add(p6);

        System.out.println(game.jugar(3,30,pagos));
    }
}
