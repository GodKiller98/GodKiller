import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;

public class Editor
{
	static BufferedImage img = null;
	static String OutputName;
	static int width = 0,height = 0,a=0,r=0,g=0,b=0,avg = 0,opt = 1;
	public static void main(String args[]) throws IOException
	{
		img = ImageIO.read( new File("image.jpg") );
		width = img.getWidth();
		height = img.getHeight();
		int pixels[][] = new int[height][];
		for(int i = 0;i< height;i++)
		{
			pixels[i] = new int[width];
			for(int j = 0;j<width;j++)
			{
				pixels[i][j] = img.getRGB(j,i);
			}
		}
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("**********Editor Menu*********");
			System.out.println("Chose from the following options:-");
			System.out.println("1.To Black and White\n2.To Yellow\n3.To Green\n0.Exit.");
			opt = Integer.parseInt( input.readLine() );
			switch(opt)
			{
				case 1 :System.out.print("Enter the output filename for black and white conversion : ");
						OutputName = input.readLine(); 
						black(pixels,OutputName);
						break;
				case 2 :System.out.print("Enter the output filename yellow conversion : ");
						OutputName = input.readLine(); 
						yellow(pixels,OutputName);
						break;
				case 3 :System.out.print("Enter the output filename for green conversion : ");
						OutputName = input.readLine(); 
						green(pixels,OutputName);
						break;
				case 0: System.out.println("Thank You.Visit Again");
						break;
			}
		}while(opt!= 0);
	}
	public static void green(int pixels[][],String n) throws IOException
	{
		for(int i = 0;i<height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				a = (pixels[i][j]>>24)&0xff;	//denotes transparency
				r = (pixels[i][j]>>16)&0xff;
				g = (pixels[i][j]>>8)&0xff;
				b = pixels[i][j]&0xff;
				//avg = (r+g+b)/3;
				pixels[i][j] = (a<<24) | (0<<16) | (g<<8) | 0;
				img.setRGB(j, i, pixels[i][j]);
				pixels[i][j] = (a<<24) | (r<<16) | (g<<8) | b;
			}
		}
		addWatermark( img , " Made by 1611102 & 1611103");
		ImageIO.write(img,"jpg" , new File(n + ".jpg") );
	}
	public static void yellow(int pixels[][],String n) throws IOException
	{
		for(int i = 0;i<height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				a = (pixels[i][j]>>24)&0xff;	//denotes transparency
				r = (pixels[i][j]>>16)&0xff;
				g = (pixels[i][j]>>8)&0xff;
				b = pixels[i][j]&0xff;
				//avg = (r+g+b)/3;
				pixels[i][j] = (a<<24) | (g<<16) | (g<<8) | 0;
				img.setRGB(j, i, pixels[i][j]);
				pixels[i][j] = (a<<24) | (r<<16) | (g<<8) | b;
			}
		}
		//ImageIO.write(img ,"jpg" , new File(n + ".jpg") );
		addWatermark( img , " Made by 1611102 & 1611103");
		ImageIO.write(img ,"jpg" , new File(n + ".jpg") );
	}
	public static void black(int pixels[][],String n) throws IOException
	{
		for(int i = 0;i<height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				a = (pixels[i][j]>>24)&0xff;	//denotes transparency
				r = (pixels[i][j]>>16)&0xff;
				g = (pixels[i][j]>>8)&0xff;
				b = pixels[i][j]&0xff;
				avg = (r+g+b)/3;
				pixels[i][j] = (a<<24) | (avg<<16) | (avg<<8) | avg;
				img.setRGB(j, i, pixels[i][j]);
				pixels[i][j] = (a<<24) | (r<<16) | (g<<8) | b;
			}
		}
		addWatermark( img , " Made by 1611102 & 1611103");
		ImageIO.write(img,"jpg" , new File(n + ".jpg") );
	}
	public static void addWatermark(BufferedImage temp,String n)
	{
		Graphics g = temp.getGraphics();
		g.drawImage(temp, 0, 0, null);
		 
        g.setFont(new Font("Ubuntu Mono", Font.BOLD, 80));
        g.setColor( new Color(255,255,255,40) );	//new Color(int r,int g,int b,int a);
 
        g.drawString(n, temp.getWidth()/6 , temp.getHeight()/6);
 
        g.dispose();
	}
}
