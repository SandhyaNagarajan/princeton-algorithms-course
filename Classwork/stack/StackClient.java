package stack;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {
	public static void main(String[] args){
		LinkedListStackOfStrings st=new LinkedListStackOfStrings();
		while(!StdIn.isEmpty()){
			String s=StdIn.readString();
			if(s.equals("-")) StdOut.print(st.pop());
			else 				st.push(s);
		}
	}
}
