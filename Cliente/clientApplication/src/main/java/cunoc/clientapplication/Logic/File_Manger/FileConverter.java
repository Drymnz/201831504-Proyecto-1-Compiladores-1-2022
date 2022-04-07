package cunoc.clientapplication.Logic.File_Manger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileConverter {

    private FileInputStream entry;
    private File file;

    public FileConverter(File file) {
        this.file = file;
    }

    public String upLoadTextFile() {
        String extract = "";
        try {
            entry = new FileInputStream(file);
            int valor;
            while ((valor = entry.read()) != -1) {
                char caracter = (char) valor;
                if (caracter=='\u007c') {
                    caracter = '\u0026';
                }
                String add = String.valueOf(caracter);
                if (add.equals("\\")) {
                    if ((valor = entry.read()) != -1) {
                        char siguiente = (char) valor;
                        String siguienteChar = String.valueOf(siguiente);
                        add += siguienteChar;
                        if (siguienteChar.equals("\"")) {
                            add = "";
                        }
                    }
                }
                extract += add;
            }
            entry.close();
        } catch (FileNotFoundException ex) {
            System.out.println("error en lectura");
        } catch (IOException ex) {
            System.out.println("error en lectura");
        }
        return extract;
    }

    public File addressExists(File file) {
        if (file.exists()) {
            return file;
        } else {
            if (file.mkdirs()) {
                System.out.println("FUE CREADO " + file.getName());
                return file;
            } else {
                System.out.println("NO SE PUDO CREAR " + file.getName());
            }
        }
        return null;
    }
}
