package model;

public class Pond {
	public int id;
	public String name;
	public Point center;
	public double radius;
	public Pond(int id,double[] points3) {
		this.id=id;
		this.name="P"+id;
		this.center=new Point(points3[2], points3[1]);
		this.radius=points3[0]-points3[2];
	}
}
