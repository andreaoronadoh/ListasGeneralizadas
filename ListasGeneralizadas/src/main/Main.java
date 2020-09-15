package main;

import listasGen.ArbolnArio;

public class Main {

    public static void main(String[] args){

        ArbolnArio arbol = new ArbolnArio(0);

        arbol.insertar(0, 1);
        arbol.insertar(0, 2);
        arbol.insertar(0, 3);

        arbol.insertar(1, 4);
        arbol.insertar(1, 5);

        arbol.insertar(4, 6);
        arbol.insertar(4, 7);

        /*arbol.insertar(1, 5);
        arbol.insertar(1, 6);

        arbol.insertar(6, 7);
        arbol.insertar(6, 8);
        //arbol.insertar(1, 6);*/

        arbol.mostrar();

        System.out.println(arbol.buscar(10));

    }
}
