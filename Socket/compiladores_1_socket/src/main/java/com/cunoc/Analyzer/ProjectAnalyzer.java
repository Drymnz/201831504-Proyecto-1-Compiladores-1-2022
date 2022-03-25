package com.cunoc.Analyzer;

import java.util.ArrayList;

import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;

public class ProjectAnalyzer extends Thread{
    private ArrayList<String> listClass;
    private ArrayList<ClassSyntax> proyect = new ArrayList<>();
    
    public ProjectAnalyzer(ArrayList<String> listClass) {
        this.listClass = listClass;
    }

    public ArrayList<String> getListClass() {
        return listClass;
    }

    public void setListClass(ArrayList<String> listClass) {
        this.listClass = listClass;
    }

    public ArrayList<ClassSyntax> getProyect() {
        return proyect;
    }

    public void setProyect(ArrayList<ClassSyntax> proyect) {
        this.proyect = proyect;
    }
    @Override
    public void run() {
        for (String element : listClass) {
            new Thread(new Analyzer(element, proyect)).start();
        }        
    }
 }
