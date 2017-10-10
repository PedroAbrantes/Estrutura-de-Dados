package ed;
import java.util.*;
import java.lang.*;


class ONP {
 
   
 
    static String infixToPostfix(String infix) {
        
        final String ops = "-+/*^";
 
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
 
        for (String token : infix.split("\\s*")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);
 
            // checando os operandos
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);
 
                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append("");
                        else break;
                    }
                    s.push(idx);
                }
            } 
            else if (c == '(') {
                s.push(-2); // -2 stands for '('
            } 
            else if (c == ')') {
                // até '(' no stack, pop operandos.
                while (s.peek() != -2)
                     sb.append(ops.charAt(s.pop())).append("");
                s.pop();
            }
            else {
                sb.append(token).append("");
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append("");
        return sb.toString();
    }
     public static void main(String[] args)throws java.lang.Exception {
        String infix = null;
        
        Scanner sca = new Scanner(System.in);
        Scanner t = new Scanner(System.in);
        int aux = 0;
        String aux2;
        String teste = null;
        aux = t.nextInt();
        if(aux <= 100){
        String armazena[] = new String[aux];
        for(int i = 0; i<aux;i++){
            
           
            aux2 = sca.nextLine();
            if (aux2.length() <= 400){
                armazena[i] = aux2;
            }
            
            }
         System.out.println(); //Quebra de linha para separar a resposta
            for(int i = 0; i<aux; i++){
                infix = armazena[i];
                System.out.printf("%s%n", infixToPostfix(infix));;
            }
        
        }
    }
}