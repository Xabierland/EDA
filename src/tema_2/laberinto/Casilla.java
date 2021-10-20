package laberinto;

import java.util.Objects;

public class Casilla
{
    int x;
    int y;

    public Casilla(int pX, int pY)
    {
        this.x=pX;
        this.y=pY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casilla casilla = (Casilla) o;
        return x == casilla.x && y == casilla.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
