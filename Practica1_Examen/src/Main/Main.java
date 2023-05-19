/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Domain.Cliente;
import Domain.Librería;
import Logic.StackLinkedList;

/**
 *
 * @author Kenneth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Librería librería= new Librería();
        
        librería.saveClient(new Cliente("ernesto", 21, new StackLinkedList(), 500));
        librería.saveClient(new Cliente("Maria", 25, new StackLinkedList(), 1500));
        librería.saveClient(new Cliente("juan", 64, new StackLinkedList(), 2500));
        
        librería.addTrolley("juan", "los jesners");
        librería.addTrolley("Maria", "el libro de la selva");
        librería.addTrolley("ernesto", "el principito");
        
        Cliente cliente =librería.searchWithAge(25);
        System.out.println(cliente.toString());
        System.out.println(librería.generarFactura(librería.searchWithAge(21)));
        
        librería.pasarPorCaja(librería.searchWithAge(21));
        librería.pasarPorCaja(librería.searchWithAge(64));
        librería.pasarPorCaja(librería.searchWithAge(25));
        
        System.out.println(librería.salirDeLaCola(1));
        System.out.println(librería.salirDeLaCola(2));
        
    }
    
}
