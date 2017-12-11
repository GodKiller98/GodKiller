import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/* <applet code = "exp10.class" height = 768 width = 1366> </applet> */

public class exp10 extends Applet implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button cal,clr,exit;
	public void init()
	{
		setLayout(null);
		l1 = new Label("Enter the value :");
		l2 = new Label("Result :");
		t1 = new TextField(10);
		t2 = new TextField(10);
		cal = new Button("Calculate");
		clr = new Button("Clear");
		exit = new Button("Exit");
		l1.setBounds(130,40,100,20);
		t1.setBounds(260,40,100,20);	
		l2.setBounds(130,150,100,20);
		t2.setBounds(260,150,100,20);
		cal.setBounds(160,200,100,20);
		clr.setBounds(260,200,100,20);
		exit.setBounds(360,200,100,20);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(cal);
		add(clr);
		add(exit);
		cal.addActionListener(this);
		clr.addActionListener(this);
		exit.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		int n = Integer.parseInt( t1.getText() );
		if(ae.getSource() == cal)
			t2.setText( String.valueOf( fact(n) ) );
		else if(ae.getSource() == clr)
		{
			t1.setText("");
			t2.setText("");
		}
		else if(ae.getSource() == exit)
			stop();
	}
	public void stop(){}
	int fact(int x)
	{
		if(x == 0)
			return 1;
		else 
			return x*fact(x-1);
	}
}