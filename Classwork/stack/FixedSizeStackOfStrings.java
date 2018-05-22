package stack;

public class FixedSizeStackOfStrings {
	/*
	 * this class represents the array implementation of stacks
	 * with fixed size by getting the user input for size of the 
	 * stack in the constructor
	 */
	private String s[];
	private int N=0;
	//constructor for setting the size of array
	public FixedSizeStackOfStrings(int capacity) {
		s=new String[capacity];
	}
	public void push(String item){
		s[N++]=item;
	}
	public String pop(){
		/*
		 * while return s[--N] could be sufficient from implementation point of view
		 * we have to explicitly delete the number which the stack was holding to help recognize 
		 * the garbage collector that it is not being used.
		 * The scenario of object holding the reference even when its not being used is called 
		 * LOITERING.
		 */
		String item=s[--N];
		s[N]= null;
		return item;
	}
	public boolean isEmpty(){
		return N==0;
	}
}
