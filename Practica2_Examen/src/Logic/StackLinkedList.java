/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Ernesto
 */
public class StackLinkedList implements Stack{
    
    public NodeStack startNode; 
    public int size;

    public StackLinkedList() {
        this.startNode = null;
        this.size = 0;
    }//constructor

    @Override
    public void cancel() {
        this.startNode = null;
        this.size = 0;
    }//delete all elements of the stack

    @Override
    public int getSize() {
        NodeStack aux = this.startNode;
        int i;
        for (i = 0; aux != null; i++) {
            aux = aux.nextNode;
        }//count the items in the list
        return i;
    }//return the number of elements in the stack

    @Override
    public boolean isEmpty() {
        return this.startNode == null;
    }//returns true if the stack is empty

    @Override
    public Object top() throws ListException {
        if (this.isEmpty()) {
            throw new ListException("the stack is empty it has no elements to recover");
        }//if the stack is empty send an exception message
        return this.startNode.element;
    }//return the first node of the stack

    @Override
    public void push(Object elemnet) {
        NodeStack newNode = new NodeStack(elemnet);
        newNode.nextNode = this.startNode;
        this.startNode = newNode;
        this.size++;
    }//add node in the stack

    @Override
    public Object pop() throws ListException {
        if (this.isEmpty()) {
            throw new ListException("the stack is empty it has no elements to recover");
        }//if the stack is empty send an exception message
        NodeStack aux = this.startNode;//retrieves the information and saves it in an auxiliary
        this.startNode = this.startNode.nextNode;//deleting the initial node from the stack
        this.size--;
        return aux.element;
    }//returns the first element of the stack and deletes it

    @Override
    public String toString() throws ListException {
        if (this.isEmpty()) {//if the stack is empty send an exception messag
            throw new ListException("the stack is empty it has no elements to recover");
        } else {
            NodeStack aux = this.startNode;
            String nodesElements = "";
            for (int i = this.size; i > 0; i--) {
                nodesElements += " [ " + aux.element + " ] ";
                aux = aux.nextNode;
            }//add the elements of the list to a string
            return "The StackLinkedList has " + this.getSize() + " nodes and its elements are:\n{" + nodesElements + '}';
        }
    }//to string

    @Override
    public boolean exists(Object elementToCheck) {
        NodeStack auxNode = this.startNode;
        while (auxNode != null) {
            if (auxNode.element.equals(elementToCheck)) {
                return true;
            }//buys the element of the node with the element searched for
            auxNode = auxNode.nextNode;//change the node to the following
        }//look for a node
        return false;//returns false if the element was not found
    }

}//class 5/5/2023
