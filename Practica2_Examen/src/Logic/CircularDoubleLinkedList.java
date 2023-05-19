/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.List;
import Logic.ListException;
import Logic.Node;

/**
 *
 * @author Laboratorios
 */
public class CircularDoubleLinkedList implements ListCircular{
    
    public Node start;
    private Node end;
    public int size;

    public CircularDoubleLinkedList() {
        this.start = null;
        this.size = 0;
    }//constructor
    
    @Override
    public void cancel() {
        this.start=null;
        this.end=null;
        this.size=0;
    }//delete all elements of the list

    @Override
    public int getSize() {
        return this.size;
    }//return the number of elements in the list 

    @Override
    public boolean isEmpty() {
        return this.start==null;
    }//returns true if the list is empty

    @Override
    public boolean exists(Object element) {
        Node auxNode=this.start;
        do {            
            if (auxNode.element.equals(element)) return true;//if compares the node element with the searched element
            auxNode = auxNode.nextNode;
        } while (!auxNode.equals(this.start));//look for a node
        return false; 
    }// check if a node exists
    
    @Override
    public void addHead(Object element) {
        Node newNode = new Node(element);
        if (this.isEmpty()) {//it is validated when the list is empty
            this.start = newNode;
            this.end=this.start;
        } else {//if you don't add new element at the beginning
            this.start.previusNode=newNode;
            this.start.previusNode.nextNode=this.start;
            this.start=this.start.previusNode;
            this.start.previusNode=this.end;
            this.end.nextNode=this.start;
        }
        this.size++;
    }//add an element to the beginning

    @Override
    public void addEnd(Object element) {
        Node newNode = new Node(element);
        if (this.isEmpty()) {//it is validated when the list is empty
            this.start = newNode;
            this.end = this.start;
        } else {//if you don't add new element at the end
            this.end.nextNode = newNode;
            this.end.nextNode.previusNode = this.end;
            this.end = this.end.nextNode;
            this.end.nextNode = this.start;
            this.start.previusNode=this.end;
        }
        this.size++;
    }//add an element to the end

    @Override
    public StackLinkedList getByPosition(int index) throws ListException {
        if (isEmpty()) {//if the list is empty send an exception message
            throw new ListException("the list is empty it has no elements to recover");
        }else if (index < 0 || index > this.size) {//if the index does not exist in the list send an exception message
            throw new ListException("cannot recover node the index does not exist in the list");
        } else {//if the index exists, it looks for it through a loop
            Node auxNode = this.start;
            for (int i = 0; i < index; i++) {
                auxNode = auxNode.nextNode;
            }//the for changes the value of the aux node the requested i times
            return (StackLinkedList) auxNode.element;//return the element      
        }
    }//search for an objectToDelete by a given position

    @Override
    public void deleteByElement(Object objectToDelete) throws ListException {
        if (isEmpty() || !this.exists(objectToDelete)) {//if the list is empty send an exception message
            throw new ListException("Cannot delete items from the list because it is empty or does not exist");
        }//if the list is empty send an exception message
        if (this.size == 1) {//check the possibility of deleting the only node in the list
            this.start = null;
        } else if (this.start.element.equals(objectToDelete)) {//checks the possibility of deleting the initial node from the list
            this.start = this.start.nextNode;
            this.start.previusNode = this.end;
            this.end.nextNode = this.start;
        } else if (this.end.element.equals(objectToDelete)) {//checks the possibility of deleting the final node from the list
            this.end = this.end.previusNode;
            this.end.nextNode = this.start;
            this.start.previusNode = this.end;
        } else {
            Node auxNode = this.start;
            do {
                if (auxNode.element.equals(objectToDelete))break;//if compares the node objectToDelete with the searched objectToDelete
                auxNode = auxNode.nextNode;//pass node
            } while (auxNode.nextNode != this.start);//look for a node
            //Assigns as the next node from the previous node to the current one, the node after the current one.
            auxNode.previusNode.nextNode = auxNode.nextNode;
            //Assigns as previous node of the node next to the current one, the node before the current one.
            auxNode.nextNode.previusNode = auxNode.previusNode;
        }//If the node to be deleted is the start one, a different process will be carried out than if it were a next node
        this.size--;
    }//Borra un elemento de la lista

    @Override
    public Object lastInList() throws ListException{
        if (isEmpty()) {
            throw new ListException("the list is empty it has no elements to recover");
        }//if the list is empty send an exception message
        return this.end.element;
    }//return the last node of the list

    @Override
    public Object firstInList() throws ListException{
        if (isEmpty()) {
            throw new ListException("the list is empty it has no elements to recover");
        }//if the list is empty send an exception message
        return this.start.element;
    }//return the first node of the list
    
    @Override
    public String toString() {
        String nodesElements="";
        for (int i = 0; i < this.size; i++) {
            nodesElements+=this.getByPosition(i);
            if (i<this.size-1) {
                nodesElements+=",";
            }//add commas to string
        }//add the elements of the list to a string
        return "The CircularDoubleLinkedList has "+this.size+" nodes and its elements are:\n{" +nodesElements+ '}';
    }//to string
    
}//class 28/4/2023