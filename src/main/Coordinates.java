package main;

public class Coordinates {
	int[][] coord=new int[2][2];
	int direction;
	
	Coordinates(int x,int y) {
		this.direction=3;
		this.coord[1][1]=x; // X
		this.coord[0][0]=y; // Y
		System.out.println(this.coord[1][1]+" "+this.coord[0][0]);
	}
	public int[][] getCoordinates() {
		return this.coord;
	}
	public void changeCoordinates(int x,int y) {	
		//System.out.print("Changing coordinates "+this.coord[1][1]+" "+this.coord[0][0]);
		this.coord[1][1]+=x;
		this.coord[0][0]+=y;		
		//System.out.print(" ---> to "+this.coord[1][1]+" "+this.coord[0][0]);
		//System.out.println();
	}
	public int getDirection() {
		return this.direction;
	}
	public void setDirecrtion(int direction) {
		this.direction=direction;
	}
}
