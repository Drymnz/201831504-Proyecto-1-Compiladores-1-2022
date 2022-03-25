package com.cunoc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.cunoc.Analyzer.Analyzer;
import com.cunoc.Analyzer.CompaProyect;
import com.cunoc.Analyzer.ConvertirJSon;
import com.cunoc.Analyzer.JSon;
import com.cunoc.Analyzer.ProjectAnalyzer;
import com.cunoc.File_Manger.FileConverter;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;

public class App {
    public static final int PUERTO = (((1581)));
    public static ArrayList<String> listPurevas = new ArrayList<>();
    public static ArrayList<String> listPurevasTWO = new ArrayList<>();

    public static void main(String[] args) {
        /*
         * PRUEVAS PARA VER LO SIMPLE
         */
        crearProyect();
        ProjectAnalyzer proyecttwo = new ProjectAnalyzer(listPurevasTWO);
        ProjectAnalyzer proyectOne = new ProjectAnalyzer(listPurevas);
        proyectOne.start();
        proyecttwo.start();
        try {
            do {
                Thread.sleep(1000);
            } while (proyectOne.isAlive() || proyecttwo.isAlive());
        } catch (Exception e) {
            System.out.println("no se pudo dormir");
        }
        ArrayList<ClassSyntax> poryectTwoFinal = proyecttwo.getProyect();
        ArrayList<ClassSyntax> poryectOneFinal = proyectOne.getProyect();
        if (Analyzer.errorCounter == 0) {
            CompaProyect analyzer = new CompaProyect(poryectOneFinal, poryectTwoFinal);
            JSon result = analyzer.compaAnalyzer();
            System.out.println(new ConvertirJSon().objectJSonString(result));
        } else {
            System.out.println("hay errores en una clase");
        }
        // ANALISAR
        // (new Analyzer(text).Analyzer())
        ClassSyntax prueva = null;
        /*
         * FIN DE PRUEVAS
         */
        // IMPRIMIR LA CLASE
        /*
         * if (prueva != null) {
         * System.out.println("NOMBRE DE LA CLASE ****" + prueva.getName() +
         * "************");
         * List<Method> ListMethods = prueva.getListMethods();
         * List<Variable> ListVariable = prueva.getListVariable();
         * List<Token> ListComments = prueva.getListComments();
         * 
         * System.out.println("*******************************************METODOS :");
         * for (Method usar : ListMethods) {
         * System.out.println("*******************************************");
         * System.out.println("NOMBRE DEL METODO<" + usar.getLexeme() + ">TIPO<" +
         * usar.getType() + ">");
         * List<Variable> listParametors = usar.gelListParameters();
         * System.out.println("PARAMETOS:");
         * for (Variable usar1 : listParametors) {
         * System.out.println("NOMBRE<" + usar1.getLexeme() + ">TIPO<" + usar1.getType()
         * + ">");
         * }
         * System.out.println("*******************************************");
         * }
         * System.out.
         * println("********************VARIABLE :*******************************************"
         * );
         * for (Variable usar : ListVariable) {
         * System.out.println("*******************************************");
         * System.out.println("NOMBRE<" + usar.getLexeme() + ">TIPO<" + usar.getType() +
         * ">");
         * System.out.println("*******************************************");
         * }
         * System.out.println("******************************************COMENTARIOS :"
         * );
         * for (Token usar : ListComments) {
         * System.out.println("*******************************************");
         * System.out.println("NOMBRE<" + usar.getLexeme() + ">");
         * System.out.println("*******************************************");
         * }
         * }
         */
    }

    public static void crearProyect() {
        ArrayList<File> listadoPurevas = new ArrayList<>();
        ArrayList<File> listadoPurevas2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listadoPurevas.add(new File("POYECT/ONE/PROYECTONE" + i + ".java"));
        }
        for (int i = 0; i < 10; i++) {
            listadoPurevas2.add(new File("POYECT/TWO/PROYECTTWO" + i + ".java"));
        }
        // CREAR EL ARCHIVO DE PRUEVAS DE JAVA
        for (File fileTest : listadoPurevas) {
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
        }
        for (File fileTest : listadoPurevas2) {
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
        }
        // convertidr ese archivo en texto

        for (File fileTest : listadoPurevas) {
            listPurevas.add((new FileConverter()).upLoadTextFile(fileTest));
        }
        for (File fileTest : listadoPurevas2) {
            listPurevasTWO.add((new FileConverter()).upLoadTextFile(fileTest));
        }
    }

}
