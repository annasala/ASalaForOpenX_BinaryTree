package org.binary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void createNewTree() {
        //failed to create
        BinaryTree bt = new BinaryTree();
        bt.createNewTree(null);
        assertNull( bt.getRoot());
        bt.createNewTree("Ania");
        assertNull( bt.getRoot());

        //succesful create
        bt.createNewTree("5,3,2,#,#,5,#,#,7,1,#,#,12,2,#,#,8,#,5");
        assertNotNull( bt.getRoot());
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

        BinaryTree singleTree = new BinaryTree();
        singleTree.createNewTree("1");
        assertEquals(1,singleTree.calculateChildlessNodes());
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

        BinaryTree singleTree = new BinaryTree();
        singleTree.createNewTree("1");
        singleTree.calculateMaxEdges();
        assertEquals(0,singleTree.getMaxEdges());
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

        BinaryTree btFalse1 = new BinaryTree();
        BinaryTree btFalse2 = new BinaryTree();
        btFalse1.createNewTree("1,3,3,4,5");
        btFalse2.createNewTree("1,2,3,4,5");
        assertFalse(BinaryTree.areTreesEqual(btFalse1, btFalse2));

        BinaryTree singleTree1 = new BinaryTree();
        BinaryTree singleTree2 = new BinaryTree();
        singleTree1.createNewTree("1");
        singleTree2.createNewTree("1");
        assertTrue(BinaryTree.areTreesEqual(singleTree1, singleTree2));
    }
}