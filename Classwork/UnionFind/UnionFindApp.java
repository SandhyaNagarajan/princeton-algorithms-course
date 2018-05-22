package UnionFind;

public class UnionFindApp {

	public static void main(String[] args) {
		//quick find
//		
//		QuickFind qf=new QuickFind(10);
//		qf.displayArray();
//		qf.union(2, 3);
//		qf.union(4, 5);
//		qf.union(1,0);
//		qf.displayArray();
//		boolean a=qf.find(5,4);
//		System.out.println("5,4 "+a);
//		boolean b=qf.find(3,2);
//		System.out.println("3,2 "+b);
//		
//		//quickunion
//		QuickUnion qu=new QuickUnion(10);
//		qu.displayArray();
//		qu.union(2, 3);
//		qu.union(4, 5);
//		qu.union(1,0);
//		qu.displayArray();
//		boolean a1=qu.find(5,4);
//		System.out.println("5,4 "+a1);
//		boolean b1=qu.find(3,2);
//		System.out.println("3,2 "+b1);
//
		//weighted quick union
		QuickUnion wqu=new QuickUnion(10);
		wqu.displayArray();
		wqu.weightedUnion(2, 3);
		wqu.weightedUnion(4, 5);
		wqu.weightedUnion(3, 5);
		wqu.weightedUnion(2,1);
		wqu.weightedUnion(1,0);
		wqu.displayArray();
		int n1=wqu.findLargest(0);
		int n2=wqu.findLargest(4);
		int n3=wqu.findLargest(2);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
	}

}
