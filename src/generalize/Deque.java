package org.fmz.container;


public class Deque extends Queue {


	public Object back(){
        if(tail == null)
            return null ;
		return tail.data ;
	}

	/**
	 * 
	 * @param element
	 */
	public void insertFront(Object element){
        if(isEmpty())
            head = tail = new DLNode(element) ;
        else
            head = head.prev = new DLNode(element, null, head) ;
        numItems ++ ; 

	}

	public Object removeBack(){
        Object temp = back() ;
        if(temp == null)
            return null ;
        tail = tail.prev ;
        if(tail != null){
            ((DLNode)tail.next).prev = null ;
            tail.next = null ;
        }
        else
            head = null ;
        numItems -- ;
        return temp ;
	}

}
