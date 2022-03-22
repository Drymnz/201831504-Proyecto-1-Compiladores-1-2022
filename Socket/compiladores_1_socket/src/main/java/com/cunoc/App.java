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
        String d  = 3+ "3";
        int i =43;
        switch (i) {
            case 1*1:
                
                break;
        
            default:
                break;
        }
        boolean sdf = (32!=(43+1));
        if (sdf) {
            
        } else if (!sdf){
            
        }else{

        }
        int j =0;
        for ( Reader readser = new StringReader(text); j < args.length;j++) {
            
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
