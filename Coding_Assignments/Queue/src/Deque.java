import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	/*
	 * instance variables
	 */
	private int size=0;
	private Node header,trailer,first,last;
	/*
	 * Node implementation
	 */

	private class Node {
		private Item item;
		private Node prev;
		private Node next;
		
		public Node(Item i){
			item=i;
			prev=null;
			next=null;
		}
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

			
		

	/*
	 * Constructor: Create an empty deque with sentinel nodes header and trailer
	 */
	public Deque(){
		Item sentinel=null;
		header=new Node(sentinel);
		trailer=new Node(sentinel);
		header.setNext(trailer);
		trailer.setPrev(header);
	}
		
			
	public boolean isEmpty(){
		return (size==0);
	}
	
	public int size(){
		return size;
	}
	
	
	public void addFirst(Item item){
		//get oldfirst through header
		if(item==null){
			throw new java.lang.IllegalArgumentException();
		}
		Node oldFirst=header.getNext();
		//set new node values
		Node first= new Node(item);
		first.setNext(oldFirst);
		first.setPrev(header);
		//update header next to new node
		header.setNext(first);
		oldFirst.setPrev(first);
		size++;
	}
	
	public void addLast(Item item) {
		if(item==null){
			throw new java.lang.IllegalArgumentException();
		}
		Node oldLast=trailer.getPrev();
		Node last=new Node(item);
		last.setNext(trailer);
		last.setPrev(oldLast);
		trailer.setPrev(last);
		oldLast.setNext(last);
		size++;
	}
	
	public Item removeLast(){
		//get the lastnode
		Node oldLast=trailer.getPrev();
		if(oldLast==header)
			throw new java.util.NoSuchElementException();
			//get oldlast's previous node
		last=oldLast.getPrev();
		//avoid loitering
		oldLast.setNext(null);;
		oldLast.setPrev(null);
		//make last as trailer's previous node
		trailer.setPrev(last);
		size--;
		Item item=oldLast.getItem();
		//avoid loitering
		oldLast.setItem(null);
		return item;
	}
	
	public Item removeFirst() {
		Node oldFirst=header.getNext();
		if(oldFirst==trailer)
			throw new java.util.NoSuchElementException();
		first=oldFirst.getNext();
		oldFirst.setNext(null);
		oldFirst.setPrev(null);
		header.setNext(first);
		size--;
		Item item=oldFirst.getItem();
		//avoid loitering
		oldFirst.setItem(null);
		return item;
		
	}
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
				return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		
		private Node current = header.getNext();
        public boolean hasNext()  { return current.getItem() != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (hasNext())
            { 
            Item item = current.getItem();
            current = current.getNext(); 
            return item;
            }
            else 
            	throw new NoSuchElementException();

            
			           
        }
		
	}

	public static void main(String args[]){
		Deque<Integer> dq=new Deque<Integer>();
		
		//testing addfirst
		for(int i=0;i<5;i++)
			dq.addFirst(i);
		
		//testing iterator-longhand
		Iterator<Integer> itr=dq.iterator();
		while(itr.hasNext()){
			int i=itr.next();
			System.out.println(i);
			}		
		
		//testing addlast
		for(int i=6;i<10;i++)
			dq.addLast(i);
		
		//testing iterator-shorthand
		for(Integer d:dq)
			System.out.println(d);
		
		//testing removelast
		int size1=dq.size()/2;
		for(int i=0;i<size1;i++)
			System.out.println(dq.removeLast());

		//testing removefirst
		int size2=dq.size();
		for(int i=0;i<size2;i++)
			System.out.println(dq.removeLast());
		
		

	}
	
}
