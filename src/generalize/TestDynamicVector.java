package org.fmz.container ;

public class TestDynamicVector{
    public static void main(String args[]){
        DynamicVector dv = new DynamicVector(10) ;
        for(int i=0; i<10; i++)
            dv.append(i) ;
        System.out.println("numItems= "+dv.numItems) ;
        dv.append(100) ;
        System.out.println("numItems= "+dv.numItems) ;
        System.out.println("element at index of 10= "+dv.elementAt(10)) ;
        System.out.println("capacity= "+dv.capacity()) ;
        dv.append(1000) ;
        System.out.println("numItems= "+dv.numItems) ;
        System.out.println("element at index of 11= "+dv.elementAt(11)) ;
        System.out.println("capacity= "+dv.capacity()) ;
        System.out.println("DEFAULT_CAPACITY= "+dv.DEFAULT_CAPACITY) ;
        DynamicVector dv2 = new DynamicVector() ;
        System.out.println(dv2.capacity()) ;
    }
}
