package edexercicio1;

import java.util.*;
import java.lang.*;

class LSEGen<T> {
	
	class No {
		private T conteudo;
		private No prox;
		
		public No(){
			setProx(null);
		}

		public T getConteudo() {
			return conteudo;
		}

		public void setConteudo(T conteudo) {
			this.conteudo = conteudo;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}
	}
	
	private No cabeca;
	private int tamanho;
	
	public LSEGen(){
		cabeca = null;
		tamanho = 0;
	}
	
        public boolean vazia() {
	    if (tamanho == 0)
	        return true;
	    else
	        return false;
	}
        
        private boolean insereInicioLista(T valor) { 
	    No novoNo = new No();
	    
	    novoNo.setConteudo(valor);
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    tamanho++;
	    return true;
	}
        
        private boolean insereMeioLista(int pos, T dado){
	    int cont = 1;

	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    No aux = cabeca;
	    while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {
	    		return false;
	    }
            novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);

	    tamanho++;
	    return true;
        }
        
        private boolean insereFimLista(T dado){ 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.tamanho++;
	    return true;
	}
        public boolean insere(int pos, T dado) {
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
        
        public int tamanho() {
	    return tamanho;
	}
        
        public T elemento (int pos) {
	    No aux = cabeca;
	    int cont = 1;

	    if (vazia()) {
	        return null; 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return null;
	    }
 
	    while (cont < pos){ 
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getConteudo();
	}

}

public class EDExercicio2 {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        LSEGen<String> lista1;
        lista1 = new LSEGen<String>();
        LSEGen<String> lista2;
        lista2 = new LSEGen<String>();
        
        int n = s.nextInt();
        int q = s.nextInt();
    
        for(int i = 0; i <= n; i++)
        {
            String dado = s.nextLine();
            lista1.insere(i + 1, dado);
        }
               
        for(int i = 0; i < q; i++)
        {
            String dado = s.nextLine();
            lista2.insere(i + 1, dado);
        }
        
        int contador = 0;
        
        for(int i = 0; i < q; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(lista1.elemento(j+1).indexOf(lista2.elemento(i+1)) == 0)
                {
                    contador ++;
                }
            }
            System.out.println(contador);
            contador = 0;
        }
    }
}
