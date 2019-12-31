/********************************************
*	AUTHOR:	Hunter Stennett
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	M W 1:30-3:20
*	PROJECT(PART):	Project 13
*	LAST MODIFIED:	12/2/19
********************************************/

/********************************************
*	PlayTrivia
*********************************************
*	PROGRAM DESCRIPTION:
*	Driver class PlayTrivia uses Trivia, OpenTrivia, and ChoiceTrivia
* 	to create a trivia game
*********************************************
*	ALGORITHM:
*	INITIALIZE array of trivia objects
* 	FOR each trivia object
* 		object.askQuestion()
* 		INPUT from user
* 		IF input == object.answer
* 			score = score + pointValue
* 		PRINT user answer and object.answer
* 	PRINT final user score
*********************************************
*	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
*	Scanner for user input
*********************************************/

// <IMPORTS GO HERE>
import java.util.Scanner;

public class PlayTrivia
{

  /***** CONSTANT SECTION *****/
  public static int score;

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/
    Scanner keyboard;
    Trivia[] game;

    /***** INITIALIZATION SECTION *****/
    keyboard = new Scanner(System.in);
    game = new Trivia[6];
    //game[0] = new OpenTrivia("What is the highest score possible in bowling?", 3, "300");
    score = 0;
    String[] choices1 = {"A. Goat", "B. Cow", "C. Pig"};
	String[] choices2 = {"A. Indiana", "B. Nevada", "C. California"};
	String[] choices3 = {"A. Peas", "B. Beans", "C. Berries"};
	game[0] = new OpenTrivia("What is the highest score possible in bowling?", 3, "300");
	game[1] = new OpenTrivia("How many soccer players should be on the field at the same time?",
			3, "22");
	game[2] = new OpenTrivia("What NFL quarter back has been in the most super bowls?", 3, "Tom Brady");
	game[3] = new ChoiceTrivia("On a farm a kid is a baby what?", 5, 'A', choices1);
	game[4] = new ChoiceTrivia("Which state is called the Golden state?", 5, 'C', choices2);
	game[5] = new ChoiceTrivia("What are black-eyed peas?", 5, 'B', choices3);
   
    // PlayTrivia.fillTrivia(game);

    /***** INTRO SECTION *****/
    

    /***** INPUT SECTION *****/

    /***** PROCESSING SECTION *****/
    // For some reason late binding isn't working for getAnswer(), it's trying to find 
    // 		getAnswer() from Trivia, but getPointValue() is binding correctly and I 
    // 		can't figure out why, it's from the Trivia class, but it's using the 
    // 		constructor from their respective classes
    for(int i = 0; i < game.length; i++)
    {
		String input;
		
		if(game[i] instanceof OpenTrivia)
		{
			game[i].askQuestion();
			input = keyboard.nextLine();
			if(input.equalsIgnoreCase(game[i].getAnswer()))
			{
				System.out.println("Correct!");
				score = score + game[i].getPointValue();
			}
			else
			{
				System.out.println("Incorrect!");
			}
		}
		else if(game[i] instanceof ChoiceTrivia)
		{
			char letter;
			game[i].askQuestion();
			input = keyboard.nextLine();
			letter = input.charAt(0);
			if(letter == game[i].getAnswer())
			{
				System.out.println("Correct!");
				score = score + game[i].getPointValue();
			}
			else
			{
				System.out.println("Incorrect!");
			}
		}
	}
	
	System.out.println("\n Final score is: " + score);

    /***** OUTPUT SECTION *****/

  }
  /***** STATIC METHODS *****/
	/*public static void fillTrivia(Trivia[] a)
	{
		String[] choices1 = {"A. Goat", "B. Cow", "C. Pig"};
		String[] choices2 = {"A. Indiana", "B. Nevada", "C. California"};
		String[] choices3 = {"A. Peas", "B. Beans", "C. Berries"};
		
		a[0] = new OpenTrivia("What is the highest score possible in bowling?", 3, "300");
		a[1] = new OpenTrivia("How many soccer players should be on the field at the same time?",
			3, "22");
		a[2] = new OpenTrivia("What NFL quarter back has been in the most super bowls?", 3, "Tom Brady");
		a[3] = new ChoiceTrivia("On a farm a kid is a baby what?", 5, 'A', choices1);
		a[4] = new ChoiceTrivia("Which state is called the Golden state?", 5, 'C', choices2);
		a[5] = new ChoiceTrivia("What are black-eyed peas?", 5, 'B', choices3);
	}*/
}
 
