public class HW0_2{	
	public static void drawTriangle(int N){
		int total = 0;
		while (total<N){
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
	public static void main(String[] arg){
		int N = 5;
		drawTriangle(N);
	}
}