/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectTools;

import ProjectClasses.Edge;
import ProjectClasses.Graph;
import ProjectClasses.User;

/**
 *
 * @author juanmendezl
 */
public class Parser {
    public static Graph Parse(String data){
        String[] parsed = data.split("\n");
        Graph grafo = new Graph();
        int i = 0;
        while (i <= parsed.length){
            String[] line = parsed[i].split(", ");
            if (line.length == 2){
                String id = line[0];
                String name = line[1];
                User user = new User(id,name);
                grafo.addUser(user);
                System.out.println(id+"  "+name);
            } else if (line.length == 3){
                String origin = line[0];
                String destination = line[1];
                String distance = line[2];
                Edge edge = new Edge(origin,destination,distance);
                grafo.addEdge(edge);
                System.out.println(origin+"  "+destination+"  "+distance);
            } else {
                System.out.println("nada");
            }
            i++;
        }
        return grafo;
    }
}
