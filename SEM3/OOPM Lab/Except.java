import java.util.Scanner;

class Fail extends Exception
{
	Fail(Marks o)
	{
		System.out.println("PercentageLessThan35Exception\nStudentFail\n" + o);
	}
	Fail(int x)
	{
		System.out.println("SubjectFail.\nMarksLessThan35Exception : " + x);
	}
}

class Marks
{
	int avg,marks[] = new int[3];
	Marks(int m1,int m2,int m3)
	{
		marks[0] = m1;
		marks[1] = m2;
		marks[2] = m3;
		avg = (m1+m2+m3)/3;
	}
	public void cal()
	{
		try{
		if(avg < 35)
			throw new Fail( this );
		else
		{
			if(marks[0] < 35)
				throw new Fail(marks[0]);
			else if(marks[1] < 35)
				throw new Fail(marks[1]);
			else if(marks[2] < 35)
				throw new Fail(marks[2]);
			else 
				System.out.println("Pass");
		}
		}
		catch(Exception e){}
	}
}

class Except
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			new Marks( sc.nextInt(),sc.nextInt(),sc.nextInt() ).cal();
		}
		catch(Exception e){}
	}
}