/********************************************
*	AUTHOR:	Hunter Stennett
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	M W 1:30-3:20
*	PROJECT(PART):	Project 13
*	LAST MODIFIED:	11/28/19
********************************************/

/* UML CLASS DIAGRAM:
-----------------------------------------
Trivia
-----------------------------------------
- question : String
- pointValue : int
-----------------------------------------
+ Trivia() : 
+ Trivia(question : String, pointValue : int) :
+ Trivia(original : Trivia) :
+ setQuestion(question : String) : boolean
+ setPointValue(pointValue : int) : boolean
+ setAll(question : String, pointValue : int) boolean
+ getQuestion() : String
+ getPointValue() : int
+ isValidQuestion(question : String) : boolean
+ isValidPointValue(pointValue : int) : boolean
+ <methodName1(parameter1 : datatype, parameter2 : datatype, etc.) : returnType>
+ etc.
-----------------------------------------
*/

public class Trivia
{
	/***** CONSTANTS SECTION *****/
	public static final String DEFAULT_QUESTION = "Defualt Question";
	public static final int DEFAULT_POINT_VALUE = 100;

	/***** STATIC VARIABLES *****/

	/***** INSTANCE VARIABLES *****/
	private String question;
	private int pointValue;

	/***** REQUIRED METHODS *****/
	// DESCRIPTION: No argument constructor for defualt initialization
	// PRE-CONDITION: N/A
	// POST-CONDITION: Instance variables set to defualt values
	public Trivia()
	{
		this.setAll(DEFAULT_QUESTION, DEFAULT_POINT_VALUE);
	}
	
	// DESCRIPTION: Full constructor for setting all values at initialization
	// PRE-CONDITION: N/A
	// POST-CONDITION: Instance variables set to given values
	public Trivia(String question, int pointValue)
	{
		this.setAll(question, pointValue);
	}
	
	// DESCRIPTION: Copy constructor for deep copy of Trivia objects
	// PRE-CONDITION: Valid Trivia object
	// POST-CONDITION: Deep copy of Trivia object
	public Trivia(Trivia original)
	{
		if (original != null)
		{
			this.setAll(original.getQuestion(), original.getPointValue());
		}
		else
		{
			System.out.println("Error: Null object");
		}
	}
	
	// DESCRIPTION: Mutator for the question instance variable
	// PRE-CONDITION: Argument valid String
	// POST-CONDITION: Changes question instance variable to given value
	public boolean setQuestion(String question)
	{
		boolean isValid;
		
		isValid = isValidQuestion(question);
		
		if(isValid)
		{
			this.question = question;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Mutator for the pointValue instance variable
	// PRE-CONDITION: Argument has valid value
	// POST-CONDITION: Changes pointValue to given value
	public boolean setPointValue(int pointValue)
	{
		boolean isValid;
		
		isValid = isValidPointValue(pointValue);
		
		if(isValid)
		{
			this.pointValue = pointValue;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Mutator that sets all Trivia instance variables
	// PRE-CONDITION: Valid argument values input
	// POST-CONDITION: Changes instance variables question and pointValue
	public boolean setAll(String question, int pointValue)
	{
		boolean isValid;
		
		isValid = (isValidQuestion(question) && isValidPointValue(pointValue));
		
		if(isValid)
		{
			this.question = question;
			this.pointValue = pointValue;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Accessor for question instance variable
	// PRE-CONDITION: Valid values for question instance variable
	// POST-CONDITION: Returns value of question
	public String getQuestion()
	{
		return this.question;
	}
	
	// DESCRIPTION: Accessor for pointValue instance variable
	// PRE-CONDITION: Valid value for pointValue instance variable
	// POST-CONDITION: Returns value of pointValue
	public int getPointValue()
	{
		return this.pointValue;
	}
	
	// DESCRIPTION: toString method for Trivia class returns instance variable values
	// PRE-CONDITION: Valid values and Trivia object
	// POST-CONDITION: Returned values of question and pointValue
	public String toString()
	{
		return "Question: " + this.question + ", Points: " + this.pointValue;
	}
	
	// DESCRIPTION: equals method for Trivia class tests equality with another object
	// PRE-CONDITION: Valid calling object and argument object of the Trivia class
	// POST-CONDITION: Returns a boolean true/false testing equality of Trivia objects
	public boolean equals(Object other)
	{
		Trivia otherTrivia;
		
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof Trivia))
		{
			return false;
		}
		else
		{
			otherTrivia = (Trivia) other;
			return this.question.equals(otherTrivia.question)
				&& this.pointValue == otherTrivia.pointValue;
		}
	}
	
	// DESCRIPTION: Prints out the question instance variable and its point value
	// PRE-CONDITION: Valid Trivia object with valid instance variable values
	// POST-CONDITION: question and pointValue printed to console
	public void askQuestion()
	{
		System.out.println(this.question);
		System.out.println("\n" + this.pointValue + " points");
	}
  
	/***** HELPER METHODS *****/
	// DESCRIPTION: Validity checking static method for question instance variable
	// PRE-CONDITION: Instance variable question has a String value longer that 0
	// POST-CONDITION: Returns boolean if question is longer than 0
	public static boolean isValidQuestion(String question)
	{
		boolean isValid;
		
		isValid = question.length() > 0;
		
		return isValid;
	}
	
	// DESCRIPTION: Validity checking static method for pointValue
	// PRE-CONDITION: Instance variable pointValue is larger than 0
	// POST-CONDITION: Returns boolean if pointValue is larger than 0
	public static boolean isValidPointValue(int pointValue)
	{
		boolean isValid;
		
		isValid = pointValue >= 0;
		
		return isValid;
	}
}
 
