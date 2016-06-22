package org.fmz.container ;

public class LinearNode{
	public LinearNode next ;
	public Object data ;

	public LinearNode(Object o){
		data = o ;
	}

	public LinearNode(Object o, LinearNode nxt){
		data = o ;
		next = nxt ;
	}
}