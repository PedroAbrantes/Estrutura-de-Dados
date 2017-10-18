package exercicio3;

import java.util.*;
import java.lang.*;

class Fila {
        class No {
            private No ant;
            private int conteudo;
            private No prox;
	
            public No(){
                setProx(null);
            }

            public int getConteudo() {
                	return conteudo;
            }

            public void setConteudo(int conteudo) {
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
	private No inicio;  // aponta para o inicio da fila 
	private No fim;    	// aponta para o fim da fila  
	private int nElementos;
        public boolean isreverse = false;
	
	/** Cria uma Fila  */
	public Fila() {
            inicio = null;
            fim = null;
            nElementos = 0;
	}
        
        public void inverteFila()
        {
            No aux = inicio;
            inicio = fim;
            fim = aux;
            isreverse = !isreverse;
        }
        
	/**Verifica se a Fila estÃ¡ vazia */
	public boolean vazia () {
            if (nElementos == 0)
		return true;
            else
		return false;
	}

	/** ObtÃ©m o tamanho da Fila */
	public int tamanho () {
            return nElementos;
	}

	/** Consulta o elemento do inÃ­cio da fila
	    Retorna -1 se a fila estiver vazia */
	public int primeiro () {
            if (vazia())
		return -1; // Erro: Fila vazia 

            return inicio.getConteudo();
	}
        
        public int ultimo () {
            if (vazia())
		return -1; // Erro: Fila vazia 

            return fim.getConteudo();
	}

	/** Insere um elemento no fim de uma fila
	    Retorna false se a mem. for insuficiente, true caso contrÃ¡rio*/
	public boolean insereFim (int valor) {
            if(isreverse){
                inverteFila();
                insereInicio(valor);
                inverteFila();
                return true;
            } 
            else 
            {
                No novoNo = new No();
                novoNo.setConteudo(valor);
                novoNo.setProx(null);

                if (vazia()){    /*InserÃ§Ã£o em fila vazia */
                    inicio = novoNo;
                }
                else {
                    novoNo.setAnt(fim);
                    fim.setProx(novoNo); /* liga com a fila */
                }
                fim = novoNo; /* atualiza o novo fim */
                nElementos++;
                return true;
            }
	}
        
        public boolean insereInicio (int valor) {
            if(isreverse){
                inverteFila();
                insereFim(valor);
                inverteFila();
                return true;
            } 
            else 
            {
                No novoNo = new No();
                novoNo.setConteudo(valor);
                novoNo.setProx(null);

                if (vazia()){    /*InserÃ§Ã£o em fila vazia */
                    fim = novoNo;
                }
                else {
                    novoNo.setProx(inicio);
                    inicio.setAnt(novoNo); /* liga com a fila */
                }
                inicio = novoNo; /* atualiza o novo inicio */
                nElementos++;
                return true;
            }
	}
        
	/**Retira o elemento do inÃ­cio da fila e retorna o seu valor
	    Retorna -1 se a fila estiver vazia. */
	public void removeInicio() throws Exception{
            if (vazia()) {
	        throw new Exception("Fila vazia");
	    }
            
            if(isreverse){
                inverteFila();
                removeFim();
            }
            
            else 
            {
                int valor = primeiro();
                No p = inicio;
                if (inicio == fim){ // Fila com 1 elemento 
                    fim = null;
                    inicio = null;
                }
                else{
                    inicio = p.getProx();
                }	
		/* sugere ao garbage collector que libere a memoria
                *  da regiao apontada por p*/
                p= null;

                nElementos--;
                return;
            }
            inverteFila();
	}
        
        public void removeFim () throws Exception
        {
            if (vazia()) {
	        throw new Exception("Fila vazia");
	    }
            
            if(isreverse){
                inverteFila();
                removeInicio();
            } 
            else 
            {
                No p = fim;
                if (inicio == fim){ // Fila com 1 elemento 
                    fim = null;
                    inicio = null;
                }   
                else{
                    fim = p.getAnt();
                }	
		/* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
                p= null;
                nElementos--;
                return;
            }
            inverteFila();
        }
        
        public int front() throws Exception
        {
            int front = inicio.getConteudo();
            removeInicio();
            return front;
        }
        
        public int back() throws Exception
        {
            int back = fim.getConteudo();
            removeFim();
            return back;
        }
        
        public int elemento (int pos) {
	    No aux = inicio;
	    int cont = 1;

	    if (vazia()) {
	        return -1; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return -2; // Posicao invalida 
	    }

	    // Percorre a lista do 1o elemento atÃ© pos 
            if(!isreverse)
            {
                while (cont < pos){
                    // modifica "aux" para apontar para o proximo elemento da lista 
                    aux = aux.getProx();
                    cont++;
                }
            }
            else
            {
                while (cont < pos){
                    // modifica "aux" para apontar para o elemento anterior da lista 
                    aux = aux.getAnt();
                    cont++;
                }
            }
            
	    return aux.getConteudo();
	}
	
	
}

class Adaqueue {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        Fila minhaFila = new Fila();
        String in;
        String[] s;
        String[] command;
        int qtde;
        
        qtde = scan.nextInt();
        command = new String[qtde + 1];
        
        try{
            if(qtde > 1 && qtde <= 1000000)
            {
                for(int j = 0; j <= qtde; j++)
                {
                    command[j] = scan.nextLine();
                }
            
                for(int i = 0; i <= qtde; i++)
                {   
                    s = command[i].split(" ");
                    switch(s[0])
                    {
                        case "back":
                            if(minhaFila.vazia())
                                System.out.println("No job for Ada?");
                            else
                                System.out.println(minhaFila.back());
                            break;
                        case "front":
                            if(minhaFila.vazia())
                                System.out.println("No job for Ada?");
                            else
                                System.out.println(minhaFila.front());
                            break;
                        case "reverse":
                            minhaFila.inverteFila();
                            break;
                        case "push_back":
                            minhaFila.insereFim(Integer.parseInt(s[1]));
                            break;
                        case "toFront":
                            minhaFila.insereInicio(Integer.parseInt(s[1]));
                            break;
                    }
                }       
            }
        } catch(Exception e){
            System.out.println("No job for Ada?");    
        }
    }
}
