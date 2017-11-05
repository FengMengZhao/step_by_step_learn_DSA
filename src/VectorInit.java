public class VectorInit{

    private Object[] data;
    private static final int DEFAULT_CAPACITY = 100;
    private int numItems;

    public Vector(){
        data = new Object[DEFAULT_CAPACITY] ;
    }

    public boolean append(Object element){
            if(isFull())
                return false;
            data[numItems++] = element ;
            return true ;
    }

    public void clear(){
        for(int i=0; i<numItems; i++){
            data[i] = null ;
        }
        numItems = 0 ;
    }

    public boolean contains(Object element){
        return indexOf(element) != -1 ;
    }

    public Object elementAt(int index){
        if(index < 0 || index > numItems-1)
            return null;
        return data[index] ;
    }

    public int indexOf(Object element){
        for(int i=0; i<numItems; i++)
            if(element.equals(data[i]))
                return i ;
        return -1 ;
    }

    public boolean insertAt(int index, Object element){
        if(index<0 || index>numItems-1 || isFull())
            return false;
        for(int i=numItems-1; i>=index; i--)
            data[i+1] = data[i] ;
        data[index] = element ;
        numItems ++ ;
        return true ;
    }

    public boolean isEmpty(){
        return numItems == 0 ;
    }

    public boolean isFull(){
        return numItems == data.length ;
    }

    public boolean remove(Object element){
        int pos = indexOf(element) ;
        if(pos == -1)
            return false;
        removeAt(pos) ;
        return true ;
    }

    public Object removeAt(int index){
        if(index < 0 || index > numItems-1)
            return null ;
        Object temp = data[index] ;
        while(index < numItems-1)
            data[index] = data[index+1] ;
            index ++ ;
        data[--numItems] = null ;
        return temp ;
    }

    public boolean replace(int index, Object element){
        if(index < 0 || index > numItems-1)
            return false;
        data[index] = element ;
        return true ;
    }

    public int size(){
        return numItems ;
    }

}

