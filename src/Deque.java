package org.fmz.container;


public class Deque extends Queue {

	public Deque(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Object back(){
		if(isEmpty())
			return null ;
		return tail.data ;
	}

	/**
	 * 
	 * @param element
	 */
	public void insertFront(Object element){
		if(isEmpty()){
			insertBack(element) ;
			numItems ++ ;
			return ;
		}
		head = new DLNode(element, null, (DLNode)head) ;
		if(head.next != null)
			((DLNode)head.next).prev = (DLNode)head ;
		numItems ++ ;

	}

	public Object removeback(){
		Object temp = back() ;
		if(temp == null)
			return null ;
		tail = tail.prev ;
		if(tail == null)
			head = null ;
		else{
			((DLNode)tail.next).prev = null ;
			tail.next = null ;
		}
		numItems -- ;
		return temp ;
	}

}