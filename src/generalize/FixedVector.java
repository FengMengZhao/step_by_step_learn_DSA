package org.fmz.container;


public class FixedVector extends Vector {


    public FixedVector(){

    }

	/**
	 * 
	 * @param element
	 */
	public boolean append(Object element){
        if(isFull())
            return false ;
        data[numItems++] = element ;
		return true ;
	}

	/**
	 * Not allowed to insertAt after index of numItems-1
     * insertAt index of numItems equals append method
	 * @param index
	 * @param element
	 */
	public boolean insertAt(int index, Object element){
        if(index < 0 || index > numItems-1 || isFull())
		    return false;
        for(int pos = numItems-1; pos >= index; pos--)
             data[pos+1] = data[pos] ;
        data[index] = element ;
        numItems ++ ;
        return true ;
	}

}
