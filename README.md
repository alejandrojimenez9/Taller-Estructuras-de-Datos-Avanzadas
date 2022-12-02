# Taller Estructuras de Datos Avanzadas
# Solución de Ejercicios en ![Logo](https://upload.wikimedia.org/wikipedia/commons/0/0a/LeetCode_Logo_black_with_text.svg)
## 1. Complete Binary Tree Inserter 
*Enlace: https://leetcode.com/problems/complete-binary-tree-inserter/*

**EXPLICACIÓN**

Un árbol binario completo es un árbol binario en el que todos los niveles, excepto posiblemente el último, están completamente llenos y todos los nodos están lo más a la izquierda posible.

Además debe tener todos sus niveles completos, a excepción del último, este último nivel también debe tener por lo menos un nodo completo, es decir, tenga 2 hijos (Sub Izquierdo – Sobre Derecho).

**EJEMPLO:**

![Logo](https://www.techiedelight.com/wp-content/uploads/Complete-Binary-Tree.png)

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

![Logo](https://i.ibb.co/k1wJm3s/Ejercicio1.png)

## 2.  Binary Tree Inorder Traversal
*Enlace: https://leetcode.com/problems/complete-binary-tree-inserter/*

**EXPLICACIÓN**

El recorrido inorden, es un recorrido de los árboles binarios en los que se empieza desde el nodo que se encuentra más a la izquierda de todos, sigue con la raíz y termina con los nodos del lado derecho, entonces, como en el recorrido inorden ya encontramos la raíz, la parte izquierda representa el subárbol izquierdo y la parte derecha representa el subárbol derecho.

**EJEMPLO:**

![Logo](https://i.ibb.co/f4ZJmvy/Ejercicio2.png)

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

![Logo](https://i.ibb.co/QCcrrP4/Ejercicio3.png)

## 3.  Validate Binary Search Tree
*Enlace: https://leetcode.com/problems/validate-binary-search-tree/*

**EXPLICACIÓN**

Un árbol binario de búsqueda(ABB) es un árbol binario con la propiedad de que todos los elementos almacenados en el subárbol izquierdo de cualquier nodo x son menores que el elemento almacenado en x ,y todos los elementos almacenados en el subárbol derecho de x son mayores que el elemento almacenado en x.

Un BST válido se define de la siguiente manera:

* El subárbol izquierdo de un nodo contiene solo nodos con claves menores que la clave del nodo.
* El subárbol derecho de un nodo contiene solo nodos con claves mayores que la clave del nodo.
* Los subárboles izquierdo y derecho también deben ser árboles de búsqueda binarios.

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

![Logo](https://i.ibb.co/TRmCzQ5/Ejercicio-3.png) 

**Example 2: FALSE**

![Logo](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg)

```
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

![Logo](https://i.ibb.co/gw422Sj/Ejercicio-3-FALSE.png)
