#include<iostream.h>
#include<conio.h>
#include<string.h>
#include<math.h>
void push(char a[],int *cp,char ele)
{
if(*cp == 99)
	{
	//cout<<"Stack is full!!!";
	return;
	}
else
	{
	a[++(*cp)] = ele;
	return;
	}
}
void push(int a[],int *cp,int ele)
{
if(*cp == 99)
	{
	//cout<<"Stack is full!!!";
	return;
	}
else
	{
	a[++(*cp)] = ele;
	return;
	}
}
void printstk(char a[],int cp)
{
	cout<<"The Stack is :\n";
	for(int i = 0;i<=cp;i++)
	{
		cout<<a[i];
		if(i != cp)
			{
			cout<<"--->";
			continue;
			}
		else
			return;
	}
}
int pop(int a[],int *cp)
{
	if(*cp < 0)
	{
		//cout<<"Stack is empty.";
		return (0);
	}
	else
	{
		//*cp-=1;
		return a[(*cp)--];
	}
}
char pop(char a[],int *cp)
{
	if(*cp < 0)
	{
		//cout<<"Stack is empty.";
		return (0);
	}
	else
	{
		//*cp-=1;
		return a[(*cp)--];
	}
}
void eval(char exp[],int c)
{
	//clrscr();
	int stk[100];
	//char exp[180];
	//cin.getline(exp,180);
	int curPos = -1 ;
	for(int i = c;i>=0;i--)
	{
		if(exp[i] >= '0' && exp[i] <= '9')
		{

			push(stk,&curPos,(exp[i] - '0'));
		}
		else
		{
			int op1,op2;
			op1 = pop(stk,&curPos);
			op2 = pop(stk,&curPos);
			switch(exp[i])
			{
				case '+':
					 push(stk,&curPos,(op1+op2));
					 break;
				case '-':
					push(stk,&curPos,(op1-op2));
					break;
				case '*':
					push(stk,&curPos,(op1*op2));
					break;
				case '/' :
					push(stk,&curPos,(op1/op2));
					break;
				case '^':
					push(stk,&curPos,(int)(pow(op1,op2)));
					break;
			}
		}
	}
	cout<<"\nThe final value is : ";
	cout<<stk[curPos];
	//getch();
}
int prcd(char a)
{
	switch(a)
	{
		case '*':
		case '/':
		case '^':
			return 3;
		case '+':
		case '-':
			return 2;
		case ')':
			return 0;
		default:
			return 4;
	}
}
void reverse(char a[],int b)
{
	char temp;
	for(int i = 0;i<=b/2;i++)
	{
		temp = a[i];
		a[i] = a[b-i];
		a[b-i] = temp;
	}
}
void main()
{
	clrscr();
	char exp[180],stk[180],opt[180];
	int cp = -1,co = -1;
	cout<<"Enter the infix expression : ";
	cin.getline(exp,180);
	for(int i = (strlen(exp)-1);i>=0;i--)
	{
		if(exp[i] >= '0' && exp[i] <= '9')
		{
			push(stk,&cp,exp[i]);
		}
		else
		{
			//char op1,op2;
			//op1 = pop(stk,&cp);
			//op2 = pop(stk,&cp);
			while((co != -1) && exp[i]!=')' && (prcd(exp[i])<prcd(opt[co])) || (exp[i] == '(' && opt[co] !=')') )
			{
				stk[++cp] = pop(opt,&co);
			}
			if((co == -1) || exp[i]!= '(' )
				push(opt,&co,exp[i]);
			else
				co--;
		}
	}
	while(co!=-1)
	{
		push(stk,&cp,pop(opt,&co));
	}
	reverse(stk,cp);
	cout<<"The prefix string is : \n";
	for(i = 0;i<=cp;i++)
	{
	       cout<<stk[i];
	}
	cout<<endl;
	eval(stk,cp);
	getch();
}