/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject1;

/**
 *
 * @author macbookpro
 */
public class singleLinkedList {
    
    private Node pFirst;
    private Node pLast;
    private int size;

    public singleLinkedList() {
        this.pFirst = null;
        this.pLast = null;
        this.size = size;
    }
    
    public boolean isEmpty() {  
        return pFirst == null;
    }
    
    public void addFirst(int data) {
        
        Node node = new Node(data);
        
        if (this.isEmpty()) {
            this.pFirst = this.pLast = node;
        } else {
            node.setpNext(pFirst);
            pFirst = node;
        }
        size++;
    }
    
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.isEmpty()) {
            this.pFirst = this.pLast = node;
        } else {
            Node aux = pLast;
            aux.setpNext(node);
            pLast = node;
        }
        size++;
    }
    
    public void deleteFirst() {
        Node aux2 = pFirst;
        pFirst = pFirst.getpNext();
        aux2 = null;
        size--;

    }
    
    public void deleteLast() {
        
        
        if(isEmpty()){
            System.out.println("lista vacia, nada que eliminar");
        }else{
            Node pAux = pFirst;
            Node pAux2 = null;
            
            while(pAux.getpNext() != null){
                pAux2 = pAux;
                pAux = pAux.getpNext();
                System.out.println("pAux2 =>" + pAux2.getData()+"pAux=>"+pAux.getData());
            }
            pAux2.setpNext(null);
            pLast = pAux2;
            
        }size--;
    
        
    }
    
    public Node searchList(int element) { 
        Node indice;
        int i;
        if (element < 0) {
            return null;
        }
        indice = pFirst;
        for (i = 1; (i < element) && (indice != null); i++) {
            indice = indice.getpNext();
        }
        return indice;

    }
    
    public void Decreciente() {
        if (isEmpty()) {
            System.out.println("No se puede ordenar nada");
        } else {
            Node pAux = pFirst;
            Node pAux2 = pAux.getpNext();

            int i = 0;
            while (i < size) {
                if (pAux.getData() < pAux2.getData()) {
                    int aux = pAux2.getData();
                    pAux2.setData(pAux.getData());
                    pAux.setData(aux);

                    if (pAux2 == this.pFirst) {
                        pAux = pAux2;
                        pAux2 = pAux2.getpNext();
                    } else {
                        pAux = this.pFirst;
                        pAux2 = this.pFirst.getpNext();
                    }
                } else {
                    pAux = pAux2;
                    pAux2 = pAux2.getpNext();
                }
                i++;
            }

        }
    }
    
    public Node Reverse() {
        Node prev = null;
        Node current = this.pFirst;
        Node next = null;
        if (isEmpty()) {
            System.out.println("No se puede hacer más nada.");
        } else {
            while (current != null) {
                next = current.getpNext();
                current.setpNext(prev);
                prev = current;
                current = next;
            }
        }
        this.pFirst = prev;
        return this.pFirst;
    }
    
    public void InsertIn(int data, int numero) {
        Node nodito = new Node(data);
        if (this.isEmpty()) {
            this.pFirst = nodito;
        } else {
            Node aux = pFirst;
            for (int i = 0; i < numero - 1; i++) {
                aux = aux.getpNext();
            }
            nodito.setpNext(aux.getpNext());
            aux.setpNext(nodito);
        }
        size++;
    }
    
    public void print() {

        if (!this.isEmpty()) {
            Node aux = pFirst;
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getData());
                aux = aux.getpNext();
            }
        } else {
            System.out.println("La lista está vacía");
        }
    }
    
     public static singleLinkedList suma(singleLinkedList List1,singleLinkedList List2,singleLinkedList List3){
        
        
        Node pAux1 = List1.pFirst;
        Node pAux2 = List2.pFirst;
        Node pAux3 = List3.pFirst;
        singleLinkedList newList = new singleLinkedList();
        
        while(pAux1!=null || pAux2!=null || pAux3!=null){
            int element = 0;
            
            if(pAux1 != null){
                element += pAux1.getData();
                pAux1 = pAux1.getpNext();
            }
            
            if(pAux2 != null){
                element += pAux2.getData();
                pAux2 = pAux2.getpNext();
            }
            
            if(pAux3 != null){
                element += pAux3.getData();
                pAux3 = pAux3.getpNext();
            }
            
            newList.addFirst(element);
            
             
            
        }return newList;
            
    } 
     
     
     public static singleLinkedList invertir(singleLinkedList list){
         
         singleLinkedList invertida = new singleLinkedList();
         
         Node pAux = list.pFirst;
         
         while(pAux != null){
             invertida.addLast(pAux.getData());
             pAux = pAux.getpNext();
         }return invertida;
         
   
     }
    
}
