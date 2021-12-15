package tema_4.arbol_genealogico;

import java.util.HashMap;

//ESTE EJERCICIO ESTA BIEN SI TENEMOS EN CUENTA QUE LOS ANTECESORES ESTAN POR ENCIMA EN EL ARBOL
public class ArbolGenealogico {
    BTN<Persona> root;

    public boolean esVizcainoDePuraCepa(String nombre, HashMap<String, String> localidades)
    {
        HashMap<BTN<Persona>,BTN<Persona>> path=new HashMap<>();
        path.put(root,null);
        BTN<Persona> objetivo=find(nombre,root,path);
        if(objetivo!=null)
        {
            if(!localidades.get(objetivo.data.localidadNacimiento).equals("Bizkaia"))
            {
                return false;
            }
            else
            {
                boolean bizkaino=true;
                while (path.get(objetivo)!=null&&bizkaino)
                {
                    BTN<Persona> antecesor=path.get(objetivo);
                    if(!localidades.get(antecesor.data.localidadNacimiento).equals("Bizkaia"))
                    {
                        bizkaino=false;
                    }
                    objetivo=antecesor;
                }
                return bizkaino;
            }
        }
        else
        {
            return false;
        }
    }

    private BTN<Persona> find(String nombre, BTN<Persona> a, HashMap<BTN<Persona>,BTN<Persona>> path)
    {
        if(a==null)
        {
            return null;
        }
        else if(a.data.nombre.equals(nombre))
        {
            return a;
        }
        else
        {
            path.put(a.left,a);
            path.put(a.right,a);
            BTN<Persona> b=find(nombre,a.left,path);
            if(b!=null)
            {
                return b;
            }
            else
            {
                return find(nombre,a.right,path);
            }
        }
    }
}
