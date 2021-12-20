package tema_2.part2.colegio;

import java.util.Queue;

public class Colegio {
    Queue<Queue<String>> alumnos;

    public void repartirRegalos(Queue<String> regalos)
    {
        while (!regalos.isEmpty())
        {
            String regalo=regalos.remove();
            Queue<String> clase=alumnos.remove();
            while (!clase.isEmpty()) {
                System.out.println("("+clase.remove()+", "+regalo);
            }
        }
    }
}
