package org.fmz.container ;

public class TestStack{
    public static void main(String args[]){
        Stack stack = new Stack() ;
        stack.push(new Integer(0)) ;
        stack.push(new Integer(1)) ;
        stack.push(new Integer(2)) ;
        stack.push(new Integer(3)) ;
        System.out.println(stack.pop()) ;
        System.out.println(stack.pop()) ;
        System.out.println(stack.pop()) ;
    }
}
