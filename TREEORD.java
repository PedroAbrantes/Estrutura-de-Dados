import java.util.*;
import java.lang.*;


 class TREEORD {
   
    public static void main(String[] args) throws java.lang.Exception
    {
       
        Scanner entrada = new Scanner(System.in);
        int no, cont= 0;
        int qtd = entrada.nextInt();
        int[] aux = new int[2];
        
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < qtd; j++)
            {
                no = entrada.nextInt();
                if(i == 0 && j == 0) 
                    aux[0] = no;
                

                if(i == 0 && j == qtd - 1)
                    aux[1] = no;
            

                if((i == 1 && j == qtd - 1) && aux[0] == no)
                    cont++;
            

                if(i == 2 && j == qtd - 1 && aux[1] == no) 
                    cont++;
            
            }
        }
        if(cont == 2)
            System.out.println("yes");
        
        else
            System.out.println("no");
        
    }
    
}
