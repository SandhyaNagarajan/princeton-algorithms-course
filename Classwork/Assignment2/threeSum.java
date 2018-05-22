package Assignment2;

public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr;
		arr = new int[] {-20,-30,-10,0,30,20,10};
		int i=Integer.parseInt(args[0]),
				j=Integer.parseInt(args[1]),k;
		sortArray(arr);
		 k=findThirdNumber(arr,i,j);
		 if(k== -1)
		 System.out.println("No");
		 else
			System.out.println("Yes");
		
	}
	private static void sortArray(int[] arr) {
		for(int i=0;i < arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i] < arr[j]){
					int temp;
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}
	
	
	private static int findThirdNumber(int[] arr,int i,int j){
		
		int low = 0,high = arr.length-1,mid = 0;
		int target = - (i+j);
		while(low <= high){
			mid = (low+high)/2;
			if(arr[mid] > target) high=mid-1;
			else if(arr[mid] < target) low=mid+1;
			else return mid;
		}
		return -1;
	}
	

}
