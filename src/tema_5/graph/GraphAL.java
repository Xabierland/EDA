package tema_5.graph;

import java.util.*;

public class GraphAL<T>
{
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected LinkedList<Integer>[] adjList;
    protected boolean[][] adjMatrix;
    protected HashMap<T, ArrayList<T>> g=new HashMap<>();
    protected T[] vertices;

    public GraphAL()
    {
        numVertices=0;
        vertices=(T[]) new Object[DEFAULT_CAPACITY];
        adjList= new LinkedList[DEFAULT_CAPACITY];
        for(int i=0;i<adjList.length;i++)
        {
            adjList[i]=new LinkedList<Integer>();
        }
    }

    public boolean conectadosEnLista(T x, T y)
    {
        Queue<Integer> porExaminar = new LinkedList<>();
        boolean[] examinados=new boolean[numVertices]; //Java lo pone a False automaticamente, otros lenguajes no.

        int posX=buscar(x);
        int posY=buscar(y);
        boolean enc=false;
        porExaminar.add(posX);
        examinados[posX]=true;
        while(!porExaminar.isEmpty() && !enc)
        {
            int act=porExaminar.remove();
            if(act==posY)
            {
                enc=true;
            }
            else
            {
                for(int i:adjList[act])
                {
                    if(!examinados[i])
                    {
                        porExaminar.add(i);
                        examinados[i]=true;
                    }
                }
            }
        }
        return enc;
    }

    public boolean conectadosEnMatriz(T x, T y)
    {
        Queue<Integer> porExaminar = new LinkedList<>();
        boolean[] examinados=new boolean[numVertices]; //Java lo pone a False automaticamente, otros lenguajes no.

        int posX=buscar(x);
        int posY=buscar(y);
        boolean enc=false;
        porExaminar.add(posX);
        examinados[posX]=true;
        while(!porExaminar.isEmpty() && !enc)
        {
            int act=porExaminar.remove();
            if(act==posY)
            {
                enc=true;
            }
            else
            {
                for(int i=0; i<numVertices;i++)
                {
                    if (adjMatrix[act][i] && !examinados[i])
                    {
                        porExaminar.add(i);
                        examinados[i]=true;
                    }
                }
            }
        }
        return enc;
    }

    public boolean conectadosEnMap(T x, T y)
    {
        Queue<T> porExaminar=new LinkedList<>();
        HashSet<T> examinados=new HashSet<>();
        porExaminar.add(x);
        examinados.add(x);
        boolean enc=false;

        while (!porExaminar.isEmpty() && !enc)
        {
            T act=porExaminar.remove();
            if(act.equals(y))
            {
                enc=true;
            }
            else
            {
                for(T t:g.get(act))
                {
                    if(!examinados.contains(t))
                    {
                        porExaminar.add(t);
                        examinados.add(t);
                    }
                }
            }
        }
        return enc;
    }

    private int buscar(T x)
    {
        return 0;       //FALTARIA POR IMPLEMENTAR
    }
}
