import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Passenger
{
	String Name,Address;
	int type;
	Passenger() throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in) );
		System.out.println("Enter your name:");
		Name=input.readLine();
		
		System.out.println("Enter your Address:");
		Address=input.readLine();
		
		System.out.println("Enter your type:");
		System.out.println("1.Student \n2.Adult \n3.Army personnel \n4.Senior citizen");
		type =  Integer.parseInt(input.readLine()) ;
		System.out.println("According To Your Type total percent of discount on price of tickets is " + setDiscount() + "%.");
	}
	
	int setDiscount()
	{
		switch(type)
		{
			case 1:
					return 15;
			case 3:
					return 50;
			case 4:
					return 75;
			default:
					return 0;
					
		}
	}
	public String toString()
	{
		return ("Name: "+ Name + "\n" + "Address : " + Address + "\n" + "Type : " + type);
	}
}