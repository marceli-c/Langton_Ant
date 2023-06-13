package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.Timer;

public class Window extends JFrame implements ActionListener{
	
	
	
	Coordinates[] coordinate;
	int direction=3,direction2=3;
	int[][] board;
	Rectangles[][] recArr;
	Scanner skaner;
	int boardSize;
	int scale;
	Timer timer;
	int numberOfAnts;
	recDraw recDraw;
	Mesh mesh;
																		// STABILNA POZYCJA - {17,18} {20,22}
	
	Window(int windowSize, int boardSize){
		this.scale=windowSize/boardSize;
		
		Board board=new Board(100);
		this.board=board.getBoard();
		
		System.out.println("Podaj liczbe mrowek");
		skaner=new Scanner(System.in);
		int numberOfAnts=skaner.nextInt();
		
		this.numberOfAnts=numberOfAnts;
		coordinate=new Coordinates[numberOfAnts];
		createAnts(numberOfAnts);
		

		createWindow(windowSize);
		
		
		this.boardSize=boardSize;

				
		recArr=new Rectangles[boardSize][boardSize];
		
		
				
		callRecArr(board.getBoard());
		
		timerInitialize(10);
				
		recDraw=new recDraw(boardSize,board,recArr);
		mesh= new Mesh(scale);
		
		this.add(mesh);
		this.add(recDraw);
		
	}
	private void createAnts(int numberOfAnts) {
		int x=0,y=0;
		for(int i=0;i<numberOfAnts;i++) {
			System.out.println("Podaj x:");
			x=skaner.nextInt();
			System.out.println("Podaj y:");
			y=skaner.nextInt();
			this.coordinate[i]=new Coordinates(x,y);
		}
	}
	
	

	
	
	private void createWindow(int Windowsize) {
		
		//this.setLocationRelativeTo(this.getParent());
		//this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(Windowsize,Windowsize);
		
		this.setVisible(true);
		
		mesh=new Mesh(scale);
		
		this.add(mesh,0);
		//System.out.println("BOUNDSSSSSSSSSSSSSSSSSSSSSSSSSS"+mesh.getBounds()+" "+mesh.isVisible()+" "+mesh.isOpaque());
		this.pack();
	}
	
		

	
	

	
	
	
	private void callRecArr(int[][] board) {
		int h=0;
		for(int i=0;i<boardSize;i++) {
			int k=0;
			for(int j=0;j<boardSize;j++) {
				k+=scale;
				recArr[i][j]=new Rectangles(this.getWidth()/boardSize,false);
				//recArr[i][j].setBounds(k+200, h+200, scale, scale);
				recArr[i][j].setRect(k, h, scale, scale);
			}
			h+=scale;
		}
		implementBoardState(board);
		
	}
	
	
	private void implementBoardState(int[][] board) {
		//int h=0;
		for(int i=0;i<boardSize;i++) {
			//int k=0;
			for(int j=0;j<boardSize;j++) {
				if(board[i][j]==1) recArr[i][j].setState(true);
				else recArr[i][j].setState(false);

				
			}
		}
			
	}
	
	public void showStates() {
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				System.out.print(recArr[i][j].getState()+" ");
				System.out.print(recArr[i][j].getBounds()+" ");
			}
			System.out.println();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		implementBoardState(board);
		
		this.repaint();
		for(int i=0;i<numberOfAnts;i++) {
			move(coordinate[i],board);
		}

		recDraw.repaint();
		
	}
	
	private void timerInitialize(int delay) {
		timer=new Timer(delay,this);
    	timer.start();
		
	}
	
	private static void moveLeft(Coordinates coordinates) {

		switch (coordinates.getDirection()) {
		case 1: coordinates.setDirecrtion(3);								// 1-GÓRA
				coordinates.changeCoordinates(-1,0);
				break;
		case 2: coordinates.setDirecrtion(4);								// 2-DÓL
				coordinates.changeCoordinates(1, 0);
				break;	
		case 3: coordinates.setDirecrtion(2);								// 3-LEWO
				coordinates.changeCoordinates(0, 1);
				break;
		case 4: coordinates.setDirecrtion(1);								// 4-PRAWO
				coordinates.changeCoordinates(0,-1);
				break;
		}		
		
	}
	private static void moveRight(Coordinates coordinates) {

		switch (coordinates.getDirection()) {
		case 1: coordinates.setDirecrtion(4);								// 1-GÓRA
				coordinates.changeCoordinates(1,0);
				break;										
		case 2: coordinates.setDirecrtion(3);								// 2-DÓL
				coordinates.changeCoordinates(-1, 0);
				break;
		case 3: coordinates.setDirecrtion(1);								// 3-LEWO
				coordinates.changeCoordinates(0, -1);
				break;
		case 4: coordinates.setDirecrtion(2);								// 4-PRAWO
				coordinates.changeCoordinates(0,1);
				break;
		}
		
	}

	private static void move(Coordinates coordinate, int[][] board) {
		
		if(	board[coordinate.getCoordinates()[0][0]][coordinate.getCoordinates()[1][1]]==1) {
			changeBoard(coordinate,board,1);
			moveLeft(coordinate);			
		}
		else {
			changeBoard(coordinate,board,0);
			moveRight(coordinate);
			
		}
		
		
	}
	
	private static void changeBoard(Coordinates coordinate,int[][] board, int value) {
		switch(value) {
		case 1:board[	coordinate.getCoordinates()[0][0] 	] [	coordinate.getCoordinates()[1][1]	] =0;
			break;
		case 0:board[	coordinate.getCoordinates()[0][0]	] [	coordinate.getCoordinates()[1][1]	] =1;
			break;
		}
	}
	
}
