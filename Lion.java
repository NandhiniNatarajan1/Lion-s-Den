// Class Lion - Define's a lion's behavior
import java.util.Random;
public class Lion
{
		// Data
		
		private int row;
		private int col;
    private int moveRow;
    private int moveCol;
    private final int NORTH=0;
    private final int SOUTH=1;
    private final int EAST=2;
    private final int WEST=3;
		// Constructor

		public Lion(int r, int c)
		{
			row = r;
			col = c;
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
		public int getMove()
    {
      Random rand = new Random(); //instance of random class
      int upperbound = 3;
        //generate random values from 0-3
      int int_random = rand.nextInt(upperbound); 
      return int_random;
    }

		public void move()
		{
			// Move
      int move =  getMove();
			
    if (move == NORTH) {
      moveRow = row - 1;
      moveCol = col;
    }
    else if (move == SOUTH) {
      moveRow = row + 1;
      moveCol = col;   
    }
    else if (move == EAST){
      moveRow = row;
      moveCol = col+1;
    }
    else if (move == WEST) {
      moveRow = row;
      moveCol = col-1;
    }
      
				// Lion's can't walk through walls or each other
				// If a lion enters a player space, it's game over
    
   if(Main.den.hasPlayer(moveRow,moveCol)) {
       Main.lose = true;
    }
    else if(Main.den.hasLion(moveRow,moveCol)) {
      //do nothing 
    }
    else if (Main.den.canMoveToCell(moveRow,moveCol)) {
      row = moveRow;
      col = moveCol;
    }
    else {
      
    } 

		}
}