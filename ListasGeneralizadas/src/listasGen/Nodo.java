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

public void eliminar(Nodo cabeza, int dato, Nodo anterior_cabeza) {

        Nodo Anterior, nodoactual;

        nodoactual = cabeza;
        Anterior = nodoactual;

        boolean datoe = buscar(dato);

        if (datoe == true) {

            while (cabeza != null) {

                /* llamado recursivo para acceder a la liga de la lista generalizada
                Guardamos la cabeza de la lista generalizada para: si el dato a 
                borrar es un nodo cabeza poder enlazarla sin perder los datos*/
                if (cabeza.ligaLista != null) {

                    eliminar(cabeza.ligaLista, dato, cabeza);
                }

                //Eliminamos si el dato es la raiz
                if (dato == this.raiz.dato) {

                    if (this.raiz.liga == null && this.raiz.ligaLista == null) {

                        this.raiz = null;

                    } else if (this.raiz.ligaLista != null) {

                        this.raiz = this.raiz.ligaLista;

                    } else {

                        this.raiz = this.raiz.liga;
                    }
                } else if (nodoactual.dato == dato) {

                    //eliminamos si el nodo es un nodo cabeza (lista de listas
                    if (cabeza == Anterior) {

                        anterior_cabeza.ligaLista = nodoactual.liga;
                        nodoactual.liga = null;
                        nodoactual = anterior_cabeza.ligaLista;
                    } // eliminamos si es diferente a nulo y no es lista de listas
                    else if (nodoactual.liga != null) {

                        Anterior.liga = nodoactual.liga;
                        nodoactual.liga = null;

                        // eliminamos cuando el nodo esta apuntando a nulo
                    } else if (nodoactual.liga == null) {

                        Anterior.liga = null;

                    }
                }
                //avanza en el ciclo y guarda el nodo anterior de la lista normal
                cabeza = cabeza.liga;
                Anterior = nodoactual;
                nodoactual = cabeza;
            }

        } else {

            JOptionPane.showMessageDialog(null, "Dato no encontrado");
        }
    }
}
