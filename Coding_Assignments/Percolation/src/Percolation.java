import edu.princeton.cs.algs4.WeightedQuickUnionUF;;

public class Percolation {
	private int[] grid;
	private int counter=0;
	private WeightedQuickUnionUF uf;
	private int gridLength=0;
	private int totalGridElements=0;
	private int virtualSiteTop;
	private int virtualSiteBottom;
	
	
	public Percolation(int n)  {
		
		/*
		 * constructor:create n-by-n grid, with all sites blocked(all sites value is zero)
		 * initialises all the starting values and makes sure n is not zero or negative
		 */
		
		if(n<=0){
			throw new java.lang.IllegalArgumentException(n +" cannot be o or negative");
		}
		
		gridLength=n;
		totalGridElements = n*n+3; //+3 for the virtual sites
		grid=new int[totalGridElements];
		uf = new WeightedQuickUnionUF(totalGridElements);
		virtualSiteTop = n*n + 1;
		virtualSiteBottom = n*n +2;
		
		
	}
	
	private void validateIndex(int row,int col){
		if(row <= 0 || row > gridLength || col <= 0 || col > gridLength ) {
			throw new java.lang.IllegalArgumentException(row +"or"+ col +" cannot be o or negative");

		}
			
		
	}
	
	
	private int calculateGridElement(int row,int col)
	{
		/*
		 * with given n,row and column, we calculate value at index as row*n+col-n
		 * all the elements gets value from 1 to n^2 
		 */
		
		validateIndex(row,col);
		int gridElement = (row*gridLength)+ col - gridLength;
		return gridElement;
	}
	
	private int fillGridElement(int row,int col){
		/*
		* The array gets the value from 1 to n^2 only when the open method is used
	    * Else all the values are zero
	    * if the element is in top row or botton row, the element is 
	    * connected to either of the virtual sites 
	    	    */
		validateIndex(row,col);
		int element=0;
		if(!isOpen(row,col)){
				element = calculateGridElement(row, col);
			   grid[element]=element;
			   if(row==1)
				   uf.union(element, virtualSiteTop);
				if(row==gridLength)
					uf.union(element, virtualSiteBottom);
			   counter++;
			   }
		return element;
	}
	
	public void open(int row, int col) {	
		/*
		 * open site (row, col) if it is not open already
		 * 
		 * fills the adjacent sites if open
		 * corner case is addressed
			 
		 */
		
		validateIndex(row,col);
		int element=fillGridElement(row,col);
		if(!((row-1)<=0)){
			int elementTop = calculateGridElement(row-1,col);
			if(isOpen(row-1,col))
				uf.union(element,elementTop);
		}
		if(!((row+1) > gridLength)){
			int elementBottom = calculateGridElement(row+1,col);
			if(isOpen(row+1,col))
				uf.union(element,elementBottom);
		}
		if(!((col-1)<=0)) {
			int elementLeft=calculateGridElement(row,col-1);
			if(isOpen(row,col-1))
				uf.union(element, elementLeft);
		}	
		if(!((col+1) > gridLength)) {
			int elementRight=calculateGridElement(row,col+1);
			if(isOpen(row,col+1))
				uf.union(element, elementRight);
		}	
	   }
	
	public boolean isOpen(int row, int col) {   
	   // is site (row, col) open?
		validateIndex(row,col);
	   int element = calculateGridElement(row,col);
	   if(grid[element]!=0)
	   	return true;
	   return false;
   }
	public boolean isFull(int row, int col) {
		   // is site (row, col) full?
		//is the topsite and bottomsites are connected through this element
		validateIndex(row,col);
		int element = calculateGridElement(row,col);
		boolean topSiteConnected = uf.connected(element,virtualSiteTop);
		if(topSiteConnected)
			return true;
		return false;

	   }
	public int numberOfOpenSites()  {
		   // number of open sites
	   /*
	    * initialise a counter and increment everytime site opens
	    * return the number here
	    */
	   return counter;
	   }
	public boolean percolates() {
	
		   // does the system percolate?
	   /*
	    * create a virtual site connecting elements in first row seperately and elements
	    * in second row seperately
	    * system perculates when both the virtual elements are connected
	    */
	   /*
	    * create the array of top row cells (1-N)
	    * 
	    */
	   if(uf.connected(virtualSiteTop, virtualSiteBottom))	
		   return true;
	   return false;
	   }

	public static void main(String[] args){
		   // test client (optional)
	   Percolation pr=new Percolation(3);
	   pr.open(1, 2);
	   pr.open(2, 3);
	   pr.open(1,3);
	   pr.open(3, 3);
	   boolean result=pr.percolates();
	   System.out.println(result);
	   }
}
