package tema_4.arbol_tareas;

public class Main {
    public static void main(String[] args) {
        ArbolTareas at=new ArbolTareas();
        at.add("T7",5);
        at.add("T1",5);
        at.add("T3",6);
        at.add("T21",5);
        at.add("T45",5);
        at.add("T54",5);
        at.add("T33",5);
        at.add("T31",5);
        at.add("T12",5);
        at.add("T5",5);
        at.add("T10",5);
        at.add("T34",5);
        at.add("T8",5);

        System.out.println(at.coste("T1"));
    }
}
