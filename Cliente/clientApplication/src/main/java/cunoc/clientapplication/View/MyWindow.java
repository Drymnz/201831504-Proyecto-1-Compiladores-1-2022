/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cunoc.clientapplication.View;

import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class MyWindow extends javax.swing.JFrame {

    /**
     * Creates new form MyWindow
     */
    private CardLayout car;

    public MyWindow() {
        initComponents();
        car = (CardLayout) (this.getContentPane().getLayout());
        car.addLayoutComponent("analyzerProyects1", analyzerProyects1);
        car.addLayoutComponent("editorTexto1", editorTexto1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorTexto1 = new cunoc.clientapplication.View.editorTexto.EditorTexto();
        analyzerProyects1 = new cunoc.clientapplication.View.AnalyzerProyects();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        edit = new javax.swing.JMenuItem();
        Analy = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(editorTexto1, "card3");
        getContentPane().add(analyzerProyects1, "card3");

        jMenu1.setText("File");

        edit.setText("Editor");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jMenu1.add(edit);

        Analy.setText("Analizador");
        Analy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyActionPerformed(evt);
            }
        });
        jMenu1.add(Analy);

        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void AnalyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyActionPerformed
        car.show(this.getContentPane(), "analyzerProyects1");
        /*this.getContentPane().removeAll();
        this.getContentPane().add(analyzerProyects1);
        this.getContentPane().repaint();*/
    }//GEN-LAST:event_AnalyActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        car.show(this.getContentPane(), "editorTexto1");
        /*   this.getContentPane().removeAll();
        this.getContentPane().add(editorTexto1);
        this.getContentPane().repaint();*/
    }//GEN-LAST:event_editActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Analy;
    private cunoc.clientapplication.View.AnalyzerProyects analyzerProyects1;
    private javax.swing.JMenuItem edit;
    private cunoc.clientapplication.View.editorTexto.EditorTexto editorTexto1;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
