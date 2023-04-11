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
   
   
   /*
   recursive insert method
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
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      return false;           
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
   }



   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
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