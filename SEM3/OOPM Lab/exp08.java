import Dpackages.*;
import java.io.*;

public class exp08
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Enter an angle in degree : ");
		double x = (Integer.parseInt(input.readLine())*3.1415926536)/180;
		System.out.print("Enter the total no. of terms : ");
		int n = Integer.parseInt(input.readLine());
		System.out.println("cos(" + x + ") : \t" + math.cos(x,n));
		System.out.println("sin(" + x + ") : \t" + math.sin(x,n));
		System.out.println("tan(" + x + ") : \t" + math.tan(x,n));
		System.out.println("cosec(" + x + ") : \t" + math.cosec(x,n));
		System.out.println("sec(" + x + ") : \t" + math.sec(x,n));
		System.out.println("cot(" + x + ") : \t" + math.cot(x,n));
	}
}

/*OUTPUT : 
Enter an angle in degree : 45
Enter the total no. of terms : 10
cos(0.7853981634000001) :       0.707758814182129
sin(0.7853981634000001) :       0.7021253653106106
tan(0.7853981634000001) :       0.9920404398240829
cosec(0.7853981634000001) :     1.4242470780949692
sec(0.7853981634000001) :       1.412910697771498
cot(0.7853981634000001) :       1.0080234230948575
*/