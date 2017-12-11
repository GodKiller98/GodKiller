import java.util.Scanner;

class GCD
{
	int temp = 1;
	/* static */ int gcd(int a, int b)
	{
	/*int temp = 1*/	//if using static mode.
	temp = a%b;
	if(temp == 0)
		return b;
	else
		return gcd(b,temp);
	}
}

class exp01
{
	public static void main(String args[])
	{
		int num,deno;int MAX,MIN;
		GCD obj = new GCD();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number : ");
		num = sc.nextInt();
		System.out.print("Enter the second number : ");
		deno  = sc.nextInt();
		if(num > deno)
		{MAX = num;MIN = deno;}
		else
		{MAX = deno;MIN = num;}											//GCD.gcd(MAX,MIN); for static access from Gcd class.
		System.out.println("The GCD of given nos : " + obj.gcd(MAX,MIN)); //gcd(MAX,MIN); for ststic int gcd.
		int LCM = (MAX*MIN)/obj.gcd(MAX,MIN);								//exp01 obj1;obj1.gcd(MAX,MIN); for non-static access from same class.
		System.out.println("The LCM of given nos : " + LCM);
	}
	public String toString()
	{
		System.out.println("In To String");
		return "exit\n";
	}
//	/* static */ int gcd(int a, int b)
//	{
//	/*int temp = 1*/	//if using static mode.
//	temp = a%b;
//	if(temp == 0)
//		return b;
//	else
//		return gcd(b,temp);
//	}

//	int gcd(int a, int b)
//	{
//	/*int temp = 1*/	//if using static mode.
//	temp = a%b;
//	if(temp == 0)
//		return b;
//	else
//		return gcd(b,temp);
//	}
}