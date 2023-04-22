package org.binary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void createNewTree() {
        BinaryTree bt = new BinaryTree();
        bt.createNewTree(null);
        assertNull( bt.getRoot());
    }

    @Test
    void calculateChildlessNodes() {
        BinaryTree bt = new BinaryTree();
        bt.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        assertEquals(5,bt.calculateChildlessNodes());

        BinaryTree leftOrientation1Leaf = new BinaryTree();
        leftOrientation1Leaf.createNewTree("1,2,3,4,5,6");
        assertEquals(1,leftOrientation1Leaf.calculateChildlessNodes());

        BinaryTree nullTree = new BinaryTree();
        assertEquals(0,nullTree.calculateChildlessNodes());
    }

    @Test
    void calculateMaxEdges() {
        BinaryTree bt = new BinaryTree();
        bt.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        bt.calculateMaxEdges();
        assertEquals(4,bt.getMaxEdges());

        BinaryTree leftOrientation5Edge = new BinaryTree();
        leftOrientation5Edge.createNewTree("1,2,3,4,5,6");
        leftOrientation5Edge.calculateMaxEdges();
        assertEquals(5,leftOrientation5Edge.getMaxEdges());

        BinaryTree nullTree = new BinaryTree();
        nullTree.calculateMaxEdges();
        assertEquals(0,nullTree.getMaxEdges());
    }

    @Test
    void areTreesEqual() {
        BinaryTree bt = new BinaryTree();
        bt.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        BinaryTree bt2 = new BinaryTree();
        bt2.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        assertTrue(BinaryTree.areTreesEqual(bt, bt2));
        BinaryTree nullTree = new BinaryTree();
        assertTrue(BinaryTree.areTreesEqual(nullTree, nullTree));

        assertFalse(BinaryTree.areTreesEqual(bt, nullTree));
        BinaryTree leftOrientation = new BinaryTree();
        BinaryTree rightOrientation = new BinaryTree();
        leftOrientation.createNewTree("1,2,3,4,5");
        rightOrientation.createNewTree("1,#,2,#,3,#,4,#,5");

        assertFalse(BinaryTree.areTreesEqual(leftOrientation, rightOrientation));
    }
}