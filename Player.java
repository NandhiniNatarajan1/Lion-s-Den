// Class Player - defines a player's behavior

import java.util.Scanner;

public class Player
{
	// Data

	private int row;
	private int col;
	private Scanner scan;
  private int moveRow;
  private int moveCol;
	// Constructor

	public Player(int r, int c)
	{
		row = r;
		col = c;
		scan = new Scanner(System.in);
	}

	// Accessors

	public int getRow()
	{
		return row;		
	}

	public int getCol()
	{
		return col;		
	}

	// Mutators
		
	public void move()
	{
		// Get User Input
		String s = "";
    do {
      System.out.print("Choose a direction (n, s, e, w): ");
		  s = scan.next();
    } while(!(s.equals("n")) &&  !(s.equals("e")) && !(s.equals("s")) &&  !(s.equals("w")));
    
    if (s.equals("n")) {
      moveRow = row - 1;
      moveCol = col;
    }
    else if (s.equals("s")) {
      moveRow = row + 1;
      moveCol = col;
    }
    else if (s.equals("e")){
      moveRow = row;
      moveCol = col+1;
    }
    else if (s.equals("w")) {
      moveRow = row;
      moveCol = col-1;
    }
	// Move the player's position
   if(Main.den.hasExit(moveRow, moveCol)) {
     row = moveRow;
      col = moveCol;
      Main.win = true;
   }
    else if(Main.den.hasLion(moveRow,moveCol)) {
       Main.lose = true;
    }
    else if (Main.den.canMoveToCell(moveRow,moveCol)) {
      row = moveRow;
      col = moveCol;
    }
    else {
      
    }
   
		// If you're on an exit, you win
		// If you're on a lion, you lose

			// Hint:  To access global variables, use "Main.""
			// Ex: Main.den.hasLion(row, col)
	
	}
}



