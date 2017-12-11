import java.util.Scanner;
import java.util.Random;

class Square extends Thread
{
	int x;
	Square(int y)		//to store value into x
	{
		x = y;
	}
	public void run()
	{
		if(x%2 == 0)
		{
				System.out.println("Inside Square.\nBefore operation : " + x);
				x*=x;
				System.out.println("After squaring : " + x);
				System.out.println("Ending square function........");
		}
	}
}

class Cube extends Thread
{
	int x;
	Cube(int y)		//to store value into x
	{
		x = y;
	}
	public void run()
	{
		if(x%2 != 0)
		{
				System.out.println("Inside cube.\nBefore operation : " + x);
				x*=x*x;
				System.out.println("After cubing : " + x);
				System.out.println("Ending cube function........");
		}
	}
}

class exp07 extends Thread
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		Square s;Cube c;	//reference variable of following class
		int total,x;
		Random r;	//to genreate random integers
		System.out.print("Enter total no. of integers : ");
		total = in.nextInt();
		r = new Random(total);
		try{
		for(int i = 0;i<total;i++)
		{
			x = r.nextInt(total);
			s = new Square(x);c = new Cube(x);	//converting reference variable to objects
			s.start();
			Thread.sleep(200);		//to stop main and other thread while square is running
			c.start();
			Thread.sleep(200);		//to stop main and other thread while cube is running
		} }	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

/*OUTPUT:
Enter total no. of integers : 15
Inside Square.
Before operation : 6
After squaring : 36
Ending square function........
Inside Square.
Before operation : 2
After squaring : 4
Ending square function........
Inside cube.
Before operation : 13
After cubing : 2197
Ending cube function........
Inside Square.
Before operation : 12
After squaring : 144
Ending square function........
Inside Square.
Before operation : 10
After squaring : 100
Ending square function........
Inside cube.
Before operation : 5
After cubing : 125
Ending cube function........
Inside Square.
Before operation : 14
After squaring : 196
Ending square function........
Inside Square.
Before operation : 10
After squaring : 100
Ending square function........
Inside Square.
Before operation : 14
After squaring : 196
Ending square function........
Inside Square.
Before operation : 10
After squaring : 100
Ending square function........
Inside cube.
Before operation : 7
After cubing : 343
Ending cube function........
Inside cube.
Before operation : 7
After cubing : 343
Ending cube function........
Inside cube.
Before operation : 5
After cubing : 125
Ending cube function........
Inside cube.
Before operation : 11
After cubing : 1331
Ending cube function........
Inside cube.
Before operation : 3
After cubing : 27
Ending cube function........
*/