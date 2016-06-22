package org.fmz.container;


public abstract class ArrayContainer extends Container {

	protected Object[] data;
	protected static final int DEFAULT_CAPACITY = 100;




	public ArrayContainer(){
        data = new Object[DEFAULT_CAPACITY] ;
	}

	public int capacity(){
		return data.length ;
	}

	public void clear(){
        for(int i=0; i<numItems; i++)
            data[i] = null ;
	}

	public boolean isFull(){
		return numItems == data.length ;
	}

}
