/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * * * *   Clase del metodo de conteo de Numeros Distintos en una lista  * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
import java.util.*;
class Solution {
    
 
   int contarNumeroDistintos (int [] nums){
       Set <Integer> l = new HashSet <Integer>() ;  //<-- Coleccion HashSet, almacena datos NO REPETIDOS
       for(int i =0;i<nums.length;i++) {
           if(nums[i]<1 || nums[i]>1000) return -1; //Si un dato incumple las restricciones dadas por el ejercicio, retorna -1 como entrada invalida
           l.add(nums[i]);
       }
       return l.size(); //Imprime el tamaño  de elementos del hashSet, retorna la salida del conteo de nums
      
   }
}
   

