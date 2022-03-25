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
public class Rectangulo {
    
    int base;
    int altura;
    
    public int CalcularArea(){
        int area;
        area = base*altura;
        
        return area;
    }
    
    public int CalcularPerimetro(){
        int perimetro;
        
        perimetro = 2*(base + altura);
        
        return perimetro;
    
    }
    
    
}
