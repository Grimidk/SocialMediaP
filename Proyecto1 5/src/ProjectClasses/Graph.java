/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author juanmendezl
 * Por Juan Mendez y Hugo Duque
 */
public class Graph {
    private ListSimple vertices;
    private ListSimple edges;
    private int numVertices;
    private int numEdges;
   
    /**
     * Constructor for the Graph with 0 Users
     */
    public Graph() {
        this.vertices = new ListSimple();
        this.edges = new ListSimple();
        this.numVertices = 0;
        this.numEdges = 0;
    }
    
    /**
     * Constructor for the Graph with 1 User
     * @param user
     */
    public Graph(User user) {
        Node aux = new Node(user.getId() + "//" + user.getName());
        this.vertices = new ListSimple(aux);
        this.edges = null;
    }
    
    /**
     * Prints the list of User
     */
    public void printVertices(){
        this.vertices.print();
    }
    
    /**
     * Prints the list of Relations
     */
    public void printEdges(){
        this.edges.print();
    }
    
    /**
     * Returns the number of Users
     * @return 
     */
    public int getNumVertices(){
        return this.numVertices;
    }
    
    /**
     * Returns the number of Edges
     * @return 
     */
    public int getNumEdges(){
        return this.numEdges;
    }
    
    /**
     * Returns the Users
     * @return 
     */
    public ListSimple getVertices(){
        return this.vertices;
    }
    
    /**
     * Returns the Edges
     * @return 
     */
    public ListSimple getEdges(){
        return this.edges;
    }
    
    /**
     * Adds an User to the graph
     * @param user
     */
    public void addUser(User user){
        String aux = user.getId() + "//" + user.getName();
        this.vertices.addLast(aux);
        this.numVertices++;
    }
    
    /**
     * Deletes an User from the graph
     * @param user que deseamos eliminar
     */
    public void delUser(User user){
        Node aux = new Node(user.getId() + "//" + user.getName());
        int I = this.vertices.getIndex(aux);
        if (I != -1) {
            this.vertices.delete(I);
            this.numVertices--;
        }
    }
    
    /**
     * Adds an Edge to the graph
     * @param edge, que deseamos agregar al grafo
     */
    public void addEdge(Edge edge){
        String aux = edge.getOrigin() + "//" + edge.getDestination() + "//" + edge.getDistance();
        this.edges.addLast(aux);
        this.numEdges++;
    }
    
    /**
     * Deletes an Edge from the graph
     * @param edge que deseamo eliminar
     */
    public void delEdge(Edge edge){
        Node aux = new Node(edge.getOrigin() + "//" + edge.getDestination() + "//" + edge.getDistance());
        int I = this.edges.getIndex(aux);
        if (I != -1) {
            this.edges.delete(I);
            this.numEdges--;
        }
    }
    
    /**
     * Boolean to check if two users are related
     * @param origin
     * @param destination
     * @return
     */
    public boolean isAdjacent(User origin, User destination){
        String oriAux = origin.getId();
        String desAux = destination.getId();
        Node edge = this.edges.head;
        while (edge != null){
            String temp = (String) edge.getData();
            String[] splits = temp.split("//");
            if (splits[2].equals(oriAux) & splits[0].equals(desAux) | splits[0].equals(oriAux) & splits[2].equals(desAux)){
                return true;
            } else {
                edge = edge.getNext();
            }
        }
        return false;
    }
}
