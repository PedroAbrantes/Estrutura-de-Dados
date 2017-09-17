package edexercicio1;

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int lista[], lista2[];
	int t1, t2;
        Scanner s = new Scanner(System.in);
        t1 = s.nextInt();
        lista = new int[t1];

        
        for(int k = 0; k < t1; k++)
        {
            lista[k] = s.nextInt();
        }
        
        t2 = s.nextInt();
        lista2 = new int[t2];
        
        for(int k = 0; k < t2; k++)
        {
            lista2[k] = s.nextInt();
        }
        
        int contador = 0, contador2 = 0;
        
        for(int i = 0; i < t1; i++)
        {
            for(int j = 0; j < t2; j++)
            {
                if(lista[i] == lista2[j])
                    contador++;
            }
            if(contador == 0)
            {
                if(contador2 == 0)
                {
                    System.out.printf("" + lista[i]);
                    contador2++;
                }    
                else
                    System.out.printf(" " + lista[i]);
            }
            contador = 0;
        }
    }
}