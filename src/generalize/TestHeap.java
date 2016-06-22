package org.fmz.container ;

public class TestHeap{
    public static void main(String args[]){
        MinHeap mh = new MinHeap() ;
        mh.insert(5) ;
        mh.insert(3) ;
        mh.insert(9) ;
        mh.insert(7) ;
        mh.insert(1) ;
        mh.insert(6) ;
        System.out.println(mh.remove()) ;
        System.out.println(mh.remove()) ;
        System.out.println(mh.remove()) ;
        System.out.println(mh.remove()) ;
        System.out.println(mh.remove()) ;
        System.out.println(mh.remove()) ;
        MaxHeap mxh = new MaxHeap() ;
        mxh.insert(5) ;
        mxh.insert(3) ;
        mxh.insert(9) ;
        mxh.insert(7) ;
        mxh.insert(1) ;
        mxh.insert(6) ;
        System.out.println(mxh.remove()) ;
        System.out.println(mxh.remove()) ;
        System.out.println(mxh.remove()) ;
        System.out.println(mxh.remove()) ;
        System.out.println(mxh.remove()) ;
        System.out.println(mxh.remove()) ;
    }
}
