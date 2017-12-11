import java.util.Vector;
import java.util.Random;

class VectSum
{
	static Vector<Integer> v = new Vector<Integer>();
	public static void main(String args[])
	{
		Random r = new Random(10);
		int sum = 0;
		for(int i = 0;i<10;i++)
			v.add( r.nextInt() );	//generates any random int to limit range pass int as parameter
		for(int i = 0;i<v.size();i++)
		{
			System.out.println( v.elementAt(i) );
			sum += v.elementAt(i);
		}
		System.out.println("Sum : " + sum);
	}
}