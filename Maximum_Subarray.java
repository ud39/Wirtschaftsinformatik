
public class Maximum_Subarray {


	public int maxSubArray(int[] A, int n)
	{
	if(n == 0)
	{
	return 0;
	}else{
		 return maxSubArraySup(A,0,n-1);
		 }
	}

	private int maxSubArraySup(int[] A, int left, int right) {
		if(right == left) return A[left];
		int middle = (right+left)/2;
		int leftans = maxSubArraySup(A, left, middle);
		int rightans = maxSubArraySup(A, middle+1, right);
		int leftmax = A[middle];
		int rightmax = A[middle+1];
		int temp = 0;
		for(int i=middle; i >= left;i--)
		{
			temp += A[i];
			if(temp > leftmax) leftmax = temp;
		}
		temp = 0;
		for(int i = middle+1; i <= right; i++)
		{
			temp += A[i];
			if(temp > rightmax) rightmax = temp;
		}
		return Math.max(Math.max(leftans,rightans),leftmax+rightmax );
	}

	public static void main(String args[])
	{
	int[] test = new int[] {31,-41,59,26,-53,58,97,-93,-23,84};
	System.out.println(new Maximum_Subarray().maxSubArray(test, 10));
	}
}
