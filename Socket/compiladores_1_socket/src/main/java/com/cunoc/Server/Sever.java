package com.cunoc.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.cunoc.Analyzer.Analyzer;
import com.cunoc.Analyzer.CompaProyect;
import com.cunoc.Analyzer.ConvertirJSon;
import com.cunoc.Analyzer.JSon;
import com.cunoc.Analyzer.ProjectAnalyzer;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;

public class Sever extends Thread {
    private final int port;

    public Sever(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void run() {
        try {
            ServerSocket severt = new ServerSocket(this.port);
            Console.ConsoleText.append("\nEl servidor esta corriendo en el puerto : " + this.port);
            while (true) {
                Socket socketClient = severt.accept();
                ObjectOutputStream out = new ObjectOutputStream(socketClient.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socketClient.getInputStream());
                Package recvPack = (Package) in.readObject();
                Console.ConsoleText.append(recvPack.getName());
                //Comparet(listTwo, listadoOne);
            }
        } catch (Exception e) {
            Console.ConsoleText.append("Error en el arranque de servidor");
        }
    }
    private void Comparet(ArrayList<String> listTwo,ArrayList<String> listadoOne){
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
            System.out.println(new ConvertirJSon().objectJSonString(result));
        } else {
            Console.ConsoleText.append("hay errores en una clase");
        }
    }

}
