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
public class Lista<T> implements Serializable{

    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;
    private int ultimoIndice;

    public void add(T contendio) {
        ultimoIndice++;
        Nodo<T> nuevo = new Nodo<>(contendio);
        if (esVacia()) {
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        } else {
            nuevo.setAnterior(ultimoNodo);
            ultimoNodo.setSiguiente(nuevo);
            ultimoNodo = nuevo;
        }
    }

    public void addFirst(T contenido) {
        Nodo<T> temporal;
        if (esVacia()) {
            temporal = new Nodo<>(contenido);
            primerNodo = temporal;
            ultimoNodo = temporal;
        } else {
            temporal = new Nodo<>(contenido);
            temporal.setSiguiente(primerNodo);
            primerNodo.setAnterior(temporal);
            primerNodo = temporal;
        }
        ultimoIndice++;
    }

    public boolean esIndiceValido(int indice) {
        return !(indice < 0 || indice >= ultimoIndice);
    }

    public void insertar(T contenido, int indice) {
        if (!esIndiceValido(indice)) {
            System.out.println("indiceChueco" + indice + "tamañoDeLista: " + ultimoIndice);
        }
        if (indice == 0) {
            addFirst(contenido);
        } else if (indice == (ultimoIndice - 1)) {
            add(contenido);
        } else {
            Nodo<T> anterior = obtenerPorIndice(indice - 1);
            Nodo<T> actual = obtenerPorIndice(indice);
            Nodo<T> temporal = new Nodo<>(contenido);
            anterior.setSiguiente(temporal);
            temporal.setSiguiente(actual);
            temporal.setAnterior(anterior);
            actual.setAnterior(temporal);

            ultimoIndice++;
        }
    }

    public void eliminarUltimo() throws Exception {
        if (esVacia()) {
            throw new Exception("ERROR. Lista Vacia");
        }
        if (primerNodo.equals(ultimoNodo)) {
            primerNodo = null;
            ultimoNodo = null;
        } else {
            ultimoNodo.setAnterior(null);
            Nodo<T> penultimo = obtenerPorIndice(ultimoIndice - 2);
            penultimo.setSiguiente(null);
            ultimoNodo = penultimo;
        }
        ultimoIndice--;
    }

    public void eliminarPrimero() throws Exception {
        if (esVacia()) {
            throw new Exception("ERROR. Lista Vacia");
        }
        if (primerNodo.equals(ultimoNodo)) {
            primerNodo = null;
            ultimoNodo = null;
        } else {
            primerNodo = primerNodo.getSiguiente();
            primerNodo.setAnterior(null);
        }
        ultimoIndice--;
    }

    public int getSize() {
        return ultimoIndice;
    }

    public boolean esVacia() {
        return primerNodo == null;
    }

    public Nodo<T> obtenerPorIndice(int indice) {
        if (esIndiceValido(indice) == false) {

        }
        Nodo<T> buscado = primerNodo;
        for (int i = 0; i < indice; i++) {
            buscado = buscado.getSiguiente();
        }
        return buscado;
    }

    public void eliminar(int indice) {
        if (esVacia() || esIndiceValido(indice) == false) {
        } else if (indice == 0) {

        } else if (indice == (ultimoIndice - 1)) {

        } else {
            Nodo<T> nodoAnterior = obtenerPorIndice(indice - 1);
            Nodo<T> nodoActual = obtenerPorIndice(indice);
            Nodo<T> nodoSiguiente = nodoActual.getSiguiente();
            nodoActual = null;
            nodoAnterior.setSiguiente(nodoSiguiente);
            nodoSiguiente.setAnterior(nodoAnterior);
            ultimoIndice--;
        }
    }

    public T get(int indice) {
        if (esIndiceValido(indice) == false) {

        }
        Nodo<T> buscado = primerNodo;
        for (int i = 0; i < indice; i++) {
            buscado = buscado.getSiguiente();
        }
        return buscado.getContenido();
    }

    public void modifica(T contenido, int indice) {
        if (esVacia() || esIndiceValido(indice) == false) {
        } else {

            obtenerPorIndice(indice).setContenido(contenido);

        }
    }

    public boolean existe(T contenido) {
        if (esVacia()) {
            return false;
        } else {
            Nodo<T> temporal = primerNodo;
            while (temporal != null) {
                if (contenido == temporal.getContenido()) {
                    return true;
                }
                temporal = temporal.getSiguiente();
            }

        }
        return false;
    }

    public int indexOf(T contenido) {
        if (esVacia()) {
            return -1;
        } else {
            Nodo<T> temporal = primerNodo;
            return buscar(contenido, temporal, 0);
        }
    }

    public int buscar(T contenido, Nodo<T> temporal, int contador) {
        if (temporal == null) {
            return -1;
        }
        if (contenido == temporal.getContenido()) {
            return contador;
        }
        contador++;
        temporal = temporal.getSiguiente();
        int cuenta = buscar(contenido, temporal, contador);
        return cuenta;
    }


//        public void asignaIndices() {
//            Nodo<T> buscado = primerNodo;
//            buscado.setIndiceNodo(0);
//            for (int i = 0; i < ultimoIndice; i++) {
//                buscado = buscado.getSiguiente();
//                buscado.setIndiceNodo(i + 1);
//            }
//        }
public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }

    public T getFirst() {
        return primerNodo.getContenido();
    }

    public T getLast() {
        return ultimoNodo.getContenido();
    }

    public void setFirst(T content) {
        primerNodo.setContenido(content);
    }

    public void setLast(T content) {
        ultimoNodo.setContenido(content);
    }

    public void setPrimerNodo(Nodo<T> primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo<T> getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo<T> ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

}
