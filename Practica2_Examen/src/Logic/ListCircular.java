/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public interface ListCircular {
    
    public void cancel();
    
    public int getSize();
    
    public boolean isEmpty();
    
    public boolean exists(Object element);
    
    public void addHead(Object element);
    
    public void addEnd(Object element);
    
    public void deleteByElement(Object element);
    
    public StackLinkedList getByPosition(int index);
    
    public Object lastInList();
    
    public Object firstInList();
    
}//interfaces 28/4/2023
