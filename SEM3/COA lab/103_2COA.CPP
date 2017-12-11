#include<stdio.h>
#include<conio.h>
#define MAXB 15
#define MAX 16
//using namespace std;
void bic(int l,int p[])
{
	int i = 0;
	while(l != 0)
	{
		p[i] = l%2;
		i++;
		if(i >= MAX)
			l = 0;
		else
			l = l/2;
	}
	for(;i<MAX;i++)
	{
		p[i] = 0;
	}
}
void printb(int n[])
{
	for(int i = MAXB;i>=0;i--)
	{
		printf("%d",n[i]);
	}
	printf("\t");
}
int check(int a[])
{
	if(a[MAXB] == 1)
		return 1;
	else if(a[MAXB] == 0)
		return 2;
	else
		return 3;
}
void add(int A[],int m[])
{
	int carry = 0;
	for(int i =0;i<MAX;i++)
	{
		A[i] = A[i] + m[i] + carry ;
		carry = 0;
		if(A[i] == 2)
		{
			A[i] = 0;
			carry = 1;
		}
		else if(A[i] == 3)
		{
			A[i] = 1;
			carry = 1;
		}
		else
			continue;
	}
}
void sub(int a[],int m[])
{
	int n[MAX];
	for(int j = 0;j<MAX;j++)
	{
		n[j] = m[j];
	}
	for(int i = MAXB;i>=0;i--)
	{
		if(n[i] == 0)
		{
			n[i] = 1;
			continue;
		}
		else if(n[i] == 1)
		{
			n[i] = 0;
			continue;
		}
	}
	int m1[] = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	add(n,m1);
	add(a,n);
}
void shift(int a[],int q[])
{
	int temp = q[MAXB];
	for(int i = MAXB;i>0;i--)
	{
		a[i] = a[i-1];
		q[i] = q[i-1];
	}
	a[0] = temp;
}
void main()
{
	clrscr();
	int M,Q,count = MAX;
	printf("Enter the numerator : ");
	scanf("%d",&Q);
	printf("Enter the denominator : ");
	scanf("%d",&M);
	int m[MAX],q[MAX];
	bic(M,m);
	bic(Q,q);
	//printb(m);
	//printb(q);
	int A[16];
	for(int i = 0;i<MAX;i++)
	{
		A[i] = 0;
	}
	label:
		  switch(check(A))
		  {
			case 2 :shift(A,q);
				sub(A,m);
				break;
			case 1 :shift(A,q);
				add(A,m);
				break;
			case 3 :printf("error!:-(");
				count = 0;
				break;
			default :break;
		  }
		  switch(check(A))
		  {
			case 1:
				q[0] = 0;
				break;
			case 2:
				q[0] = 1;
				break;
			case 3:printf("Error");
				count = 0;
				break;
		  }
		  count--;
		  if(count>0)
			goto label;
		  else
			{
				if(check(A) == 1)
					add(A,m);
				printf("The division of the given nos: \nRemainder: ");
				printb(A);
				printf("\nQuotient : ");
				printb(q);
			}
	//return 0;
	getch();
}
