package edexercicio2;

import java.util.*;
import java.lang.*;

class LDE2 {
	
    class No {
	private No ant;
	private String conteudo;
	private No prox;
		
	public No(){
            setProx(null);
	}
        
	public String getConteudo() {
            return conteudo;
	}

	public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
	}

	public No getProx() {
            return prox;
	}

	public void setProx(No prox) {
            this.prox = prox;
	}

	public No getAnt() {
            return ant;
	}

	public void setAnt(No ant) {
            this.ant = ant;
	}
    }
	
	private No inicio;
	private No fim;
	private int tamanho;
	
	public LDE2(){
		inicio = null;
		fim = null;		
		tamanho = 0;
	}
        
        public No getNo(int pos)
        {
            No aux = inicio;
            int cont = 1;
            while (cont < pos){
	        aux = aux.getProx();
	        cont++;
	    }
            return aux;
        }
        
        public No noAnt(int pos)
        {
            No aux = inicio;
            int cont = 1;
            while (cont < pos){
	        aux = aux.getProx();
	        cont++;
	    }
            return aux.getAnt();
        }
        
         public No noProx(int pos)
        {
            No aux = inicio;
            int cont = 1;
            while (cont < pos){
	        aux = aux.getProx();
	        cont++;
	    }
            return aux.getProx();
        }
	
        public int retornaNo(String dado)
        {
            No aux = inicio;
            int cont = 1;
            while (cont < tamanho){
                if(aux.getConteudo().equals(dado))
                {
                    break;
                }
                aux = aux.getProx();
                cont++;
	    }
            return cont;
        }
        
	public boolean vazia() {
	    if (tamanho == 0)
	        return true;
	    else
	        return false;
	}

	public int tamanho() {
	    return tamanho;
	}

	public String elemento (int pos) {
	    No aux = inicio;
	    int cont = 1;

	    if (vazia()) {
	        return "VAZIA";
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return "NAO ACHADO";
	    }

	    while (cont < pos){
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getConteudo();
	}

	public int posicao (String dado) {
	    int cont = 1;
	    No aux;

	    if (vazia()) {
	        return -1;
	    }

	    aux = inicio;
		while (aux != null) {
	        if (aux.getConteudo() == dado){
	            return cont;
	        }

	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	public boolean insereInicioLista(String valor) {
	    No novoNo = new No();
	    
	    novoNo.setConteudo(valor);
	    novoNo.setProx(inicio);
	    
	    novoNo.setAnt(null);
	    if (vazia())
    			fim = novoNo;
	    else
    			inicio.setAnt(novoNo);	    
	    
	    inicio = novoNo;
	    tamanho++;
	    return true;
	}

	public boolean insereMeioLista(int pos, String dado){
	    int cont = 1;

	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    No aux = inicio;
	    while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) { 
	    		return false;
	    }

	    novoNo.setAnt(aux);
	    novoNo.setProx(aux.getProx());
	    
	    aux.getProx().setAnt(novoNo);
	    
	    aux.setProx(novoNo);

	    tamanho++;
	    return true;
	}

	public boolean insereFimLista(String dado){
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    No aux = inicio;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);
	    
	    novoNo.setAnt(fim);
	    fim.setProx(novoNo);
	    fim = novoNo; 		
	    
	    this.tamanho++;
	    return true;
	}

	public boolean insere(int pos, String dado) {
		if ((vazia()) && (pos != 1)){
	        return false;
	    }

	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    else if (pos == tamanho+1){
	        return insereFimLista(dado);
	   }
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	private String removeInicioListaUnitaria(){          
	    String dado = inicio.getConteudo();
	    inicio = null;
	    fim = null; 
	    tamanho--;
	    return dado;
	}
	
	private String removeInicioLista(){
	    No p = inicio;

	    String dado = p.getConteudo();

	    inicio = p.getProx();
	    p.getProx().setAnt(null);
	    
	    tamanho--;

	    p = null;

	    return dado;
	}

	private String removeMeioLista(int pos){
	     No p = inicio;
	     int n = 1;
	     
	     while((n <= pos-1) && (p != null)){ 
	    	 	p = p.getProx();
	        n++;
	     }
	     
	     if (p == null) {
	    	 	return "NAO ENCONTRADO";
	     }
	     
	    	 String dado = p.getConteudo();
	    	 p.getAnt().setProx(p.getProx());
	    	 p.getProx().setAnt(p.getAnt());
			 
	     tamanho--;
	     
	    p = null;
	    return dado;
	}
	
	private String removeFimLista(){          
	     No p = fim;
	     String dado = p.getConteudo();
	     
	     fim.getAnt().setProx(null);
	     fim = fim.getAnt();
	     tamanho--;
	     
	     p = null; 
	     return dado;
	}

	

	public String remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    		return "VAZIA";
	    }

	    // RemoÃ§Ã£o do elemento da cabeÃ§a da lista 
	    if ((pos == 1) && (tamanho() == 1)){ 
	 		 return removeInicioListaUnitaria();
	    }
	    else if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remocao no fim da lista
	    else if (pos == tamanho()){ 
	 		 return removeFimLista();
	    }
	    // RemoÃ§Ã£o em outro lugar da lista
	    else{
	        return removeMeioLista(pos);
	    }
	}	
}
public class Exercicio4 {
    
    //vai montar a lista
    public static void montaLista(LDE minhaLista1, LinkedList lista2)
    {
        LDE minhaLista = new LDE();
        LinkedList <String[]> lista1 = new LinkedList();
        minhaLista = minhaLista1;
        lista1 = lista2;
        if(lista1.get(0)[1].equals("0"))
        {
            minhaLista.insere(1, lista1.get(0)[0] + "");
            minhaLista.insere(2, lista1.get(0)[2] + "");
            System.out.println("wat");
        }
        else
        {
            minhaLista.insere(1, lista1.get(0)[1]);
            minhaLista.insere(2, lista1.get(0)[0]);
            minhaLista.insere(3, lista1.get(0)[2]);
            System.out.println("wat2");
        }
        
        if(lista1.get(1)[1].equals(minhaLista.elemento(1)))
        {
            if(lista1.get(1)[2].equals("0"))
                ;                
        }
        else
        {
            if(lista1.get(1)[2].equals("0") && !lista1.get(1)[1].equals(minhaLista.elemento(1)))
            {
                minhaLista.insereFimLista(lista1.get(1)[0]);
                if(!lista1.get(1)[1].equals(minhaLista.elemento(2)))
                    minhaLista.insereMeioLista(minhaLista.retornaNo(lista1.get(1)[0]), lista1.get(1)[1]);                
            }
            else
            {
                minhaLista.insereFimLista(lista1.get(1)[2]);
                minhaLista.insere(minhaLista.retornaNo(lista1.get(1)[2]), lista1.get(1)[0]);
                minhaLista.insere(minhaLista.retornaNo(lista1.get(1)[2]) - 1, lista1.get(1)[1]);
            }
        }
        
        for(int i = 2; i < lista1.size(); i++)
        {
            boolean aux = false;
            System.out.println("oi  3");
            
            if(lista1.get(i)[2].equals(minhaLista.elemento(1)) || lista1.get(i)[1].equals("0")) //caso o primeiro entrada tiver
            {                                                                                   //o primeiro elemento como ant
                System.out.println("oi  1");
                //minhaLista.insereInicioLista(lista1.get(i)[0]);
                if(lista1.get(i)[1].equals("0"))
                    continue;
                else
                    minhaLista.insereInicioLista(lista1.get(i)[1]);
                continue;
                    
            }
            
            if(lista1.get(i)[1].equals(minhaLista.elemento(minhaLista.tamanho()))) 
            {
                System.out.println("oi  2");
                minhaLista.insereFimLista(lista1.get(i)[0]);
                if(lista1.get(i)[2].equals("0"))
                    continue;
                else
                    minhaLista.insereFimLista(lista1.get(i)[2]);
                continue;
            }
            
            for(int k = minhaLista.tamanho(); k > 0; k--)
            {
                aux = false;
                if(lista1.get(i)[2].equals(minhaLista.elemento(k)) || lista1.get(i)[0].equals(minhaLista.elemento(k)))
                {
                    //minhaLista.insere(k - 1, lista1.get(i)[0]);
                    System.out.println("oi  k = " + k);
                    if(!lista1.get(i)[1].equals("0") && !lista1.get(i)[1].equals(minhaLista.elemento(k - 2)))
                        if(lista1.get(i)[1].equals(minhaLista.elemento(k - 1)) && !lista1.get(i)[2].equals(minhaLista.elemento(k + 1)))
                            minhaLista.insere(k + 1, lista1.get(i)[2]);  
                        else    
                            minhaLista.insere(k - 1, lista1.get(i)[1]);
                    aux = true;
                }
                if(aux == true)
                    break;
            }
                
            if(aux == false)
            {
                minhaLista.insere(minhaLista.tamanho() - 1, lista1.get(i)[1]);
                minhaLista.insere(minhaLista.tamanho() - 1, lista1.get(i)[0]);
                minhaLista.insere(minhaLista.tamanho() - 1, lista1.get(i)[2]);
            }  
        }
    }
    
    //main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LDE minhaLista = new LDE();
        String s = "a";
        LinkedList <String[]> lista1 = new LinkedList();
        
        while(true)
        {
            s = scan.nextLine();
            if(!s.equals(""))
            {
                String array[] = new String[3];
                array = s.split(" ");
                lista1.add(array);
            }
            else
                break;
        }
        
        String cam1 = "", cam2 = "";
        
        int pos1, pos2;
        
        montaLista(minhaLista, lista1);        
        
        pos1 = minhaLista.retornaNo(lista1.get(0)[0]);
        pos2 = minhaLista.retornaNo(lista1.get(1)[0]);
        
        int dif;
        
        dif = minhaLista.retornaNo(lista1.get(1)[0]) - minhaLista.retornaNo(lista1.get(0)[0]);
        if(dif < 0)
            dif = -dif;
        
        if(pos1 < pos2)
        {
            for(int i = pos1; i < (pos2 - 1); i++)
            {
                cam1 = cam1 + minhaLista.elemento(i+1);
            }
        
            for(int i = pos2; i > pos1 + 1; i--)
            {
                cam2 = cam2 + minhaLista.elemento(i - 1);
            }
        }
        else
        {
            for(int i = pos2; i < dif; i++)
            {
                cam2 = cam2 + minhaLista.elemento(i+1);
            }
        
            for(int i = pos1; i > pos2 + 1; i--)
            {
                cam1 = cam1 + minhaLista.elemento(i - 1);
            }
        }
        
        int aux = cam1.length();
        
        boolean[] verifica = new boolean[aux];
        
        /*for(int i = 0; i < aux; i++)
        {
            if(cam1.charAt(i) == cam2.charAt((aux - 1) - i))
                verifica[i] = true;
            else
                verifica[i] = false;
        }
        
        int cont = 0;
        
        for(int i = 0; i < aux; i++)
        {
            if(verifica[i] == true)
                cont++;
        }    
        
        if(cam1.equals("") || cam2.equals(""))
            System.out.println("insana");
        else
        {
            if(cont == aux)
                System.out.println("sana");
            else
                System.out.println("insana");
        }*/
        /*if(minhaLista.elemento(pos1).equals(c1+"") && minhaLista.elemento(pos1-1).equals(c2+"") && minhaLista.elemento(pos1+1).equals(c3+""))
        {
            
        }
        */
        System.out.println("Pos1: " + pos1);
        System.out.println("Pos2: " + pos2);
        System.out.println("cam1: " + cam1);
        System.out.println("cam2: " + cam2);
        
        for(int i = 1; i <= minhaLista.tamanho(); i++)
        {
            System.out.println("elemento " + i + ": "+ minhaLista.elemento(i));
        }
        
        System.out.println("COM FUNÇÃO!!!");
    }
    
}
