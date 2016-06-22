package org.fmz.container;


public class MinHeap extends Heap {

	/**
	 * 
	 * @param initCapacity
	 */
	public MinHeap(int initCapacity){
        super(initCapacity) ;
	}

	public MinHeap(){
        
	}

	public Comparable peekMin(){
		return peek() ;
	}

	protected void percolate(){
        int pos = size() - 1 ;
        /*
        while(pos != 0){
            if(data[pos].compareTo(data[parent(pos)]) < 0)
                swap(data, pos, parent(pos)) ;
            pos = parent(pos) ;
        } 
         * When you write programing, you must makesure your deep understanding of the logic of the suit.
         * Please spend more time on the logic of the suit and make the arrangement for it.
         * Then you will get more with less.
         * Otherwise, your program maybe not robust or even not correct.
         */ 
        while(pos !=0 && data[pos].compareTo(data[parent(pos)]) < 0){ 
            swap(data, pos, parent(pos)) ;
            pos = parent(pos) ;
        }
	}

	public Comparable removeMin(){
		return remove() ;
	}

	protected void sift(){
        int pos = 0,
            i,
            rc ;
        while(! isLeaf(pos)){
            i = leftChild(pos) ;
            rc = rightChild(pos) ;
            //Select the smaller of the left child and right child
            if(rc < size() && data[i].compareTo(data[rc]) > 0)
                i = rc ;
            //If the item at index 'pos' is less than or equal to the smaller of its children, then we finished
            if(data[pos].compareTo(data[i]) <= 0)
                return ;
            // Otherwise swap the item at 'pos' with the smaller of its children
            swap(data, pos, i) ;
            pos = i ;
        }
	}

}
