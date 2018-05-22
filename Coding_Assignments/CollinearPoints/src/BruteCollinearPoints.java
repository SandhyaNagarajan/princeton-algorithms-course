import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collector;

import edu.princeton.cs.algs4.StdRandom;



public class BruteCollinearPoints {
	private ArrayList<LineSegment> lineSegments=new ArrayList<>();
	private LineSegment[] noOfSegments;
	public BruteCollinearPoints(Point[] points)  {
		int pointsSize=points.length;
		// finds all line segments containing 4 points
		if(points==null)
			throw new java.lang.IllegalArgumentException();
		// throw same exception when any one point is null or repeated points
		for(int i=0;i < pointsSize;i++) {
			if(points[i]==null)
				throw new java.lang.IllegalArgumentException();
			for(int j=i+1; j < pointsSize; j++) {
				//required says points cannot be the same
				if(points[i]==points[j])
					throw new java.lang.IllegalArgumentException();
				//arrange the points to ascending order to make 
				//drawing line segment easy
				
				if(points[i].compareTo(points[j])==1){
					Point temp=new Point(0, 0);
					temp=points[i];
					points[i]=points[j];
					points[j]=temp;
				}
			}
		}
		
		for(int i=0;i < pointsSize ; i++) {
			ArrayList<Double> slopes=new ArrayList<>();
			int j = i+1; // rememberJ=0;
			while( j < pointsSize ) {
				while(slopes.size() < 4 && j < pointsSize) {
					slopes.add(points[i].slopeTo(points[j]));
					j++;
				}
				//rememberJ=j;
				//check whether all slopes are equal
				//if they are equal -> collinear=true
				
				Double First=slopes.get(0);
				Boolean collinear=false;
				if(slopes.size()==4) {
					for(double s:slopes)
						
						if(!(s==First)){
							collinear= false;
							break;
						}	else {
							collinear=true;
						}
				}
				//if the points are collinear then draw the line segment and
				//add the line to the lineSegment array.
				if(collinear){
						points[i].drawTo(points[j]);
						LineSegment line = new LineSegment(points[i], points[j]);
						lineSegments.add(line);
				}
				//clear the slopes arraylist to continue with next set of 4 items
				slopes.clear();
			}
			
			noOfSegments=lineSegments.toArray(new LineSegment[lineSegments.size()]);	
			//j=rememberJ;
			}
		
	}
	public int numberOfSegments()	{
		/*
		 * lineSegments -> arraylist is created initially since we dont know the no of line 
		 * segments from the points.
		 * noOfSegments -> array of type LineSegment : which is the required return type. Hence,
		 * we convert to array from arraylist
		 */
		
		return noOfSegments.length;
		   // the number of line segments
	   }
	public LineSegment[] segments()  {
		
		return noOfSegments;
		   // the line segments
	   }
}
