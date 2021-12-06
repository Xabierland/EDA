package tema_4.arbol_aritmetico;

public class BTN<T> {
    T element;
    BTN<T> left, right;

    public BTN(T elem)
    {
        this.element=elem;
    }
}
