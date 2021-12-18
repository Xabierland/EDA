package tema_5.terremoto;

import java.util.*;

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
        ArrayList<String> afectados=new ArrayList<>();
        Queue<String> porEx=new LinkedList<>();
        HashMap<String, Integer> intensidades=new HashMap<>();
        boolean[] examinados=new boolean[numVertices];

        porEx.add(c);
        examinados[index(c)]=true;
        intensidades.put(c,intensidad);

        while (!porEx.isEmpty()&&intensidad>1)
        {
            String act=porEx.remove();
            for(int i=0;i<numVertices;i++)
            {
                if(adjMatrix[index(act)][i]&&!examinados[i])
                {
                    porEx.add(vertices[i]);
                    examinados[i]=true;
                    intensidades.put(vertices[i],intensidades.get(act)/2);
                }
            }
        }
        for(Map.Entry<String,Integer> entry : intensidades.entrySet())
        {
            if(entry.getValue()>1)
            {
                afectados.add(entry.getKey());
            }
        }
        return afectados;
    }
}