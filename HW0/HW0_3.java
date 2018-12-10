public class HW0_3{	
	/** returns the maximum value from m. */
	public static int max(int[] m){
		int len = m.length;
		int next = 1;
		int max_num = m[0];
		while(next < len){
			if (max_num <= m[next]){max_num = m[next];}
			else {max_num = max_num;}
			next = next + 1;
		}
		return max_num;
		
	}

	public static void main(String[] arg){
		int[] numbers = new int[]{9,2,15,2,22,10,6};
		System.out.println(max(numbers));
	}
}