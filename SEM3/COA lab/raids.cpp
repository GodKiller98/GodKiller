#include<iostream>
#define RAIDW 4
#define MAX 180
using namespace std;

void print0(int a[][MAX],int size)
{
  for(int i = 0;i<RAIDW;i++)
  {
    cout<<"DISK "<<i<<" |";
  }
  cout<<endl;
  for(int i = 0;i<=size;i++)
  {
    if(i%4 == 0 && i!=0)
      cout<<endl;
    cout<<"  "<<a[i%RAIDW][i/RAIDW]<<"    |";
  }
}

void print1(int a[][MAX],int size)
{
  for(int i = 0;i<RAIDW;i++)
  {
    cout<<"DISK "<<i<<" |";
  }
  cout<<endl;
  for(int i = 0;i<=size;i++)
  {
    for(int j =0;j<RAIDW;j++)
    {
      cout<<"  "<<a[j][i]<<"    |";
    }
    cout<<endl;
  }
}

void print2(int a[][MAX], int size)
{
	  for(int i = 3;i>=0;i--)
  	{
    		cout<<"D"<<i<<"|";
	  }
	  for(int i = 2;i>=0;i--)
	  {
	    cout<<"P"<<i<<"|";
	  }
  	cout<<endl;
	  for(int i = 0;i<=size;i++)
  	{
    		for(int j =0;j<7;j++)
    		{
      			cout<<a[j][i]<<" |";
    		}
    		cout<<endl;
  	}
}

int hamming(int x)
{
	int a[7],temp = 8;
	for(int i = 0;i<4;i++)
	{
		a[i] = (x&temp)?1:0;
		temp = temp>>1;
	}
	a[6] = a[1]^a[2]^a[3];
	a[5] = a[0]^a[3]^a[1];
	a[4] = a[1]^a[2]^a[0];
	x = 0;
	for(int i = 6;i>=0;i--)
	{
		x = (x<<1) + a[i];
	}
	return x;
}

int main()
{
  int RAID0[RAIDW][MAX],RAID1[RAIDW][MAX],RAID2[7][MAX],input,counter = -1;
  //counter ---> to keep a track on which disk to insert and which position to insert
  label:
    cout<<"Enter data(-1 to quit) less than 16: ";
    cin>>input;
    if(input!=-1 || input>15)
      {
        counter++;
        RAID0[counter%RAIDW][counter/RAIDW] = input;
        for(int i = 0;i<RAIDW;i++)
        {
          RAID1[i][counter] = input;
        }
	input = hamming(input);int temp = 64;		//function to convert given input to hamming.
	for(int i = 6;i>=0;i--)
	{
		RAID2[i][counter] = (input&temp)?1:0;;
		temp = temp>>1;;
	}		
        cout<<"RAID 0 : \n";
        print0(RAID0,counter);cout<<"\nRAID 1 : \n";
        print1(RAID1,counter);cout<<"RAID 2: \n";
        print2(RAID2,counter);cout<<"\n";
        goto label;
      }
    else
    {
      cout<<"Final state of raids : \nRAID 0: \n";
      print0(RAID0,counter);cout<<"\nRAID 1:\n";
      print1(RAID1,counter);cout<<"\nRAID 2: \n";
      print2(RAID2,counter);cout<<"\n";
    }
  return 0;
}
