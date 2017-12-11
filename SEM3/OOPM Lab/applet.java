import java.applet.*;
import java.awt.*;

public class applet extends Applet
{
	TextField text1 = new TextField(8);
	public void paint(Graphics g)
	{
		g.drawString("Hello Java",10,75);
		add(text1);
		text1.setText("0");
		int x = Integer.parseInt(text1.getText());
		if(x == 0)
			destroy();
	}
}