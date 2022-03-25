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
                extract += caracter;
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
