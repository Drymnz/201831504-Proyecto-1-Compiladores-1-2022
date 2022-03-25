/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication;

import cunoc.clientapplication.View.MyWindow;
import javax.lang.model.SourceVersion;


/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class Start {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cunoc.clientapplication.View.MyWindow windos = new MyWindow();
                windos.setVisible(true);
                windos.setLocationRelativeTo(null);
            }
        });
    }

}
