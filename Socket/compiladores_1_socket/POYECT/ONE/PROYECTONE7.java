/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio01abstraccion;

/**
 *
 * @author chivi
 */
public class Alumno {
    
    String CUI;
    String Nombre;
    int[] notas= new int [3];
    
    
    public int PromedioFinal (){
    int PrimerNota;
    int SegundaNota;
    int TerceraNota;
    int Promedio;
    
    PrimerNota= notas [0];
    SegundaNota= notas [1];
    TerceraNota = notas [2];
    
    Promedio = (PrimerNota + SegundaNota + TerceraNota) / 3;
    return Promedio;
    
    
    
    
    }
    
    public boolean SerAprobado(){
        boolean aprobar = false;
        int nota;
        
        nota = PromedioFinal();
    
        if (nota >=  61) {
            aprobar = true;
        }
        
        return aprobar;
    
    }
    
    public void ImprimirResumenDatos(){
        
        boolean aprobo;
        
        aprobo = SerAprobado();
        
        
    
        System.out.println("CUI: " + CUI);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Promedio Final es " + PromedioFinal());
        
        if (aprobo==true) {
            System.out.println("Estado de aprovacion: Usted Aprobo ");
        
        }else{
        
            System.out.println("Estado de arpovacion: Usted no ha aprobado");
        
        }
    
    }
    
}
