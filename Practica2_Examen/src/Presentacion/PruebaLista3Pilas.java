/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Domain.Lista3Pilas;

/**
 *
 * @author Ernesto
 */
public class PruebaLista3Pilas {
    
    private Lista3Pilas lista3Pilas;

    public PruebaLista3Pilas() {
        this.lista3Pilas=new Lista3Pilas();
    }

    public void PruebaLista3Pilas() {

        this.lista3Pilas.insertar(5);
        this.lista3Pilas.insertar(30);
        this.lista3Pilas.insertar(4);
        this.lista3Pilas.insertar(6);
        this.lista3Pilas.insertar(55);
        this.lista3Pilas.insertar(99);
        this.lista3Pilas.insertar(85);
        
        System.out.println(this.lista3Pilas.toString());
        
        System.out.println("\nExiste 30 "+this.lista3Pilas.existe(30));
        
        System.out.println("\nExiste 10 "+this.lista3Pilas.existe(10));
        
        System.out.println("\nExiste 85 "+this.lista3Pilas.existe(85));
        
        System.out.println("\n"+this.lista3Pilas.rangoMayor());
        
        this.lista3Pilas.mostrar(1, 89);
        
        this.lista3Pilas.etiquetar(0, 0);
        System.out.println("\n"+this.lista3Pilas.toString());  
        
        this.lista3Pilas.modificar(5, 1);
        System.out.println("\n"+this.lista3Pilas.toString());  

    }

}
