package com.cunoc.Analyzer;

import java.io.Reader;
import java.io.StringReader;

import com.cunoc.JFlex_Cup.HTML.Lexico;
import com.cunoc.JFlex_Cup.HTML.Sintactico;
import com.cunoc.Server.Console;

public class CompaHTML {
    private String text;

    public CompaHTML(String text) {
        this.text = text;
    }

    public String compaHTML() {
        if (!text.isEmpty()) {
            Reader reader = new StringReader(text);
            Lexico lexema = new Lexico(reader);
            Sintactico sic = new Sintactico(lexema);
            try {
                sic.parse();
                System.out.println(lexema.getReport());
            } catch (Exception e) {
                e.printStackTrace();
                Console.ConsoleText
                        .append(e.getMessage());
            } finally {
            }
            return "Ok";
        }
        return "";
    }
}
