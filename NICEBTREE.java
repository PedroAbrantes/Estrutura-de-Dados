import java.util.*;
import java.lang.*;


class NICEBTREE {
    public static int i;
    public static char[] k = new char[1000];
    
    public static void main(String[] args) throws java.lang.Exception
    {
        
        Scanner entrada = new Scanner(System.in);
        int qtde = entrada.nextInt();
        while(qtde > 0)
        {
            String palavra = entrada.next();
            k = palavra.toCharArray();
            i = 0;
            System.out.println(lenght() - 1);
            qtde--;
        }
    }
    
    public static int lenght()
    {
         if(k[i++] == 'l')
             return 1;
         
         else
             return max(lenght(), lenght()) + 1;
         
    }
    
    public static int max(int a, int b)
    {
        if(a > b)
            return a;
        
        else
            return b;
        
    }
}