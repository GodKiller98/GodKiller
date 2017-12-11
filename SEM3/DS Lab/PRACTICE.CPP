#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
int n=1;
void insert (int a[], int n, int t)
{
 int i=n;
 a[i]= t;
 while (1)
 {
  if ((a[i]<a[i/2]) || i==1)
  {
   break;
  }
  else if (a[i]>a[i/2])
  {
   int temp;
   temp = a[i];
   a[i] = a[i/2];
   a[i/2] = temp;
   i=i/2;
  }
 }
}
int del (int a[], int n)
{
 int i=1,l=2,r=3,temp,x;
 if (n== -1)
 {
  return -1;
 }
 x = a[1];
 a[1]= a[n];
 while (1)
 {
  if (a[i]>a[l] && a[i]>a[r])
  {
   break;
  }
  else if (a[l]>a[r])
  {
   temp = a[i];
   a[i] = a[l];
   a[l] = temp;
   i=l;
   l= (2*i);
   r= l+1;
  }
  else if (a[r]>a[l])
  {
   temp = a[i];
   a[i] = a[r];
   a[r] = temp;
   i=r;
   l= (2*i);
   r=  l+1;
  }
 }
  return x;
}
void main()
{
 int a[100]={-1},x,z;
 clrscr();
 while (1)
 {
 printf ("enter your choice\n1)Insert element\n2)Delete element\n3)Print\n4)Exit\n");
 scanf ("%d",&x);
 switch (x)
 {
  case 1:
  {
   printf ("enter the element in the queue\n");
   scanf ("%d",&a[n]);
   insert (a,n,a[n]);
   n++;
   break;
  }
  case 2:
  {
   z= del (a,n-1);
   if (z == -1)
   {
    printf ("It's empty\n");
   }
   printf ("the element deleted is %d",z);
   n--;
   break;
  }
  case 3:
  {
   for (int i=1;i<n;i++)
   {
    printf ("%d\t", a[i]);
   }
   break;
  }
  case 4:
  {
   exit (-1);
   break;
  }
 }
}
 getch();
}


