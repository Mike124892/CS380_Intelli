/**
 * This program implements basic operations for a binary search tree (BST).
 * It defines a class for a node in the BST and a class for the BST itself.
 *
 * @author Michael Barry
 */

/**
 * Represents a node in a BST.
 */
class Node{
   int value;
   Node left, right;

   /**
    * Initializes a node object that will be inserted into the BST.
    *
    * @param value the value that will be inserted into the BST.
    */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

/**
 * Represents a BST and provides operations on it.
 */
class BinarySearchTree{

   Node root;

   /**
    * Inserts a value into the binary search tree using recursion.
    *
    * @param root the root node of the tree where the new node will be inserted.
    * @param value the value to be inserted into the BST.
    * @return the root node of the tree after the insertion.
    */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }

   /**
    * Performs a pre-order traversal of the BST and prints the nodes using recursion.
    *
    * @param root the root node of the BST.
    */
   public void preOrderTraversal(Node root){
      if (root == null) return;

      System.out.print(root.value + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   /**
    * Performs an in-order traversal of the BST and prints the nodes using recursion.
    *
    * @param root the root node of the BST.
    */
   public void inOrderTraversal(Node root){
      if(root == null) return;

      inOrderTraversal(root.left);
      System.out.print(root.value + " ");
      inOrderTraversal(root.right);
   }

   /**
    * Performs a post-order traversal of the BST and prints the nodes using recursion.
    *
    * @param root the root node of the BST.
    */
   public void postOrderTraversal(Node root){
      if (root == null) return;

      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + " ");
   }
   
   /**
    * Finds a node in the binary search tree with a specific value using recursion.
    *
    * @param root the root node of the BST.
    * @param key the value to search for in the BST.
    * @return true if the value is found in the BST, false otherwise.
    */
   public boolean find(Node root, int key){
      if (root == null) return false;

      if (root.value == key) return true;

      if (key < root.value) {
         return find(root.left,key);
      } else {
         return find (root.right,key);
      }
   }

   /**
    * Finds the smallest value in the BST using recursion.
    *
    * @param root the root node of the BST.
    * @return the minimum value.
    */
   public int getMin(Node root){
      while (root.left != null){
         root = root.left;
      }

      return root.value;
   }

   /**
    * Finds the largest value in the BST using recursion.
    *
    * @param root the root node of the BST.
    * @return the maximum value.
    */
   public int getMax(Node root){
      while (root.right != null){
         root = root.right;
      }

      return root.value;
   }

   /**
    * Deletes a specified value from the BST using recursion.
    *
    * @param root the root node of the BST.
    * @param key the value to delete in the BST.
    * @return BST with deleted node.
    */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
}

/**
 * Main method used to test BST initialization and operations.
 */
public class TreeDemo {
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.root = t1.insert(t1.root,24);
      t1.root = t1.insert(t1.root,80);
      t1.root = t1.insert(t1.root,18);
      t1.root = t1.insert(t1.root, 9);
      t1.root = t1.insert(t1.root,90);
      t1.root = t1.insert(t1.root,22);

      System.out.print("Pre-order: ");
      t1.preOrderTraversal(t1.root);
      System.out.print("\nIn-order: ");
      t1.inOrderTraversal(t1.root);
      System.out.print("\nPost-order: ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
   }
}