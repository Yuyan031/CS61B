public class HW0_4{	
	/** returns the maximum value from m. */
	public static int ForMax(int[] m){
		int max_num = m[0];
		for(int i=1;i<m.length;i=i+1){
			if (max_num <= m[i]){max_num = m[i];}
			else {max_num = max_num;}
		}
		return max_num;
		
	}

	public static void main(String[] arg){
		int[] numbers = new int[]{9,2,15,2,22,10,6};
		System.out.println(ForMax(numbers));
	}
}