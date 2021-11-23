package tema_4.arbol_tareas;

public class BTN
{
    Tarea element;
    BTN left,right;

    public BTN(String pId, int pCoste)
    {
        element= new Tarea(pId, pCoste);
    }

}
