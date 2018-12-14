public class Planet{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV, double yV,double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
		
	}

	public double calcDistance(Planet p){
		double distance = Math.sqrt(Math.pow((this.xxPos - p.xxPos),2) + Math.pow((this.yyPos - p.yyPos),2));
		return distance;
	}

	public double calcForceExertedBy(Planet p){
		double distance = this.calcDistance(p);
		double force = 6.67 * Math.pow(10,-11) * this.mass * p.mass / Math.pow(distance,2);
		return force;
	}
	
	public double calcForceExertedByX(Planet p){
		double distance = this.calcDistance(p);
		double force = this. calcForceExertedBy(p);
		double forcex = (p.xxPos - this.xxPos) * force / distance;
		return forcex;
	}
	
	public double calcForceExertedByY(Planet p){
		double distance = this.calcDistance(p);
		double force = this. calcForceExertedBy(p);
		double forcey = (p.yyPos - this.yyPos) * force / distance;
		return forcey;
	}
	
	public double calcNetForceExertedByX(Planet[] pl){
		double l = pl.length;
		double netForce = 0;
		for(int i = 0;i<l;i++){
			if(this.equals(pl[i])==true){continue;}
			else{
			netForce += this.calcForceExertedByX(pl[i]);
			}
		}
		return netForce;
	}
	
	public double calcNetForceExertedByY(Planet[] pl){
		double l = pl.length;
		double netForce = 0;
		for(int i = 0;i<l;i++){
			if(this.equals(pl[i])==true){continue;}
			else{
			netForce += this.calcForceExertedByY(pl[i]);
			}
		}
		return netForce;
	}
	
	public boolean equals(Planet p){
		if(this.xxPos == p.xxPos && this.yyPos == p.yyPos){return true;}
		else{return false;}
	}
	
	public void update(double dt, double Fx, double Fy){
		double a_x = Fx / this.mass;
		double a_y = Fy / this.mass;
		this.xxVel = this.xxVel + dt * a_x;
		this.yyVel = this.yyVel + dt * a_y;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
	
	public void draw(){
		String path = "images/" + this.imgFileName; 
		StdDraw.picture(this.xxPos, this.yyPos, path);

	}
}