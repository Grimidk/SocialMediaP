/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author juanmendezl
 * @param <T>
 */

public class Node<T> {

    private T data;
    private Node next;
    private Node prev;

    /**
     * Constructor for the Node
     * @param datum
     */
    public Node(T datum) {
        this.data = datum;
        this.next = null;
        this.prev = null;
    }

    /**
     * Get Node's data
     *
     * @return the data inside Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets new data to Node
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
     /**
     *
     * @return a reference to the previous Node
     */
    public Node getPrev() {
        return prev;
    }
    
    /**
     * Sets new Node to reference to
     *
     * @param prev
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
    
    /**
     * comparar dos nodos
     *
     * @param firstNode, primer nodo a comparar
     * @param secondNode, segundo nodo a comparar
     */
    
    
    public static int comparator(Node firstNode, Node secondNode) {
        String firstClass = firstNode.getData().getClass().getSimpleName();
        String secondClass = secondNode.getData().getClass().getSimpleName();
        
        if (!firstClass.equals(secondClass)) {
            throw new Error("Nodes does not have same data or are not the same class");
        }
        
        switch (firstClass) {
            case "Integer":
                Integer firstDataInteger = (Integer)firstNode.getData();
                Integer secondDataInteger = (Integer)secondNode.getData();
                 if (firstDataInteger > secondDataInteger) {
                    return 1;
                } else if (secondDataInteger > firstDataInteger) {
                    return -1;
                } else {
                    return 0;
                }
            case "Double":
                Double firstDataDouble = (Double)firstNode.getData();
                Double secondDataDouble = (Double)secondNode.getData();
                if (firstDataDouble > secondDataDouble) {
                    return 1;
                } else if (secondDataDouble > firstDataDouble) {
                    return -1;
                } else {
                    return 0;
                }
            case "String":
                String firstDataString = (String)firstNode.getData();
                String secondDataString = (String)secondNode.getData();
                if (firstDataString.length() > secondDataString.length()) {
                    return 1;
                } else if (secondDataString.length() > firstDataString.length()) {
                    return -1;
                } else {
                    return 0;
                }
        }
        
        return 0;
    }

}