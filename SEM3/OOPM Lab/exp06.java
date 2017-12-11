import java.util.*;

public class exp06
{

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int x ;
		ShoppingList list1 = new ShoppingList();
		for(int i = 0;i<args.length;i++)
		{
			list1.insertItem(args[i]);
		}
		do
		{
			System.out.println("**************MAIN MENU*****************");
			System.out.println("Select option:");
			System.out.println("1.Insert Element\n2.Delete Element\n3.Print\n4.Insert at specific index\n5.Exit");
			
			x =  in.nextInt();
			switch(x)
			{
			case 1:	System.out.print("Enter the element to be Inserted : ");
					list1.insertItem( in.next() );
					break;
			case 2: System.out.println("Enter the element to be deleted :");
					list1.delItem( in.next() );
					break;
			case 3:	list1.prntList();
					break;
			case 4 : list1.InsrtAtIndex();
			default:break;
			}
		}while( x != 5 );
		in.close();
	}

}
class ShoppingList
{
	private static Vector<String> v = new Vector<String>();
	void insertItem(String s)
	{
		if( v.contains(s) )
		{
			System.out.println("The item already exits.Try Again");
			return;
		}
		else
		{
			v.add(s);
			return;
		}
	}
	void delItem(String s)
	{
		if(v.contains(s))
			v.removeElement(s);
		else
			System.out.println("Element does not exist.");
		return;
	}
	void prntList()
	{
		System.out.println(v);
		return;
	}
	void InsrtAtIndex()
	{
		System.out.print("Enter the item to be inserted :");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		if(v.contains(s))
		{
			System.out.println("Item Already exists.Try Again");
			return;
		}
		System.out.print("Enter the Index : ");
		int index = input.nextInt();
		if( index < v.size() )
			v.insertElementAt(s, index);
		else
			System.out.println("Index not available.Try another index");
		return;
	}
}