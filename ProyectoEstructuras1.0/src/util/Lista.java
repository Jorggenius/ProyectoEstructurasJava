/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author JORGE
 */
public class Lista<S> implements IList<S>, Serializable{

    private Nodo<S>  primero;
    private int size;

    public Lista() {
        this.primero = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(S dato) {
        Nodo<S> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<S> aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        size++;
    }

    public S get(int index) {
        if (index == 0) {
            return primero.dato;
        } else {
            Nodo<S> aux = primero;
            int contador = 0;
            while (contador < index) {
                aux = aux.siguiente;
                contador++;
            }
            return aux.dato;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango:" + index);
        }
        if (index == 0) {
            primero = primero.siguiente;
        } else {
            Nodo<S> aux = primero;
            int contador = 0;
            while (contador < index - 1) {
                aux = aux.siguiente;
                contador++;
            }
            Nodo<S> nodoAEliminar = aux.siguiente;
            aux.siguiente = nodoAEliminar.siguiente;
        }
        size--;
    }

    public void add( S dato ,int index) {
        Nodo<S> nuevo = new Nodo(dato);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango:" + index);
        } else if (index == 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            Nodo<S> aux = primero;
            int contador = 0;
            while (contador < index - 1) {
                aux = aux.siguiente;
                contador++;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
        size++;
    }

    public boolean isEmpty() {
        return primero == null;
    }
}
