import java.util.Scanner;

class excp extends Exception
{
	public String toString()			//commenting this function returns the class name to catch block
	{
		return "java.lang.MarksOutOfRange ";
	}
}

class StdntData
{
	int marks;
	String name;
	StdntData(String b, int a)
	{
		name = b;
		try
		{
			marks = a;
			if(marks<0 || marks>100)
				throw new excp();	//Throws default constructor to catch block	//no parameters allowed
			display();
		}
		catch(excp m)	//catch(Exception m) ---> prints class name whenever m is called
		{
			System.out.println("Error occured: " + m + "Marks entered : " + marks);	
		}
	}
	void display()
	{
		System.out.println("Marks entered succesfully!!.");
	}
}

class exp05
{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		StdntData stdnt = new StdntData(scn.next(),scn.nextInt() );	//calling parameterized constructor
	}
}

/*
OUTPUT 1:
Dhruvil
500
Error occured! java.lang.MarksOutOfRange Marks entered : 500

OUTPUT 2:
Dhruvil
99
Marks entered succesfully!!
*/