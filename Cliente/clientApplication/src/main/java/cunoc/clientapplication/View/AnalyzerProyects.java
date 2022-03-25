/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cunoc.clientapplication.View;

import cunoc.clientapplication.Logic.Converter.DirectoryToArrayListString;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class AnalyzerProyects extends javax.swing.JPanel {

    private final String SELECTFILE = "Selecione la carpeta del ";
    private final String PLSSELECT = "Por favor selecione ";
    private final String PROYECTONE = "primer proyecto";
    private final String PROYECTTWO = "segundo proyecto";
    private final String CONFIR = "¿Esta seguro de analizar?";

    private String fileProyectOne = "";
    private String fileProyectTwo = "";

    /**
     * Creates new form AnalyzerProyects
     */
    public AnalyzerProyects() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelProyect1 = new javax.swing.JLabel();
        labelProyect2 = new javax.swing.JLabel();
        jButtonSeleectProyect1 = new javax.swing.JButton();
        jButtonSelecctProyect2 = new javax.swing.JButton();
        jButtonAnalyzer = new javax.swing.JButton();

        labelProyect1.setText("Proyecto 1");

        labelProyect2.setText("Proyecto 2");

        jButtonSeleectProyect1.setText("Seleccionar Proyecto 1");
        jButtonSeleectProyect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleectProyect1ActionPerformed(evt);
            }
        });

        jButtonSelecctProyect2.setText("Seleccionar Proyecto 2");
        jButtonSelecctProyect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecctProyect2ActionPerformed(evt);
            }
        });

        jButtonAnalyzer.setText("Analizar");
        jButtonAnalyzer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalyzerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAnalyzer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProyect1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelProyect2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSeleectProyect1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelecctProyect2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProyect2)
                    .addComponent(labelProyect1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSeleectProyect1)
                    .addComponent(jButtonSelecctProyect2))
                .addGap(18, 18, 18)
                .addComponent(jButtonAnalyzer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeleectProyect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleectProyect1ActionPerformed
        this.fileProyectOne = selectFile(SELECTFILE + PROYECTONE);
    }//GEN-LAST:event_jButtonSeleectProyect1ActionPerformed

    private void jButtonSelecctProyect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecctProyect2ActionPerformed
        this.fileProyectTwo = selectFile(SELECTFILE + PROYECTTWO);
    }//GEN-LAST:event_jButtonSelecctProyect2ActionPerformed

    private void jButtonAnalyzerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalyzerActionPerformed
        if (this.fileProyectOne.isBlank()) {
            JOptionPane.showMessageDialog(null, PLSSELECT + PROYECTONE);
        } else if (this.fileProyectTwo.isBlank()) {
            JOptionPane.showMessageDialog(null, PLSSELECT + PROYECTTWO);
        } else if (JOptionPane.showConfirmDialog(null, CONFIR, CONFIR, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            ArrayList<String> proyectOne = (new DirectoryToArrayListString(new File(this.fileProyectOne))).converterProyect();
            ArrayList<String> proyectTwo = (new DirectoryToArrayListString(new File(this.fileProyectTwo))).converterProyect();
        }
    }//GEN-LAST:event_jButtonAnalyzerActionPerformed
    private String selectFile(String menssage) {
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleccionarArchivo.setAcceptAllFileFilterUsed(false);
        if (seleccionarArchivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION || seleccionarArchivo.getCurrentDirectory() != null) {
            return seleccionarArchivo.getSelectedFile().getAbsoluteFile().toString();
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalyzer;
    private javax.swing.JButton jButtonSelecctProyect2;
    private javax.swing.JButton jButtonSeleectProyect1;
    private javax.swing.JLabel labelProyect1;
    private javax.swing.JLabel labelProyect2;
    // End of variables declaration//GEN-END:variables
}
