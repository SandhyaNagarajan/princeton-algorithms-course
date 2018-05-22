package stack;

public class ResizingStackOfStrings {
	private String s[];
	private int N=0;
	//constructor
	public ResizingStackOfStrings() {
		s=new String[1];
	}
	public void push(String item) {
		/*
		 * We resize the array to DOUBLE capacity when 
		 * size of array equals stack
		 */
		if(s.length==N) 
			resize(2*s.length);
		s[N++]=item;
	}
	
	public String pop(){
		/*
		 * We resize the array to HALF capacity only when
		 * size of stack is 1/4 of size of array
		 */
		String item=s[--N];
		s[N]=null;
		if(N>0 && N==s.length/4) resize(s.length/2);
		return item;
	}
	
	public void resize(int capacity){
		String copy[]=new String[capacity];
		for(int i=0;i<N;i++)
			copy[i]=s[i];
		s=copy;
	}
}
