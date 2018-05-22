package stack;


public class LinkedListStackOfStrings {
	private Node first=null;
	//Here no constructor is created,
	//so the complier will create the default empty constructor
	private class Node{   // inner class to create node object
		String item;
		Node next;
	}
	public String pop() {
		
		String item=first.item;
		first=first.next;
		return item;
	}
	
	public void push(String item){
		Node oldFirst=first;
		first=new Node();
		first.item= item;
		first.next=oldFirst;
	}
	
	public boolean isEmpty(){
		return first==null;
	}

}
