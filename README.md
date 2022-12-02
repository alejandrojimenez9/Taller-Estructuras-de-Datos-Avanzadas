# Taller Estructuras de Datos Avanzadas
# Solución de Ejercicios en ![Logo](https://upload.wikimedia.org/wikipedia/commons/0/0a/LeetCode_Logo_black_with_text.svg)
## 1. Complete Binary Tree Inserter 
*Enlace: https://leetcode.com/problems/complete-binary-tree-inserter/*

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

**Example 1**

![Logo](https://assets.leetcode.com/uploads/2021/08/03/lc-treeinsert.jpg)

```
Input
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
Output
[null, 1, 2, [1, 2, 3, 4]]
```

![Logo](https://i.ibb.co/k1wJm3s/Ejercicio1.png)
