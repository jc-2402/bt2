//diameter of a tree
import java.util.*;
public class BT10{
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

        static class info{
            int diam;
            int ht;
            public info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static info diameter(Node root){ //O(n)
            if(root == null){
                return new info(0,0);
            }
            info leftinfo = diameter(root.left);
            info rightinfo = diameter(root.right);

            int diam = Math.max(Math.max (leftinfo.diam , rightinfo.diam), leftinfo.ht + rightinfo.ht + 1);

            int ht = Math.max(leftinfo.ht, rightinfo.ht)+1;

            return new info(diam , ht);
        }

        // public static int diameter(Node root){  // O(N^2)
        //     if(root == null){
        //         return 0;
        //     }
        //     //1
        //     int leftdia = diameter(root.left);
        //     //2
        //     int rightdia = diameter(root.right);

        //     int leftheight = height(root.left);
        //     int rightheight =height(root.right);
        //     //3
        //     int self = leftheight + rightheight + 1;

        //     return Math.max(self , Math.max(leftdia, rightdia));
        // }
    
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4); 
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

        System.out.println("diameter of the tree = "+diameter(root).diam);
        System.out.println("height of the tree = "+diameter(root).ht);
        }
}