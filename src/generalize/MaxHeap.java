package org.fmz.container;


public class MaxHeap extends Heap {


	protected MaxHeap(){

	}

	/**
	 * 
	 * @param initCapacity
	 */
	protected MaxHeap(int initCapacity){
        super(initCapacity) ;
	}

	public Comparable peekMax(){
		return peek();
	}

	protected void percolate(){
        int pos = size() - 1 ;
        while(pos !=0 && data[pos].compareTo(data[parent(pos)]) > 0){
            swap(data, pos, parent(pos)) ;
            pos = parent(pos) ;
        }
	}

	public Comparable removeMax(){
		return remove() ;
	}

	protected void sift(){
        int pos = 0,
            i,
            rc ;
        while(! isLeaf(pos)){
            i = leftChild(pos) ;
            rc = rightChild(pos) ;
            if(rc < size() && data[i].compareTo(data[rc]) < 0)
                i = rc ;
            if(data[pos].compareTo(data[i]) >= 0)
                return ;
            swap(data, i, pos) ;
            pos = i ;
        }
	}

}
