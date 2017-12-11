import java.util.Scanner;

class exp02
{
	public static void main(String args[])
	{
		int n,m;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the no. of players : ");
		n = in.nextInt();
		int p[][] = new int[n][];
		float avg[] = new float[n]; 
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print("Enter the no. of matches played by Player " + (i+1) + " : ");
			m = in.nextInt();
			p[i] = new int[m+1];
		}
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println("Enter the runs scored by player " + (i+1)+ " in");	
			int sum =0;int j = 0;
			for(; j < (p[i].length - 1); j++)
			{
				System.out.print("Match " + (j+1) + " :");
				p[i][j] = in.nextInt();
				sum+=p[i][j];
			}
			avg[i] = ((float)sum)/j;
			p[i][j] = sum;
		}
		for(int i = 0;i<n;i++)
		{
			System.out.println("Runs scored by player " + (i+1) + " :");
			int j = 0;
			for(;j < (p[i].length -1) ; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.print("\nSum = " + (p[i][j]) + " Average = " + avg[i] +"\n");
		}
		System.out.println("Thank You,!!");
	}
}


/*
Enter the no. of players : 3
Enter the no. of matches played by Player 1 : 4
Enter the no. of matches played by Player 2 : 3
Enter the no. of matches played by Player 3 : 5
Enter the runs scored by player 1 in
Match 1 :34
Match 2 :43
Match 3 :54
Match 4 :61
Enter the runs scored by player 2 in
Match 1 :52
Match 2 :56
Match 3 :21
Enter the runs scored by player 3 in
Match 1 :158
Match 2 :0
Match 3 :10
Match 4 :1
Match 5 :5
Runs scored by player 1 :
34 43 54 61
Sum = 192 Average = 48.0
Runs scored by player 2 :
52 56 21
Sum = 129 Average = 43.0
Runs scored by player 3 :
158 0 10 1 5
Sum = 174 Average = 34.8
Thank You,!!
*/