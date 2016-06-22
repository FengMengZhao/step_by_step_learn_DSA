package  org.fmz.container ;

public class TestDeque{
    public static void main(String args[]){
        Deque deque = new Deque() ;
        deque.insertFront(new Integer(0)) ;
        System.out.println(deque.back()) ;
        deque.insertFront(new Integer(100)) ;
        System.out.println(deque.front()) ;
        System.out.println(deque.removeBack()) ;
    }
}
