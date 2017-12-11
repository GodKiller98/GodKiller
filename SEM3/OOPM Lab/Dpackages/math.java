package Dpackages;

class trigo
{	
	public static double cos(double angle,int terms)
	{
		double cos = 1;int i = 2;int sign = -1;
		while(terms != 0)
		{
			cos = cos + sign*(math.power(angle,i)/math.fact(i));
			sign*=sign;
			i+=2;terms--;
		}
		return cos;
	}
	public static double sin(double angle,int terms)
	{
		double sin = 0;int i = 1;int sign = 1;
		while(terms != 0)
		{
			sin = sin + sign*(math.power(angle,i)/math.fact(i));
			sign*=-sign;
			i+=2;terms--;
		}
		return sin;
	}
	public static double tan(double angle,int terms)
	{
		return sin(angle,terms)/cos(angle,terms);
	}
	public static double cosec(double angle,int terms)
	{
		return 1/sin(angle,terms);
	}
	public static double sec(double angle,int terms)
	{
		return 1/cos(angle,terms);
	}
	public static double cot(double angle,int terms)
	{
		return 1/(sin(angle,terms)/cos(angle,terms));
	}
}

public class math extends trigo
{
	public static double power(double number,int exponent)
	{
		if(exponent == 0)
			return 1;
		else
			return number*math.power(number,exponent-1);
	}
	public static double fact(int number)
	{
		if(number == 0)
			return 1;
		else 
			return number*math.fact(number-1);
	}
}
