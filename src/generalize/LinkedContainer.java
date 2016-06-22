package org.fmz.container;


public abstract class LinkedContainer extends Container {

	protected static abstract class Node {

		public Object data;



		/**
		 * 
		 * @param dat
		 */
		public Node(Object dat){
			data = dat ;
		}

	}

}
