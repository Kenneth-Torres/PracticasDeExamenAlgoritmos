/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public class LinkedListQueue implements Queue{

    private Node start;
    private Node end;
    private int size;

    public LinkedListQueue() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }//constructor

    @Override
    public void cancel() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }//method to clear de queue

    @Override
    public int getSize() {
        return this.size;
    }//method return a number of elements in the queue 

    @Override
    public boolean isEmpty() {
        return this.start == null;
    }//method returns a boolean indicating whether the queue is empty.

    @Override
    public void insert(Object element) {
        if (this.isEmpty()) {//valid a special case when the queue is empty
            this.start = new Node(element);
            this.end = this.start;
        } else {//if it is not empty, the new elements will be added to the end of the last known node of the queue.
            this.end.nextNode = new Node(element);//a new node will be added next to the end
            this.end.nextNode.previusNode = this.end;//the new node will default to the current end node.
            this.end = this.end.nextNode;//replaces a end node
        }//end if else
        this.size++;
    }//method to add a new element in the queue
    
     @Override
    public void insertWithPriority(Object element, int priority) {
        Node newNode=new Node(element,priority);
        if (this.isEmpty()) {//valid a special case when the queue is empty
            this.start = newNode;
            this.end = this.start;
        }else if (this.start.priority < priority) {
            this.start.previusNode=newNode;
            this.start.previusNode.nextNode=this.start;
            this.start=this.start.previusNode;
        }else if (this.end.priority > priority) {
            this.end.nextNode=newNode;
            this.end.nextNode.previusNode=this.end;
            this.end=this.end.nextNode;
        } else {//if it is not empty, the new elements will be added to the end of the last known node of the queue.
            Node aux=this.start;
            while (aux.nextNode!=null && aux.nextNode.priority > priority) {                
                aux=aux.nextNode;
            }//walk a queue
            newNode.previusNode=aux;
            newNode.nextNode=aux.nextNode;
            aux.nextNode.previusNode=newNode;
            aux.nextNode=newNode;
        }//end if else
        this.size++;
    }//method to add a new element in the queue with priority

    @Override
    public Object firstElement() throws ListException {
        if (this.isEmpty()) {
            throw new ListException("The queue is empty");
        }//return a exception if this queue is empty
        return this.start.element;
    }//method return an element to the start node

    @Override
    public Object delete() throws ListException {
        if (this.isEmpty()) {//return a exception if this queue is empty
            throw new ListException("The queue is empty");
        } else {//else return a element
            Object aux = this.start.element;//save a element in aux node
            this.start = this.start.nextNode;//replace a start node
            if (this.size>1)this.start.previusNode = null;//Verify that this action is only performed when there is more than one node left
            this.size--;
            return aux;//return element
        }//end if else
    }//method return an element to the start node and replaces it

    @Override
    public String toString() {
        String elements = "{";
        Node auxNode = this.start;
        while (auxNode != null) {
            elements += "[ " + auxNode.element + " ]";
            auxNode=auxNode.nextNode;
        }//walk the queue
        elements += "}";
        return "LinkedListQueue has a size of " + this.size + " and the following items\n" + elements;
    }//toString
    
}//class 10/5/2023
