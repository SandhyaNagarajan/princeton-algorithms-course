
public class Shell {
	public static void sort(Comparable[] a){
		int N=a.length;
		int h=1;
		//compute the max value of h
		while(h <  N/3)
			h=3*h + 1;
		while(h >=1) {
			//h sorted array
			for(int i=h;i<N;i++){
				for(int j=i;j >= h && less(a[j],a[j-1]);j=j-h)
						exch(a,j,j-1);
			}
			h= h/3;
		}
	}
	

	private static void exch(Comparable[] a, int i, int min) {
		// TODO Auto-generated method stub
		Comparable swap=a[i];
		a[i]=a[min];
		a[min]=swap;
	}

	private static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w) < 0;
	}

}
