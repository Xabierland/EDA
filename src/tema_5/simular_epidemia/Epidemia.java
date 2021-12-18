package tema_5.simular_epidemia;

import java.util.*;

public class Epidemia
{
    Persona Jon; Persona Ana; Persona Isa; Persona Peio; Persona Iker; Persona Peru; Persona Fer; Persona Tim; Persona Elsa; Persona Dan;
    public Epidemia()
    {
        Jon=new Persona("Jon");
        Ana=new Persona("Ana");
        Isa=new Persona("Isa");
        Peio=new Persona("Peio");
        Iker=new Persona("Iker");
        Peru=new Persona("Peru");
        Fer=new Persona("Fer");
        Tim=new Persona("Tim");
        Elsa=new Persona("Elsa");
        Dan=new Persona("Dan");
        Jon.contactos.add(Ana);Jon.contactos.add(Peru);
        Ana.contactos.add(Peio);Ana.contactos.add(Isa);Ana.contactos.add(Jon);
        Isa.contactos.add(Ana);Isa.contactos.add(Iker);Isa.contactos.add(Dan);
        Peio.contactos.add(Ana);Peio.contactos.add(Iker);
        Iker.contactos.add(Peio);Iker.contactos.add(Isa);Iker.contactos.add(Fer);Iker.contactos.add(Peru);
        Peru.contactos.add(Jon);Peru.contactos.add(Fer);Peru.contactos.add(Tim);Peru.contactos.add(Iker);
        Tim.contactos.add(Peru);
        Fer.contactos.add(Iker);Fer.contactos.add(Peru);Fer.contactos.add(Elsa);
        Elsa.contactos.add(Fer);Elsa.contactos.add(Dan);
        Dan.contactos.add(Elsa);Dan.contactos.add(Isa);

    }

    public void simularEpidemia()
    {
        Queue<Persona> porEx=new LinkedList<>();
        HashSet<Persona> examinados=new HashSet<>();

        Jon.infectada=true;
        System.out.println(Jon.nombre+" \tHA SIDO INFECTO\n");
        porEx.add(Jon);
        examinados.add(Jon);

        while (!porEx.isEmpty())
        {
            Persona act=porEx.remove();
            for(Persona p:act.contactos)
            {
                if(!examinados.contains(p))
                {
                    if(act.infectada&&contagio())
                    {
                        p.infectada=true;
                        porEx.add(p);
                        examinados.add(p);
                        System.out.println(act.nombre+" \tSI HA INFECTADO A  \t"+p.nombre);
                    }
                    else
                    {
                        porEx.add(p);
                        examinados.add(p);
                        System.out.println(act.nombre+ " \tNO HA INFECTADO A \t"+p.nombre);
                    }
                }
            }
        }
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

        public Persona(String nom)
        {
            nombre=nom;
            infectada=false;
            contactos=new ArrayList<>();
        }
    }
}
