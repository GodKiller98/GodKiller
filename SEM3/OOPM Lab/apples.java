import java.util.Scanner;

class apples
{
	public static void main(String args[])
	{
		System.out.println("Hello User!!!!");
		pali obj = new pali();
	}
}

class pali
{
	pali()
	{
		int pn;
		System.out.println("Enter a number");
		Scanner input = new Scanner(System.in);
		pn = input.nextInt();
		int i = pali_check(pn);
		switch(i)
		{
			case 1:
				System.out.println("Entered number is palindrome");
				break;
			case 0:
				System.out.println("Palindrome check failed");
				break;
		}
	}
	int pali_check(int x)
	{
		int temp = 0,n = x;
		while(n!=0)
		{
			temp = (temp*10) + (n%10);
			n = n/10;
		}
		if(temp == x)
			return 1;
		else
			return 0;
	}
}