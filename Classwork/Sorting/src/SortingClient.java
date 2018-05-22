
public class SortingClient {
	public static void main(String[] args){
//		Comparable[] a={5,3,6,9,1};
//		Selection.sort(a);
//		for(Comparable el:a)
//			System.out.println(el);
//		Comparable[] b={'A','C','D','W','B'};
//		Comparable[] b={'E','E','G','M','R','A','C','E','R','T'};
		Comparable[] b={5,4,3,2,12};
		merge.sort(b);
		for(Comparable el:b)
			System.out.println(el);
	}
}
