package main;

public class Board {

	
	int[][] board;

	
	Board(int size){
		
		this.board=new int[size][size];		
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	public void setBoard(int x, int y, int value) {
		this.board[x][y]=value;
	}
	public void showBoard(int[][] board) {
		for(int i[]:board) {

			for(int k:i) {
				if(k==0) {
					System.out.print(" "+" ");
					
				}
				else System.out.print(k+ " ");
			}
			System.out.println();
		}
	}
	
	
}
