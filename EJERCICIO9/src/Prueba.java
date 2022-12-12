/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * * * *        Clase de Creacion y ejecucion de pruebas aleatorias      * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
import java.io.*;

public class Prueba {
    //Creacion de objeto de la clase Solucion
    Solution s = new Solution();
    
    //Creacion de objeto tipo Fichero de la clase File denominado "Pruebas.txt" 
    File Pruebas = new File("Pruebas.txt");
    
    //Creacion de objeto tipo Fichero de la clase File denominado "Resultados.txt" 
    File Resultado = new File("Resultados.txt");

    
    
    //Crear el archivo de  texto "Pruebas.txt", se debe trabajar usando excepciones -  try-catch
    public void crearArchivo() {
        try {
            System.out.println("Creando archivo de texto denominado 'Pruebas'...");

            if (Pruebas.createNewFile()) { //Creacion del archivo de texto  "Pruebas.txt"
                System.out.println("¡Archivo creado con exito!"); //Creacion del archivo por primera vez
            } else {
                System.out.println("El Archivo Pruebas.txt ya esta creado, revisa en el directorio principal"); // El archivo ya fue creado anteriormente
            }

        } catch (IOException Exception) {
            System.out.println("Error Grave en Ejecucion del Metodo");
        }
    }

    //Metodo que genera un numero aleatorio a traves de un rango (Maximo - Minimo)
    public static int generaNumeroAleatorio( int maximo, int minimo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num; //Retorna un numero entero aleatorio dentro del rango
    }

    //Metodo que genera, escribe  y almacena el conjunto de casos de pruebas en el archivo "Pruebas.txt"
    public void generarPruebas() {

        
        
        //Contadores de bucles  para cada una de las diferentes casos de prueba
        int pc = 1; //-> Primer Caso
        int sc = 1; //-> Segundo Caso
        int tc = 1; //-> Tercer Caso
        int cc = 1; //-> Cuarto Caso

        
        try {
            
            // La Clase FileWriter permite la escritura de un archivo, se debe trabajar usando try-catch
            FileWriter escritura = new FileWriter(Pruebas);
            
            /* Primer Caso de Prueba - 20 pruebas de arreglos ordenados */
            while (pc <= 20) {
                
                
                /* 5 Variables de Numeros Aleatorios entre rangos*/
                //Rango entre 1 - 50
                int a = generaNumeroAleatorio(50, 1);
                //Rango entre 51 - 100
                int b = generaNumeroAleatorio(50, 1);
                //Rango entre 101 - 1000
                int c = generaNumeroAleatorio(50, 1);
                //Rango entre 1001 - 2500
                int d = generaNumeroAleatorio(50, 1);
                //Rango entre 2501 - 5000
                int e = generaNumeroAleatorio(50, 1);
                
                //Escribiendo sobre el archivo dicho caso de prueba en String con espaciado y aplicando salto de linea
                escritura.write(a + " " + b + " " + c + " " + d + " " + e + "\r\n");
                pc++; //Incrementa iterador hasta cumplir con 20 lineas de casos de pruebas
            }
            /* Segundo Caso de Prueba - 20 pruebas de arreglos invertidos */
            
            while (sc <= 20) {
                int a = generaNumeroAleatorio(100, 51);
                
                int b = generaNumeroAleatorio(100, 51);
                
                int c = generaNumeroAleatorio(100, 51);
                
                int d = generaNumeroAleatorio(100, 51);
                
                int e = generaNumeroAleatorio(100, 51);

                escritura.write(e + " " + d + " " + c + " " + b + " " + a + "\r\n");
                sc++;
            }
            /* Tercer Caso de Prueba - 20 pruebas de arreglos semiordenados */
            while (tc <= 20) {
                int a = generaNumeroAleatorio(101, 1000);
                
                int b = generaNumeroAleatorio(101, 1000);
                
                int c = generaNumeroAleatorio(101, 1000);
                
                int d = generaNumeroAleatorio(101, 1000);
                
                int e = generaNumeroAleatorio(101, 1000);

                escritura.write(a + " " + b + " " + c + " " + e + " " + d + "\r\n");
                tc++;
            }
            
            /* Cuarto Caso de Prueba - 20 pruebas de arreglos desordenados y con desborde */
            while (cc <= 20) {
                int a = generaNumeroAleatorio(-50, 100);
                
                int b = generaNumeroAleatorio(-50, 100);
                
                int c = generaNumeroAleatorio(-50, 100);
                
                int d = generaNumeroAleatorio(500, 15000000);
                
               int e = generaNumeroAleatorio(500, 150000000);

                escritura.write(a + " " + d + " " + c + " " + b + " " + e + "\r\n");
                cc++;
            }
             

            escritura.close();
        } catch (IOException Exception) {

        }

    }

    public void ejecutarPruebas() {
        
        //Creacion del archivo de texto  "Resultado.txt"
        try {
            System.out.println("Creando archivo de texto denominado 'Resultado'...");

            if (Resultado.createNewFile()) {
                System.out.println("¡Archivo creado con exito!"); //Creacion del archivo por primera vez
            } else {
                System.out.println("El Archivo Resultado.txt ya esta creado, revisa en el directorio principal");// El archivo ya fue creado anteriormente
            }
            
            //Clase FileReader, lectura de un archivo (para este caso, lectura del archibo de texto: "Pruebas.txt"
            FileReader lector = new FileReader(Pruebas);
            BufferedReader lectura = new BufferedReader(lector);
            
            //Se lee cada linea completa del archivo de pruebas, se almacena en casodeprueba
            String casodeprueba = lectura.readLine();
            
            //Contador que ayudara a iterar los 100 casos de pruebas
            int iterador = 1;
            
            //Escritura del Archibo "Resultados.txt"
            FileWriter escritura = new FileWriter(Resultado);
            
            
            //Mientras iterador, realiza en bucle 80 iteracciones de los casos de prueba
            while (iterador <= 80) {
                
                //Leemos la cadena completa y convertimos la cadena en un arreglo de String arraynumerica [] separado por su espacio " " usando split()
                String[] arraynumerica = casodeprueba.split(" ");
                
                //Creacion de un arreglo de enteros int [], donde almacenara por cada linea, sus numeros
                int[] nums = new int[arraynumerica.length];
                
                //Bucle for que iterra cada uno de los elementos del arreglo de String
                for (int i = 0; i < arraynumerica.length; i++) {
                
                    nums[i] = Integer.parseInt(arraynumerica[i]);
                    
                    
                
                }
                
               
                //Recordemos que si un numero incumple las restricciones retornara -1, este primer condicional es validar casos d eprueba Invalido
               int datoinvalido = 0;
                String resultado=""; //<--- Esta variable resultado se ira concatenando con mas datos, almacenando en el archivo "Resultado.txt"
                if (s.contarNumeroDistintos(nums)==-1) {
                         System.out.println("Entrada invalida, verifica las restricciones"); //<--- Imprime el error en Consola
                        resultado="CASO BORDE: Entrada invalida, verifica las restricciones"; //<--- Almacena la Respuesta en el TXT de resultados
                         datoinvalido ++;
                    }  
                
                else if(datoinvalido==0){
                    
                    System.out.println(s.contarNumeroDistintos(nums)); //<--- Imprime el consola, el entero de cantidad de numeros distintos
                    resultado = Integer.toString(s.contarNumeroDistintos(nums));//<--- Almacena en resultados.txt, dicha salida, se hace conversion de int a String
                    
                } 
                
                //Escribe en el archivo de texto de resultados, la respuesta recibida y genera salto de linea
                escritura.write(resultado + "\r\n");
                casodeprueba = lectura.readLine();  //asigna el valor de casos de prueba, la siguiente linea del texto
                iterador++; //El iterador va incrementado!
            }
            //Finalizacion de las 80 iteracciones y cierre del escritura del archivo de "Resultados.txt"
            escritura.close();

        } catch (IOException Exception) {

        }
    }
}
