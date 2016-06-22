package org.fmz.container;

public class FixedVector extends Vector {

	public FixedVector(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param element
	 */
	public boolean append(Object element){
		if(isFull())
			return false;
		data[numItems++] = element ;
		return true ;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public boolean insertAt(int index, Object element){
		if(index<0 || index>numItems-1 || isFull())
			return false;
		for(int i=numItems-1; i>=index; i--)
			data[i+1] = data[i] ;
		data[index] = element ;
		numItems ++ ;
		return true ;
	}
}