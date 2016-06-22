package org.fmz.container ;

public class TestQueue{
    public static void main(String args[]){
        Queue queue = new Queue() ;
        System.out.println(queue.front()) ;
        queue.insertBack(new Integer(0)) ;
        System.out.println(queue.size()) ;
        System.out.println(queue.front()) ;
        queue.insertBack(new Integer(1)) ;
        System.out.println(queue.size()) ;
        System.out.println(queue.removeFront()) ;
        System.out.println(queue.removeFront()) ;
        System.out.println(queue.removeFront()) ;
    }
}
