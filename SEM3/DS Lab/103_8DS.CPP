#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

void SelectSort(int a[],int n)
{
	int i = 0,j=0,minindx,temp;
	for(i=0;i<n-1;i++)
	{
		minindx = i;
		for(j=i+1;j<n;j++)
			if(a[j]<a[minindx])
				minindx = j;
		temp = a[i];
		a[i] = a[minindx];
		a[minindx] = temp;
		cout<<"After loop no. "<<i+1<<endl;	//simulation step
		for(int k = 0;k<n;k++)
			cout<<a[k]<<" ";
		cout<<endl;
	}
}

void InsertionSort(int a[],int n)
{
	if(n <= 1)
		return;
	InsertionSort(a,n-1);
	int mini = a[n-1],j = n-2;
	while(j>=0 && a[j] > mini)
	{
		a[j+1] = a[j];
		j--;
	}
	a[j+1] = mini;
	cout<<"After operation no. "<<n-1<<" the sorted array is : \n";	//simulation step
	for(int k =0;k<n;k++)
		cout<<a[k]<<" ";
	cout<<endl;
}

int main()
{
	clrscr();
	int len;
	cout<<"Enter the lenght of array to be sorted : ";
	cin>>len;
	int array[180];
	cout<<"Enter the elements of array to be sorted : ";
	for(int i=0;i<len;i++)
		cin>>array[i];
	int option;
	cout<<"Enter sorting algo : \n";
	cout<<"1.Selection Sort.\n2.Insertion Sort.\n";
	cin>>option;
	switch(option)
	{
		case 1:SelectSort(array,len);break;
		case 2:InsertionSort(array,len);break;
		default : cout<<"Fatal error in input\nTerminating program....\n";getch();exit(0);
	}
	cout<<"\nAfter sorting......\n";
	for(i = 0;i<len;i++)
		cout<<array[i]<<" ";
	getch();
	return 0;
}