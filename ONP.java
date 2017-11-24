package teste;

import java.util.*;
import java.lang.*;

class ONP{
    static class pilha{
        private int dados[];
        private int topo;
        private int tamMax;

        public pilha()
        {
            tamMax = 400;
            dados = new int[tamMax];
            topo = -1;
        }
        
        public int tamanho(){
            return topo + 1;
        }
        
        public boolean vazia(){
            if (topo == -1){
                return true;
            }
            else{
                return false;
            }
        }
        
        public boolean cheia(){
            if (topo == (tamMax-1))
                return true;
            else
                return false;

        }
             
        public int topo () {
            if (vazia())
            return -1; 

        return dados[topo];
        }
        
        public int pop() {
            if (vazia()){
                return -1; // Pilha vazia
            }
            int valor = dados[topo];
            topo--;
            return valor;
        }
        
        public boolean push (int valor) {
            if (cheia()){
                return false;
            }
            topo++;
            dados[topo] = valor;
            return true;
        }
        
}

    public static LinkedList<String> lista = new LinkedList<String>();
    
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
       
        
        for (int i = 0; i < n ;i++){
            String a = scan.nextLine();
            lista.add(a);
     
        }
        
        for (String str : lista){
            resultado(str);
        }  
    }
    
    public static void resultado (String str)
    {
        pilha p = new pilha();
        char equacao[] = str.toCharArray();
        
        for(int i = 0; i < str.length(); i++)
        {
            char atual = equacao[i];
           
            if (atual == '^' || atual == '(')
            {
                p.push(atual);
            
            }else if (atual == '*' || atual == '/') 
            {
		if (p.topo() != '^')
                {
                  
                    p.push(atual);
                }
	    }else if (atual == '+' || atual == '-')
            {
                if (p.topo() != '^' && p.topo() != '*' && p.topo() != '/')
                {
                  
                    p.push(atual);
                }
	    }else if ((atual == ')'))
            {
                while (p.topo() != '(')
                {
		System.out.printf("%c", p.topo());
		p.pop();
                }
                p.pop();
            }else
            {
                System.out.printf("%c", atual);
            }
        }
        
        System.out.printf("\n");  
    }
}
