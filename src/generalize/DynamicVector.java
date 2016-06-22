package org.fmz.container;


public class DynamicVector extends Vector {

    public DynamicVector(){
        // auto subclass constructor public Vector(){}
        //super() ;
    }

	/**
	 * 
	 * @param initCapacity
	 */
	public DynamicVector(int initCapacity){
        if(initCapacity < 0){
            data = new Object[DEFAULT_CAPACITY] ;
        }else{
            data = new Object[initCapacity] ;
        }
	}

	/**
	 * 
	 * @param element
	 */
	public boolean append(Object element){
        if(isFull())
            ensureCapacity(data.length << 1) ;
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
        Object[] new_data = new Object[minCapacity] ;
        for(int i=0; i<numItems; i++){
            new_data[i] = data[i] ;
        }
        data = new_data ;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public boolean insertAt(int index, Object element){
        if(index < 0 || index > numItems-1)
    		return false;
        if(isFull())
            ensureCapacity(data.length << 1) ;
        for(int pos=numItems-1; pos>=index; pos--)
            data[pos+1] = data[pos] ;
        data[index] = element ;
        numItems ++ ;
        return true ;
	}

}
