import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.swing.*;

public class Editor
{
	static BufferedImage img = null;
	static File f = null;
	static String OutputName,ImageName;
	static int width = 0,height = 0,a=0,r=0,g=0,b=0,avg = 0,opt = 1,angle = 0;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static JFrame jf = new JFrame();
	public static void main(String args[]) throws IOException
	{
		new Editor();
		System.out.print("Enter the file name with extension:-");
		ImageName = input.readLine();
		f = new File( ImageName );
		if(!f.exists())
		{
			System.out.println("No such image exists.Terminating code.");
			return;
		}
		img = ImageIO.read( f );
		width = img.getWidth();
		height = img.getHeight();
		int pixels[][] = new int[height][width];
		for(int i = 0;i< height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				pixels[i][j] = img.getRGB(j,i);
				//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
			}
		}
		do
		{
			System.out.println("**********Editor Menu*********");
			System.out.println("Chose from the following options:-");
			System.out.println("1.To Black and White\n2.To Yellow\n3.To Green\n4.To Negative.\n5.Change Orientation\n6.Change Image Source\n0.Exit.");
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
				case 5:	System.out.println("Enter the angle of rotation in clockwise sense(only multiples of 90):-");
						angle = Integer.parseInt( input.readLine() );
						System.out.println("Enter the output filename for orientation changes:-");
						OutputName = input.readLine();
						orientation(width,height,angle,pixels,OutputName);
						break;
				case 4: System.out.print("Enter the output filename for negative conversion conversion : ");
						OutputName = input.readLine(); 
						negative(pixels,OutputName);
						break;
				case 6: System.out.print("Enter the new name of image with extension:-");
						f = new File(input.readLine());
						if(!f.exists())
						{
							System.out.println("Image does not exists.Reverting to previous one.");
							f = new File(ImageName);
						}
						img = ImageIO.read(f);
						for(int i = 0;i< height;i++)
						{
							for(int j = 0;j<width;j++)
							{
								pixels[i][j] = img.getRGB(j,i);
								//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
							}
						}
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
	public static void negative(int pixels[][],String n) throws IOException
	{
		for(int i = 0;i<height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				a = (pixels[i][j]>>24)&0xff;	//denotes transparency
				r = (pixels[i][j]>>16)&0xff;
				g = (pixels[i][j]>>8)&0xff;
				b = pixels[i][j]&0xff;
				pixels[i][j] = (a<<24) | ((255-r)<<16) | ((255-g)<<8) | (255-b);
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
		 
        g.setFont(new Font("Ubuntu Mono", Font.BOLD, 40 ));
        g.setColor( new Color(255,255,255,40) );	//new Color(int r,int g,int b,int a);
 
        g.drawString(n, temp.getWidth()/6 , temp.getHeight()/6);
 
        g.dispose();
	}
	public static void orientation(int width , int height , int angle, int pixels[][],String n) throws IOException	//to consider clockwise rotation.
	{
		BufferedImage image1 = null;
		switch(angle/90)
		{
			case 1:image1 = new BufferedImage(height,width,img.getType());
					for(int i = 0;i<height;i++)
						for(int j = 0;j<width;j++)
						{
							//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
							image1.setRGB(i, j, pixels[i][j] );
						}
					/*addWatermark(image1,"Made by 1611102 & 1611103!!!");
					ImageIO.write(image1, "jpg", new File(n + "@" + angle +  ".jpg") );*/
					break;
			case 2:image1 = new BufferedImage(width,height,img.getType());
					 for(int i = 0;i<height;i++)
						 for(int j = 0;j<width;j++)
						 	{
							 	//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
							 	image1.setRGB(j, i, pixels[height - 1 -i][width - 1 - j] );
						 	} 
					 break;
			case 3:image1 = new BufferedImage(height,width,img.getType());
					 for(int i = 0;i<height;i++)
						 for(int j = 0;j<width;j++)
						 	{
							 	//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
							 	image1.setRGB(i, j, pixels[height-1-i][width-1-j] );
						 	}
					 break;
			case 4:System.out.println("Should I laugh:-)\nNo changes in image but still saved by the given file name.");
			default : System.out.println("Invalid Angle entered.\nNo changes in orientation.");return;
		}
		addWatermark(image1,"Made by 1611102 & 1611103!!!");
		ImageIO.write(image1, "jpg", new File(n + "@" + angle +  ".jpg") );
	}
	Editor()
	{
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setSize(1600,900);
	}
}

