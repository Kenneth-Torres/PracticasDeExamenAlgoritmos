/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import Logic.StackLinkedList;

/**
 *
 * @author Laboratorios
 */
public class Cliente {
    
    private String name;
    private int age;
    private StackLinkedList trolley;
    private float total;

    public Cliente(String name, int age, StackLinkedList trolley, float total) {
        this.name = name;
        this.age = age;
        this.trolley = trolley;
        this.total = total;
    }//constructor

    //acces methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StackLinkedList getTrolley() {
        return trolley;
    }

    public void setTrolley(StackLinkedList trolley) {
        this.trolley = trolley;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cliente{" + "name=" + name + ", age=" + age + ", total=" + total + ", trolley=\n" + trolley.toString() +'}';
    }

}//class 12/5/2023 
