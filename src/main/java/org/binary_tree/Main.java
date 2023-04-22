package org.binary_tree;

public class Main {
    public static void main(String[] args) {
        int leafCount;

        BinaryTree bt = new BinaryTree();
        bt.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        bt.calculateMaxEdges();
        leafCount = bt.calculateChildlessNodes();
        System.out.println("Leaf count is " + leafCount);
        System.out.println("Maximum edge count to from root to leaf is " +bt.getMaxEdges());


    }
}