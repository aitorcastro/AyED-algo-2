package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;


    private class Nodo {
        T dato;
        Nodo anterior;
        Nodo siguiente;

        Nodo(T d) {
            dato = d;
            anterior = null;
            siguiente = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo nuevo = new Nodo(elem);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo nuevo = new Nodo(elem);
        if (ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        longitud++;
    }

    public T obtener(int i) {
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo actual = primero;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public void eliminar(int i) {
        //throw new UnsupportedOperationException("No implementada aun");
        if (longitud == 1) {
            primero = null;
            ultimo = null;
        } else if (i == 0) {
            primero = primero.siguiente;
            primero.anterior = null;
        } else if (i == longitud - 1) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
        } else {
            Nodo actual = primero;
            for (int j = 0; j < i; j++) {
                actual = actual.siguiente;
            }
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo actual = primero;
        for (int j = 0; j < indice; j++) {
            actual = actual.siguiente;
        }
        actual.dato = elem;
    }

    public ListaEnlazada<T> copiar() {
        //throw new UnsupportedOperationException("No implementada aun");
        ListaEnlazada<T> copia = new ListaEnlazada<>();
        Nodo actual = primero;
        while (actual != null) {
            copia.agregarAtras(actual.dato);
            actual = actual.siguiente;
        }
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        //throw new UnsupportedOperationException("No implementada aun");
        primero = null;
        ultimo = null;
        longitud = 0;
        
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.dato);
            actual = actual.siguiente;
        }
    }
    
    @Override
    public String toString() {
        //throw new UnsupportedOperationException("No implementada aun");
        String listaString = "[";
        Nodo actual = primero;
        while(actual != null) {
            listaString += actual.dato;
            if(actual.siguiente != null) {
                listaString += ", ";
            }
            actual = actual.siguiente;
        }
        listaString += "]";
        return listaString;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        private Nodo anterior;
        private Nodo siguiente;

        public ListaIterador() {
            anterior = null;
            siguiente = primero;
        }            

        public boolean haySiguiente() {
	        //throw new UnsupportedOperationException("No implementada aun");
            return siguiente != null;
        }
        
        public boolean hayAnterior() {
	        //throw new UnsupportedOperationException("No implementada aun");
            return anterior != null;
        }

        public T siguiente() {
	        //throw new UnsupportedOperationException("No implementada aun");
            T dato = siguiente.dato;
            anterior = siguiente;
            siguiente = siguiente.siguiente;
            return dato;            
        }
        

        public T anterior() {
	        //throw new UnsupportedOperationException("No implementada aun");
            T dato = anterior.dato;
            siguiente = anterior;
            anterior = anterior.anterior;
            return dato;
        }
    }

    public Iterador<T> iterador() {
	    //throw new UnsupportedOperationException("No implementada aun");
        return new ListaIterador();
    }

}
