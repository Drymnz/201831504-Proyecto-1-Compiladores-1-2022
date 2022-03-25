/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication.Logic.Converter;

import cunoc.clientapplication.Logic.File_Manger.FileConverter;
import cunoc.clientapplication.Logic.Manager.AggregationHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class DirectoryToArrayListString {

    private File proyect;
    private final String OPEN = "/";
    private final String DIVER = ".";
    private final String EXTENDS_JAVA = "java";
    private ArrayList<String> proyectFinal = new ArrayList<>();

    public DirectoryToArrayListString(File proyect) {
        this.proyect = proyect;
    }

    public ArrayList<String> converterProyect() {
        if (proyect != null) {
            String root = proyect.getAbsoluteFile().toString();
            viewDirectory(root);
        }
        return proyectFinal;
    }

    private void viewDirectory(String root) {
        try {
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(root))) {
                for (Path ruta : ds) {
                    String file = ruta.getFileName().toString();
                    add(ruta);
                }
            } catch (IOException e) {
                System.err.println("Error -> " + e.getMessage());
                System.err.println("Error -> " + root);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void add(Path rut) {
        String fileName = getExtension(rut.getFileName().toString());
        if (!fileName.isBlank()) {
            //if extension java
            if (fileName.equals(EXTENDS_JAVA)) {
                String direction = rut.getParent() + OPEN + rut.getFileName().toString();
                (new AggregationHandler(proyectFinal, new FileConverter(new File(direction)))).start();
            }
        } else if (!rut.getFileName().toString().isBlank()) {
            viewDirectory(rut.getParent() + OPEN + rut.getFileName().toString());
        }
    }

    private String getExtension(String fileName) {
        String fe = "";
        if (fileName.contains(DIVER)) {
            fe = java.util.Arrays.stream(fileName.split("\\.")).reduce((a, b) -> b).orElse(null);
        }
        return fe;
    }
}
