/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication.Logic.Socket;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class CompareProjects {

    private int port;
    private ArrayList<String> proyectOne;
    private ArrayList<String> proyectTwo;
    private JButton button;

    public CompareProjects(int port, ArrayList<String> proyectOne, ArrayList<String> proyectTwo, JButton button) {
        this.port = port;
        this.proyectOne = proyectOne;
        this.proyectTwo = proyectTwo;
        this.button = button;
    }

    public String JSonResults() {
        String result = "";
        try {
            Socket socket = new Socket("localhost", port);
            ObjectOutputStream send = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in2 = new ObjectInputStream(socket.getInputStream());
            ArrayList<ArrayList> list = new ArrayList<>();
            list.add(proyectOne);
            list.add(proyectTwo);
            send.writeObject(list);
            //send.writeObject(new SendSocektProyects(proyectOne, proyectTwo));
            String resivido = (String) in2.readObject();
            result = resivido;
            send.close();
            in2.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("NO SE CONNECTO AL ASERVER");
        }
        button.setEnabled(true);
        return result;
    }

    public ArrayList<String> getProyectOne() {
        return proyectOne;
    }

    public void setProyectOne(ArrayList<String> proyectOne) {
        this.proyectOne = proyectOne;
    }

    public ArrayList<String> getProyectTwo() {
        return proyectTwo;
    }

    public void setProyectTwo(ArrayList<String> proyectTwo) {
        this.proyectTwo = proyectTwo;
    }

}
