package cunoc.clientapplication.View.editorTexto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Resaltador implements Runnable {
    
    private Highlighter.HighlightPainter reslatarTexto = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
    private Highlighter lin;
    private Document doc;
    private String palabra = "";
    
    public Resaltador(JTextComponent comp, String palabra) {
        lin = comp.getHighlighter();
        doc = comp.getDocument();
        this.palabra = palabra;
    }

    public ArrayList<String> dividirTextoPalabra(String texto) {
        ArrayList<String> listado = new ArrayList();
        String palabra = "";
        for (char caracter : texto.toCharArray()) {
            String ver = String.valueOf(caracter);
            if (ver.equals(" ")) {
                listado.add(palabra);
                palabra = "";
            } else {
                palabra += ver;
            }
        }
        if (!palabra.isEmpty()) {
            listado.add(palabra);
        }
        return listado;
    }
    
    @Override
    public void run() {
        try {
            lin.removeAllHighlights();
            String texto = doc.getText(0, doc.getLength());
            ArrayList<String> listado = (dividirTextoPalabra(texto));
            ArrayList<String> bucar = (dividirTextoPalabra(palabra));
            for (int j = 0; j < listado.size(); j++) {
                if (bucar.get(0).equalsIgnoreCase(listado.get(j))) {
                    String encontre = "";
                    for (int k = 0; k < palabra.length(); k++) {
                        encontre += listado.get(k + j);
                    }
                    if (encontre.equalsIgnoreCase(palabra)) {
                        lin.addHighlight(j, j + palabra.length(), reslatarTexto);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
