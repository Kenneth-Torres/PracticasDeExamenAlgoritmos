/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import Logic.CircularDoubleLinkedList;
import Logic.StackLinkedList;

/**
 *
 * @author Laboratorios
 */
public class Lista3Pilas {
    
    private CircularDoubleLinkedList pilas;
    private StackLinkedList auxStack;

    public Lista3Pilas() {
        this.pilas = new CircularDoubleLinkedList();
        this.pilas.addEnd(new StackLinkedList());
        this.pilas.addEnd(new StackLinkedList());
        this.pilas.addEnd(new StackLinkedList());
        this.auxStack = new StackLinkedList();
    }

    public void insertar(int elemento) {
        if (elemento > 0 && elemento < 34) {
            this.pilas.getByPosition(0).push(elemento);
        } else if (elemento >= 34 && elemento < 67) {
            this.pilas.getByPosition(1).push(elemento);
        } else if (elemento >= 67 && elemento < 100) {
            this.pilas.getByPosition(2).push(elemento);
        }
    }

    public boolean existe(int elemento) {
        for (int i = 0; i < this.pilas.getSize(); i++) {
            if(this.pilas.getByPosition(i).exists(elemento)) return true;
        }
        return false;
    }

    public void modificar(int elemento1, int elemento2) {
        this.auxStack.cancel();
        for (int i = 0; i < this.pilas.getSize(); i++) {
            StackLinkedList auxS = this.pilas.getByPosition(i);
            for (int j = auxS.getSize() - 1; j > -1; j--) {
                if (auxS.top().equals(elemento1)) {
                    System.out.println("\nremplazado " + auxS.pop());
                    this.auxStack.push(elemento2);
                    break;
                }
                this.auxStack.push(auxS.pop());
            }
            for (int j = this.auxStack.getSize() - 1; j > -1; j--) {
                auxS.push(this.auxStack.pop());
            }
        }
    }

    public void etiquetar(int numPila, int posición) {
        this.auxStack.cancel();
        int contsdor = 0;
        StackLinkedList auxS = this.pilas.getByPosition(numPila);
        while (contsdor != posición) {
            this.auxStack.push(auxS.pop());
            contsdor++;
        }
        System.out.println("\netiquetado " + auxS.pop());
        this.auxStack.push("etiquetado");
        for (int j = this.auxStack.getSize() - 1; j > -1; j--) {
            auxS.push(this.auxStack.pop());
        }
    }

    public void mostrar(int valorInicial, int valorFinal) {
        System.out.println("\nvalorInicial=="+valorInicial+" y valorFinal=="+valorFinal);
        if (valorInicial > 0) {
            System.out.println("Rango de 1 a 33. Cantidad de elementos: " + this.pilas.getByPosition(0).size);
        }
        if (valorFinal > 33) {
            System.out.println("Rango de 34 a 66. Cantidad de elementos: " + this.pilas.getByPosition(1).size);
        }
        if (valorFinal > 66) {
            System.out.println("Rango de 67 a 99. Cantidad de elementos: " + this.pilas.getByPosition(2).size);
        }
    }

    public String rangoMayor() {
        if (this.pilas.getByPosition(1).size > this.pilas.getByPosition(0).size && this.pilas.getByPosition(1).size > this.pilas.getByPosition(2).size) {
            return "Rango del 34 al 66 tiene mas elementos con un total de " + this.pilas.getByPosition(1).size;
        } else if (this.pilas.getByPosition(2).size > this.pilas.getByPosition(0).size && this.pilas.getByPosition(2).size > this.pilas.getByPosition(1).size) {
            return "Rango del 67 al 99 tiene mas elementos con un total de " + this.pilas.getByPosition(2).getSize();
        }
        return "Rango del 1 al 33 tiene mas elementos con un total de " + this.pilas.getByPosition(0).getSize();
    }

    @Override
    public String toString() {
        String pilas = "Lista3Pilas pilas";
        for (int i = 0; i < this.pilas.getSize(); i++) {
            pilas += "\nPila " + (i+1) + "\n" + this.pilas.getByPosition(i).toString();
        }
        return pilas;
    }
 
}
