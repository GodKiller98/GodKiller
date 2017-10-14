import java.text.*;
import java.util.*;
import java.io.*;

public class Airline extends Flight 
{
	Airline() throws IOException, ParseException 
	{
		super();
		//commenting this function causes
		/*Default constructor cannot handle exception type ParseException thrown by implicit super constructor. Must define an explicit constructor*/
	}
	static int TotalFlights;
	static Vector<Flight> flghts = new Vector<Flight>(TotalFlights);
	public static void main(String args[]) throws IOException, ParseException
	{
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );
		
		System.out.print("Enter the total no. of flights :- ");
		TotalFlights = Integer.parseInt( input.readLine() );
		for(int i = 0 ; i < TotalFlights ; i++)
		{
			System.out.println("Enter Details for Flight No. " + (i+1) );
			flghts.addElement( new Flight() );
		}
		System.setOut( new PrintStream(new File("Flight1.txt")) );
		for(int i = 0 ;i<flghts.size();i++)
		{
			System.out.println( flghts.elementAt(i) );
		}
		//System.out.println("Data Stored Succesfully!!!");
	}
}