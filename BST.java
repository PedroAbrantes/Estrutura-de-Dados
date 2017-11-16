package bst;

import java.util.*;
import java.lang.*;

class ABP {
    public class No {
	private int conteudo;
	private No esq;
	private No dir;
	
	public No(){
		esq = null;
		dir = null;
	}
	
	public int getConteudo() {
		return conteudo;
	}
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}
	
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	
	public No getDir() {
		return dir;
	}
	
	public void setDir(No dir) {
		this.dir = dir;
	}
    
    }
    private No raiz;
    private static int counter = 0;
	
    public ABP(){
	raiz = null;
    }
    
    public int getCounter()
    {
        return counter;
    }
	/** Verifica se a Ã¡rvore estÃ¡ vazia */
    public boolean vazia (){
	return (raiz == null);
    }

	/**Buscar recursivamente a partir da raiz.
	    Retorna o endereÃ§o se o elemento for
	    encontrado, caso contrÃ¡rio retorna NULL*/
    private No busca(No T, int valor) {
	if (T == null)
            return null;  // Arvore Vazia

	if(T.getConteudo() == valor)
            return T; 	// Elem. encontrado na raiz
		
	if (valor < T.getConteudo())
            return busca(T.getEsq(), valor);
	else
            return busca(T.getDir(), valor);
    }
	
	/**Buscar um elemento na ABP
    		Retorna o endereÃ§o se o elemento for
    		encontrado, caso contrÃ¡rio retorna NULL*/
    public No busca(int valor) {          
	if (raiz != null) 
            return busca(raiz, valor);
		
	return null;
    }
	

	/**Exibe o conteÃºdo de uma Ã¡rvore no formato in-ordem
	    (preserva a ordenaÃ§Ã£o)*/
    private void exibe (No T){
	if (T != null) {
            exibe(T.getEsq());
            System.out.print(" " + T.getConteudo());
            exibe(T.getDir());
	}
    }

    public void exibe() {
        if (raiz == null) {
            System.out.println("Arvore vazia");
        } else {
            exibe(raiz);
        }
    }
	
	/**Insere um nÃ³ em uma Ã¡rvore ABP
	    Retorna 1 se a inserÃ§Ã£o for com sucesso.
	    Caso contrÃ¡rio retorna 0*/
    
    public void insert(int x)
    {
        insert(raiz, x);		
    }
    
    private void insert(No T, int x)
    {
        
        if (raiz == null) { // Arvore vazia
            No node = new No();
            node.setConteudo(x);
            node.setEsq(null);
            node.setDir(null);
            raiz = node;
            return;
        }
        
        counter++;
        No aux = T;
        
        if (x < aux.getConteudo()) {
            if(aux.getEsq() == null)
            {
                No node = new No();
                node.setConteudo(x);
                node.setEsq(null);
                node.setDir(null);
                aux.setEsq(node);
            }
            else
                insert(aux.getEsq(), x);
        } 
        else 
        {
            if(aux.getDir() == null)
            {
                No node = new No();
                node.setConteudo(x);
                node.setEsq(null);
                node.setDir(null);
                aux.setDir(node);
            }
            else
                insert(aux.getDir(), x);
        }
                
    }
    
    /*
    public boolean insere(int valor){

        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setEsq(null);
        novoNo.setDir(null);

        if (raiz == null) { // Arvore vazia
            raiz = novoNo;
            return true;
        }
        //counter++;
        // Procura a posicao correta pra inserir o novo no
        No aux = raiz;
        No p = null;
        while (aux != null) {
            counter++;
            p = aux;
            if (valor < aux.getConteudo()) {
                aux = aux.getEsq();
            } else {
                aux = aux.getDir();
            }
        }

        // Encontrou um nÃ³ folha para inserir
        if (valor < p.getConteudo()) {
            p.setEsq(novoNo);
        } else {
            p.setDir(novoNo);
        }
        return true;
    }*/
}

class BST {

    
    public static void main(String[] args) throws java.lang.Exception{
        Scanner scan = new Scanner(System.in);
        ABP bst = new ABP();
        int n;
        try
        {  
            n = scan.nextInt();
            if(n >= 1 && n <= 300000)
            {
                int[] input = new int[n];
      
                for(int i = 0; i < n; i++)
                {
                    bst.insert(scan.nextInt());
                    input[i] = bst.getCounter();
                }
        
                for(int j = 0; j < n; j++)
                {
                    System.out.println(input[j]);
                }
            
            
            }
        } catch(Exception e){    
        }
    }
    
}
