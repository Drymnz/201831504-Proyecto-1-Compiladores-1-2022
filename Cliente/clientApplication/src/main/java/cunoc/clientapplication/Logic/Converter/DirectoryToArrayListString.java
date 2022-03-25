/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication.Logic.Converter;

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

    public DirectoryToArrayListString(File proyect) {
        this.proyect = proyect;
    }

    public ArrayList<String> converterProyect() {
        ArrayList<String> renviar = new ArrayList<>();
        if (proyect != null) {
            System.out.println(proyect.getParentFile());
            System.out.println(proyect.getAbsoluteFile());
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(proyect.getAbsolutePath()))) {
                for (Path ruta : ds) {
                    System.out.println(ruta.getFileName());
                }
            } catch (IOException e) {
                System.err.println("Error -> " + e.getMessage());
            }
        }
        return renviar;
    }
}
