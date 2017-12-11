#include<iostream.h>
#include<conio.h>
void RestoreBelow(int pos,int arr[],int n)
{
	int val = arr[pos],i;
	while(pos<=n/2-1)
	{
		i = 2*pos+1;
		if((i<n-1)&&arr[i]<arr[i+1])
			i++;
		if(val >= arr[i])
			break;
		arr[pos]  = arr[i];
		pos = i;
	}
	arr[pos] = val;
}
int del(int arr[],int *n)
{
	int var= arr[0];
	arr[0] = arr[(*n)-1];
	(*n)--;
	RestoreBelow(0,arr,*n);
	return var;
}
void makeheap(int arr[],int n)
{
	int i;
	for(i = n/2-1;i>=0;i--)
		RestoreBelow(i,arr,n);
}
void insert(int data,int arr[],int *n)
{
	int i = 0;
	while( i<(*n) )
	{
		if(arr[i] == 0)
		{
			arr[i] = data;
			(*n)++;
			makeheap(arr,*n);
			return;
		}
		i++;
	}
	cout<<"Queue Full.Delete to insert new value.\n";
	return;
}
void print(int arr[],int n)
{
	cout<<"Priority Queue:-\n";
	for(int i = 0;i<n;i++)
		cout<<arr[i]<<endl;
}
int main()
{
	clrscr();
	int arr[180],n,size,opt;
	cout<<"Enter total no. of elements:-";
	cin>>n;
	size = 0;
	for(int i = 0;i<n;i++)
	{
		cin>>opt;arr[i] = 0;
		insert(opt,arr,&size);
	}
	print(arr,n);
	label:
	clrscr();
	cout<<"***********************MAIN MENU(PRIORITY QUEUE)********************\n";
	cout<<"1.Insert.\n2.Delete.\n3.Exit.\n";
	cin>>opt;
	switch(opt)
	{
		case 1: cin>>opt;
			insert(opt,arr,&size);
			print(arr,size);
			goto label;
		case 2: del(arr,&size);
			print(arr,size);
			goto label;
		case 3: opt = 0;
			cout<<"Finalising the data of queue........\n";
			print(arr,size);
			cout<<"Thank You.\nVisit Again.\n";
			break;
		default:cout<<"Wrong input.\n";
			goto label;
	}
	getch();
	return 0;
}