import java.util.* ;

import org.fmz.container.MinHeap ;

public class HeapSort{
	public static void heapSort(int[] array){
		int n = array.length ;
		MinHeap heap = new MinHeap(n) ;

		for(int i=0; i<n; i++)
			heap.insert((Comparable)array[i]) ;
		for(int j=0; j<n; j++)
			array[j] = (int)heap.removeMin() ; 
	}

	public static void main(String args[]){
		int[] array = new int[10] ;
		Random rand = new Random(26) ;
		for(int i=0; i<array.length; i++)
			array[i] = rand.nextInt(10) ;
		heapSort(array) ;
		for(int i : array)
			System.out.print(i + "\t") ;
	}
}/* output
2	3	3	4	4	4	7	7	7	9	[Finished in 0.6s]
*/