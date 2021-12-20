package tema_2.part1.cartas;

import java.util.Arrays;
import java.util.Iterator;

public class Baraja
{
    private Carta[] cartas;

    public Iterator<Carta> iterador()
    {
        return Arrays.stream(cartas).iterator();
    }
}
