package listasGen;

public class ArbolnArio {

    /*Clase para crear objetos de tipo arbol n-ario a partir de listas generalizadas.*/

    Nodo raiz;


    /*Constructores*/

    public ArbolnArio(Nodo raiz){

        this.raiz = raiz;

    }

    public ArbolnArio(int raiz){

        this.raiz = new Nodo(raiz);

    }

    public void insertar(Nodo raiz, int raizInsertar, int datoInsertar){

        /*Metodo para insertar nodos en el arbol. Crea �tomos o listas de acuerdo a donde se
        *    encontro el nodo raiz.*/

        Nodo nodoActual = raiz;

        if(raiz.dato == raizInsertar){

            System.out.println("Insertando: " + datoInsertar);

            Nodo nuevoNodo = new Nodo(datoInsertar, nodoActual.liga, null);
            nuevoNodo.liga = nodoActual.liga;
            nodoActual.liga= nuevoNodo;

            return;
        }

        while(nodoActual != null){

            if(nodoActual.dato == raizInsertar){

                //Lo hace esto es poner el nodo vacio, en caso de que sea necesario

                Nodo nodoInsertar = new Nodo(datoInsertar, null, null);
                Nodo nodoVacio = new Nodo(nodoActual.dato, nodoInsertar, null);

                nodoActual.dato = -1;
                nodoActual.ligaLista = nodoVacio;

                return;
            }

            if(nodoActual.ligaLista != null){
                insertar(nodoActual.ligaLista, raizInsertar, datoInsertar);
            }

            nodoActual = nodoActual.liga;

        }
    }

    public void insertar(int raizInsertar, int datoInsertar){

        /*Sobrecarga no recursiva del metodo insertar.*/

        insertar(raiz, raizInsertar, datoInsertar);
    }

    public boolean buscar(Nodo raiz, int dato){

        /*Busca si un dato esta o no en el arbol, retorna un boolean.*/

        Nodo nodoActual = raiz;

        while(nodoActual != null){

            if(nodoActual.dato == dato)
                return true;

            if(nodoActual.ligaLista != null){
                return buscar(nodoActual.ligaLista, dato);
            }

            nodoActual = nodoActual.liga;

        }

        return false;

    }

    public boolean buscar(int dato){
        return buscar(raiz, dato);
    }

    public static void mostrar(Nodo raiz){

        Nodo nodoActual = raiz;

        while(nodoActual != null){

            System.out.println(nodoActual.dato);

            if(nodoActual.ligaLista != null){
                mostrar(nodoActual.ligaLista);
            }

            nodoActual = nodoActual.liga;

        }
    }

    public void mostrar(){
        mostrar(raiz);
    }

    /*Metodos para recuperar informacion sobre la lista generalizada sobre la cual esta hecho el arbol*/

    Nodo getRaiz(){
        return raiz;
    }


}
