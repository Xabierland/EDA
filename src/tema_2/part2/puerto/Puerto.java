package tema_2.part2.puerto;

import java.util.Queue;
import java.util.Stack;

public class Puerto {
    Stack<String>[] muelles;

    public void simularPuerto(Queue<Barco> barcos, int maxPeticiones, int numMuelles)
    {
        // Pre: maxPeticiones es el número máximo de peticiones que se pueden atender en
        // el turno de un barco
        // Pre: numMuelles es el número de muelles del puerto (>=2). El muelle 0 es especial
        // Post: se ha simulado la actividad del puerto, atendiendo las peticiones de los barcos
        muelles=new Stack[numMuelles];
        for(int i=0;i<numMuelles;i++)
        {
            muelles[i]=new Stack<>();
        }

        while(!barcos.isEmpty())
        {
            Barco unBarco=barcos.remove();
            if(unBarco.tipo==0) //BARCO DE DESCARGA
            {
                int numPeticiones=0;
                while(numPeticiones<maxPeticiones && !unBarco.peticiones.isEmpty())
                {
                    Peticion unaPeticion = unBarco.peticiones.remove(); //Se van guardando las peticiones
                    int unMuelle = unaPeticion.muelle;
                    if(unMuelle<=numMuelles && unMuelle>=2)     //Solo si es muelle correcto
                    {
                        muelles[unMuelle].add(unaPeticion.codigoDeContenedor);
                    }
                    numPeticiones++;
                }
                if(!unBarco.peticiones.isEmpty())
                {
                    barcos.add(unBarco);    //Volvemos a meter el barco porque quedan peticiones por ejecutar
                }
            }
            else                //BARCO DE CARGA
            {
                for(int i=unBarco.peticiones.size();i>0;i--)
                {
                    Peticion unaPeticion = unBarco.peticiones.remove(); //Se van guardado las peticiones
                    int unMuelle = unaPeticion.muelle;
                    if(unMuelle<=numMuelles && unMuelle>=2)
                    {
                        boolean enc=false;
                        while (!enc && !muelles[unMuelle].isEmpty())
                        {
                            if(muelles[unMuelle].peek().equals(unaPeticion.codigoDeContenedor))
                            {
                                Peticion p= new Peticion(muelles[unMuelle].pop(),unMuelle);
                                unBarco.peticiones.add(p);
                                enc=true;
                            }
                            else
                            {
                                muelles[0].push(muelles[unMuelle].pop());
                            }
                        }
                        while (!muelles[0].isEmpty())
                        {
                            muelles[unMuelle].push(muelles[0].pop());
                        }
                    }
                }
            }
        }
    }
}
