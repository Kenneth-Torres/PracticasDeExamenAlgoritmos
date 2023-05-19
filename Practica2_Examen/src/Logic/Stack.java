/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public interface Stack {
    
    public int getSize();
    
    public boolean isEmpty();
    
    public void cancel();
    
    public Object top();
    
    public void push(Object elemnet);
    
    public Object pop();
    
    public boolean exists(Object objectToCheck);
    
}//class 3/5/2023
