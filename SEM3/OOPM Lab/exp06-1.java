import java.util.*;

public class exp06-1 
{

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int x ;
		Vector<String> List = new Vector<String>();
		do
		{
			System.out.println("**************MAIN MENU*****************");
			System.out.println("Select option:");
			System.out.println("1.Insert Element\n2.Delete Element\n3.Insert at Specific Index\n4.Print\n5.Exit");
			ShoppingList list1 = new ShoppingList();
			x =  in.nextInt();
			switch(x)
			{
			case 1:	list1.insertItem(List);
					break;
			case 2: System.out.println("Enter the element to be deleted :");
					String s = in.next();
					list1.delItem(List,s);
					break;
			case 3: list1.InsrtAtIndex(List);
					break;
			case 4: list1.prntList(List);
					break;
			default:break;
			}
		}while( x != 5 );
		in.close();
	}

}
class ShoppingList
{
	void insertItem(Vector<String> v)
	{
		System.out.print("Enter the item to be inserted :");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		if(v.contains(s))
		{
			System.out.println("The item already exits.");
			//input.close();
			return;
		}
		else
		{
			v.add(s);
			//input.close();
			return;
		}
	}
	void delItem(Vector<String> v,String s)
	{
		if(!v.contains(s))
		{
			System.out.println("The Item does not exist.");
			return;
		}
		v.removeElement(s);
		return;
	}
	void prntList(Vector<String> v)
	{
		//System.out.println(v.capacity());
		System.out.println(v);
		return;
	}
	void InsrtAtIndex(Vector<String> v)
	{
		System.out.print("Enter the item to be inserted :");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		if(v.contains(s))
		{
			System.out.println("Item Already exists.Try Again");
			return;
		}
		System.out.println("Enter the Index : ");
		int index = input.nextInt();
		if( index < v.size() )
			v.insertElementAt(s, index);
		else
			System.out.println("Index not available.Try another index");
		return;
	}
}