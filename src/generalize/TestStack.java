package org.fmz.container ;

public class TestStack{
    public static void main(String args[]){
        Stack stack = new Stack() ;
        System.out.println(stack.pop()) ;
        stack.push(new Integer(1)) ;
        stack.push(new Integer(2)) ;
        System.out.println(stack.pop()) ;
        System.out.println(stack.pop()) ;
        System.out.println(stack.pop()) ;
    }
}
