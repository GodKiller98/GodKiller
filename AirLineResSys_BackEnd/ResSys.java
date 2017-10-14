import java.io.*;
import java.util.*;
import java.text.*;


public class ResSys 
{
	@SuppressWarnings({ "resource"})
	public static void main(String[] args) throws IOException,ParseException 
	{
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );
		File f = new File("Flight1.txt");
		if( !f.exists() )
		{
			System.out.println("No Flights Available\nTry Again Later.");
			System.exit(0);
		}
		BufferedReader FileIn = new BufferedReader( new FileReader(f) );
		Vector<Flight> FlghtDetails = new Vector<Flight>();
		Flight in = new Flight("Hi");
		String str = FileIn.readLine();
		while(str != null)
		{
			in.SOURCE = str ; 
			in.DESTINATION = FileIn.readLine();
			in.dd =  FileIn.readLine() ;
			in.DepartureTime = new Time( Float.parseFloat( FileIn.readLine() ) );
			in.ad =  FileIn.readLine() ;
			in.ArrivalTime = new Time( Float.parseFloat( FileIn.readLine() ) );
			in.eSeats = Integer.parseInt(FileIn.readLine());
			in.ePrice = Float.parseFloat(FileIn.readLine());
			in.bSeats = Integer.parseInt(FileIn.readLine());
			in.bPrice = Float.parseFloat(FileIn.readLine());
			FlghtDetails.addElement(in);
			str = FileIn.readLine();
		}
		System.out.println("Hello Passenger!!!\nEnter Your details.");
		Passenger p = new Passenger();
		String Source,Destination;
		float TicketPrice = 0;int ClassID;
		System.out.println("Enter the source : ");
		Source = input.readLine();
		System.out.println("Enter the destination : ");
		Destination = input.readLine();
		for(int i = 0;i<FlghtDetails.size();i++)
		{
			if(FlghtDetails.elementAt(i).SOURCE.equalsIgnoreCase(Source) && FlghtDetails.elementAt(i).DESTINATION.equalsIgnoreCase(Destination) )
		  	{
	  				System.out.println("Economy Seats Left : " + FlghtDetails.elementAt(i).eSeats);
	  				System.out.println("Economy Price : " + FlghtDetails.elementAt(i).ePrice);
	  				System.out.println("Business Seats Left : " + FlghtDetails.elementAt(i).bSeats);
					System.out.println("Business Price : " + FlghtDetails.elementAt(i).bPrice);
					System.out.println("Enter your choice of Class:-\n1.Economy Class.\t2.Business Class.");
					ClassID = Integer.parseInt( input.readLine() );
					if(ClassID == 1)
					{
						TicketPrice = FlghtDetails.elementAt(i).ePrice - (FlghtDetails.elementAt(i).ePrice*p.setDiscount()/100);
						FlghtDetails.elementAt(i).eSeats--;
					}
					else if(ClassID == 2)
					{
						TicketPrice = FlghtDetails.elementAt(i).bPrice - ( FlghtDetails.elementAt(i).bPrice*p.setDiscount()/100 );
						FlghtDetails.elementAt(i).bSeats--;
					}
					else
					{
						System.out.println("Wrong input.Terminating Program.......");
						return;
					}
					System.out.println("The total cost of ticket:- " + TicketPrice + "\nPress any ley to enter the payment gateway.");
					input.readLine();
					System.out.println("Payment Successfull!!!\nYour Trip Details Are:-");
					System.out.println(p);
					System.out.println("Flight Details :- \nSource --> " + FlghtDetails.elementAt(i).SOURCE);
					System.out.println("Destination : " + FlghtDetails.elementAt(i).DESTINATION);
					System.out.println("Departure Date : " + FlghtDetails.elementAt(i).dd);
					System.out.println("Arrival Date : " + FlghtDetails.elementAt(i).ad);
					System.out.println("Do you wish to book more Tickets?Enter 1 for booking more tickets");
					if(Integer.parseInt( input.readLine() ) == 1)
					{
						i = -1;
						System.out.println("Enter the source : ");
						Source = input.readLine();
						System.out.println("Enter the destination : ");
						Destination = input.readLine();
					}
					else
						return;
		 	}
			
		}
		System.out.println("No flights found for your Source and Destination");
		
	}
}
