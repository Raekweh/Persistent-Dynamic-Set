package com.company;

import java.util.ArrayList;

public class PersistentDynamicSet<E> extends BinarySearchTree<E> {
    protected ArrayList<ArrayList<BinaryTreeNode>> subTree;

    public PersistentDynamicSet() {
        nodesVisted = new ArrayList<>();
        subTree = new ArrayList<>();
    }

    @Override
    public void hookAddMethod(BinaryTreeNode node) { //Fix this
        //Creating copy node
        BinaryTreeNode copyNode = new BinaryTreeNode(node.element);
        //Creating copies of the right and left child
        copyNode.leftChild = node.leftChild;
        copyNode.rightChild = node.rightChild;
        //Adding the root node
        nodesVisted.add(copyNode);
        if(!(node.element.equals(rootNode.element)))
        {
            //Setting the left node
            if (nodesVisted.get(nodesVisted.size() - 1).leftChild.element.equals(copyNode.leftChild.element)) {
                //Making the copy node's left child
                copyNode.leftChild = nodesVisted.get(nodesVisted.size() - 1).leftChild; //I think this is wrong
            }
            //Setting the right node
            else if (nodesVisted.get(nodesVisted.size() - 1).rightChild.element.equals(copyNode.rightChild.element)) {
                //Making the copy node's right child
                copyNode.rightChild = nodesVisted.get(nodesVisted.size() - 1).rightChild;
            }
        }
    }

    @Override
    public void creatingPathingCollection()
    {
        //Adding the nodes visited into a new BinarySearchTree
        subTree.add(nodesVisted);
        System.out.println("The Subtree size: " + subTree.size());
        for(ArrayList<BinaryTreeNode> st: subTree)
        {
            System.out.println(subTree);
        }
        //Creating a new nodes visited
        nodesVisted = new ArrayList<>();
    }

    //Creating a helper method to add into the subtree
    @Override
    public void hookRemoveMethod(BinaryTreeNode node)
    {
        //Use the subtree to iterate through the affected nodes
        BinaryTreeNode copyNode = new BinaryTreeNode(node.element);
        copyNode.leftChild = node.leftChild;
        copyNode.rightChild = node.rightChild;
        if(!(node.element.equals(rootNode.element)))
        {
            if()
        }
    }
    
    //Testing
    public static void main(String[] args)
    {
        PersistentDynamicSet<String> pds = new PersistentDynamicSet<>();
        pds.add("cow");
        pds.add("fly");
        pds.add("dog");
        pds.add("bat");
        pds.add("fox");
        pds.add("ant");
        pds.add("cat");
        //The hook add method will not go through this section
//        pds.add("owl");
//        pds.add("eel");
    }
}