/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author juanmendezl
 */
public class Edge {
    private String origin;
    private String destination;
    private String distance;
    
    /**
     * Constructor for a new edge 
     * @param origin
     * @param destination
     * @param distance
     */
    public Edge(String origin, String destination, String distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    } 
    
    /**
     * Sets the origin user of the edge
     * @param origin
     */
    public void setOrigin(String origin){
        this.origin = origin;
    }
    
    /**
     * Returns the origin of the edge
     * @return
     */
    public String getOrigin(){
        return this.origin;
    }
    
    /**
     * Sets the destination user of the edge
     * @param destination
     */
    public void setDestination(String destination){
        this.destination = destination;
    }
    
    /**
     * Returns the destination of the edge
     * @return
     */
    public String getDestination(){
        return this.destination;
    }
    
    /**
     * Sets the distance of the edge
     * @param distance
     */
    public void setDistance(String distance){
        this.distance = distance;
    }
    
    /**
     * Returns the distance of the edge
     * @return
     */
    public String getDistance(){
        return this.distance;
    }
    
    /**
     * Flips the origin and destination users 
     * @return 
     */
    public Edge flipOrigin(){
        String temp = this.origin;
        String aux = this.destination;
        Edge flipped = new Edge(aux,temp,this.distance);
        return flipped;
    }
    
    /**
     * Boolean that tells if the edge is self-related
     * @return 
     */
    public boolean isSelfRelated(){
        return this == this.flipOrigin();  
    }
}
