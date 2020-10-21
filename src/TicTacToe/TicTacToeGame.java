package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

	static char[][] board = {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};
	static Scanner scan = new Scanner(System.in); 
	static List<Integer> rememberPosition1 = new ArrayList<Integer>();
	static List<Integer> rememberPosition2 = new ArrayList<Integer>();
	
	
	public static void PlayBoard() {		
		for(char[] i: board) {
			for(char c: i) {
				System.out.print(c);
			}
			System.out.println();
		}		
	}
	
	public static void OnBoardPosition(List player1, List player2) {
		int xAxis = 0, yAxis = 0;  
		int cursor = 0;
		
		Collections.sort(player1);
		Collections.sort(player2);
		
		
			for(char[] i: board) {
				for(char c: i) {					
					cursor = Position(xAxis, yAxis);
					
					if(player1.contains(cursor)) {
						board[yAxis][xAxis] = 'O';
					}else if(player2.contains(cursor)) {
						board[yAxis][xAxis] = 'X';
					}	
					xAxis++;
				}
				yAxis++;
				xAxis = 0;
			}
			
			for(char[] i: board) {
				for(char c: i) {
					System.out.print(c);
				}
				System.out.println();
			}
			
	}
	
	public static void Play() {
		
		int xAxis = 0, yAxis = 0;  
		int cursor = 0;
		int positionVal = 0;
		boolean running = true;
			
		while(running) {
			System.out.println("Enter Player \"O\" Position (1-9)");
			positionVal = scan.nextInt();
			rememberPosition1.add(positionVal);
			
			OnBoardPosition(rememberPosition1, rememberPosition2);
			
			running = CheckWinPlayer();
			if(!running)
				break;
			
			System.out.println("Enter Player \"X\" Position (1-9)");
			positionVal = scan.nextInt();
			rememberPosition2.add(positionVal);
			
			OnBoardPosition(rememberPosition1, rememberPosition2);
			
		}
		
	}
	public static boolean CheckWinPlayer() {
		List<Integer> li = new ArrayList<Integer>();
		boolean running = true;
		
		int[][] winArray = { 
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{1,4,7},
				{2,5,8},
				{3,6,9},
				{1,5,9},
				{3,5,7}};
		
		for(int[] array: winArray) {		
			for(int ele: array) {
				li.add(ele);
			}
			if(rememberPosition1.containsAll(li)) {
				System.out.println("****** Player \"O\" Wins ******");
				running = false;
			}
			if(rememberPosition2.containsAll(li)) {
				System.out.println("****** Player \"X\" Wins ******");
				running = false;
			}				
			li.clear();
		}
		return running;
	}
	
	
	public static int Position(int xaxis, int yaxis) {
		String posOnAxis = Integer.toString(yaxis) + Integer.toString(xaxis); 
		int finalPos = 0;
		
		switch(posOnAxis){
			case "00":
				finalPos = 1;
				break;
			case "02":
				finalPos = 2;
				break;
			case "04":
				finalPos = 3;
				break;
			case "20":
				finalPos = 4;
				break;
			case "22":
				finalPos = 5;
				break;
			case "24":
				finalPos = 6;
				break;
			case "40":
				finalPos = 7;
				break;
			case "42":
				finalPos = 8;
				break;
			case "44":
				finalPos = 9;
				break;
			default:
//				System.out.println("Position is not valid");
							
		}
//		System.out.println(finalPos);
		return finalPos;
	}
	

	
	
	public static void main(String[] args) {
//		PlayBoard();
		Play();
//		Position(3,3);
		
		
		
	}
	
}
