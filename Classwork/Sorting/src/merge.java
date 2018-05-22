
public class merge {
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	 {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	 }
	 public static void sort(Comparable[] a)
	 {
		 Comparable[] aux = new Comparable[a.length];
		 sort(a, aux, 0, a.length - 1);
	 }
	 
	 public static void merge(Comparable[] a,Comparable[] aux,int lo, int mid, int hi){
		
		//check whether the two parts of array is sorted before starting 
		assert isSorted(a,lo,mid);
		assert isSorted(a,mid+1,hi);
		
		//initialise starting point for two half of arrays
		//i -> first half of array aux, j -> second half of array aux; k->starting of a array
		int i=lo;
		int j=mid+1;
		//copy the aux array
		for(int k=lo;k < a.length;k++)
			aux[k]=a[k];
		for (int k = lo; k <= hi; k++)
		 {
		 if (i > mid) a[k] = aux[j++];
		 else if (j > hi) a[k] = aux[i++];
		 else if (less(aux[j], aux[i])) a[k] = aux[j++];
		 else a[k] = aux[i++];
		 }
		
		assert isSorted(a,lo,hi);
	}
	
	private static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w) < 0;
	}


	private static boolean isSorted(Comparable[] a, int from, int to) {
		// TODO Auto-generated method stub
		for(int i=from;i<=to;i++)
			if(less(a[i+1],a[i])) return false;
		return true;
	}
	
	
}
