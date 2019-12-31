/********************************************
*	AUTHOR:	Hunter Stennett
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	M W 1:30 - 3:20
*	PROJECT(PART):	Project 13
*	LAST MODIFIED	12/1/19
********************************************/

/* UML CLASS DIAGRAM:
-----------------------------------------
OpenTrivia
-----------------------------------------
- answer : String
- <instanceVariable2> : datatype
- etc.
-----------------------------------------
+ OpenTrivia() : 
+ OpenTrivia(question : String, pointValue : int, answer : String) :
+ OpenTrivia(other : OpenTrivia) :
+ setAnswer(answer : String) : boolean
+ setAll(answer : String) : boolean
+ getAnswer() : String
+ toString() : String
+ equals(other : Object) : boolean
+ isValidAnswer(answer : String) : boolean
+ <methodName1(parameter1 : datatype, parameter2 : datatype, etc.) : returnType>
+ etc.
-----------------------------------------
*/

public class OpenTrivia extends Trivia
{
	/***** CONSTANTS SECTION *****/
	public static final String DEFAULT_ANSWER = "Defualt Answer";

	/***** STATIC VARIABLES *****/

	/***** INSTANCE VARIABLES *****/
	private String answer;

	/***** REQUIRED METHODS *****/
	// DESCRIPTION: No argument constructor for OpenTrivia
	// PRE-CONDITION: N/A
	// POST-CONDITION: Initializes object with defualt values
	public OpenTrivia()
	{
		super();
		this.answer = DEFAULT_ANSWER;
	}
	
	// DESCRIPTION: Full argument constructor for OpenTrivia
	// PRE-CONDITION: N/A
	// POST-CONDITION: Initializes object with given values
	public OpenTrivia(String question, int pointValue, String answer)
	{
		super(question, pointValue);
		this.answer = answer;
	}
	
	// DESCRIPTION: Copy constructor for OpenTrivia
	// PRE-CONDITION: Valid OpenTrivia object
	// POST-CONDITION: Initializes a deep copy of given OpenTrivia object
	public OpenTrivia(OpenTrivia other)
	{
		if(other == null)
		{
			System.out.println("Error: Copying null OpenTrivia object!");
			System.exit(0);
		}
		else
		{
			super.setAll(other.getQuestion(), other.getPointValue());
			this.setAll(other.answer);
		}
	}
	
	// DESCRIPTION: Mutator for answer instance variable
	// PRE-CONDITION: Valid value for answer
	// POST-CONDITION: Changes value of answer and returns a boolean of validity
	public boolean setAnswer(String answer)
	{
		boolean isValid;
		
		isValid = isValidAnswer(answer);
		
		if(isValid)
		{
			this.answer = answer;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Overriding setAll from the Trivia class
	// PRE-CONDITION: Valid argument values
	// POST-CONDITION: Sets answer instance variable and returns a boolean of validity
	public boolean setAll(String answer)
	{
		boolean isValid;
		
		isValid = isValidAnswer(answer);
		
		if(isValid)
		{
			this.answer = answer;
		}
		
		return isValid;
	}
	
	// DESCRIPTION: Accessor method for the answer instance variable
	// PRE-CONDITION: Valid OpenTrivia object values
	// POST-CONDITION: Returns a String with answer value
	public String getAnswer()
	{
		return this.answer;
	}
	
	// DESCRIPTION: Overrides toString from Trivia class
	// PRE-CONDITION: Valid OpenTrivia calling object
	// POST-CONDITION: Returns values of instance variables
	public String toString()
	{
		return super.toString() + ", " + this.answer;
	}
	
	// DESCRIPTION: Checks OpenTrivia object for equality with another OpenTrivia object
	// PRE-CONDITION: Valid OpenTrivia calling object and argument object
	// POST-CONDITION: Returns a boolean value depending on equality of objects
	public boolean equals(Object other)
	{
		OpenTrivia otherOpen;
		
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof OpenTrivia))
		{
			return false;
		}
		else
		{
			otherOpen = (OpenTrivia) other;
			
			return super.equals(otherOpen) &&
				this.answer.equals(otherOpen.answer);
		}
	}
	
	// DESCRIPTION: Prints out question and point value of OpenTrivia object
	// PRE-CONDITION: Valid calling object values
	// POST-CONDITION: Prints out instance variable values of calling object
	public void askQuestion()
	{
		System.out.println(this.getQuestion());
		System.out.println("Points: " + this.getPointValue() + "\n");
	}
	/***** HELPER METHODS *****/
	// DESCRIPTION: Validity checking static method for OpenTrivia
	// PRE-CONDITION: Valid value for instance variable answer
	// POST-CONDITION: Returns a boolean value depending on answer longer than 0
	public static boolean isValidAnswer(String answer)
	{
		boolean isValid;
		
		isValid = answer.length() > 0;
		
		return isValid;
	}
}
