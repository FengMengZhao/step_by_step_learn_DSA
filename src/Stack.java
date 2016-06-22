package org.fmz.container;

public class Stack{
	protected LinearNode head;
	protected int numItems = 0;


	public Stack(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void clear(){
		head = null ;
	}

	public boolean isEmpty(){
		return numItems == 0 ;
	}

	public Object pop(){
		if(isEmpty())
			return null;
		Object element = head.data ;
		head = head.next ;
		numItems -- ;
		return element ;
	}

	/**
	 * 
	 * @param element
	 */
	public void push(Object element){
		if(isEmpty())
			head = new LinearNode(element) ;
		else
			head = new LinearNode(element, head) ;
		numItems ++ ;
	}

	public int size(){
		return numItems ;
	}

	public Object top(){
		if(isEmpty())
			return null;
		return head.data ;
	}

}
