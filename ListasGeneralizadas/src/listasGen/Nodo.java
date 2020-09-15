package listasGen;

/*Clase para crear objetos Nodo, los cuales seran el
objeto fundamental en la listas generalizadas.*/


public class Nodo {

    public int dato;
    public Nodo liga;
    public Nodo ligaLista;

    /*Constructores*/

    public Nodo(int dato, Nodo liga, Nodo ligaLista){

        this.dato = dato;
        this.liga = liga;
        this.ligaLista = ligaLista;

    }

    public Nodo(int dato, Nodo liga){

        this.dato = dato;
        this.liga = liga;
        ligaLista = null;
    }

    public Nodo(int dato){

        this.dato = dato;
        this.liga = null;
        ligaLista = null;
    }

    public Nodo(Nodo liga, Nodo ligaLista){

        this.dato = -1;
        this.liga = liga;
        ligaLista = null;
    }

    /**/

}
