package listasGen;

import excepciones.ExcepcionNodoNoEncontrado;

import java.util.ArrayList;

public class ArbolnArio {

    /*Clase para crear objetos de tipo arbol n-ario a partir de listas generalizadas.*/

    Nodo raiz;


    /*Constructores*/

    public ArbolnArio(Nodo raiz) {

        this.raiz = raiz;

    }

    public ArbolnArio(int raiz) {

        this.raiz = new Nodo(raiz);

    }

    public void insertar(Nodo raiz, int raizInsertar, int datoInsertar) {

        /*Metodo para insertar nodos en el arbol. Crea �tomos o listas de acuerdo a donde se
         *    encontro el nodo raiz.*/

        Nodo nodoActual = raiz;

        if (raiz.dato == raizInsertar) {

            System.out.println("Insertando: " + datoInsertar);

            Nodo nuevoNodo = new Nodo(datoInsertar, nodoActual.liga, null);
            nuevoNodo.liga = nodoActual.liga;
            nodoActual.liga = nuevoNodo;

            return;
        }

        while (nodoActual != null) {

            if (nodoActual.dato == raizInsertar) {

                //Lo hace esto es poner el nodo vacio, en caso de que sea necesario

                Nodo nodoInsertar = new Nodo(datoInsertar, null, null);
                Nodo nodoVacio = new Nodo(nodoActual.dato, nodoInsertar, null);

                nodoActual.dato = -1;
                nodoActual.ligaLista = nodoVacio;

                return;
            }

            if (nodoActual.ligaLista != null) {
                insertar(nodoActual.ligaLista, raizInsertar, datoInsertar);
            }

            nodoActual = nodoActual.liga;

        }
    }

    public void insertar(int raizInsertar, int datoInsertar) {

        /*Sobrecarga no recursiva del metodo insertar.*/

        insertar(raiz, raizInsertar, datoInsertar);
    }

    public Nodo buscar(Nodo raiz, int dato) throws ExcepcionNodoNoEncontrado {

        /*Busca si un dato esta o no en el arbol, retorna un boolean.*/

        Nodo nodoActual = raiz;

        while (nodoActual != null) {

            if (nodoActual.dato == dato)
                return nodoActual;

            if (nodoActual.ligaLista != null) {
                return buscar(nodoActual.ligaLista, dato);
            }

            nodoActual = nodoActual.liga;

        }

        throw new excepciones.ExcepcionNodoNoEncontrado("No se encontró el nodo (" + dato + ")");

    }

    public Nodo buscar(int dato) throws ExcepcionNodoNoEncontrado {
        return buscar(raiz, dato);
    }

    public static void mostrar(Nodo raiz) {

        Nodo nodoActual = raiz;

        while (nodoActual != null) {

            System.out.println(nodoActual.dato);

            if (nodoActual.ligaLista != null) {
                mostrar(nodoActual.ligaLista);
            }

            nodoActual = nodoActual.liga;

        }
    }

    private ArrayList<Integer> raices(Nodo cabeza){

        /*Devuelve las raices mediante, mediante un ArrayList*/

        ArrayList<Integer> arrayRaices = new ArrayList<Integer>();

        Nodo p = cabeza;

        while (p != null) {

            if (p == cabeza)
                arrayRaices.add(p.dato);

            if (p.ligaLista != null)
                arrayRaices.addAll(raices(p.ligaLista));

            p = p.liga;
        }

        return arrayRaices;
    }



    public ArrayList<Integer> raices(){

        /*Sobrecarga no recursiva del método raices*/

        return raices(raiz);
    }

    private ArrayList<Integer> hojas(Nodo cabeza){

        /*Retorna hojas del arbol*/

        ArrayList<Integer> arrayHojas = new ArrayList<Integer>();

        Nodo p = cabeza;

        while (p != null) {

            if (p != cabeza && p.dato != -1)
                arrayHojas.add(p.dato);


            if (p.ligaLista != null)
                arrayHojas.addAll(hojas(p.ligaLista));

            p = p.liga;
        }

        return arrayHojas;
    }

    public ArrayList<Integer> hojas(){

        /*Sobrecarga no recursiva del método hojas*/

        return hojas(raiz);
    }

    private int grado(Nodo cabeza, int dato ) throws ExcepcionNodoNoEncontrado {

        /*Cálcula el grado de un nodo especificado. Si el no se encuentra
        * un nodo con el dato solicitado, lanza excepción.*/

        Nodo p = cabeza;

        int grado = -1;

        while(p != null){

            if(p.dato == dato){

                if(p == cabeza){ //Comprueba si el dato es un raíz o una hoja
                    while(p != null){
                        grado++;
                        p = p.liga;
                    }
                    return grado;
                }else{
                    return 0;
                }
            }

            if(p.ligaLista != null){
                return grado(p.ligaLista, dato);
            }
            p = p.liga;
        }

        throw new excepciones.ExcepcionNodoNoEncontrado("No se encontró el nodo (" + dato + ")");
    }

    public int grado(int dato) throws ExcepcionNodoNoEncontrado {
        return grado(raiz, dato);
    }

    private int grado(Nodo cabeza){

        /*Calcula grado de subarbol*/

        Nodo p = cabeza;

        int grado = -1;

        int gradoMayor = 0;
        int gradoAux;

        while(p != null) {

            if(p.ligaLista != null){

                gradoAux = grado(p.ligaLista);

                if(gradoAux > gradoMayor){
                    gradoMayor = gradoAux;
                }
            }

            grado++;
            p = p.liga;
        }

        return Math.max(grado, gradoMayor);
    }

    public Nodo padre(Nodo cabeza, int dato) throws ExcepcionNodoNoEncontrado {

        Nodo p = cabeza;

        while(p != null){

            if(p.ligaLista != null){

                if(p.ligaLista.dato == dato)
                    return cabeza;
                else
                    return padre(p.ligaLista, dato);
            }

            if(p.dato == dato){
                return cabeza;
            }

            p = p.liga;
        }

        throw new excepciones.ExcepcionNodoNoEncontrado("No se encontró el nodo (" + dato + ")");
    }

    public Nodo padre(int dato) throws ExcepcionNodoNoEncontrado {
        return padre(raiz, dato);
    }


    public int grado(){
        return grado(raiz);
    }

    public void mostrar(){
        mostrar(raiz);
    }

    /*Metodos para recuperar informacion sobre la lista generalizada sobre la cual esta hecho el arbol*/

    Nodo getRaiz(){
        return raiz;
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
