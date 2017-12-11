#include<iostream.h>
#include<conio.h>
#include<string.h>
#include<math.h>
void push(int a[],int *cp,int ele)
{
if(*cp == 99)
	{
	cout<<"Stack is full!!!";
	return;
	}
else
	{
	a[++(*cp)] = ele;
	return;
	}
}
void printstk(int a[],int cp)
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
		cout<<"Stack is empty.";
		return (0);
	}
	else
	{
		//*cp-=1;
		return a[(*cp)--];
	}
}
void main()
{
	clrscr();
	int stk[100];
	char exp[180];
	cin.getline(exp,180);
	int curPos = -1 ;
	for(int i = (strlen(exp)-1);i>=0;i--)
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
	printstk(stk,curPos);
	getch();
}