package org.fmz.container;

public class SLNode {

	public Object data;
	public SLNode next;

	public SLNode(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param dat
	 */
	public SLNode(Object dat){
		data = dat ;
	}

	/**
	 * 
	 * @param dat
	 * @param nxt
	 */
	public SLNode(Object dat, SLNode nxt){
		data = dat ;
		next = nxt ;
	}

}