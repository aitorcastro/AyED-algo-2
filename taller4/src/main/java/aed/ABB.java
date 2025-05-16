package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo arriba;

        // Crear Constructor del nodo
        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            arriba = null;
        }
    }

    public ABB() {
        //throw new UnsupportedOperationException("No implementada aun");
        _raiz = null;
    }

    
    private int cardinalRecursivo(Nodo n){
        if (n == null) {
            return 0;
        } else {
            return 1 + cardinalRecursivo(n.izq) + cardinalRecursivo(n.der);
        }
    }
    public int cardinal() {
        //throw new UnsupportedOperationException("No implementada aun");
        if (_raiz == null){
            return 0;
        }
        return cardinalRecursivo(_raiz);
    }

    private T minimoRecursivo(Nodo n){
        if (n.izq == null) return n.valor;
        return minimoRecursivo(n.izq);
    }
    public T minimo(){
        //throw new UnsupportedOperationException("No implementada aun");
        return minimoRecursivo(_raiz);
    }

    private T maximoRecursivo(Nodo n){
        if (n.der == null) return n.valor;
        return maximoRecursivo(n.der);
    }
    public T maximo(){
        //throw new UnsupportedOperationException("No implementada aun");
        return maximoRecursivo(_raiz);
    }

    private Nodo insertarRecursivo(Nodo actual, T elem){
        if (actual == null){
            return new Nodo(elem);
        }

        if (elem.compareTo(actual.valor)< 0){
            actual.izq = insertarRecursivo(actual.izq, elem);
            actual.izq.arriba = actual;
        } else if (elem.compareTo(actual.valor)> 0){
            actual.der = insertarRecursivo(actual.der, elem);
            actual.der.arriba = actual;
        }
        return actual;
    }
    public void insertar(T elem){
        //throw new UnsupportedOperationException("No implementada aun");
        _raiz = insertarRecursivo(_raiz, elem);
    }
    
    private boolean perteneceRecursivo(T elem, Nodo n){
        boolean res = false;
        if (n == null){
            res = false;
        } else if (elem.compareTo(n.valor) == 0){
            res = true;
        } else if (elem.compareTo(n.valor) < 0){
            res = perteneceRecursivo(elem, n.izq);
        } else if (elem.compareTo(n.valor) > 0){
            res = perteneceRecursivo(elem, n.der);
        }
        return res;
    }
    public boolean pertenece(T elem){
        //throw new UnsupportedOperationException("No implementada aun");
        return perteneceRecursivo(elem, _raiz);
    }

    private Nodo eliminarRecursivo(Nodo actual, T elem) {
        if (elem.compareTo(actual.valor) < 0) {
            actual.izq = eliminarRecursivo(actual.izq, elem);
        } else if (elem.compareTo(actual.valor) > 0) {
            actual.der = eliminarRecursivo(actual.der, elem);
        } else {
            if (actual.izq == null && actual.der == null) {
                return null;
            } else if (actual.izq == null) {
                actual.der.arriba = actual.arriba; 
                return actual.der;
            } else if (actual.der == null) {
                actual.izq.arriba = actual.arriba; 
                return actual.izq;
            } else {
                T minValue = minimoRecursivo(actual.der); 
                actual.valor = minValue; 
                actual.der = eliminarRecursivo(actual.der, minValue); 
            }
        }
        return actual;
    }
    
    public void eliminar(T elem){
        //throw new UnsupportedOperationException("No implementada aun");
        _raiz = eliminarRecursivo(_raiz, elem);
    }
    @Override
    public String toString(){
        //throw new UnsupportedOperationException("No implementada aun");
        String abbString = "{" + toStringRecursivo(_raiz) + "}";
        return abbString;
    }
    private String toStringRecursivo(Nodo actual){
        if (actual == null) {
            return "";
        }
        String izq = toStringRecursivo(actual.izq);
        String valor = actual.valor.toString();
        String der = toStringRecursivo(actual.der);

        //return izq + ", " + valor + ", " + der;
        String resultado = "";
        if (actual.izq != null) {
            resultado += izq + ",";
        }

        resultado += valor;

        if (actual.der != null) {
            resultado += "," + der;
        }
        return resultado;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador() {
            _actual = _raiz;
            if (_actual != null) {
                while (_actual.izq != null) {
                    _actual = _actual.izq;
                }
            }
        }

        public boolean haySiguiente() {            
            //throw new UnsupportedOperationException("No implementada aun");
            return _actual != null;
        }
    
        public T siguiente() {
            //throw new UnsupportedOperationException("No implementada aun");
            T valor = _actual.valor;
            if (_actual.der != null) {
                _actual = _actual.der;
                while (_actual.izq != null) {
                    _actual = _actual.izq;
                }
            } else {
                while (_actual.arriba != null && _actual == _actual.arriba.der) {
                    _actual = _actual.arriba;
                }
                _actual = _actual.arriba;
            }
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
