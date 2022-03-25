package com.cunoc.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
            }
        } catch (Exception e) {
            Console.ConsoleText.append("Error en el arranque de servidor");
        }
    }
    private void Comparet(){
        /*ProjectAnalyzer proyecttwo = new ProjectAnalyzer(listPurevasTWO);
        ProjectAnalyzer proyectOne = new ProjectAnalyzer(listPurevas);
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
        }*/
    }

}
