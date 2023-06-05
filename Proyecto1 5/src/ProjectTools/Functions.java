/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectTools;
import ProjectClasses.*;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author juanmendezl
 *  Por Juan Mendez y Hugo Duque
 */
public class Functions {
    
    public static String readTxt() {
        String line;
        String data = "";
        
        JFileChooser fc= new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();

        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    if (!(line.isEmpty())) {
                        data += line + "\n";
                    }
                }
                br.close();
            }
            return data;
        } catch (Exception e) {
        }
        return data;
    } 
    
    public static Graph Parse(String data){
        try{
            String[] parsed = data.split("\n");
            Graph grafo = new Graph();
            int i = 0;
            while (i < parsed.length){
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
        }catch(Exception e){
            System.out.println(e);
        return null;
        }
    }

    public static void writetxt(Graph grafo){
        JFileChooser fc= new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
            try{
                PrintWriter output = new PrintWriter(file);
                output.print("");
                output.append("Usuarios"+"\n");
                Node temp = grafo.getVertices().head;
                while (temp != null){
                     String aux = (String) temp.getData();
                     String[] splits = aux.split("//");
                     output.append(splits[0]+", "+splits[1]+"\n");
                     temp = temp.getNext();
                }
                output.append("Relaciones"+"\n");
                Node temporal = grafo.getEdges().head;
                while (temporal != null){
                     String auxiliary = (String) temporal.getData();
                     String[] splitten = auxiliary.split("//");
                     output.append(splitten[0]+", "+splitten[1]+", "+splitten[2]+"\n");
                     temporal = temporal.getNext();
                }
                output.close();
                JOptionPane.showMessageDialog(null, "exportado exitosamente");
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "error no se ha podido exportar la data");
            }
        }
    
        public static void addusertxt(){
            try {
                String data = Functions.readTxt();
                Graph grafo = Functions.Parse(data);
                String userid = JOptionPane.showInputDialog(null,"Id del Usurario: ", "Id");
                System.out.println(userid);
                String username = JOptionPane.showInputDialog(null,"Nombre del Usurario: ", "Nombre");
                System.out.println(username);
                User user = new User(userid , username);
                grafo.addUser(user);
                Functions.writetxt(grafo);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "algo paso pero palante ");
            }
        }
        
        public static void delusertxt(){
            try {
                String data = Functions.readTxt();
                Graph grafo = Functions.Parse(data);
                String userid = JOptionPane.showInputDialog(null,"Id del Usurario: ", "Id");
                System.out.println(userid);
                String username = JOptionPane.showInputDialog(null,"Nombre del Usurario: ", "Nombre");
                System.out.println(username);
                User user = new User(userid , username);
                grafo.delUser(user);
                Functions.writetxt(grafo);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "algo paso pero palante");
            }
        }
        
        public static void addedgetxt(){
            try {
                String data = Functions.readTxt();
                Graph grafo = Functions.Parse(data);
                String edgeorigin = JOptionPane.showInputDialog(null,"Id del Usurario Origen: ", "Id");
                System.out.println(edgeorigin);
                String edgedestination = JOptionPane.showInputDialog(null,"Id del Usurario Destino: ", "Id");
                System.out.println(edgedestination);
                String edgedistance = JOptionPane.showInputDialog(null,"Distancia de la relacion: ", "Distance");
                System.out.println(edgedistance);
                Edge edge = new Edge(edgeorigin , edgedestination, edgedistance);
                grafo.addEdge(edge);
                Functions.writetxt(grafo);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "algo paso pero palante");
            }
        }
        
        public static void deledgetxt(){
            try {
                String data = Functions.readTxt();
                Graph grafo = Functions.Parse(data);
                String edgeorigin = JOptionPane.showInputDialog(null,"Id del Usurario Origen: ", "Id");
                System.out.println(edgeorigin);
                String edgedestination = JOptionPane.showInputDialog(null,"Id del Usurario Destino: ", "Id");
                System.out.println(edgedestination);
                String edgedistance = JOptionPane.showInputDialog(null,"Distancia de la relacion: ", "Distance");
                System.out.println(edgedistance);
                Edge edge = new Edge(edgeorigin , edgedestination, edgedistance);
                grafo.delEdge(edge);
                Functions.writetxt(grafo);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "algo paso pero palante");
            }
        }
}