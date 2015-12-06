package model;

public class Lion {
	public int id;
	public String name;
	public Point location;
	public Lion(int id,	double latitude,double longitude) {
		this.id=id;
		this.name="L"+id;
		this.location=new Point(latitude, longitude);
	}
	public Lion(int id,	double[] location) {
		this.id=id;
		this.name="L"+id;
		this.location=new Point(location[0], location[1]);
	}
}
