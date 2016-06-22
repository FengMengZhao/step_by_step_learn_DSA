package org.fmz.container;


public class DynamicVector extends Vector {

	public DynamicVector(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param initCapacity
	 */
	public DynamicVector(int initCapacity){
		if(initCapacity <= 0)
			data = new Object[DEFAULT_CAPACITY] ;
		else
			data = new Object[initCapacity] ;
	}

	/**
	 * 
	 * @param element
	 */
	public boolean append(Object element){
		/*
		if(isFull()){
			Object[] newData = new Object[data.length*2] ;
			for(int i=0; i<numItems; i++){
				newData[i] = data[i] ;
			}
			data = newData ;
		}
		*/
		ensureCapacity(data.length*2) ;
		data[numItems++] = element ;
		return true;
	}

	/**
	 * 
	 * @param minCapacity
	 */
	public void ensureCapacity(int minCapacity){
		if(minCapacity <= data.length)
			return ;
		Object[] newData = new Object[minCapacity] ;
		for(int i=0; i<numItems; i++)
			newData[i] = data[i] ;
		data = newData ;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public boolean insertAt(int index, Object element){
		if(index < 0 || index > numItems-1)
			return false;
		if(isFull()){
			Object[] newData = new Object[data.length*2] ;
			for(int i=0,j=0; j<numItems; i++,j++){
				if(j == index)
					i ++ ;
				newData[i] = data[j] ;
			}
			data = newData ;
			data[index] = element ;
			numItems ++ ;
			return true ;
		}

		for(int i=numItems-1; i>=index; i--)
			data[i+1] = data[i] ;
		data[index] = element ;
		numItems ++ ;
		return true ;
	}
}