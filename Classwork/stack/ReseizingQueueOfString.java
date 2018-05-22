package stack;

public class ReseizingQueueOfString {
	private String q[];
	private int tail=0;
	private int head=0;
	private int n=0;
	//constructor
	public ReseizingQueueOfString() {
		q=new String[2];
	}
	
	public void enqueue(String item) {
		/*
		 * We resize the array to DOUBLE capacity when 
		 * size of array equals stack
		 */
		if(q.length== n) 
			resize(2*q.length);
		q[tail++]=item;
		if(tail==q.length) tail=0;
		n++;
	}
	
	private void resize(int capacity) {
		// TODO Auto-generated method stub
		String copy[]=new String[capacity];
		for(int i=0;i<n;i++)
			//since we wrap up, we need to unwrap the rest array 
			//suppose head is 2 and length is 10, 2 %10 is 2 q[2] is now copied to cop[0]
			// 2+9(9th element of the queue which is actually in q[1] will be copied to
			//9th position in the new copy array
			copy[i]=q[(head+i) % q.length];
		q=copy;
		//since we have unwrapped the array we reset head to 0 and tail to size of queue
		head=0;
		tail=n;
	}

	public String dequeue(){
		String item = q[head];
		q[head]=null; //loitering
		n++;
		head++;		//move to head pointer to next available item
		//wrap around
		if(head==q.length) head=0;
		//shrink
		if(n>0 && n==q.length/4) resize(q.length/2);
		return item;
		
	}
	
	
}
