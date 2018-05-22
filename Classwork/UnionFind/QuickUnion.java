package UnionFind;

public class QuickUnion {
	private int[] id;
	//constructor
	private int[] sz;
	public QuickUnion(int N){
		id = new int[N];
		sz=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
			sz[i]=1;
		}
		
	}
	
	//find the root of element
	private int root(int i){
		while(i!=id[i])
			//path compression
		{
			id[i]=id[id[i]];
			i=id[i];
		}
		return i;
	}
	
	public void union(int p, int q){
		//The tree can grow v tall and could not be efficient
		int rootp = root(p);
		int rootq = root(q);
		id[rootp]=rootq;
	}
	
	public void weightedUnion(int p, int q){
		//The tree cannot grow v tall. in fact depth of any node is only log(base2) N 
		
		int rootp = root(p);
		int rootq= root(q);
		if(rootp==rootq) return;
		if(sz[rootp] < sz[rootq]){
			id[rootp]=rootq;
			sz[rootq]+=sz[rootp];
		}
		else {
			id[rootq]=rootp;
			sz[rootp]+=sz[rootq];
		}
	}
	
	public boolean find(int p,int q){
		return (root(p)==root(q));
	}
	
	public int findLargest(int i){
		// root element in the connected elements
		//online solution : 
		//maintain an extra array to the weighted quick-union data structure 
		//that stores for each root 𝚒 the large element in the connected component containing 𝚒
		int rootI=root(i);
		if(rootI==i)
			return i;
		
		int largest=0;
		for(int i1=0;id[i1] == rootI;i1++) {	
			if(id[i1] > largest){
				largest=id[i];
			}
		}
		return largest;	
	}
	
	public void displayArray() {
		// TODO Auto-generated method stub
		for(int i=0;i<id.length;i++){
		System.out.print(id[i]+"\t");
		}
	}
}
