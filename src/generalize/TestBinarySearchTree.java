package org.fmz.container ;

public class TestBinarySearchTree{


    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree() ;
        bst.insert(new Integer(5)) ;
        bst.insert(new Integer(3)) ;
        bst.insert(new Integer(4)) ;
        bst.insert(new Integer(8)) ;
        bst.insert(new Integer(1)) ;
        bst.insert(new Integer(6)) ;
        bst.insert(new Integer(4)) ;
        /*
        System.out.println(bst.root.data) ;
        bst.remove(new Integer(5)) ;
        System.out.println(bst.root.data) ;
        bst.remove(new Integer(6)) ;
        System.out.println(bst.root.data) ;
        bst.remove(new Integer(8)) ;
        System.out.println(bst.root.data) ;
        */


        NodePrinter np = new NodePrinter() ;
        System.out.println("preorder -->") ;
        bst.preorderTraverse(np) ;
        System.out.println() ;

        System.out.println("inorder -->") ;
        bst.inorderTraverse(new BinaryTree.NodeProcessor(){
            public void processNode(BinaryTree.BinaryTreeNode node){
                System.out.print(node.data + "\t") ;
            }
        }) ;
        System.out.println() ;

        System.out.println("posorder -->") ;
        bst.postorderTraverse(new BinaryTree.NodeProcessor(){
            public void processNode(BinaryTree.BinaryTreeNode node){
                System.out.print(node.data + "\t") ;
            }
        }) ;
        System.out.println() ;
    }
}
