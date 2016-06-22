package org.fmz.container;


public abstract class Vector extends ArrayContainer {




	public Vector(){
        data = new Object[DEFAULT_CAPACITY] ;
	}

	/**
	 * 
	 * @param element
	 */
	public abstract boolean append(Object element);

	/**
	 * 
	 * @param element
	 */
	public boolean contains(Object element){
		return indexOf(element) != -1 ;
	}

	/**
	 * 
	 * @param index
	 */
	public Object elementAt(int index){
        if(index < 0 || index > numItems-1)
            return null ;
		return data[index] ;
	}

	/**
	 * 
	 * @param element
	 */
	public int indexOf(Object element){
        for(int i=0; i<numItems; i++){
            if(element.equals(data[i]))
                return i ;
        }
		return -1 ;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public abstract boolean insertAt(int index, Object element);

	/**
	 * 
	 * @param element
	 */
	public boolean remove(Object element){
        int pos = indexOf(element) ;
        if(pos == -1)
            return false ;
        removeAt(pos) ;
		return true ;
	}

	/**
	 * 
	 * @param index
	 */
	public Object removeAt(int index){
        if(index < 0 || index > numItems-1)
            return null ;
        Object temp = data[index] ;
        while(index < numItems-1){
            data[index] = data[index+1] ;
            index ++ ;
        }
        data[--numItems] = null ;
		return temp;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public boolean replace(int index, Object element){
        if(index < 0 || index > numItems-1)
            return false ;
        data[index] = element ;
		return true ;
	}

}
