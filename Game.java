

import java.io.*;

public class Game {
	
	public static int play(InputStreamReader input){
		BufferedReader keyboard = new BufferedReader(input);
		Configuration c = new Configuration();
		int columnPlayed = 3; int player;
		
		// first move for player 1 (played by computer) : in the middle of the grid
		c.addDisk(firstMovePlayer1(), 1);
		int nbTurn = 1;
		
		while (nbTurn < 42){ // maximum of turns allowed by the size of the grid
			player = nbTurn %2 + 1;
			if (player == 2){
				columnPlayed = getNextMove(keyboard, c, 2);
			}
			if (player == 1){
				columnPlayed = movePlayer1(columnPlayed, c);
			}
			System.out.println(columnPlayed);
			c.addDisk(columnPlayed, player);
			if (c.isWinning(columnPlayed, player)){
				c.print(); 
				System.out.println("Congrats to player " + player + " !");
				return(player);
			}
			nbTurn++;
		}
		return -1;
	}
	
	public static int getNextMove(BufferedReader keyboard, Configuration c, int player){
		// ADD YOUR CODE HERE
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		c.print();
		int returncol=0;
		System.out.println("player "+(player)+(" ") + "Please enter the column the column number in which you want to add a disk");
	
try {
			
			String inputString = input.readLine();
			int colnum = Integer.parseInt ( inputString );
			Integer Intcol =colnum;
			Integer sev=7;
			
			
			//if((c.available[colnum]==6)||(colnum>6)) {
				while((c.available[colnum]==6)) {
				//System.out.println("goes through while");
					if(((c.available[colnum]==6))&&(colnum<=6)) {
					System.out.println("Please enter a column number that is not full");
				BufferedReader input1 = new BufferedReader (new InputStreamReader (System.in));
					String y = input1.readLine();
					colnum = Integer.parseInt ( y );
					Intcol=colnum;
					
					}
					//else if(colnum>=7) {
					//	System.out.print("greater");
					//	break;
					//}
				}
					
					while(Intcol>=sev) {
						
						System.out.println("please enter a valid column number");
					BufferedReader	input2 = new BufferedReader (new InputStreamReader (System.in));
						String x = input2.readLine();
						colnum = Integer.parseInt ( x );
						Intcol=colnum;
						}
					
				
				 
				//return colnum;
				
			
			 if(colnum<=6) {
				System.out.println("Nice!");
			}
			returncol=colnum;
			return colnum;
			
			
		} 
catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return returncol; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public static int firstMovePlayer1 (){
		return 3;
	}
	
	public static int movePlayer1 (int columnPlayed2, Configuration c){
		// ADD YOUR CODE HERE
		int colret;
		if((c.canWinNextRound(1))!=(-1)){//can win
			//c.addDisk(c.canWinNextRound(1),1);
			colret=c.canWinNextRound(1);
			return c.canWinNextRound(1);
		}
		else if((c.canWinTwoTurns(1))!=(-1)){  
			//c.addDisk((c.canWinTwoTurns(1)),1);
			colret=c.canWinTwoTurns(1);
			return c.canWinTwoTurns(1);
		}
		else {
			if(c.available[columnPlayed2]!=6) {///error
		//	c.addDisk(columnPlayed2, 1);
			colret=columnPlayed2;
			return columnPlayed2;
			}
			else {
				for(int i=0;i<=6;i++) {
					if((c.available[columnPlayed2-i]!=6)&&((columnPlayed2-i)>=0)) {
						//c.addDisk(columnPlayed2-i, 1);	
						colret=columnPlayed2-i;
						return columnPlayed2-i;
					}
					else if((c.available[columnPlayed2+i]!=6)&&((columnPlayed2+i)<=6)) {
						//c.addDisk(columnPlayed2+i, 1);	
						colret=columnPlayed2+i;
						return columnPlayed2+i;
						}
					else {
						continue;
						//colret=colret;
					}
				}
			}
			//return colret;
		}
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
