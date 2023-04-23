package org.binary_tree;

public class BinaryTree {
    public Node getRoot() {
        return root;
    }
    private Node root;
    int inputIterator;
    int maxTreeStringArrLen;

    public int getMaxEdges() {
        return maxEdges;
    }

    int maxEdges;

    public BinaryTree(){
        root=null;
        maxEdges = 0;
    }

    public void createNewTree(String input){
        root= parseInput(input);
        if (root == null) System.out.println("Failed to create tree from input string");
    }

    private Node parseInput(String input) {
        if(input==null) return null;
        if(!input.matches("[0-9,#]+")) return null;

        inputIterator=0;
        String[] treeArray = input.split(",");
        maxTreeStringArrLen = treeArray.length;
        return parseSingleNode(treeArray);
    }

    private Node parseSingleNode(String[] treeArray) {
        if(inputIterator>=maxTreeStringArrLen) return null;
        if(treeArray[inputIterator].equals("#")) return null;

        Node root = new Node(Integer.parseInt(treeArray[inputIterator]));
        inputIterator++;
        root.left = parseSingleNode(treeArray);
        inputIterator++;
        root.right = parseSingleNode(treeArray);
        return root;
    }

    public int calculateChildlessNodes(){
        int childless;
        childless = inorderTraversalChildless(root);
        System.out.println("Number of childless nodes equals " + childless);
        return childless;
    }

    private int inorderTraversalChildless(Node  root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return (inorderTraversalChildless(root.left)+inorderTraversalChildless(root.right));
    }

    public void calculateMaxEdges(){
        maxEdges = 0;
        inorderTraversalMaxEdges(root, 0);
        System.out.println("Furthest leaf node have " + maxEdges + " edges from root");
    }

    private void inorderTraversalMaxEdges(Node root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null)
        {
            if(maxEdges<depth) maxEdges=depth;
            return;
        }

        inorderTraversalMaxEdges(root.left, depth+1);
        inorderTraversalMaxEdges(root.right, depth+1);
    }

    public static boolean areTreesEqual(BinaryTree tree1, BinaryTree tree2){
        if(tree1.getRoot() == null && tree2.getRoot() == null ) {
            System.out.println("Trees are equal (null)");
            return true;
        }
        if(tree1.getRoot() == null || tree2.getRoot() == null ) {
            System.out.println("Trees are not equal (one is null)");
            return false;
        }

        if(inorderTraversalEqualityCheck(tree1.getRoot(), tree2.getRoot()) == false) {
            System.out.println("Trees are not equal");
            return false;
        }
        System.out.println("Trees are equal");
        return true;
    }

    private static boolean inorderTraversalEqualityCheck(Node root1, Node root2) {
        boolean leftCheck, rightCheck;
        if(root1 == null && root2 == null ) return true;
        if(root1 == null || root2 == null ) return false;

        if(root1.getData() != root2.getData()) return false;
        leftCheck = inorderTraversalEqualityCheck(root1.left, root2.left);
        rightCheck = inorderTraversalEqualityCheck(root1.right, root2.right);
        return (leftCheck && rightCheck);
    }
}
