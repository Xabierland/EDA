package tema_2.puerto;

import java.util.Queue;

public class Barco {
    int tipo; //0 (descarga), 1 (carga)
    String nombre;
    Queue<Peticion> peticiones;
}
