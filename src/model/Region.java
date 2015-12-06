package model;

public class Region {
	public int id;
	public String name;
	public int verticesCount;
	public Point[] shape;
	public Region(int id,int verticesCount,double[] shapeArray) {
		this.id=id;
		this.name="R"+id;
		this.verticesCount=verticesCount;
		this.shape=new Point[verticesCount+1];
		for(int i=0;i<=verticesCount;i++){
			this.shape[i]=new Point(shapeArray[2*i],shapeArray[2*i+1]);
		}
	}
}
