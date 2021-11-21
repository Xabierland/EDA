package tema_2.juego_colores;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Juego j=new Juego();
        ArrayList<Tirada> tiradas=new ArrayList<>(3);
        Tirada t1,t2,t3;
        t1=new Tirada(4,3); t2=new Tirada(4,1); t3=new Tirada(3,5);
        tiradas.add(t1);tiradas.add(t2);tiradas.add(t3);

        System.out.println("El ganador es el jugador: \t\t"+j.juego(5,tiradas));
        System.out.println("El ganador deveria ser: \t\t4");
    }
}
