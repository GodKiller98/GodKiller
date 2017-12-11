import java.io.*;

class file
{
	public static void main(String args[]) throws IOException
	{
		FileWriter osw = new FileWriter("File.java");
		byte b[] = {'/','*','W','r','i','t','e',' ','t','h','r','o','u','g','h',' ','f','i','l','e',' ','*','/'};		
		osw.write(b);
	}
}/*Write through file */
