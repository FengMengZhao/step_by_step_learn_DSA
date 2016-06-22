package org.fmz.container;


public class BinarySearchTree extends BinaryTree {

	public static class BSTNode extends BinaryTreeNode implements Comparable{


		/**
		 * 
		 * @param dat
		 */
		public BSTNode(Comparable dat){
            super(dat) ;
		}

		/**
		 * 
		 * @param dat
		 * @param lc
		 * @param rc
		 * @param par
		 */
		public BSTNode(Comparable dat, BSTNode lc, BSTNode rc, BSTNode par){
            super(dat, lc, rc, par) ;
		}

		/**
		 * 
		 * @param o
		 */
		public int compareTo(Object o){
		    Comparable c = (Comparable)((BSTNode)o).data;
            return ((Comparable)data).compareTo(c) ;
		}

	}


	/**
	 * 
	 * @param target
	 */
	public Comparable find(BSTNode target){
        BSTNode rs = findHelper((BSTNode)root, target) ;
        if(rs == null)
		    return null;
        return (Comparable)rs.data ;
	}

	/**
	 * 
	 * @param current
	 * @param target
	 */
	protected BSTNode findHelper(BSTNode current, BSTNode target){
        if(current == null)
		    return null;
        if(target.compareTo(current) < 0)
            findHelper((BSTNode)current.leftChild, target) ;
        if(target.compareTo(current) > 0)
            findHelper((BSTNode)current.rightChild, target) ;
        return current ;
	}

	/**
	 * 
	 * @param newItem
	 */
	public void insert(Comparable newItem){
        root = insertHelper((BSTNode)root, new BSTNode(newItem)) ;
	}

	/**
	 * 
	 * @param current
	 * @param newNode
	 */
	protected BSTNode insertHelper(BSTNode current, BSTNode newNode){
        if(current == null){
            numItems ++ ;
            return newNode ;
        }
        if(newNode.compareTo(current) < 0){
            current.leftChild = insertHelper((BSTNode)current.leftChild, newNode) ;
            current.leftChild.parent = current ;
        }else{
            current.rightChild = insertHelper((BSTNode)current.rightChild, newNode) ;
            current.rightChild.parent = current ;
        }
		return current ;
	}

	/**
	 * 
	 * @param current
	 */
	protected BSTNode maxHelper(BSTNode current){
        if(current == null)
            return null ;
        while(current.rightChild != null)
            current = (BSTNode)current.rightChild ;
		return current ;
	}

	public Comparable maximum(){
        BSTNode max = maxHelper((BSTNode)root) ;
        if(max == null)
		    return null;
        return (Comparable)max.data ;
	}

	/**
	 * 
	 * @param current
	 */
	protected BSTNode minHelper(BSTNode current){
        if(current == null)
		    return null;
        while(current.leftChild != null)
            current = (BSTNode)current.leftChild ;
        return current ;
	}

	public Comparable minimum(){
        BSTNode min = minHelper((BSTNode)root) ;
        if(min == null)
		    return null;
        return (Comparable)min.data ;
	}

	/**
	 * 
	 * @param target
	 */
	public Comparable predecessor(Comparable target){
        BSTNode found = findHelper((BSTNode)root, new BSTNode(target)) ;
        if(found == null)
            return null ;
        if(found.leftChild != null)
            return (Comparable)maxHelper((BSTNode)found.leftChild).data ;
        BSTNode parent = (BSTNode)found.parent ;
        while(parent != null && parent.compareTo(found) > 0)
            parent = (BSTNode)parent.parent ;
        if(parent == null)
            return null ;
		return (Comparable)parent.data ;
	}

	/**
	 * 
	 * @param target
	 */
	public void remove(Comparable target){
        removeHelper((BSTNode)root, new BSTNode(target)) ;
	}

	/**
	 * 
	 * @param current
	 * @param target
	 */
	protected BSTNode removeHelper(BSTNode current, BSTNode target){
        if(current == null)
            return null ;
        if(target.compareTo(current) < 0)
            current.leftChild = removeHelper((BSTNode)current.leftChild, target) ;
        else if(target.compareTo(current) > 0)
            current.rightChild = removeHelper((BSTNode)current.rightChild, target) ;
        else{
            if(current.isLeaf()){
                numItems -- ;
                return null ;
            }
            BSTNode temp ;
            if(current.leftChild == null){
                temp = (BSTNode)current.rightChild ;
                current.data = temp.data ;
                current.leftChild = temp.leftChild ;
                if(current.leftChild != null)
                    current.leftChild.parent = current ;
                current.rightChild = temp.rightChild ;
                if(current.rightChild != null)
                    current.rightChild.parent = current ;
            }
            if(current.rightChild == null){
                temp = (BSTNode)current.leftChild ;
                current.data = temp.data ;
                current.leftChild = temp.leftChild ;
                if(current.leftChild != null)
                    current.leftChild.parent = current ;
                current.rightChild = temp.rightChild ;
                if(current.rightChild != null)
                    current.rightChild.parent = current ;
            }else{
                temp = (BSTNode)current.rightChild ;
                if(temp.isLeaf()){
                    current.data = temp.data ;
                    current.rightChild = null ;
                }else if(temp.leftChild == null){
                    current.data = temp.data ;
                    current.rightChild = temp.rightChild ;
                    if(current.rightChild != null)
                        current.rightChild.parent = current ;
                }else{
                    while(temp.leftChild.leftChild != null)
                        temp = (BSTNode)temp.leftChild ;
                    current.data = temp.leftChild.data ;
                    removeHelper((BSTNode)temp, new BSTNode((Comparable)temp.leftChild.data)) ;
                    numItems ++ ;
                }
            }
            numItems -- ;
        }
		return current ;
	}

	/**
	 * 
	 * @param target
	 */
	public Comparable successor(Comparable target){
        BSTNode found = findHelper((BSTNode)root, new BSTNode(target)) ;
        if(found == null)
            return null ;
        if(found.rightChild != null)
            return (Comparable)minHelper((BSTNode)found.rightChild).data ;
        BSTNode parent = (BSTNode)found.parent ;
        while(parent != null && parent.compareTo(found) <= 0)
            parent = (BSTNode)parent.parent ;
        if(parent == null)
            return null ;
		return (Comparable)parent.data ;
	}

}
