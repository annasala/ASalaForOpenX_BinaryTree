package org.binary_tree;

public class Node {

    public int getData() {
        return data;
    }

    int data;
    Node right;
    Node left;

    Node (int value){
        data=value;
        right=null;
        left=null;
    }

}
