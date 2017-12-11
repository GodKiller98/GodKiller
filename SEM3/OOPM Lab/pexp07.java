/*Create a class thread demo which stores thread name and an array of String and ceate a constructor which will get name of thread and size of array. Create array with given size and read the name of thread.Display thread name and all the string one by one.
write a program to create to 2 child threads of class
1 displays month
2 displays day
main thread should show active when it time slice.*/
import java.util.*;
class ThreadDemo extends Thread
{
	String threadName;
	int n;
	String a[];
	ThreadDemo()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the name of thread : ");
		threadName = in.next();
		System.out.print("Enter the no. of " + threadName + " : ");
		this.n = in.nextInt();			//to refer to n of calling object 
		a = new String[this.n];
		for(int i = 0;i<this.n;i++)
		{
			System.out.print("Enter " + threadName + " no. " + (i+1) + " : ");
			a[i] = in.next();
		}
	}
	public void run()
	{
		System.out.println(threadName + " starts. ");
		try
		{
			for(int i = 0;i<this.n;i++)
			{
				System.out.println("Inside " + threadName);
				System.out.println(threadName + " no. " + (i+1) + " : " + a[i] );
				Thread.sleep(100);
			}
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
}

public class pexp07
{
	public static void main(String args[])
	{
		ThreadDemo x = new ThreadDemo();
		ThreadDemo y = new ThreadDemo();
		x.start();
		y.start();
		try
		{
			System.out.println("\nmain() is active");
			Thread.sleep(200);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("\nEnd of main()");
	}
}