

public class Node_Ignore<Item> {
	private Item item;
	private Node_Ignore prev;
	private Node_Ignore next;
	public Node_Ignore(Item i,Node_Ignore p,Node_Ignore n){
		item=i;
		prev=p;
		next=n;
	}
	public Node_Ignore(Item i){
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
	public Node_Ignore getPrev() {
		return prev;
	}
	public void setPrev(Node_Ignore prev) {
		this.prev = prev;
	}
	public Node_Ignore getNext() {
		return next;
	}
	public void setNext(Node_Ignore next) {
		this.next = next;
	}
	
	
}
