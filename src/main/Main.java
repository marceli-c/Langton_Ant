package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

public class Main{

	
	
	
	static Window okno;
	
	public static void main(String[] args) {
		
		
		
		System.out.println("POCZĄTEK");
		
		Scanner skaner=new Scanner(System.in);
		System.out.println("Podaj rozmiar planszy");
		int boardSize=skaner.nextInt();
		

		okno=new Window(1000,boardSize);			// WIELKOŚĆ EKRANU, WIELKOŚĆ TABLICY -//-
		System.out.println("KONIEC");
		
		
	}
}
