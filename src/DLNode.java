package org.fmz.container;

public class DLNode extends SLNode {

	DLNode prev;

	public DLNode(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

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