package model;

public class Ambulance {
	public int id;
	public String name;
	public Point location;
	public double coverRaduis;
	public Ambulance(int id,double[] coverArea) {
		this.id=id;
		this.name="A"+id;
		this.location=new Point(coverArea[2], coverArea[1]);
		this.coverRaduis=coverArea[0]-coverArea[2];
	}
}
