/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   Clase Principal de ejecucion del Aplicacion de Ordenamiento por Paridad     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public class Main {
    public static void main (String args[]){
        //Creando Objeto de la clase Pruebas
        Prueba p = new Prueba();
        
        p.crearArchivo(); //<--- Llamada del metodo de creacion de fichero de pruebas
        p.generarPruebas(); //<--- Llamada del metodo de generacion, escritura y almacenamiento de las pruebas
        p.ejecutarPruebas();
    }
}
