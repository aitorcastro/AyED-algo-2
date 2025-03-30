package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        //return Math.sqrt(cuadrado(x)+cuadrado(y));
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
    }

    int factorialIterativo(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    int factorialRecursivo(int n) {
        int factorial = 0;
        if (n == 0) factorial = 1;
        else factorial = factorialRecursivo(n-1)*n;
        return factorial;
    }

    boolean esPrimo(int n) {
        int cont = 0;
        for (int i = 1;i <= n; i++){
            if (n % i == 0) cont++;
        }        
        return cont == 2;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++){
            res = res + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int pos = 0;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscado) pos = i;
        }
        return pos;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i < numeros.length; i++){
            if (esPrimo(numeros[i])) res = true;
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < numeros.length; i++){
            if (!esPar(numeros[i])) res = false;
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        for (int i = 0; i < s1.length(); i ++){
            if (s1.length() > s2.length()) res = false;
            else if (s1.charAt(i) != s2.charAt(i)) res = false;
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        String s1Reves = "";
        for (int i = s1.length() - 1; i >= 0; i --){
            s1Reves = s1Reves + s1.charAt(i);
        }
        String s2Reves = "";
        for (int i = s2.length() - 1; i >= 0; i --){
            s2Reves = s2Reves + s2.charAt(i);
        }

        return esPrefijo(s1Reves, s2Reves);
    }
}
