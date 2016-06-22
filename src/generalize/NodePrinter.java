package org.fmz.container ;

public class NodePrinter implements BinaryTree.NodeProcessor{
    public void processNode(BinaryTree.BinaryTreeNode node){
        System.out.print(node.data + "\t") ;
    }
}
