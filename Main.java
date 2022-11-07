// Main - Controls main event loop
// DO NOT MODIFY

public class Main 
{
	// ANSI Color Codes
	public static final String WHITE = "\u001B[0m"; 
  public static final String BLUE = "\u001B[96m";
 	public static final String YELLOW = "\u001B[93m";
  public static final String GREEN = "\u001B[32m";
 	public static final String RED = "\u001B[31m";

	// Global Variables	 
	public static boolean win = false;
	public static boolean lose = false;
	public static	Den den;

	public static void main(String[] args)
	{
		den = new Den();
		
		// Keep game loop going until win or loss
		while(!win && !lose)
		{
			// Display and update the game
			clearConsole();
			den.display();
			den.update();

		}
		
		// Win or loss message
		if(win)
		{
			System.out.println(GREEN + " \n*** YOU WIN *** \n");
		}
		else
		{
			System.out.println(RED + " \n*** YOU LOSE *** \n");
		}
	}
  
	// This method wipes the console clean each time
	public static void clearConsole()
	{
			System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}
}