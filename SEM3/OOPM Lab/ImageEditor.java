import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.swing.*;

//<applet code=Image.class height=768 width=1366 ></applet>

class ImageEditor extends JFrame implements ActionListener,ItemListener
{
	Label l1,l2,l3;		//Label,TextField are all classes in awt package
	TextField t1,t2;
	Button b1,b2,b3;
	Checkbox c1 = new Checkbox("To Black and White");		
	Checkbox c2 = new Checkbox("To Yellow");
	Checkbox c3 = new Checkbox("To Green");		
	Checkbox c4 = new Checkbox("To Negative");
	Checkbox c5 = new Checkbox("Change Orientation");
	Checkbox c6 = new Checkbox("Change Image Source");
	BufferedImage img = null;
	File f = null;
	int pixels[][] = new int[1366][768];
	//Graphics g = new Graphics2D();
	String OutputName = "Out",ImageName;
	int width = 0,height = 0,a=0,r=0,g=0,b=0,avg = 0,opt = 1,angle = 0;
	JFrame jf = new JFrame();
	public void init()
	{
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setSize(1366,768);
		l1 = new Label("Enter the name of the Image you want to search(with extension):");
		l2 = new Label("No Such image found. Try different name.");
		l3 = new Label("Enter the name of output file(without extension): ");
		t2 = new TextField(15);
		t1 = new TextField(15);	
		b1 = new Button("Search");
		b2 = new Button("Exit");
		b3 = new Button("Create");
		
		//For alignment
		l1.setBounds(10,20,350,20);
		l2.setBounds(100,120,280,20);
		l3.setBounds(10,320,300,20);
		t1.setBounds(370,20,310,20);
		t2.setBounds(320,320,280,20);
		b1.setBounds(180,60,55,40);
		b2.setBounds(245,60,55,40);
		b3.setBounds(610,320,55,40);
		
		jf.add(l1);
		jf.add(t1);
		jf.add(b1);
		jf.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try {
		Graphics g1 = getGraphics();
		ImageName = t1.getText();
		if(ae.getSource() == b1)
		{
			f = new File( ImageName );
			while(!f.exists())
			{
				jf.add(l2);
				t1.setText("");
				f = new File( t1.getText() );
			}
			l2.setBounds(5000,5000,0,0);
			img = ImageIO.read( f );
			width = img.getWidth();
			height = img.getHeight();
			for(int i = 0;i< height;i++)
			{
				for(int j = 0;j<width;j++)
				{
					pixels[i][j] = img.getRGB(j,i);
					//System.out.println(j + "\t" + i + "\t" + pixels[i][j]);
				}
			}
			c1.setBounds(10,80,280,20);
			c2.setBounds(10,120,280,20);
			c3.setBounds(10,160,280,20);
			c4.setBounds(10,200,280,20);
			c5.setBounds(10,240,280,20);
			c6.setBounds(10,280,280,20);
			jf.add(c1);
			jf.add(c2);
			jf.add(c3);
			jf.add(c4);
			jf.add(c5);
			jf.add(c6);		
			c1.addItemListener(this);
			c2.addItemListener(this);
			c3.addItemListener(this);
			c4.addItemListener(this);
			c5.addItemListener(this);
			c6.addItemListener(this);
			if(img.getWidth() < 1366 && img.getHeight() < 768)
			g1.drawImage(img,1366-img.getWidth(),0,img.getWidth(),img.getHeight(),this);		//drawImage(Image img, int xTopLeft, int yTopLeft, int width, int height, ImageObserver o)	resize image on screen
		}
		if(ae.getSource() == b2)
		{
			g1.dispose();
			//jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
			System.exit(0);
		}
		if(ae.getSource() == b3)
		{
			OutputName = t2.getText();
			black(OutputName);
			img = ImageIO.read(new File(OutputName + ".jpg") );
			g1.drawImage( img,1366-img.getWidth()*2,0,img.getWidth(),img.getHeight(),null);
		}
		}
		catch(Exception e){}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		Graphics g3 = getGraphics();
		BufferedImage img1 = null;
		try{
		if(ie.getSource() == c1)
		{
			if(c1.getState())
			{
				jf.add(l3);
				jf.add(t2);
				jf.add(b3);
				c1.setState(false);
			}
		}
		if(ie.getSource() == c2)
		{
			if(c2.getState())
			{
				jf.add(l3);
				jf.add(t2);
				jf.add(b3);
				yellow(pixels,OutputName);
				c2.setState(false);
			}
		}
		if(ie.getSource() == c3)
		{
			if(c3.getState())
			{
				add(l3);
				add(t2);
				green(pixels,t2.getText());
			}
		}
		if(ie.getSource() == c4)
		{
			if(c4.getState())
			{
				add(l3);
				add(t2);
				negative(pixels,t2.getText());
			}
		}
		if(ie.getSource() == c5)
		{
			if(c5.getState())
			{
				add(l3);
				add(t2);
			}
		}
		if(ie.getSource() == c6)
		{
			if(c6.getState())
			{
				add(l3);
				add(t2);
			}
		}
		}
		catch(Exception e){}
	}
	public  void green(int pixels[][],String n) throws IOException
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
	public void yellow(int pixels[][],String n) throws IOException
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
	public void black(String n) throws IOException
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
	public void negative(int pixels[][],String n) throws IOException
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
	public void addWatermark(BufferedImage temp,String n)
	{
		Graphics g2 = temp.getGraphics();
		 
        g2.setFont(new Font("Ubuntu Mono", Font.BOLD, 40 ));
        g2.setColor( new Color(255,255,255,40) );	//new Color(int r,int g,int b,int a);
 
        g2.drawString(n, temp.getWidth()/6 , temp.getHeight()/6);
 
        g2.dispose();
	}
	public void orientation(int width , int height , int angle, int pixels[][],String n) throws IOException	//to consider clockwise rotation.
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
	public static void main(String args[])
	{
		ImageEditor ie = new ImageEditor();
		ie.init();
	}
}