/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.List;
import Logic.List;
import Logic.ListException;
import Logic.ListException;
import Logic.ListException;
import Logic.Node;
import Logic.Node;
import Logic.Node;

/**
 *
 * @author Laboratorios
 */
public class DoubleLinkedList implements List{
    
    public Node start;
    private Node end;
    public int size;

    public DoubleLinkedList() {
        this.start = null;
        this.size = 0;
    }//constructor
    
     @Override
    public void cancel() {
        this.start=null;
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
        while (auxNode!=null) {            
            if (auxNode.element.equals(element)) return true;//if compares the node element with the searched element
            auxNode = auxNode.nextNode;
        }//look for a node
        return false; 
    }// check if a node exists
    
    @Override
    public void addHead(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {//it is validated when the list is empty
            this.start = newNode;
            this.end=this.start;
        } else {//if you don't add new element at the beginning
            this.start.previusNode=newNode;
            this.start.previusNode.nextNode=this.start;
            this.start=this.start.previusNode;
        }
        this.size++;
    }//add an element to the beginning

    @Override
    public void addEnd(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {//it is validated when the list is empty
            this.start = newNode;
            this.end=this.start;
        } else {//if you don't add new element at the end
            this.end.nextNode=newNode;
            this.end.nextNode.previusNode=this.end;
            this.end=this.end.nextNode;
        }
        this.size++;
    }//add an element to the end

    @Override
    public StackLinkedList getByPosition(int index) throws ListException{
        if (isEmpty()) {
            throw new ListException("the list is empty it has no elements to recover");
        }//if the list is empty send an exception message
        if (index<0 || index>this.size) {
            throw new ListException("cannot recover node the index does not exist in the list");
        }//if the index does not exist in the list send an exception message
        Node auxNode=this.start;
        for (int i = 0; i < index; i++) {
           auxNode = auxNode.nextNode;
        }//the for changes the value of the aux node the requested i times
        return (StackLinkedList) auxNode.element;   
    }//search for an objectToDelete by a given position

    @Override
    public void deleteByElement(Object objectToDelete) throws ListException{
        if (isEmpty() || !this.exists(objectToDelete)) {//if the list is empty send an exception message
            throw new ListException("Cannot delete items from the list because it is empty or does not exist");
        }//if the list is empty send an exception message
        if (this.start.element.equals(objectToDelete) && this.size>1) {
            this.start = this.start.nextNode;
            this.start.previusNode = null;
        } else if (this.end.element.equals(objectToDelete) && this.size>1) {
            this.end=this.end.previusNode;
            this.end.nextNode=null;
        }else if (this.size==1) {
            this.start=null;
        } else {
            Node auxNode = this.start;
            while (auxNode!= null) {
                if (auxNode.element.equals(objectToDelete))break;//if compares the node objectToDelete with the searched objectToDelete
                auxNode = auxNode.nextNode;
            }//look for a node
            auxNode.previusNode.nextNode=auxNode.nextNode;
            auxNode.nextNode.previusNode=auxNode.previusNode;
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
        return "The DoubleLinkedList has "+this.size+" nodes and its elements are:\n{" +nodesElements+ '}';
    }//to string
    
}//class 19/4/2023
