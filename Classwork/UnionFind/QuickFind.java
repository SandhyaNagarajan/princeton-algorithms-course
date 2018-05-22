package UnionFind;

public class QuickFind {

	private int[] id;
	//constructor
	public QuickFind(int N){
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	//Find Method
	public boolean find(int p,int q){
		return (id[p]==id[q]);
	}
	//Union Method
	public void union(int p,int q){
		int pid=id[p];
		int qid=id[q];
		for(int i=0;i<id.length;i++){
			if(id[i]==pid)
				id[i]=qid;
		}
	}
	
	
	//display the array
		public void displayArray(){
			for(int i=0;i<id.length;i++){
				System.out.print(id[i]+"\t");
			}
		}	
	
}

