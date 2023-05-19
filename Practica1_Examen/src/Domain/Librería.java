/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import Logic.DoubleLinkedList;
import Logic.LinkedListQueue;
import Logic.StackLinkedList;

/**
 *
 * @author Laboratorios
 */
public class Librería {
    
    private DoubleLinkedList[] Library;
    private LinkedListQueue linkedListQueue1;
    private LinkedListQueue linkedListQueue2;
    private StackLinkedList stackLinkedList;

    public Librería() {
       this.Library=new DoubleLinkedList[3];
       this.linkedListQueue1=new LinkedListQueue();
       this.linkedListQueue2=new LinkedListQueue();
       this.stackLinkedList=new StackLinkedList();
    }//constructor

    public void saveClient(Cliente newClient) {
        for (int i =0; i<this.Library.length;i++) {
            if (this.Library[i] == null) {
                DoubleLinkedList newLibrary = new DoubleLinkedList();
                newLibrary.addEnd(newClient.getName());
                newLibrary.addEnd(newClient.getAge());
                newLibrary.addEnd(newClient.getTrolley());
                newLibrary.addEnd(newClient.getTotal());
                this.Library[i]=newLibrary;
                break;
            }//check a element is null
        }//check a null value in array
    }//method decomposes a client and saves it
    
    public Cliente searchWithAge(int age){
        for (int i=0;i<this.Library.length;i++) {
            if (this.Library[i]!=null && ((int)(this.Library[i].getByPosition(1)))==age) {
                return new Cliente((String)this.Library[i].getByPosition(0), (int)this.Library[i].getByPosition(1)
                        , (StackLinkedList)this.Library[i].getByPosition(2), (float)this.Library[i].getByPosition(3)); 
            }//if element not is null and age is equales de search age return a client
        }//search a client for the age
        return null;
    }//method return a client
    
    public void addTrolley(String clientName,String bookAdd){
        for (DoubleLinkedList doubleLinkedList : Library) {
            if (doubleLinkedList!=null && doubleLinkedList.getByPosition(0).equals(clientName)) {
                StackLinkedList trolley=(StackLinkedList)doubleLinkedList.getByPosition(2);
                trolley.push(bookAdd);
            }//if element not is null and name is equales de search name add a book
        }//search a client
    }//method add a new element of the trolley on client
    
    public void pasarPorCaja(Cliente cliente){  
        if (cliente.getAge()>63) {
            System.out.println("Edad: "+cliente.getAge());
            this.linkedListQueue1.insert(cliente);
        } else {
            System.out.println("Edad: "+cliente.getAge());
            this.linkedListQueue2.insert(cliente);
        }
    }
    
    public String generarFactura(Cliente cliente){
      return "Factura "+cliente.getName()+"\n"+cliente.toString();
    }
    
    public String salirDeLaCola(int numeroCaja){
       Cliente cliente=null;
        if (numeroCaja==1) {
            cliente=(Cliente) this.linkedListQueue1.delete();
        } else {
            cliente=(Cliente) this.linkedListQueue2.delete(); 
        }
        this.stackLinkedList.push(cliente.getName());
        return cliente.getName();
    }
    
    
}//class 12/5/2023
