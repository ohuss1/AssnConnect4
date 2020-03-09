

public class Configuration {
	
	public int[][] board;
	public int[] available;
	boolean spaceLeft;
	
	public Configuration(){
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}
	
	public void print(){
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				if (board[j][5-i] == 0){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+ board[j][5-i]+" |");
				}
			}
			System.out.println();
		}
	}
	
	public void addDisk (int index, int player){
		// ADD YOUR CODE HERE
		this.board[index][(this.available[index])]=player;
		available[index]++;
		boolean spacelft=false;
		for(int i=0;i<=6;i++) {
			if(this.available[i]<6) {
				spacelft=true;
			}
		}
		if(spacelft==false) {
			spaceLeft=false;
		}
	}
	
	public boolean isWinning (int lastColumnPlayed, int player){
		// ADD YOUR CODE HERE
		int a=lastColumnPlayed;//easier to type
		int b=player;
		
		if((horihelper(a,b))==true) {
			return true;	
			}
		
		
		if((verthelper(a,b))==true) {
			return true;	
			}
		if((diagRhelper(a,b))==true) {
			return true;	
			}
		if((diagLhelper(a,b))==true) {
			return true;	
			}
			
		return false; // DON'T FORGET TO CHANGE THE RETURN
	}
	public boolean verthelper(int lastcol,int player) {
		int currRowU=this.available[lastcol]-1;//so can go down and up within same loop and not cancelling + with -
		int currColU=lastcol;
		int currRowD=this.available[lastcol]-1;
		int currColD=lastcol;
		int found=0;
		int counter=0;
		int currRow=this.available[lastcol]-1;
		if((board[currColU][currRowU])==player) {
			found=1;
		}
else { 
	found=0;
	return false;
}
	while((((currRowU<=5)||(currRowD>=0)))&&(counter<=8)) {//counter to end while loop
		//and not to run in infinite loop
		counter++;
		if(currRowU+1<=5) {
		if(((board[currColU][currRowU+1])==player)){
			currRowU++;
			found++;
			
			if(found==4) {
				return true;
			}
		}
		}
		if(currRowD-1>=0) {
			if((board[currColD][currRowD-1])==player){
				currRowD--;
				found++;
				//counter++;
				if(found==4) {
					return true;
				}
			}
		}
		}
	if(found>=4) {
		return true;
	}
	return false;
	}
	public boolean horihelper(int lastcol,int player) {
		int currRowU=this.available[lastcol]-1;//so can go down and up within same loop and not cancelling + with -
		int currColL=lastcol;
		int currRowD=this.available[lastcol]-1;
		int currColR=lastcol;
		int currCol=lastcol;
		int found=0;
		int counter=0;
		if((board[currCol][currRowU])==player) {
			found=1;
		}
else if(found==0) {
	
	return false;
}
		while((((currColR<=6)||(currColL>=0)))&&(counter<=8)) {
			counter++;//number of while loops
			if(currColR+1<=6) {
				if(((board[currColR+1][currRowU])==player)){
					currColR++;
					found++;
					
					//System.out.println(found);
					if(found==4) {  
						return true;
					}
				}
				}
			if(currColL-1>=0) {
				if((board[currColL-1][currRowD])==player){  
					currColL--;
					found++;
					//counter++;
					//System.out.println(found);
					if(found==4) {
						return true;
					}
				}
		}
		}
		if(found>=4) {
			return true;
		}
		return false;
		
	}
	public boolean diagRhelper(int lastcol,int player){//R is this / direction updown L is \ direction updown
		int currRowL=this.available[lastcol]-1;//so can go down and up within same loop and not cancelling + with -
		int currColL=lastcol;
		int currRowR=this.available[lastcol]-1;
		int currColR=lastcol;
		//int currCol=lastcol;
		int found=0;
		int counter=0;
		if((board[currColL][currRowL])==player) {
			found=1;
		}
else if(found==0) {
	
	return false;
}
		while(((((currColR<=6)||(currColL>=0))||((currRowR<=5)||(currRowL>=0)))&&(counter<=10))) {
			counter++;
			if((currColR+1<=6)&&(currRowR+1<=5)) {
				if(((board[currColR+1][currRowR+1])==player)){
					currColR++;
					currRowR++;
					found++;
					
					if(found==4) {
						return true;
					}
				}
				}
			if((currColL-1>=0)&&(currRowL-1>=0)) {
				if(((board[currColL-1][currRowL-1])==player)){
					currColL--;
					currRowL--;
					found++;
					//counter++;
					if(found==4) {
						return true;
					}
				}
				}
		}
		if(found>=4) {
			return true;
		}
		
	return false;//remove
	}
	public boolean diagLhelper(int lastcol,int player) {
		int currRowL=this.available[lastcol]-1;//so can go down and up within same loop and not cancelling + with -
		int currColL=lastcol;
		int currRowR=this.available[lastcol]-1;
		int currColR=lastcol;
		//int currCol=lastcol;
		int found=0;
		int counter=0;
		if((board[currColR][currRowR])==player) {
			found=1;
		}
else if(found==0) {
	
	return false;
}
		while(((((currColL>=0)||(currColR<=6))||((currRowR>=0)||(currRowL<=5)))&&(counter<=10))) {
			counter++;
			if((currColL-1>=0)&&(currRowL+1<=5)) {//upleft
				if(((board[currColL-1][currRowL+1])==player)){
					currColL--;
					currRowL++;
					found++;
					
					if(found==4) {
						return true;
					}
				}
				}
			if((currColR+1<=6)&&(currRowR-1>=0)) {//dnright
				if(((board[currColR+1][currRowR-1])==player)){
					currColR++;
					currRowR--;
					found++;
					//counter++;
					if(found==4) {
						return true;
					}
				}
				}
		}
		if(found>=4) {
			return true;
		}
		
	return false;
	}
	public int[][] copyArrayhelper (){
		// ADD YOUR CODE HERE
		int x;
		int[][] temp=new int[7][6];
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=6;j++) {
				x=this.board[j][i];
				temp[j][i]=x;
			}
		}
	return temp;
	}
	
	public int[] copyAvailhelper (){
		// ADD YOUR CODE HERE
		int[]temp=new int[7];
		int x;
		
			for(int j=0;j<=6;j++) {
				x=this.available[j];
				temp[j]=x;
			}
		
	return temp;
	}
	
	
	
	
	public int canWinNextRound (int player){
		// ADD YOUR CODE HERE
		boolean win;
		
		int[][] tempBoard0 = copyArrayhelper();
		int[] tempAvail0 = copyAvailhelper();
		
		
		
		for(int i=0;i<=6;i++) {
			int[][] tempBoard = copyArrayhelper();
			int[] tempAvail = copyAvailhelper();
	
			if(available[i] != 6) {
				addDisk(i,player);
			}
			else {
				continue;
			}
			win=isWinning(i,player);
board=tempBoard;
available=tempAvail;
			
			//board = tempBoard;
			//available = tempAvail;
			if(win==true) {
				return i;
			}
		}
		return -1;
		//return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinTwoTurns (int player){
		// ADD YOUR CODE HERE
		int count=0;
		boolean def=true;
		boolean curr=false;
		int bingocount=0;
		int player2 = (player == 1)? 2: 1;//if player 1 is1 make other 2
		//int[][] tempBoard0 = copyArrayhelper();
		//int[] tempAvail0 = copyAvailhelper();
		for(int i=0;i<=6;i++) {//spot iterator
			
			int[][] tempBoard1 = copyArrayhelper();
			int[] tempAvail1 = copyAvailhelper();
			if(available[i]!= 6) {
				addDisk(i,player);
				//tempBoard1 = copyArrayhelper();
				//tempAvail1 = copyAvailhelper();
			}
			else {
				continue;//cuz we cant place our move
			}
			count =0;
			
			while(count<=6) { 
				int[][] tempBoard0 = copyArrayhelper();
				int[] tempAvail0 = copyAvailhelper();
				

				if(available[count]!= 6) {
					addDisk(count,player2);
					count++;
					if(canWinNextRound(player)!=(-1)) {
						curr=((def)&&(canWinNextRound(player)!=-1));
						
					bingocount++;
					board=tempBoard0;
					available=tempAvail0;
					}
					else {
						board=tempBoard0;  
						available=tempAvail0;
					}
				}
				else {
				count++;//to go to next while iteration
			}
			}
			
			board=tempBoard1;
			available=tempAvail1;
			if((curr==true)&&(bingocount==7)) {
				return i;
			}
			else {
				bingocount=0;
			}
		 
	}
		return -1;// DON'T FORGET TO CHANGE THE RETURN

	
}
}
