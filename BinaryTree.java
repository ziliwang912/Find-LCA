public class BinaryTree {
    Node root;
    Node left, right;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Finds LCA of given two nodes in this binary search tree.
     * @param root
     * @param node1
     * @param node2
     * @return the found LCA node
     */
    public Node getLCA(Node root, Node node1, Node node2) {
        // Base case: empty tree
        if (root == null) {
            return null;
        }

        // If both data in the two nodes is smaller than root, LCA exists in 
        // left subtree
        if (root.data > Integer.max(node1.data, node2.data)) {
            root = root.left;
            getLCA(root, node1, node2);
        }

        // If both data in the two nodes is larger than root, LCA exists in 
        // right subtree
        if (root.data < Integer.max(node1.data, node2.data)) {
            root = root.right;
            getLCA(root, node1, node2);
        }

        // If one data is larger than root, the other is smaller, then the 
        // current root is LCA
        return root;
    }

    /**
     * Node Class
     * 
     * Since this is an inner class, it must be static when creating an instance 
     * using "new Node(x)"; Another solution is to move the Node class out of 
     * the BinaryTree class.
     */
    public static class Node {
        int data;
        Node left, right;
     
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    public static void main(String args[] ) {
        // For convenience, this binary tree actually is a BST.
        BinaryTree bt = new BinaryTree();   
        bt.root = new Node(11);
        bt.root.left = new Node(5);
        bt.root.right = new Node(13);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(6);
        bt.root.right.left = new Node(15);
        
        System.out.println(
            bt.getLCA(bt.root, bt.root.left.left, bt.root.left.right).data);
        System.out.println(
            bt.getLCA(bt.root, bt.root.left, bt.root.right.left).data);
        System.out.println(
            bt.getLCA(bt.root, bt.root.left.left, bt.root.left).data);
    }
}