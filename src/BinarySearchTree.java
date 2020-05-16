import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node1 {
    Node1 left, right;
    int data;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {

    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node1 root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
        printInorder(root);
        printPostorder(root);
        printPreorder(root);
        levelOrder(root);
    }

    public static int getHeight(Node1 root) {
        //Write your code here
        return root == null ? -1 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /* Given a binary tree, print its nodes in inorder*/
    static void printInorder(Node1 node) {
        if (node != null) {
            /* first recur on left child */
            printInorder(node.left);
            /* then print the data of node */
            System.out.print(node.data + " ");
            /* now recur on right child */
            printInorder(node.right);
        }
    }

    /* Given a binary tree, print its nodes in preorder*/
    static void printPreorder(Node1 node) {
        if (node != null) {
            /* first print data of node */
            System.out.print(node.data + " ");
            /* then recur on left subtree */
            printPreorder(node.left);
            /* now recur on right subtree */
            printPreorder(node.right);
        }
    }

    static void printPostorder(Node1 node) {
        if (node != null) {
            // first recur on left subtree
            printPostorder(node.left);
            // then recur on right subtree
            printPostorder(node.right);
            // now deal with the node
            System.out.print(node.data + " ");
        }
    }

    static void levelOrder(Node1 root) {
        Queue<Node1> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node1 node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

/*    public static int getHeight(Node1 root) {
        //Write your code here
        if (root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }*/


/*    static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }*/
}