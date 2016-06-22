package org.fmz.container ;

public abstract class Heap{
	protected Comparable[] data;
	protected static final int DEFAULT_CAPACITY = 100;
	protected int numItems;




	public void finalize() throws Throwable {
		super.finalize();
	}

	public Heap(){
		data = new Comparable[DEFAULT_CAPACITY] ;
	}

	/**
	 * 
	 * @param initCapacity
	 */
	public Heap(int initCapacity){
		if(initCapacity <= 0)
			data = new Comparable[DEFAULT_CAPACITY] ;
		else
			data = new Comparable[initCapacity] ;
	}

	public void clear(){
		for(int i=0; i<numItems; i++)
			data[i] = null ;
		numItems = 0 ;
	}

	public void contract(){
		if(numItems == data.length)
			return ;

		Comparable[] new_data = new Comparable[numItems] ;
		for(int i=0; i<new_data.length; i++)
			new_data[i] = data[i] ;
		data = new_data ;
	}

	/**
	 * 
	 * @param element
	 */
	public void insert(Comparable element){
		if(isFull()){
			Comparable[] new_data = new Comparable[numItems << 1] ;
			for(int i=0; i<numItems; i++)
				new_data[i] = data[i] ;
			data = new_data ;
		}
		data[numItems++] = element ;
		percolate() ;
	}

	public boolean isFull(){
		return numItems == data.length ;
	}

	public boolean isEmpty(){
		return numItems == 0 ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected boolean isLeaf(int pos){
		return (pos << 1) + 1 >= numItems ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected int leftChild(int pos){
		if(pos < 0)
			return -1;
		return (pos << 1) + 1 ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected int parent(int pos){
		if(pos <= 0)
			return -1 ;
		return (pos - 1) >> 1 ;
	}

	protected Comparable peek(){
		if(isEmpty())
			return null ;
		return data[0] ;
	}

	protected abstract void percolate();

	protected Comparable remove(){
		if(isEmpty())
			return null ;
		Comparable root = data[0] ;
		swap(data, 0, numItems-1) ;
		data[--numItems] = null ;
		if(numItems > 0)
			sift() ;
		return root ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected int rightChild(int pos){
		if(pos < 0)
			return -1;
		return (pos << 1) + 2 ;
	}

	protected abstract void sift();

	public int size(){
		return numItems ;
	}

	/**
	 * 
	 * @param arr
	 * @param first
	 * @param second
	 */
	protected void swap(Comparable[] arr, int first, int second){
		Comparable tmp = arr[first] ;
		arr[first] = arr[second] ;
		arr[second] = tmp ;
	}

}
