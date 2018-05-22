import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
		
		private double[] threshold;
		private double mean=0;
		private double stdDev=0;
		   public PercolationStats(int n, int trials){
			   // perform trials independent experiments on an n-by-n grid
			   if(n<=0){
					throw new java.lang.IllegalArgumentException(n +" cannot be 0 or negative");
				}
			   if(trials<=0){
					throw new java.lang.IllegalArgumentException(n +" cannot be 0 or negative");
				}
			   threshold=new double[trials];
			   //memory analysis suggests to create the precolation data in local variable than instance variable to 
			   //avoid large memory usage
			   Percolation sample;
			   for(int i=0;i < trials ; i++){
				   //changed after the test result, we need to create new object 
				   //for every sample(test 4 of procolation stats)
				   sample=new Percolation(n);		   
				   do{
					   int row=StdRandom.uniform(1, n+1);
					   int col=StdRandom.uniform(1, n+1);
					   sample.open(row,col);
				   }while(!sample.percolates());
				   
				   int openSites=sample.numberOfOpenSites();
				   int totalsites= n*n;
				   double prolocationThreshold= (double) openSites/totalsites;
				   threshold[i]=prolocationThreshold;
			   }
			   
			      
		   }
		   public double mean(){
			   // sample mean of percolation threshold
			   mean=StdStats.mean(threshold);
			   return mean;
		   }
		   public double stddev(){
			   // sample standard deviation of percolation threshold
			   stdDev=StdStats.stddev(threshold);
			   return stdDev;
		   }
		   public double confidenceLo(){
			   // low  endpoint of 95% confidence interval
			   //after test results, mean and stdDev cannot be zero while evaulating confidence
			   if(mean==0) mean();
			   if(stdDev==0) stddev();
			  double low =  mean - (1.96 * stdDev/Math.sqrt(threshold.length));
			  return low;
		   }
		   public double confidenceHi(){
			   // high endpoint of 95% confidence interval
			 //after test results, mean and stdDev cannot be zero while evaulating confidence
			   if(mean==0) mean();
			   if(stdDev==0) stddev();
			   double hi =  mean + (1.96 * stdDev/Math.sqrt(threshold.length));
			   return hi;
		   }

		   public static void main(String[] args){
			   // test client (described below)
			   //Scanner reader=new Scanner(System.in);
			   //System.out.println("Enter the gridsize n for nxn");
			   //int n=reader.nextInt();
			   //System.out.println("Enter the number of trail");
			   //int trials=reader.nextInt();
			   //reader.close();
			   int n= Integer.parseInt(args[0]) ;
			   int trials = Integer.parseInt(args[1]);
			   
			   PercolationStats ps=new PercolationStats(n, trials);
			   System.out.println("mean    :" + ps.mean());
			   System.out.println("stddev    :"+ps.stddev());
			   System.out.println("95% confidence interval:   ["+ps.confidenceLo()+","+ps.confidenceHi()+"]");
			   
			   
		   }
		
}
