package org.fmz.container;


public abstract class LinearLinkedContainer extends LinkedContainer {

	protected static class SLNode extends Node {

		public SLNode next;


		/**
		 * 
		 * @param dat
		 */
		public SLNode(Object dat){
            super(dat) ;
		}

		/**
		 * 
		 * @param dat
		 * @param nxt
		 */
		public SLNode(Object dat, SLNode nxt){
            super(dat) ;
            next = nxt ;
		}

	}

	protected SLNode head;

	public void clear(){
        head = null ;
	}

}
