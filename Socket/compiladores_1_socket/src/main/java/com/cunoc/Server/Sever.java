package com.cunoc.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.cunoc.Analyzer.Analyzer;
import com.cunoc.Analyzer.CompaHTML;
import com.cunoc.Analyzer.CompaProyect;
import com.cunoc.Analyzer.ConvertirJSon;
import com.cunoc.Analyzer.JSon;
import com.cunoc.Analyzer.ProjectAnalyzer;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;

public class Sever extends Thread {
    private final int port;
    private final String NADA = "NADA";

    public Sever(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void run() {
        int attempts = 0;
        while (attempts < 10) {
            try {
                ServerSocket severt = new ServerSocket(this.port);
                Console.ConsoleText.append("\nEl servidor esta corriendo en el puerto : " + this.port);
                Console.ConsoleText.append("\nEstoy a la espera");
                Socket socketClient = severt.accept();
                Console.ConsoleText.append("\nse conecto alguien");
                ObjectInputStream in = new ObjectInputStream(socketClient.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socketClient.getOutputStream());
                Object getCliente = in.readObject();
                String json = res(getCliente);
                out.writeObject(json);
                Console.ConsoleText.append("\nle envie esto:\n" + json);
                socketClient.close();
            } catch (Exception e) {
                e.printStackTrace();
                attempts++;
                Console.ConsoleText.append("\nERROR-> class:SERVER " + e.getMessage());
            }
        }
        // System.exit(0);
    }

    private String res(Object get) {
        if (get instanceof ArrayList) {
            ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>) get;
            if (list.size() == 2) {
                ArrayList<String> proyectTwo = list.get(0);
                ArrayList<String> proyectOne = list.get(1);
                return Comparet(proyectTwo, proyectOne);
            }
        }
        if (get instanceof String) {
            String text = (String) get;
            return (new CompaHTML(text)).compaHTML();
        }
        return NADA;
    }

    private String Comparet(ArrayList<String> listTwo, ArrayList<String> listadoOne) {
        String returnString = "";
        ProjectAnalyzer proyecttwo = new ProjectAnalyzer(listTwo);
        ProjectAnalyzer proyectOne = new ProjectAnalyzer(listadoOne);
        proyectOne.start();
        proyecttwo.start();
        try {
            do {
                Thread.sleep(1000);
            } while (proyectOne.isAlive() || proyecttwo.isAlive());
        } catch (Exception e) {
            Console.ConsoleText.append("no se pudo dormir");
        }
        ArrayList<ClassSyntax> poryectTwoFinal = proyecttwo.getProyect();
        ArrayList<ClassSyntax> poryectOneFinal = proyectOne.getProyect();
        if (Analyzer.errorCounter == 0) {
            CompaProyect analyzer = new CompaProyect(poryectOneFinal, poryectTwoFinal);
            JSon result = analyzer.compaAnalyzer();
            returnString = new ConvertirJSon().objectJSonString(result);
        } else {
            Console.ConsoleText.append("hay errores en una clase");
        }
        return returnString;
    }

}
