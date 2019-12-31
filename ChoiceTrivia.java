/********************************************
*	AUTHOR:	Hunter Stennett
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	M W 1:30 - 3:20
*	PROJECT(PART):	Project 13
*	LAST MODIFIED:	12/2/19
********************************************/

/* UML CLASS DIAGRAM:
-----------------------------------------
ChoiceTrivia
-----------------------------------------
- <instanceVariable1> : datatype
- <instanceVariable2> : datatype
- etc.
-----------------------------------------
+ <methodName1(parameter1 : datatype, parameter2 : datatype, etc.) : returnType>
+ <methodName1(parameter1 : datatype, parameter2 : datatype, etc.) : returnType>
+ etc.
-----------------------------------------
*/

import java.util.Scanner;

public class ChoiceTrivia extends Trivia
{
	/***** CONSTANTS SECTION *****/
	public static final char DEFUALT_ANSWER = 'D';
	public static final String[] DEFUALT_CHOICES = {"Default A", "Default B", "Default C"};
	/***** STATIC VARIABLES *****/
	
	/***** INSTANCE VARIABLES *****/
	private char answer;
	private String[] choices;
	
	/***** REQUIRED METHODS *****/
	// DESCRIPTION: No argument constructor for ChoiceTrivia
	// PRE-CONDITION: N/A
	// POST-CONDITION: Initializes instance variables to defualt values
	public ChoiceTrivia()
	{
		super();
		this.answer = DEFUALT_ANSWER;
		this.choices = DEFUALT_CHOICES;
	}
	
	// DESCRIPTION: Full constructor
	// PRE-CONDITION: N/A
	// POST-CONDITION: Initializes instance variables to given arguments
	public ChoiceTrivia(String question, int pointValue,
		char answer, String[] choices)
	{
		super(question, pointValue);
		this.answer = answer;
		this.choices = choices;
	}
	
	// DESCRIPTION: Copy Constructor for ChoiceTrivia
	// PRE-CONDITION: Objects aren't null
	// POST-CONDITION: Initializes a deep copy of argument object values
	public ChoiceTrivia(ChoiceTrivia other)
	{
		if(other == null)
		{
			System.out.println("Error: Null Object");
			System.exit(0);
		}
		else
		{
			super.setAll(other.getQuestion(), other.getPointValue());
			this.setAll(other.answer, other.choices);
		}
	}
	
	// DESCRIPTION: Mutator method for answer instance variable
	// PRE-CONDITION: Valid value for answer
	// POST-CONDITION: Sets answer to argument value and returns a boolean of validity
	public boolean setAnswer(char answer)
	{
		boolean isValid;
		
		isValid = isValidAnswer(answer);
		
		if(isValid)
		{
			this.answer = answer;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Mutator method for choices array 
	// PRE-CONDITION: Array choices needs to be of length 3
	// POST-CONDITION: Array values are set to argument values 
	public boolean setChoices(String[] choices)
	{
		boolean isValid;
		
		isValid = isValidChoices(choices);
		
		if(isValid)
		{
			this.choices = choices;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Sets all ChoiceTrivia instance variables
	// PRE-CONDITION: Valid values for all instance variables
	// POST-CONDITION: Sets all instance variables to argument values, returns boolean
	public boolean setAll(char answer, String[] choices)
	{
		boolean isValid;
		
		isValid = isValidAnswer(answer) && isValidChoices(choices);
		
		if(isValid)
		{
			this.answer = answer;
			this.choices = choices;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Accessor method for answer instance variable
	// PRE-CONDITION: Valid value for answer
	// POST-CONDITION: Returns value of object's answer instance variable
	public char getAnswer()
	{
		return this.answer;
	}
	
	// DESCRIPTION: Accessor method for array choices
	// PRE-CONDITION: Valid values for array choices
	// POST-CONDITION: Returns values for array indexed variables
	public String[] getChoices()
	{
		return this.choices;
	}
	
	// DESCRIPTION: Overrides toString method from Trivia class
	// PRE-CONDITION: Valid ChoiceTrivia calling object
	// POST-CONDITION: Returns values of ChoiceTrivia object instance variables
	public String toString()
	{
		return super.toString() + ", " + this.answer + ", " + this.choices;
	}
	
	// DESCRIPTION: Overrides equals method from Trivia class
	// PRE-CONDITION: Two valid ChoiceTrivia objects
	// POST-CONDITION: Returns a boolean depending on ChoiceTrivia object equality
	public boolean equals(Object other)
	{
		ChoiceTrivia otherChoice;
		
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof ChoiceTrivia))
		{
			return false;
		}
		else
		{
			otherChoice = (ChoiceTrivia) other;
			
			return super.equals(otherChoice) && this.answer == otherChoice.answer &&
					this.choices.equals(otherChoice.choices);
		}
	}
	
	// DESCRIPTION: Overrides askQuestion from Trivia class
	// PRE-CONDITION: Valid values for choices array
	// POST-CONDITION: Prints out question instance variable and choices array indexed variables
	public void askQuestion()
	{
		System.out.println(this.getQuestion() + "\n");
		
		for(int i = 0; i < this.choices.length; i++)
		{
			System.out.println(choices[i]);
		}
	}
	
	/***** HELPER METHODS *****/
	// DESCRIPTION: Checks for answer instance variable validity
	// PRE-CONDITION: answer is a char of value A, B, C, or D
	// POST-CONDITION: Returns a boolean depending on validity of answer
	public static boolean isValidAnswer(char answer)
	{
		boolean isValid;
		
		isValid = (answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D');
		
		return isValid;
	}
	
	// DESCRIPTION: Checks to see if choices has 3 indexed variables
	// PRE-CONDITION: Valid length to choices array
	// POST-CONDITION: Returns a boolean depending on length of choices array
	public static boolean isValidChoices(String[] choices)
	{
		boolean isValid;
		
		isValid = choices.length == 3;
		
		return isValid;
	}
}
