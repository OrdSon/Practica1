/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lists;

import java.io.Serializable;

/**
 * 
 * @author Grupo1
 * @param <T>
 */
public class Nodo<T> implements Serializable{
    int indiceNodo;
    private T contenido;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo(T contenido) {
        this.contenido = contenido;
    }

    public Nodo(T contenido, Nodo<T> siguiente) {
        this.contenido = contenido;
        this.siguiente = siguiente;

    }

    public Nodo(T contenido, Nodo<T> siguiente,Nodo<T> anterior) {
        this.contenido = contenido;
        this.siguiente = siguiente;
        this.anterior = anterior;

    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public int getIndiceNodo() {
        return indiceNodo;
    }

    public void setIndiceNodo(int indiceNodo) {
        this.indiceNodo = indiceNodo;
    }
    
}
