/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public interface Queue {
    
    public abstract void cancel();
    
    public abstract int getSize();
    
    public abstract boolean isEmpty();
    
    public abstract  void insert(Object element);
    
     public abstract  void insertWithPriority(Object element,int priority);
    
    public abstract Object firstElement();
    
    public abstract  Object delete();
    
}//interface 10/5/2023
