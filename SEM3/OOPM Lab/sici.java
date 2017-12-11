import java.util.*;
class twod
{
	public static void main(String args[])
	{
		int avg,n,m,i,j,p[][];
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of player");
		m=in.nextInt();
		p=new int[m][];
		for(i=0;i<m;i++)
		{
			int sum=0;
			System.out.println("Enter the number of matches played by the player "+(i+1);
			n=in.nextInt();
			p[i]=new int[n];
			System.out.println("Enter the run scored:");
			for(j=0;j<n;j++)
			{
				
				p[i][j]=in.nextInt();
				sum=sum+p[i][j];
				avg=sum/n;
			}
			System.out.println("player no"+(i+1)+"runs"+p[i]j[j]+"sum of runs"+sum+"average is :"+avg);
		}
		
	}
}