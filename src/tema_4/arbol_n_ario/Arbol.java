package tema_4.arbol_n_ario;

public class Arbol
{
    BTN<Integer> root;

    private class Pareja
    {
        boolean enc;
        int pos;

        public Pareja(boolean pEnc, int pPos)
        {
            enc=pEnc;pos=pPos;
        }
    }

    public boolean esta(Integer elem)
    {
        //post: el resultado es true si elem esta en el arbol
        //      y false si no.
        BTN<Integer> act=root;
        boolean enc=false;
        while (!enc&&act!=null)
        {
            Pareja p=buscar(elem, act.valores);
            if(p.enc)
            {
                enc=true;
            }
            else
            {
                act=act.hijos[p.pos];
            }
        }
        return enc;
    }

    private Pareja buscar(Integer x, Integer[] t)
    {
        int i=0;
        boolean esta=false;
        boolean mayor=false;
        while(i<t.length && !esta && !mayor)
        {
            if(x.compareTo(t[i])==0)
            {
                esta=true;
            }
            else if(x.compareTo(t[i])<0)
            {
                mayor=true;
            }
            else
            {
                i++;
            }
        }
        if(mayor)
        {
            return new Pareja(false, i);
        }
        else if(esta)
        {
            return new Pareja(true,i);
        }
        else
        {
            return new Pareja(false, i+1);
        }
    }
}
