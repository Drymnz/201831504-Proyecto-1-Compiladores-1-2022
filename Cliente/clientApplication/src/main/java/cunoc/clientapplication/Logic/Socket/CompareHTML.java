/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication.Logic.Socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class CompareHTML {

    private String text;
    private int port;

    public CompareHTML(String text, int port) {
        this.text = text;
        this.port = port;
    }

    public String returnText() {
        String result = "";
        try {
            Socket socket = new Socket("localhost", port);
            ObjectOutputStream send = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in2 = new ObjectInputStream(socket.getInputStream());
            send.writeObject(text);
            String resivido = (String) in2.readObject();
            result = resivido;
            send.close();
            in2.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("NO SE CONNECTO AL ASERVER");
        }
        return result;
    }

}
