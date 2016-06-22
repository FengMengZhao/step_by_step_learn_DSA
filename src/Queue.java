package org.fmz.container;

public class Queue{ 

	DLNode head;
	DLNode tail;
	int numItems;

	public Queue(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void clear(){
		head = tail = null ;
	}

	public Object front(){
		if(isEmpty())
			return null;
		return head.data ;
	}

	/**
	 * 
	 * @param element
	 */
	public void insertBack(Object element){
		if(isEmpty()){
			head = tail = new DLNode(element) ;
			numItems ++ ;
			return ;
		}
		tail.next = new DLNode(element) ;
		tail = (DLNode)tail.next ;
		numItems ++ ;
	}

	public boolean isEmpty(){
		return numItems == 0 ;
	}

	public Object removeFront(){
		Object tmp = front() ;
		if(tmp == null)
			return null;
		head = (DLNode)head.next ;
		if(head != null)
			((DLNode)head).prev = null ;
		else
			tail = null ;
		numItems -- ;
		return tmp ;
	}

	public int size(){
		return numItems ;
	}

}