package tema_2.expresion_aritmetica;

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
        Stack<Character> Pila_operando=new Stack<>() ;

        for(Character c:exp.toCharArray())
        {
            if(c=='+'||c=='-'||c=='*'||c=='/')
            {
                Pila_operadores.push(c);
            }
            else if(Character.isDigit(c))
            {
                Pila_operando.push(c);
            }
            else if(c==')')
            {
                char yc = Pila_operando.pop();
                int y=Character.digit(yc,10);
                char xc = Pila_operando.pop();
                int x=Character.digit(xc,10);
                char op = Pila_operadores.pop();
                if(op=='+') {
                    int res=x+y;
                    Pila_operando.push(Character.forDigit(res,10));
                }
                else if(op=='-')
                {
                    int res=x-y;
                    Pila_operando.push(Character.forDigit(res,10));
                }
                else if(op=='*')
                {
                    int res=x*y;
                    Pila_operando.push(Character.forDigit(res,10));
                }
                else if(op=='/')
                {
                    int res=x/y;
                    Pila_operando.push(Character.forDigit(res,10));
                }
            }
        }
        if(Pila_operando.size()==1)
        {
            char c=Pila_operando.pop();
            double res=Character.digit(c,10);
            return res;
        }
        else
        {
            return -99999.0;
        }
    }
}
