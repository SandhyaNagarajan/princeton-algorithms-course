import java.util.ArrayList;
import java.util.function.Predicate;



public class BruteCollinearPoints_old {
	private ArrayList<LineSegment> lineSegments=new ArrayList<>();
	private LineSegment[] noOfSegments;
	public BruteCollinearPoints_old(Point[] points)  {
		// finds all line segments containing 4 points
		if(points==null)
			throw new java.lang.IllegalArgumentException();
		// throw same exception when any one point is null or repeated points
		for(int i=0;i < points.length-1;i++) {
			if(points[i]==null)
				throw new java.lang.IllegalArgumentException();
			for(int j=i+1; j <= i;j++) {
				//required says points cannot be the same
				if(points[i]==points[j])
					throw new java.lang.IllegalArgumentException();
				//arrange the points to ascending order to make 
				//drawing line segment easy
				if(points[i].compareTo(points[j])==-1){
					Point temp=new Point(0, 0);
					temp=points[0];
					points[i]=points[j];
					points[j]=temp;
				}
			}
		}
		for(int i=0;i < points.length-1 ; i++) {
			ArrayList<Double> slopes=new ArrayList<>();
			for (int j= i; j < i+4 && j < points.length-1; j++){
				//determine the slope for 4 points at a time
				slopes.add(points[i].slopeTo(points[j]));
			}
			//check whether all slopes are equal
			//if they are equal -> collinear=true
			Double First=slopes.get(0);
			Boolean collinear=true;
			for(double s:slopes)
				if(!(s==First)){
					collinear= false ;
					break;
				}
			//if the points are collinear then draw the line segment and
			//add the line to the lineSegment array.
			if(collinear){
					points[i].drawTo(points[i+4]);
					LineSegment line = new LineSegment(points[i], points[i+4]);
					lineSegments.add(line);
			}
			//clear the slopes arraylist to continue with next set of 4 items
			slopes.clear();
		}
		
				
		
	}
	public int numberOfSegments()	{
		/*
		 * lineSegments -> arraylist is created initially since we dont know the no of line 
		 * segments from the points.
		 * noOfSegments -> array of type LineSegment : which is the required return type. Hence,
		 * we convert to array from arraylist
		 */
		noOfSegments=lineSegments.toArray(new LineSegment[lineSegments.size()]);
		return noOfSegments.length;
		   // the number of line segments
	   }
	public LineSegment[] segments()  {
		
		return noOfSegments;
		   // the line segments
	   }
}
