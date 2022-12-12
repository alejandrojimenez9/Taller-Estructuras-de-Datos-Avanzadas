# Taller Estructuras de Datos Avanzadas
# Solución de Ejercicios en ![Logo](https://upload.wikimedia.org/wikipedia/commons/0/0a/LeetCode_Logo_black_with_text.svg)
## 1. Complete Binary Tree Inserter 
*Enlace: https://leetcode.com/problems/complete-binary-tree-inserter/*

**EXPLICACIÓN**

Un árbol binario completo es un árbol binario en el que todos los niveles, excepto posiblemente el último, están completamente llenos y todos los nodos están lo más a la izquierda posible.

Además debe tener todos sus niveles completos, a excepción del último, este último nivel también debe tener por lo menos un nodo completo, es decir, tenga 2 hijos (Sub Izquierdo – Sobre Derecho).

**¿Cómo se crea un árbol binario completo?**

* Seleccione el primer elemento de la lista para que sea el nodo raíz. (n° de elementos en el nivel-I: 1)

![Logo](https://i.ibb.co/6gDVYZW/arbol.png)

Seleccione el primer elemento como raíz

* Coloque el segundo elemento como hijo izquierdo del nodo raíz y el tercer elemento como hijo derecho. (n° de elementos en nivel-II: 2)

![Logo](https://i.ibb.co/F8xfX8L/arbol.png)

12 como hijo izquierdo y 9 como hijo derecho

* Coloque los siguientes dos elementos como elementos secundarios del nodo izquierdo del segundo nivel. Nuevamente, coloque los siguientes dos elementos como elementos secundarios del nodo derecho del segundo nivel (número de elementos en el nivel III: 4) elementos).

* Sigue repitiendo hasta llegar al último elemento.

![Logo](https://i.ibb.co/8xhX9yj/arbol.png)

5 como hijo izquierdo y 6 como hijo derecho

**EJEMPLO:**

Comparación cuando es un árbol binario completo y cuando no es un árbol binario completo.

![Logo](https://www.techiedelight.com/wp-content/uploads/Complete-Binary-Tree.png)

Los elementos del último nivel están colocados de izquierda a derecha sin dejar huecos entre ellos.

![Logo](https://i.ibb.co/sCzjRsy/Sin-t-tulo.png)

**CÓDIGO LEETCODE**

```
class CBTInserter {

    TreeNode[] arr;
    int size;
    public CBTInserter(TreeNode root) {
        arr = new TreeNode[10000];
        size = 0;
        if (root == null) { return; }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            arr[size + 1] = t;
            size++;
            if (t.left != null) { q.offer(t.left); }
            if (t.right != null) { q.offer(t.right); }
        }
    }
    
    public int insert(int v) {
        if (size == 0) {
            arr[1] = new TreeNode(v);
            size = 1;
            return v;
        }
        arr[size + 1] = new TreeNode(v);
        int parent = (size + 1) / 2;
        if ((size + 1) % 2 == 0) {
            arr[parent].left = arr[size + 1];
        } else {
            arr[parent].right = arr[size + 1];
        }
        size++;
        return arr[parent].val;
    }
    
    public TreeNode get_root() {
        return arr[1];
    }
}
```
**PRUEBA EN LEETCODE**

**Example**

![Logo](https://assets.leetcode.com/uploads/2021/08/03/lc-treeinsert.jpg)

```
Input
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
Output
[null, 1, 2, [1, 2, 3, 4]]
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/k1wJm3s/Ejercicio1.png)

## 2.  Binary Tree Inorder Traversal
*Enlace: https://leetcode.com/problems/binary-tree-inorder-traversal/*

**EXPLICACIÓN**

El recorrido inorden, es un recorrido de los árboles binarios en los que se empieza desde el nodo que se encuentra más a la izquierda de todos, sigue con la raíz y termina con los nodos del lado derecho, entonces, como en el recorrido inorden ya encontramos la raíz, la parte izquierda representa el subárbol izquierdo y la parte derecha representa el subárbol derecho.

Recorrido Inorden: subárbol izquierdo, raíz, subárbol derecho

![Logo](https://i.ibb.co/W2w7M2J/Sin-t-tulo.png)

**EJEMPLO 1:**

![Logo](https://i.ibb.co/f4ZJmvy/Ejercicio2.png)

**EJEMPLO 2:**

![Logo](https://i.ibb.co/P9xcvmG/Sin-t-tulo.png)

Recorrido Inorden: 10, 13, 18, 21, 25, 33, 40.

**CÓDIGO LEETCODE**

```
class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list,root);
        return list;
    }
    public void helper(List<Integer> list, TreeNode node){
        if(node==null)
            return;
        helper(list,node.left);
        list.add(node.val);
        helper(list,node.right);
    }
 }
```
**PRUEBA EN LEETCODE**

**Example**

![Logo](https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg)

```
Input: root = [1,null,2,3]
Output: [1,3,2]
```
**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/QCcrrP4/Ejercicio3.png)

## 3.  Validate Binary Search Tree
*Enlace: https://leetcode.com/problems/validate-binary-search-tree/*

**EXPLICACIÓN**

Un árbol binario de búsqueda(ABB) es un árbol binario con la propiedad de que todos los elementos almacenados en el subárbol izquierdo de cualquier nodo x son menores que el elemento almacenado en x ,y todos los elementos almacenados en el subárbol derecho de x son mayores que el elemento almacenado en x.

Un BST válido se define de la siguiente manera:

* El subárbol izquierdo de un nodo contiene solo nodos con claves menores que la clave del nodo.
* El subárbol derecho de un nodo contiene solo nodos con claves mayores que la clave del nodo.
* Los subárboles izquierdo y derecho también deben ser árboles de búsqueda binarios.

**EJEMPLO:**

Comparación cual es y cual no es un árbol de búsqueda binaria válido.

![Logo](https://i.ibb.co/Jr7XtDL/Sin-t-tulo.png)

No es válido el segundo árbol, debido a que el nodo izquierdo (7) es mayor que el nodo hijo derecho (6), por tal motivo no es considerado un árbol de búsqueda binaria válido.

**CÓDIGO LEETCODE**

```
class Solution{
    public boolean isBST(TreeNode root, long low, long high)
    {
        if (root==null) return true;
        
        if (root.val <= low || root.val >= high) return false;

        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root)
    {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
```
**PRUEBAS EN LEETCODE**

**Example 1: TRUE**

![Logo](https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg)

```
Input: root = [2,1,3]
Output: true
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/TRmCzQ5/Ejercicio-3.png) 

**Example 2: FALSE**

![Logo](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg)

```
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/gw422Sj/Ejercicio-3-FALSE.png)

# 4. Minimum Height Trees 

*Enlace: https://leetcode.com/problems/minimum-height-trees/* 

**EXPLICACIÓN**

**Altura** 

Se define la altura de un nodo en un arbol como la longitud del camino más largo que comienza en el nodo y termina en una hoja.

* La altura de un nodo hoja es 0.
* La altura de un nodo es igual a la mayor altura de sus hijos + 1.

La altura de un árbol se define como la altura de la raiz.

La altura de un arbol determina la eficiencia de la mayoría de operaciones definidas sobre árboles.

Una forma de encontrar el nodo medio del árbol es comenzar desde cada uno de los nodos hoja y eliminarlos iterativamente hasta que quede con 1 o 2 nodos finales que serán los nodos medios.

* Podemos encontrar los nodos hoja en cada iteración utilizando el grado interior del nodo, es decir, el número de aristas que están conectadas al nodo.
* Un nodo hoja tendrá un grado de entrada de 1.
* El algoritmo utilizado será similar a BFS. En cada nivel de BFS, sacaremos el nodo de hoja y empujaremos los nuevos nodos que se convierten en hojas después de la   eliminación de los nodos de hoja en la iteración actual.
* Esto continuará hasta que nos queden solo 1 o 2 nodos, que serían nuestros nodos intermedios finales que forman los MHT.

**EJEMPLO:**

![Logo](https://i.ibb.co/z7qkvSj/arbol.png)

A partir de este gráfico de árbol inferimos que los números dentro de los nodos indican el grado de entrada (Esto quiere decir que son los números de aristas conectadas al nodo).

![Logo](https://i.ibb.co/9nf9Vnj/arbol.png)

Con cada uno de los nodos de hoja en el nivel actual se eliminará y el grado de entrada de cada nodo adyacente a esa hoja se reducirá en consecuencia.

![Logo](https://i.ibb.co/LhMFy7C/arbol.png)

Se repite el proceso anterior

![Logo](https://i.ibb.co/pjQdTF9/arbol.png)

Continuamos el mismo proceso con los nuevos nodos que se convierten en el nodo hoja.

![Logo](https://i.ibb.co/BzkzG0s/arbol.png)

Se continúa realizando el mismo proceso

![Logo](https://i.ibb.co/27hzmLW/arbol.png)

Y por último, solo queda un único nodo. Cuando quedan 1 o 2 nodos, estos son los nodos intermedios finales que forman el MHT.

![Logo](https://i.ibb.co/DfP3mcx/arbol.png)

**CÓDIGO LEETCODE**

```
class Solution{
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> list = new ArrayList();
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0){
            list.add(0);
            return list;
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int i=0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        while(n > 2){
            int size = q.size();
            n -= size;
            for(int i=0; i < size; i++){
                int temp = q.poll();
                for(int dad : graph[temp]){
                    if(indegree[dad] == 1) continue;
                    indegree[dad]--;
                    if(indegree[dad] == 1){
                        q.add(dad);
                        }
                }
            }
        }
      while (!q.isEmpty()){
            list.add(q.poll());
            
        }
        return list;
    }
}

```
**PRUEBAS EN LEETCODE**

**Example:*

![Logo](https://assets.leetcode.com/uploads/2020/09/01/e1.jpg)

```
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/TM9k231/arbol.png)

## 5. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

*Enlace: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/* 

**EXPLICACIÓN**

Dado el siguiente árbol, nuestro objetivo será encontrar el elemento [3]:

![Logo](https://i.ibb.co/G3VSWyY/arbol.png)

Se empieza realizando un recorrido bfs (por niveles visitando primero los nodos más cercanos hasta encontrar nuestro objetivo en el árbol clonado), hemos escogido como nodo objetivo el elemento número 3.

Árbol clonado: En el primer movimiento nos ubicamos en el elemento número 6.  

![Logo](https://i.ibb.co/wL44b89/arbol.png)

Como segundo paso bajamos de nivel y nos situamos sobre el elemento número 4.

![Logo](https://i.ibb.co/zN7kYr4/arbol.png)

Continuando en el mismo nivel, avanzamos al nodo más cercano en este mismo nivel, en este caso el elemento número 9.

![Logo](https://i.ibb.co/VjDHcw4/arbol.png)

Cuando se termine de recorrer el nivel en el que estamos, bajamos al siguiente nivel, elemento número 3.

![Logo](https://i.ibb.co/DQckvP7/arbol.png)

Hemos encontrado nuestro elemento número 3, es hora de retornar y finalizar el ejercicio.

Este fue el recorrido que realizamos para encontrar nuestro elemento objetivo

![Logo](https://i.ibb.co/swygQXv/arbol.png)

**CÓDIGO LEETCODE**

```
public class Solution {

  private TreeNode result;

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    inorder(original, cloned, target);
    return result;
  }

  private void inorder(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null) {
      return;
    }
    inorder(original.left, cloned.left, target);
    if (original == target) {
      result = cloned;
      return;
    }
    inorder(original.right, cloned.right, target);
  }
}
```

**PRUEBAS EN LEETCODE**

**Example:*

![Logo](https://user-images.githubusercontent.com/38175573/206087337-7a0ad580-8764-4bf8-a71b-498cb46f3433.png)

```
Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/MpB55Mt/arbol.png)

# 6. Find if Path Exists in Graph

*Enlace: https://leetcode.com/problems/find-if-path-exists-in-graph/* 

**EXPLICACIÓN**

Para la resolución de este problema se usó el algoritmo DFS (Depth First Search) el cual recorre un grafo de manera recursiva, marcando los nodos ya visitados y así permitiendo dar con un camino si existe.

**Como trabaja:**

DFS va formando un árbol al igual que BFS pero lo hace a profundidad. Existen dos formas de hacer el recorrido una es usando una Pila y otra de manera recursiva.
Lo que hace la solución en pocas palabras es recorrer el grafo de manera recursiva mientras en una lista guardamos los nodos visitados, así tenemos que este algoritmo seguirá iterando mientras no encontremos el destino o terminemos dicho grafo.

**Ejemplo:**

Tomemos como ejemplo el siguiente grafo no dirigido:

![Logo](https://i.ibb.co/HdQv48G/arbol.png)

Al igual que con la pila requerimos un nodo inicial, de manera recursiva llamamos a los adyacentes del nodo inicial, de esta forma se puede ver si llamamos inicialmente a “1”:

Inicial “1”: marcamos “1” como visitado, sus adyacentes son “2”, “3” y “5”.

* Visitados: 1.
* Adyacentes de 1: 2, 3, 5

![Logo](https://i.ibb.co/HPksRb3/arbol.png)

En la llamada recursiva ira el primero insertado en la lista de adyacencia, en este caso “2”, marcamos como visitado. Ahora el inicial es “2”, sus adyacentes son “1” , “4” y “5”.

* Visitados: 1, 2
* Adyacentes de 2: 1, 4, 5

![Logo](https://i.ibb.co/c3TZns1/arbol.png)

Evaluamos el 1ero de la lista que es “1” pero ya fue visitado por lo tanto sigo con el siguiente, en este caso “4”, marcamos como visitado. Ahora inicial es “4”, sus adyacentes son “2”.

* Visitados: 1, 2, 4
* Adyacentes de 4: 2

![Logo](https://i.ibb.co/nPNPdzx/arbol.png)

Tocaría el nodo 2 pero ya fue visitado termina la recursión por ese lado. El siguiente adyacente de “2” es “5”. Ahora inicial es “5”, marcamos como visitado, sus adyacentes son “1” y “2”.

* Visitados: 1, 2, 4, 5
* Adyacentes de 5: 1, 2

Igual que con nodo “4” sus adyacentes han sido visitados por lo tanto terminamos la recursión por el nodo “2”.

El nodo actual es “1”, sus adyacentes eran “2”, “5” y “3”, estábamos evaluando por “2” pero ya terminamos el siguiente es “5” el cual ya fue visitado, continuamos con “3” este no fue visitado, marcamos como visitado, vemos sus adyacentes “1”.

![Logo](https://i.ibb.co/Zz2ykLd/arbol.png)

* Visitados: 1, 2 , 4 , 5 , 3
* Adyacentes de 3: 1

![Logo](https://i.ibb.co/qCyktMX/arbol.png)

Como nodo “1” ya fue visitado entonces termina la recursión y termina el recorrido DFS. Como se puede observar el orden en que fueron visitados los nodos es el recorrido DFS del grafo.

![Logo](https://i.ibb.co/41rGBmn/arbol.png)

**CÓDIGO LEETCODE**

```
class Solution {
   
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(edges, n);
        g.visit(source, destination);
        return g.isVisited(destination);
    }
    
    class Graph {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited;
        
        public Graph(int[][] edges, int n) {
            
			// initialize the graph with all possible nodes
            for(int i = 0; i < n; i++) {
                map.put(i, new ArrayList<Integer>());
            }
            
			// Insert edges into graph. Make sure both source and destination are placed in the map 
			// since this is an undirected graph with cycles possible
            for(int i = 0; i < edges.length; i++) {
                List<Integer> list = map.get(edges[i][0]);
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
                
                list = map.get(edges[i][1]);
                list.add(edges[i][0]);
                map.put(edges[i][1], list);
            }
             
            visited = new boolean[map.size()];
        }
        
        public void visit(int source, int destination) {
            List<Integer> dests = map.get(source);
            visited[source] = true;
            
            for(int i = 0; i < dests.size(); i++) {
                int next = dests.get(i);
                if(!visited[next]) {
                    visit(next, destination);
                }
            }
        }
        
        public boolean isVisited(int destination) {
            return visited[destination];
        }
    }
}
```
**PRUEBAS EN LEETCODE**

**Example:*

![Logo](https://assets.leetcode.com/uploads/2021/08/14/validpath-ex1.png)

```
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
```

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/8syzdBQ/arbol.png)

## 7. Relative Ranks
*Enlace: https://leetcode.com/problems/relative-ranks/*

**EXPLICACIÓN**

Lo que realiza principalmente el código es guardar los números y el índice, de tal manera que ordene los resultados y arroje un orden de posiciones y su respectiva premiación.

**Casos de Prueba:**

Al ejecutar el programa se lee un archivo txt que contiene 5 números, y después se corre el programa y en otro archivo txt muestra las posiciones en que quedaron.

Se coloca la dirección donde se va a ubicar el archivo txt de entrada.

![Logo](https://i.ibb.co/Lpnhrny/arbol.png)

Se coloca la dirección donde se va a ubicar el archivo txt de salida.

![Logo](https://i.ibb.co/RDZgtry/arbol.png)

**PRUEBA:**

Archivo txt entrada (in.txt)

![Logo](https://i.ibb.co/QJ49Tdd/Sin-t-tulo.png)

*Se ejecuta el programa*

Archivo txt salida (out.txt)

![Logo](https://i.ibb.co/7QXhg5S/Sin-t-tulo.png)

**CÓDIGO LEETCODE**

```
public String[] f(int[] nums) {
        if (nums == null) {
            return null;
        }
        String[] result = new String[nums.length];

        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] prizes = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = nums.length - 1; i >= 0; i--) {
            int rank = nums.length - 1 - i;
            if (rank < 3) {
                result[index.get(nums[i])] = prizes[rank];
            } else {
                result[index.get(nums[i])] = "" + (rank + 1);
            }
        }
      
        return result;
    }
```
**PRUEBAS EN LEETCODE**

**Example:*

```
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
```
**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/YR1B169/arbol.png)

# Solución de Ejercicio en ![Logo](https://codeforces.org/s/45151/images/codeforces-sponsored-by-ton.png)

## 8. Heap Operations

*Enlace: https://codeforces.com/problemset/problem/681/C*

En este ejercicio se maneja los montones binarios, que son un caso particular y sencillo de la estructura de datos Montículo, y está basada en un árbol binario balanceado, que puede verse como un árbol binario con dos restricciones adicionales: Propiedad de montículo. En cualquier momento el montón contiene varios números enteros (posiblemente ninguno), algunos de ellos pueden ser iguales.

**COLA DE PRIORIDAD USANDO EL MONTÓN BINARIO**

Priority Queue es una extensión de la cola con las siguientes propiedades: 

* Cada elemento tiene una prioridad asociada.
* Un elemento con alta prioridad se quita de la cola antes que un elemento con baja prioridad.
* Si dos elementos tienen la misma prioridad, se sirven según su orden en la cola.

Un montón binario es un árbol binario con las siguientes propiedades:  

* Es un árbol completo. Esta propiedad de Binary Heap los hace adecuados para ser almacenados en una matriz.
* Un montón binario es Min Heap o Max Heap.
* En un montón binario mínimo, la clave en la raíz debe ser mínima entre todas las claves presentes en el montón binario. La misma propiedad debe ser verdadera de forma recursiva para todos los nodos del árbol binario.
* De manera similar, en un montón binario máximo, la clave en la raíz debe ser la máxima entre todas las claves presentes en el montón binario. La misma propiedad debe ser verdadera de forma recursiva para todos los nodos del árbol binario.

**Explicación**

La función que realiza este código es completar el número de instrucciones manteniendo la coherencia secuencialmente, de modo que no falte ninguna instrucción impidiendo la ejecución de todas las instrucciones.

**input**

```
la primera línea contiene un número entero n ( 1 ≤  n  ≤ 100 000 )
Las siguientes n líneas son las instrucciones a verificar en el orden
en que se aplican. Se utiliza el formato descrito en la declaración. 
Todos los números en la entrada son números enteros que no excedan 10^9 
por su valor absoluto.
```

**output**

```
La primera línea de la salida debe contener un solo entero m: el número mínimo posible de registros en la secuencia modificada
y completa de operaciones.
Las próximas líneas deben contener la secuencia corregida de registros siguiendo el formato de la entrada 
(descrito en la declaración), uno por línea y en el orden en que se aplican. Todos los números en la salida 
deben ser números enteros que no excedan 10^9 por su valor absoluto.
```

**CASOS DE PRUEBA**

**Caso normal**

**Ejemplo:**

Que se cumplan los parámetros de entrada

![Logo](https://i.ibb.co/GWKqYWt/Sin-t-tulo.png)

En el primer caso, después de insertar el número 3 en el montón, el número mínimo es 3. Para que el resultado del primer getMin sea igual a 4, primero se debe eliminar el número 3 del montón y luego agregar el número 4 al montón

**CÓDIGO:**

```
static void solve() {
        int queries = i();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<String> res = new ArrayList<>();
        while (queries-- > 0) {
            String s = s();
            if (s.equals("insert")) {
                int x = i();
                pq.add(x);
                res.add(s + " " + x);
            } else if (s.equals("getMin")) {
                int x = i();
                while (pq.size() > 0 && pq.peek() < x) {
                    pq.poll();
                    res.add("removeMin");
                }
                if (pq.size() == 0 || pq.peek() > x) {
                    pq.add(x);
                    res.add("insert " + x);
                }
                res.add("getMin " + x);
            } else {
                if (pq.size() == 0) {
                    pq.add(1);
                    res.add("insert 1");
                    res.add("removeMin");
                    pq.poll();
                } else {
                    pq.poll();
                    res.add("removeMin");
                }
            }
        }
        sb.append(res.size() + "\n");
        for (String s : res) {
            sb.append(s).append("\n");
        }
    }
```

**PRUEBA**

Se ingresa la cantidad de números, en este caso son 5, los números ingresados son el 1, 1, 2, 2 y 4; y como resultado es 3, ya que son la cantidad de números distintos.

![Logo](https://i.ibb.co/xjzJqBv/Sin-t-tulo.png)

# Solución de Ejercicio en ![Logo](https://img.atcoder.jp/assets/icon/avatar.png)

## 9. Count Distinct Integers

*Enlace: https://atcoder.jp/contests/abc240/tasks/abc240_b?lang=en*

Este problema narra que dado un número de n donde n es la cantidad de un conjunto de números, se debe imprimir la cantidad de números distintos del conjunto de número de entrada, es decir, se debe enviar como salida el conteo de números distintos dentro de un conjunto de datos.

**EXPLICACIÓN:**

Viendo el enunciado respecto a las salidas esperadas, 

**¿Cómo se puede resolver este problema?**

**Hash Set al Rescate**

HashSet es una colección de estructura de datos de Set Interface, cuya característica destacada son:

* HashSet no permite valores duplicados
* HashSet no dispone de un criterio de ordenación para los valores almacenados

**¿Cual es la ventaja?**

Usando HashSet solo basta con preguntar cada uno de los elementos de la lista o entrada de datos que nos llegue para que únicamente almacene aquellos datos que no sean repetidos dentro de la colección.

**CÓDIGO**

```
import java.util.*;
	public class Main {
	 
	   public static void main(String[] args) {
	 
	       Scanner sc = new Scanner(System.in);
	       Set <Integer> l = new HashSet <Integer>() ;
	       int n = sc.nextInt();
	       for(int i =0;i<n;i++) {
	           l.add(sc.nextInt());
	       }
	       System.out.println(l.size()); //Imprime la cantidad de num distintos
	      
	   }
    }
```

**Nota:**

Hay que tener en cuenta que una vez agregado cada uno de los datos respecto al recorrido de este, se imprime como resultado el tamaño (Cantidad de datos) de la estructura HashSet.

**SOLUCIÓN ACEPTADA**

![Logo](https://i.ibb.co/7bJd42j/Sin-t-tulo.png)

# Autor

Luis Alejandro Jiménez Turizo - 1151463

# Documentación

https://drive.google.com/file/d/16OtCSba7UBOdIbH4pG0GwA61zZyp7amG/view?usp=share_link

