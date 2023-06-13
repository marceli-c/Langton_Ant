package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class recDraw extends JPanel{

		Rectangles recArr[][];
		Board board;
		int boardSize;
		
		public recDraw(int boardSize,Board board,Rectangles[][] recArr){
			this.board=board;
			this.recArr=recArr;
			this.setPreferredSize(new Dimension(1000,1000));
			this.setSize(1000,1000);
			this.boardSize=boardSize;
			this.setVisible(true);
			this.setBackground(new Color(0,0,0,0));
			this.setOpaque(false);

		}
		private void paintRecArr(Graphics2D g2d) {
			for(int i=0;i<boardSize;i++) {
				for(int j=0;j<boardSize;j++) {
					
					if(recArr[i][j].getState()==true) {
						//recArr[i][j].setForeground();
						g2d.setColor(new Color(0,0,0));
						g2d.fill(recArr[i][j]);
					}
					else {
						g2d.setColor(new Color(255,255,255));
						g2d.fill(recArr[i][j]);
					}
				}
				
				
			}
			
		}
		@Override
		public void paint(Graphics g) {
			Graphics2D g2d=(Graphics2D)g;
			paintRecArr(g2d);
		}
		
}
