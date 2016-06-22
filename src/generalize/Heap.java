package org.fmz.container;


public abstract class Heap extends ArrayContainer {

	protected Comparable[] data;




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

    
	public int capacity(){
		return data.length ;
	}
    

	public void clear(){
        for(int i=0; i<numItems; i++)
            data[i] = null ;
        numItems = 0 ;
	}

	public void contract(){
        if(data.length == numItems)
            return ;
        Comparable[] new_data = new Comparable[numItems] ;
        for(int i=0; i<numItems; i++)
            new_data[i] = data[i] ;
        data = new_data ;
	}

	/**
	 * 
	 * @param element
	 */
	public void insert(Comparable element){
        if(isFull()){
            Comparable[] new_data = new Comparable[data.length << 1] ;
            for(int i=0; i<numItems; i++)
                new_data[i] = data[i] ;
            data = new_data ;
        }
        data[numItems++] = element ;
        percolate() ; // This is a abstract method
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
            return -1 ;
		return (pos << 1) + 1 ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected int parent(int pos){
        if(pos < 1)
		    return -1 ;
        return (pos -1) >> 1 ;
	}

    // The data at the top of the heap has been returned
	protected Comparable peek(){
        if(isEmpty())
            return null ;
		return data[0] ;
	}

    /*
     * This method is a helper for insert()
     * This method varies between the MinHeap and MapHeap
     */
	protected abstract void percolate();

    // The data at the top of the heap has been removed and returned
	protected Comparable remove(){
        if(isEmpty())
            return null ;
        swap(data, 0, size()-1) ;
        Comparable root = data[size()-1] ;
        data[--numItems] = null ;
        if(size() != 0)
            sift() ;// This is a abstract method
		return root ;
	}

	/**
	 * 
	 * @param pos
	 */
	protected int rightChild(int pos){
        if(pos <0)
            return -1 ;
		return (pos << 1) + 2 ;
	}

    /*
     * This method is a helper for remove()
     * This method varies between MinHeap and MaxHeap
     */
	protected abstract void sift();


	/**
	 * 
	 * @param arr
	 * @param first
	 * @param second
	 */
	protected void swap(Comparable[] arr, int first, int second){
        Comparable temp = arr[first] ;
        arr[first] = arr[second] ;
        arr[second] = temp ;
	}

}
