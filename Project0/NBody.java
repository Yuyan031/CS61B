public class NBody{
	public static String imageToDraw = "images/starfield.jpg";
	public static double readRadius(String path){
		In in = new In(path);
		int id = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	
	public static Planet[] readPlanets(String path){
		In in = new In(path);				
		int id = in.readInt();
		double radius = in.readDouble();
		Planet[] planet = new Planet[5];
		planet[0] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		planet[1] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		planet[2] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		planet[3] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		planet[4] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		return planet;
	}
	
	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		double time = 0;
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planet = readPlanets(filename);
		StdDraw.setScale(-radius*5, radius*5);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		for(int i=0;i<5;i++){
			planet[i].draw();
		}
		while(time<=T){
			double[] xForces = new double[5];
			double[] yForces = new double[5];
			StdDraw.picture(0, 0, imageToDraw);
			for(int j=0;j<5;j++){
				xForces[j] = planet[j].calcNetForceExertedByX(planet);
				yForces[j] = planet[j].calcNetForceExertedByY(planet);
				planet[j].update(time, xForces[j], yForces[j]);
				planet[j].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;
		}
		StdOut.printf("%d\n", planet.length);
		StdOut.printf("%.2e\n", radius);
		for (int k = 0; k < planet.length; k++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			planet[k].xxPos, planet[k].yyPos, planet[k].xxVel,
			planet[k].yyVel, planet[k].mass, planet[k].imgFileName);   
		}
	
	}
}