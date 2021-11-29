package tema_5.graph;

import java.util.LinkedList;

public class GraphAL<T>
{
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected LinkedList<Integer>[] adjList;
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
}
