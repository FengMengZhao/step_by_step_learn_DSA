package org.fmz.container;


public class Queue extends LinearLinkedContainer {

	protected static class DLNode extends SLNode {

		public DLNode prev;

		/**
		 * 
		 * @param dat
		 */
		public DLNode(Object dat){
            super(dat) ;
		}

		/**
		 * 
		 * @param dat
		 * @param pre
		 * @param nxt
		 */
		public DLNode(Object dat, DLNode pre, DLNode nxt){
            super(dat, nxt) ;
            prev = pre ;
		}

	}

	protected DLNode head;
	protected DLNode tail;

	public Object front(){
        if(isEmpty())
            return null ;
		return head.data ;
	}

    public void clear(){
        super.clear() ;
        tail = null ;
    }

	/**
	 * 
	 * @param element
	 */
	public void insertBack(Object element){
        if(isEmpty())
            head = tail = new DLNode(element) ;
        else{
            tail.next = new DLNode(element, tail, null) ;
            tail = (DLNode)tail.next ;
        }
        numItems ++ ;
	}

	public Object removeFront(){
        Object temp = front() ;
        if(temp == null)
            return null ;
        head = (DLNode)head.next ;
        if(head != null){
            head.prev.next = null ;
            head.prev = null ;
        }
        else
            tail = null ;
        numItems -- ;
        return temp ;
	}

}
