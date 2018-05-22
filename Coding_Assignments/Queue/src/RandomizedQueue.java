import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] randomQueue;
	private int size = 0;
	
	
	public RandomizedQueue() {
		 // construct an empty randomized queue
		randomQueue = (Item[]) new Object[1];
	 }
	
	public boolean isEmpty(){
		// is the randomized queue empty?
		return size==0;	
	}
	
	public int size(){
		// return the number of items on the randomized queue
		return size;
	}
	
	public void enqueue(Item item)  {
		// add the item
		if(item==null)
			throw new java.lang.IllegalArgumentException();
		if(randomQueue.length==size)
			resize(2*randomQueue.length);
		randomQueue[size++]=item;
	}

	
	private void resize(int capacity) {
		// TODO Auto-generated method stub
		Item[] copy=(Item[]) new Object[capacity];
		for(int i=0;i<size;i++)
			copy[i]=randomQueue[i];
		randomQueue=copy;
	}
	
	public Item dequeue(){
		if(size==0){
			throw new java.util.NoSuchElementException();
		}
		// remove and return a random item
		int randomPosition = StdRandom.uniform(size);
		Item item=randomQueue[randomPosition];
		//avoid loitering
		randomQueue[randomPosition]=null;
		--size;
		if(size>0 && size==randomQueue.length/4) resize(randomQueue.length/2);
		return item;
	}
	
	public Item sample() {
		// return a random item (but do not remove it)
		if(size==0){
			throw new java.util.NoSuchElementException();
		}
		int randomPosition = StdRandom.uniform(size);
		Item item=randomQueue[randomPosition];
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item> {
		
		private int countNext=randomQueue.length-1;
		
		//constructor
		//for each instance of the iterator we shuffle the randomQueue
		public RandomQueueIterator(){
		StdRandom.shuffle(randomQueue);
		
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
				return (countNext >= 0);
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			Item next=randomQueue[countNext--];
			//need to check how to fix the problem with returning null values still
			//this below while loop partially fixes the trouble, still returns null 
			//when the last element is null
			while(next==null && hasNext())
				next=randomQueue[countNext--];
			return next;
//			while(true) {
//				Item next=randomQueue[countNext--];
//				return next;
//			}
//				
		}
		
		@Override
		public void remove() {
	           throw new UnsupportedOperationException();
	        }
				
			
		}
	
	
	//for unit testing
	public static void main(String args[]){
		RandomizedQueue<Integer> rq=new RandomizedQueue<>();
		//enqueue
		for(int i=0;i < 5; i++)
			rq.enqueue(i);
		//sample
		int sample=rq.sample();
		System.out.println(sample);
		//dequeue
		int random=rq.dequeue();
		System.out.println(random);
		//iterator 1-long form
		Iterator<Integer> itr=rq.iterator();
		while(itr.hasNext()){
			Object next=itr.next();
			if(next!=null) {
				System.out.print(next);	
			}
		}		
		//iterator 2 - short form
		for(Integer d:rq)
			//if(d!=null)
				System.out.println(d);
			}
}
