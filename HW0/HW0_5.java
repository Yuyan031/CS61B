public class HW0_5{	
	public static void windowPossSum(int[] a, int n){
		for(int i=0;i<a.length;i=i+1){
			if(a[i]<0){
				continue;
			}
			int new_value = a[i];
			int j = i+1;
			while(j<=(i+n)){
				if(j >= a.length){break;}
				new_value = new_value + a[j];				
				j = j+1;
			}
			a[i] = new_value;
		}
	}

	public static void main(String[] arg){
		int[] a = new int[]{1,2,-3,4,5,4};
		int n = 3;
		windowPossSum(a,n);
		System.out.println(java.util.Arrays.toString(a));
	}
}