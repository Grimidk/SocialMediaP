/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author juanmendezl
 * 
 */
public class User {
    private String name;
    private String id;
    private int numRelations;
    
    /**
     * Constructor for a new User 
     * @param id
     * @param name
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.numRelations = 0;
        
    }
    
    /**
     * Sets the name of the user
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the name of the user
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets the id of the user
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * Returns the id of the user
     * @return
     */
    public String getId(){
        return this.id;
    }
    
    /**
     * Returns the number of relations of the user
     * @return
     */
    public int getNumRelations(){
        return this.numRelations;
    }
    
    /**
     * Add a relation to the total
     * @param id
     */
    public void addRelations(String id){
        this.numRelations++;
    }
    
    /**
     * Deletes a relation from the total
     * @param id
     */
    public void delRelations(String id){
        this.numRelations--;
    }
}