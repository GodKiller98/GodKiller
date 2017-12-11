import java.util.Arrays;
import java.util.Scanner;

class probs
{
	public static void main(String args[])
	{
		String s1,s2;
		Scanner str = new Scanner(System.in);
		s1 = str.next();
		s2 = str.next();
		char frst[] = s1.toLowerCase().toCharArray();	//To covert to lower case and insert in array
		char scnd[] = s2.toLowerCase().toCharArray();	//toCharArray is found in java.util.Arrays;
		//Arrays.sort(frst);
		//Arrays.sort(scnd);
		/*if(Arrays.equals(frst,scnd))
			{System.out.println("Stirngs are anagrams!!");}
		else
			{System.out.println("Anagram check failed:-(");}*/
		sorter(frst,s1.length());	//sorting array to ignore repeating words
		sorter(scnd,s2.length());	//sorting array to ignore repeating words
		if(s1.length() == s2.length())
			anna(frst,scnd,s1.length());
		else
			System.out.println("Anagram check failed:-(");
		
	}
	public static void sorter(char a[],int c)
	{
		//char temp;
		for(int i = 0;i < c; i++)
		{
			for(int j = 0; j<c-i-1; j++)
			{
				if(a[j] > a[j+1])
				{
					char temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	public static void anna(char a[],char b[],int c)
	{
		int flg = 0;
		for(int i = 0;i<c;i++)
		{
			if(a[i] == b[i])
				flg++;
		}
		if(flg == c)
			System.out.println("Anagram!!");
		else
			System.out.println("Not an anagram!!");
		return;
	}
}

/*
	OUTPUT:
	DHRUVIL
	livurhd
	Anagram!!
*/