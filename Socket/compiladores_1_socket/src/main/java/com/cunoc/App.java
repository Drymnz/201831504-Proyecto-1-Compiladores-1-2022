package com.cunoc;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.cunoc.File_Manger.FileConverter;
import com.cunoc.JFlex_Cup.Java.Lexico;
import com.cunoc.JFlex_Cup.Java.Sintactico;

public  class App {
    public static final int PUERTO = (((1581)));
    String list = "text"+"text";
    public static void main(String[] args) {
        /*
         * PRUEVAS PARA VER LO SIMPLE
         */
        File fileTest = new File("TESTJAVA.java");
        // CREAR EL ARCHIVO DE PRUEVAS DE JAVA
        if (!fileTest.exists()) {
            try {
                if (fileTest.createNewFile()) {// creador de carchivos de text apra la lectura de los admin
                    System.out.println("Hey!!, fue creado el " + fileTest.getName());
                } else {
                    System.out.println("no fue creado el " + fileTest.getName());
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("no fue creado el " + fileTest.getName());
            }
        }
        // convertidr ese archivo en texto
        String text = (new FileConverter()).upLoadTextFile(fileTest);
        // ANALISAR
        int i = 3;
        switch (i) {
            case 1*1:
                
                break;
        
            default:
                break;
        }
        for (int j = 0; j < args.length;) {
            
        }
        Reader reader = new StringReader(text);
        Lexico lexema = new Lexico(reader);
        Sintactico sic = new Sintactico(lexema);
            try {
                sic.parse();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(e.getMessage());
            }finally{
            }
       
        /*
         * FIN DE PRUEVAS
         */
    }  

}
