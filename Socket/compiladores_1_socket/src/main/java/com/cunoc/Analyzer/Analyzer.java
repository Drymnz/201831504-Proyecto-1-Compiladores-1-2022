package com.cunoc.Analyzer;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import com.cunoc.JFlex_Cup.Java.Lexico;
import com.cunoc.JFlex_Cup.Java.Sintactico;
import com.cunoc.JFlex_Cup.Java.sym;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;
import com.cunoc.Server.Console;

import java_cup.runtime.Symbol;

public class Analyzer implements Runnable {
    private String text;
    public static int errorCounter = 0;
    private ArrayList<ClassSyntax> proyect;

    public Analyzer(String text, ArrayList<ClassSyntax> proyect) {
        this.text = text;
        this.proyect = proyect;
    }

    private ClassSyntax Analyzer() {
        if (!text.isEmpty()) {
            Reader reader = new StringReader(text);
            Lexico lexema = new Lexico(reader);
            Sintactico sic = new Sintactico(lexema);
            ClassSyntax prueva = null;
            try {
                sic.parse();
                prueva = sic.getClassSyntax();
                prueva.setListComments(lexema.getlistComments());
                errorCounter += sic.getErrorCounter();
            } catch (Exception e) {
                Symbol s = sic.getSymbol();
                errorCounter += sic.getErrorCounter();
                if (s != null) {
                    Console.ConsoleText
                            .append("\n" + sic.getErrorCounter() + " - Clase<" + sic.getNameClass() + ">- En simbolo<"
                                    + sym.terminalNames[s.sym]
                                    + String.format(">posicion: <%d>, <%d>", (s.left + 1), (s.right + 1)));
                }
                e.printStackTrace();
                System.out.println(e.getMessage());
            } finally {
            }
            return prueva;
        } else {
            return null;
        }
    }

    @Override
    public void run() {
        try {
            ClassSyntax analyzer = Analyzer();
            if (analyzer != null) {
                proyect.add(analyzer);
            }
        } catch (Exception e) {
            Console.ConsoleText.append("error");
        }
    }

    public int getErrorCounter() {
        return errorCounter;
    }

}
