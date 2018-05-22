package stack;


public class LinkedQueueOfString {

	private Node first=null;
	private Node last=null;
	//Here no constructor is created,
	//so the complier will create the default empty constructor
	private class Node{   // inner class to create node object
		String item;
		Node next;
	}
	
	public void enqueue(String item){
		Node oldlast=last;
		last =new Node();
		last.item =item;
		last.next=null;
		if(isEmpty()) first = last;
		else oldlast=last;
	}

	private boolean isEmpty() {
		// return if the queue is empty
		return (first == null) ;
	}
	
	public String dequeue() {
		String item = first.item;
		first=first.next;
		if(isEmpty()) last=null;
		return item;
	}
}
