package tema_5.simular_epidemia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Epidemia
{
    protected final int DEFAULT_CAPACITY = 10;
    protected LinkedList<Persona>[] adjList;

    public Epidemia()
    {
        adjList=new LinkedList[DEFAULT_CAPACITY];
        for(int i=0;i<DEFAULT_CAPACITY;i++)
        {
            adjList[i]=new LinkedList<>();
        }
    }

    public void simularEpidemia()
    {

    }

    public boolean contagio()
    {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public static void main(String[] args) //CADA EJECUCION ES DIFERENTE
    {
        new Epidemia().simularEpidemia();
    }

    private class Persona
    {
        String nombre;
        boolean infectada; //Al principio false
        ArrayList<Persona> contactos;
    }
}
