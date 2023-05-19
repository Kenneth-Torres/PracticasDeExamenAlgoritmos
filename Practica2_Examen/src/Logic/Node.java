/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public class Node {
    
    public Object element;
    public Node previusNode;
    public Node nextNode;
    public int priority;

    public Node(Object element) {
        this.element = element;
        this.previusNode = null;
        this.nextNode = null;
        this.priority=0;
    }//constructor

    public Node(Object element, int priority) {
        this.element = element;
        this.priority = priority;
        this.nextNode=null;
        this.previusNode=null;
    }
    
    
    
}//class 19/4/2023
