package tema_3.esta_array;

public class main {

    public boolean esta(int[] a, int elem)
    {
        //pre: a esta ordenado ascendentemente
        return esta(a,elem,0,a.length-1);
    }

    private boolean esta(int[] a, int elem, int com, int fin)
    {
        if(fin<com)
        {
            return false;
        }
        else
        {
            int mitad=(com+fin)/2;
            if(a[mitad]==elem)
            {
                return true;
            }
            else
            {
                if(a[mitad]<elem)
                {
                    esta(a, elem, mitad+1, fin);
                }
                else
                {
                    esta(a, elem, com, mitad-1);
                }
            }
        }
    }
}
