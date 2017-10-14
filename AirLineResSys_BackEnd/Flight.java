import java.util.*;
import java.io.*;
import java.text.*;


class Time
{
	float time;
	Time(float x)
	{
		time = x;
	}
}


public class Flight
{
	String SOURCE,DESTINATION,dd,ad;
	Date DepartureDate = new Date();
	Date ArrivalDate = new Date();
	Time ArrivalTime,DepartureTime;
	int eSeats,bSeats;
	float ePrice ,bPrice;		//e=Economy class  ,  b=Business class
	
	Flight() throws IOException, ParseException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in) );
		System.out.println("Enter The Source of the flight: ");
		SOURCE = input.readLine();
		System.out.println("Enter The Destination of the flight: ");
		DESTINATION = input.readLine();
		
		
		//Departure Details
		System.out.println("Enter The Departure Details of the flight: ");
		int year,month,date;
		System.out.println("Enter The Year : ");
		year = Integer.parseInt( input.readLine() );
		System.out.println("Enter The Month : ");
		month = Integer.parseInt( input.readLine() );
		System.out.println("Enter The Date : ");
		date = Integer.parseInt( input.readLine() );
		
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		DepartureDate = ft.parse(Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year));
		
		System.out.println("Enter the Time in 24 hrs format: ");
		int hours,minutes;
		System.out.println("Enter the Hours: ");
		hours = Integer.parseInt(input.readLine() );
		System.out.println("Enter the Minutes: ");
		minutes = Integer.parseInt(input.readLine() );
		DepartureTime = new Time(Float.parseFloat(Integer.toString(hours)) + Float.parseFloat(Integer.toString(minutes))/100 );
		
		DepartureDate.setTime(DepartureDate.getTime() + hours*3600000 + minutes*60000);	//as milliseconds is requirement
		
		dd = DepartureDate.toString();
		
		//Arrival Details
		System.out.println("Enter The Arrival Details of the flight: ");
		System.out.println("Enter The Year : ");
		year = Integer.parseInt( input.readLine() );
		System.out.println("Enter The Month : ");
		month = Integer.parseInt( input.readLine() );
		System.out.println("Enter The Date : ");
		date = Integer.parseInt( input.readLine() );
		
		ArrivalDate = ft.parse(Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year));
		
		System.out.println("Enter the Time in 24 hrs format: ");
		//int hours,minutes;
		System.out.println("Enter the Hours: ");
		hours = Integer.parseInt(input.readLine() );
		System.out.println("Enter the Minutes: ");
		minutes = Integer.parseInt(input.readLine() );
		ArrivalTime = new Time(Float.parseFloat(Integer.toString(hours)) + Float.parseFloat(Integer.toString(minutes))/100 );
		
		ArrivalDate.setTime(ArrivalDate.getTime() + hours*3600000 + minutes*60000);		//as milliseconds is requirement
		
		ad = ArrivalDate.toString();
		
		//Economy class
		
		System.out.println("Enter the total number of seats in economy class:");
		eSeats=Integer.parseInt(input.readLine());
		System.out.println("Enter the price of economy seats:");
		ePrice=Float.parseFloat(input.readLine());
		
		//Business Class
		
		System.out.println("Enter the total number of seats in business class:");
		bSeats=Integer.parseInt(input.readLine());
		System.out.println("Enter the price of business seats:");
		bPrice=Float.parseFloat(input.readLine());
		
	}
	
	public String toString()
	{
		return (SOURCE + "\n" + DESTINATION + "\n" + dd + "\n" + DepartureTime.time + "\n" + ad + "\n" + ArrivalTime.time + "\n" + eSeats + "\n" + ePrice + "\n" + bSeats + "\n" + bPrice);
	}
	
	Flight(String s)
	{
		return;
	}
}
