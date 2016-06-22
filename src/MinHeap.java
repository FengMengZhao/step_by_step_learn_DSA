package org.fmz.container;

public class MinHeap extends Heap {



	public void finalize() throws Throwable {
		super.finalize();
	}

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
		return peek();
	}

	protected void percolate(){
		int pos = size() -1 ;

		while(pos != 0 &&
				data[pos].compareTo(data[parent(pos)]) < 0){
			swap(data, pos, parent(pos)) ;
			pos = parent(pos) ;
		}
	}

	public Comparable removeMin(){
		return remove() ;
	}

	protected void sift(){
		int pos = 0,
			i ,
			r_pos ;
		while(!isLeaf(pos)){
			i = leftChild(pos) ;
			r_pos = rightChild(pos) ;

			if(r_pos < size() && data[i].compareTo(data[r_pos]) > 0)
				i = r_pos ;

			if(data[pos].compareTo(data[i]) <= 0)
				return ;

			swap(data, pos, i) ;

			pos = i ;
		}
	}
}