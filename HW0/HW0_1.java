public class HW0_1{	
	public static void main(String[] arg){
		int total = 0;
		while (total<5){
			String out = " ";
			int x = 0;
			while(x<=total){
				out = "*" + out;
				x = x+1; 
			}
			total = total + 1;
			System.out.println(out);
		}
	}
}