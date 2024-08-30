//diameter of a tree
import java.util.*;
public class BT9{
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh)+1;
        }

        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            //1
            int leftdia = diameter(root.left);
            //2
            int rightdia = diameter(root.right);

            int leftheight = height(root.left);
            int rightheight =height(root.right);
            //3
            int self = leftheight + rightheight + 1;

            return Math.max(self , Math.max(leftdia, rightdia));
        }
    
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4); 
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

        System.out.println("diameter of the tree = "+diameter(root));
        }
}