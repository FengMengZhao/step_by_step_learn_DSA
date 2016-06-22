package org.fmz.container;


public abstract class BinaryTree extends TreeContainer {

	public static abstract class BinaryTreeNode extends Node {

		public BinaryTreeNode leftChild;
		public BinaryTreeNode parent;
		public BinaryTreeNode rightChild;


		/**
		 * 
		 * @param dat
		 * @param lc
		 * @param rc
		 * @param par
		 */
		public BinaryTreeNode(Object dat, BinaryTreeNode lc, BinaryTreeNode rc, BinaryTreeNode par){
            super(dat) ;
            leftChild = lc ;
            rightChild = rc ;
            parent = par ;

		}

		/**
		 * 
		 * @param dat
		 */
		public BinaryTreeNode(Object dat){
            super(dat) ;
		}

		public boolean isLeaf(){
			return leftChild == null && rightChild == null ;
		}

	}

	public interface NodeProcessor {

		/**
		 * 
		 * @param node
		 */
		void processNode(BinaryTreeNode node);

	}


	public int height(){
		return heightHelper((BinaryTreeNode)root, -1) ;
	}

	/**
	 * 
	 * @param current
	 * @param ht
	 */
	protected int heightHelper(BinaryTreeNode current, int ht){
        if(current == null)
            return ht ;
		return Math.max(heightHelper(current.leftChild, ht+1),
                        heightHelper(current.rightChild, ht+1)) ;
	}

	/**
	 * 
	 * @param node
	 * @param processor
	 */
	protected void inorder(BinaryTreeNode node, NodeProcessor processor){
        if(node != null){
            inorder(node.leftChild, processor) ;
            processor.processNode(node) ;
            inorder(node.rightChild, processor) ;
        }
	}

	/**
	 * 
	 * @param processor
	 */
	public void inorderTraverse(NodeProcessor processor){
        inorder((BinaryTreeNode)root, processor) ;
	}

	/**
	 * 
	 * @param node
	 * @param processor
	 */
	protected void postorder(BinaryTreeNode node, NodeProcessor processor){
        if(node != null){
            postorder(node.leftChild, processor) ;
            postorder(node.rightChild, processor) ;
            processor.processNode(node) ;
        }        
	}

	/**
	 * 
	 * @param processor
	 */
	public void postorderTraverse(NodeProcessor processor){
        postorder((BinaryTreeNode)root, processor) ;
	}

	/**
	 * 
	 * @param node
	 * @param processor
	 */
	protected void preorder(BinaryTreeNode node, NodeProcessor processor){
        if(node != null){
            processor.processNode(node) ;
            preorder(node.leftChild, processor) ;
            preorder(node.rightChild, processor) ;
        }
	}

	/**
	 * 
	 * @param node
	 * @param processor
	 */
	public void preorderTraverse(NodeProcessor processor){
        preorder((BinaryTreeNode)root, processor) ;
	}

}
