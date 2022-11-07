// Den - Handles map and objects

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Den
{
	// Data
	
	private char[][] cells;
	private Player player;
	private Lion[] lions;
	private final char ROWS = 10;
	private final char COLS = 10;
	private final int NUM_LIONS = 5;
	
	// Constructor
	
	public Den()
	{
		cells = new char[ROWS][COLS];
		lions = new Lion[NUM_LIONS];
		readFile();
	}

	// Accessors

	public boolean inBounds(int row, int col)
	{
    if  (row == 0 || row == 9 || col == 0 || col == 9)  {
      return false;
    }
    else {
      return true;
    }
	}

	public boolean canMoveToCell(int row, int col)
	{
    if (inBounds(row,col)==true){
      if(cells[row][col]=='#'){
        return false;
      }
      return true;
    }
    else{
      return false;
    }
	}

	public boolean hasExit(int row, int col)
	{
    if(cells[row][col]=='E'){
		  return true;
    }
    else {
      return false;
    }
	}

	public boolean hasPlayer(int row, int col)
	{
	  if(player.getRow() == row && player.getCol() == col){
		  return true;
    }
    else {
      return false;
    }
	}

	public boolean hasLion(int row, int col)
	{
    for (int k = 0 ; k <= lions.length -1; k++) {
      if (lions[k].getRow() == row && lions[k].getCol() == col) return true;
    }
      return false;
	}

	// Mutators

	public void update()
	{
		// Add code here... eventually
		// Player moves	
    player.move();
	// All lions move
    for (int k = 0 ; k <= lions.length -1; k++) {
      lions[k].move();
    }

	}

	public void display()
	{
		for(int i = 0; i < ROWS; i++)  
   	{
      for(int j = 0; j < COLS; j++) 
      {
        // If there is a player, print P in BLUE
        if (player.getRow() == i && player.getCol() == j) {
            System.out.print("\u001B[96m");
            System.out.print("P ");
        }
        // Else If there is a lion, print & in YELLOW
        else if (CheckifLionExists(i,j)) {
            System.out.print("\u001B[93m");
            System.out.print("& ");
        }           
        // Else print the value of the cell
        else{
          System.out.print("\u001B[0m"); 
          System.out.print(cells[i][j]);
          System.out.print(" ");
        }
      }
      System.out.println();
   	}
	}

 private boolean CheckifLionExists(int row, int col)  {
    for (int k = 0 ; k <= lions.length -1; k++) {
              if (lions[k].getRow() == row && lions[k].getCol() == col) return true;
    }
    return false;
 }
	// This method is complete.  You don't need to edit it, but must *understand* it.
	public void readFile()
	{
		try
		{
			File mapFile = new File("map.txt");
			Scanner scan = new Scanner(mapFile);

			int lionCount = 0;

			// Loop through the rows
			for(int i = 0; i < ROWS; i++)   
			{
				String row = scan.nextLine();
			
				// Loop through the columns
				for(int j = 0; j < COLS; j++)      
				{
					char input = row.charAt(j);

					// If there's a P, make the player at that spot
					// The cell under the player is just blank
					if(input == 'P')
					{
						player = new Player(i, j);
						cells[i][j] = ' ';
					}

					// If there's an &, make a lion at that spot.  Iterate through them.
					// The cell under the player is just blank
					else if(input == '&')
					{
						lions[lionCount] = new Lion(i, j); 
						lionCount++;
						cells[i][j] = ' ';
					}
					// Otherwise, simply store the data in cells
					else
					{
						cells[i][j] = input;
					}
				}
			}

   		scan.close();
			 
		}
		catch(FileNotFoundException e)
		{
	    System.out.println("Cannot find file!");
		}
	}

}