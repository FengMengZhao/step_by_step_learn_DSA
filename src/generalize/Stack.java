package org.fmz.container;


public class Stack extends LinearLinkedContainer {


	public Object pop(){
        if(isEmpty())
            return null ;
        Object element = head.data ;
        head = head.next ;
        numItems -- ;
		return element;
	}

	/**
	 * 
	 * @param element
	 */
	public void push(Object element){
        if(isEmpty())
            head = new SLNode(element) ;
        else
            head = new SLNode(element, head) ;
        numItems ++ ; 
	}

	public Object top(){
        if(isEmpty())
            return null ;
		return head.data ;
	}

}
