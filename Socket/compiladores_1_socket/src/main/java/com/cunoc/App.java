package com.cunoc;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.cunoc.File_Manger.FileConverter;
import com.cunoc.JFlex_Cup.Token;
import com.cunoc.JFlex_Cup.Java.Lexico;
import com.cunoc.JFlex_Cup.Java.Sintactico;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;
import com.cunoc.JFlex_Cup.Java.repetition.ListType;
import com.cunoc.JFlex_Cup.Java.repetition.Method;
import com.cunoc.JFlex_Cup.Java.repetition.Variable;

public class App {
    public static final int PUERTO = (((1581)));

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
        Reader reader = new StringReader(text);
        Lexico lexema = new Lexico(reader);
        Sintactico sic = new Sintactico(lexema);
        ClassSyntax prueva = null;
        try {
            sic.parse();
            prueva = sic.getClassSyntax();
            prueva.setListComments(lexema.getlistComments());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
        }
        /*
         * FIN DE PRUEVAS
         */
        // IMPRIMIR LA CLASE
        if (prueva != null) {
            System.out.println("NOMBRE DE LA CLASE ****" + prueva.getName() + "************");
            List<Method> ListMethods = prueva.getListMethods();
            List<Variable> ListVariable = prueva.getListVariable();
            List<Token> ListComments = prueva.getListComments();

            System.out.println("*******************************************METODOS :");
            for (Method usar : ListMethods) {
                System.out.println("*******************************************");
                System.out.println("NOMBRE DEL METODO<" + usar.getLexeme() + ">TIPO<" + usar.getType() + ">");
                List<Variable> listParametors = usar.gelListParameters();
                System.out.println("PARAMETOS:");
                for (Variable usar1 : listParametors) {
                    System.out.println("NOMBRE<" + usar1.getLexeme() + ">TIPO<" + usar1.getType() + ">");
                }
                System.out.println("*******************************************");
            }
            System.out.println("********************VARIABLE :*******************************************");
            for (Variable usar : ListVariable) {
                System.out.println("*******************************************");
                System.out.println("NOMBRE<" + usar.getLexeme() + ">TIPO<" + usar.getType() + ">");
                System.out.println("*******************************************");
            }
            System.out.println("******************************************COMENTARIOS :");
            for (Token usar : ListComments) {
                System.out.println("*******************************************");
                System.out.println("NOMBRE<" + usar.getLexeme() + ">");
                System.out.println("*******************************************");
            }
        }
    }

    public void arrayType() {
        ListType honny = ListType.BOOLEAN;
        switch (honny) {
            case BYTE:
                honny = ListType.ARRAYBYTE;
                break;
            case SHORT:
                honny = ListType.ARRAYSHORT;
                break;
            case INT:
                honny = ListType.ARRAYINT;
                break;
            case LONG:
                honny = ListType.ARRAYLONG;
                break;
            case FLOAT:
                honny = ListType.ARRAYFLOAT;
                break;
            case DOUBLE:
                honny = ListType.ARRAYDOUBLE;
                break;
            case CHAR:
                honny = ListType.ARRAYCHAR;
                break;
            case BOOLEAN:
                honny = ListType.ARRAYBOOLEAN;
                break;
            case STRING:
                honny = ListType.ARRAYSTRING;
                break;
            case OBJECT:
                honny = ListType.ARRAYOBJECT;
                break;
            default:
                break;
        }
    }

}
