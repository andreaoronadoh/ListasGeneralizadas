package main;

import excepciones.ExcepcionNodoNoEncontrado;
import listasGen.ArbolnArio;

public class Main {

    public static void main(String[] args) throws ExcepcionNodoNoEncontrado {

        ArbolnArio arbol = new ArbolnArio(0);

        arbol.insertar(0, 1);
        arbol.insertar(0, 2);

        arbol.insertar(1, 4);
        arbol.insertar(1, 5);

        arbol.insertar(4, 6);
        arbol.insertar(4, 7);
        arbol.insertar(4, 8);
        arbol.insertar(4, 9);
        arbol.insertar(4, 10);

        arbol.mostrar();

        System.out.println("\nRaices: ");
        System.out.println(arbol.raices());

        System.out.println("\nHojas: ");
        System.out.println(arbol.hojas());

        System.out.println("\nBuscando dato (1): ");
        System.out.println(arbol.buscar(1).dato);

        int dato = 42;

        /*System.out.println("\nGrado de (" + dato + "): ");
        System.out.println(arbol.grado(dato));

        System.out.println("Grado del arbol: ");
        System.out.println(arbol.grado());*/

        System.out.println("Cabeza de  (" + dato + "): " + arbol.padre(dato).dato);

    }
}
