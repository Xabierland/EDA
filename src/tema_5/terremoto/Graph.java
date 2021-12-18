package tema_5.terremoto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph
{
    protected final int DEFAULT_CAPACITY=100;
    protected int numVertices;
    protected boolean[][] adjMatrix;
    protected String[] vertices;

    public int index(String t)
    {
        return 0;   //NO HAY QUE IMPLEMENTARLO
    }

    public ArrayList<String> comarcasAfectas(int intensidad, String c)
    {
        Queue<String> porEx=new LinkedList<>();
        boolean[] examinados=new boolean[numVertices];

        porEx.add(c);
        examinados[index(c)]=true;

        while (!porEx.isEmpty()&&intensidad<1)
        {
            String act=porEx.remove();
            
        }
    }
}