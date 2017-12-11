#include<stdio.h>
#include<conio.h>
void bic(int l,int p[])
{
	int i = 0;
	while(l != 0)
	{
		p[i] = l%2;
		i++;
		if(i >= 16)
			l = 0;
		else
			l = l/2;
	}
	for(;i<16;i++)
	{
		p[i] = 0;
	}
}
void printb(int n[])
{
	for(int i = 15;i>=0;i--)
	{
		printf("%d",n[i]);
	}
	printf("\t");
}
int check(int a,int b)
{
	if((a+b == 2) ||(a+b == 0))
	{
		return 0;
	}
	else if(a == 0 && b ==1)
	{
		return 2;
	}
	else if(a==1 && b==0)
	{
		return 1;
	}
	else
		return 3;
}
void add(int A[],int m[])
{
	int carry = 0;
	for(int i =0;i<16;i++)
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
	int n[16];
	for(int j = 0;j<16;j++)
	{
		n[j] = m[j];
	}
	for(int i = 15;i>=0;i--)
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
void shift(int a[],int q[],int *q1)
{
	int temp = a[0];*q1 = q[0];
	for(int i = 0;i<15;i++)
	{
		a[i] = a[i+1];
		q[i] = q[i+1];
	}
	q[15] = temp;
}
void main()
{
	clrscr();
	int M,Q,Q1 = 0,count = 16;
	printf("Enter the multiplicant : ");
	scanf("%d",&M);
	printf("Enter the multiplier : ");
	scanf("%d",&Q);
	int m[16],q[16];
	if( M < 0)
	{
		M = -M;
		bic(M,m);
		for(int i = 15;i>=0;i--)
		{
			if(m[i] == 0)
			{
				m[i] = 1;
				continue;
			}
			else if(m[i] == 1)
			{
				m[i] = 0;
				continue;
			}
		}
		int m1[] = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		add(m,m1);
	}
	else
		{bic(M,m);}
	if( Q < 0)
	{
		Q = -Q;
		bic(Q,q);
		for(int i = 15;i>=0;i--)
		{
			if(q[i] == 0)
			{
				q[i] = 1;
				continue;
			}
			else if(q[i] == 1)
			{
				q[i] = 0;
				continue;
			}
		}
		int m1[] = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		add(q,m1);
	}
	else
		{bic(Q,q);}
	//printb(m);
	//printb(q);
	int A[16];
	for(int i = 0;i<16;i++)
	{
		A[i] = 0;
	}
	label:
		  switch(check(q[0],Q1))
		  {
			case 2 :add(A,m);
				//printf("step add: \n");
				//printb(A);
				break;
			case 1 :sub(A,m);
				//printf("step sub : \n");
				//printb(A);
				break;
			case 3 :printf("error!:-(");
				count = 0;
				break;
			case 0 :
			default :break;
		  }
		  shift(A,q,&Q1);
		  //printf("step shift : \n");
		  //printb(A);
		  //printb(q);printf("%d\t",Q1);
		  count--;
		  if(count>0)
			goto label;
		  else
			{
				printf("The multiplication of the given nos: \n");
				printb(A);
				printb(q);
			}
	getch();
}