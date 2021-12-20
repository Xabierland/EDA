package tema_2.part2.expresion_aritmetica;

import java.util.Stack;

public class Djikstra
{
    public double evaluar(String exp)
    {
        //Pre:  La expresion aritmetica es correcta.
        //      La expresion esta Totalmente parentizada, es decir,
        //          por cada pareja de operandos se tienen parentesis
        //      Todos los operadores son binarios (de la forma "X OPERADOR Y")
        //Pos:  El resultado es el valor de la expresion
        Stack<Character> Pila_operadores=new Stack<>();
        Stack<Integer> Pila_operando=new Stack<>() ;

        for(Character c:exp.toCharArray())
        {
            if(c=='+'||c=='-'||c=='*'||c=='/')
            {
                Pila_operadores.push(c);
            }
            else if(Character.isDigit(c))
            {
                Pila_operando.push(Character.digit(c,10));
            }
            else if(c==')')
            {
                int y = Pila_operando.pop();
                int x = Pila_operando.pop();
                char op = Pila_operadores.pop();
                if(op=='+') {
                    int res=x+y;
                    Pila_operando.push(res);
                }
                else if(op=='-')
                {
                    int res=x-y;
                    Pila_operando.push(res);
                }
                else if(op=='*')
                {
                    int res=x*y;
                    Pila_operando.push(res);
                }
                else if(op=='/')
                {
                    int res=x/y;
                    Pila_operando.push(res);
                }
            }
        }
        if(Pila_operando.size()==1)
        {
            return Pila_operando.pop();
        }
        else
        {
            return -99999.0;
        }
    }
}
