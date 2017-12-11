#include<iostream>
#define WINDOW 2
using namespace std;
int check(int a[],int r,int ele)
{
  for(int i = 0;i<=r;i++)
  {
    if(a[i] == ele)
      return i;     //to Hid
  }
  if(r == WINDOW)
    return 4;   //delete last used element
  else if(r<WINDOW)
    return 5;     //to just insert
}
void hid(int a[],int pos,int rp,int ele)
{
  int temp = a[pos];
  for(int i = pos;i<rp;i++)
    a[i] = a[i+1];
  a[rp] = temp;
}
int main()
{
  int page[WINDOW+1],rp,LRU;
  rp = -1;
  int x = 0;
  do
  {
    cout<<endl;
    cout<<"Enter the number(-1 to quit) : ";
    cin>>x;
    cout<<endl;
    if(x == -1)
      break;
    switch(check(page,rp,x))
    {
      case 5 : page[++rp] = x;    //inserting
                break;
      case 4 :    //del LRU n inserting
                cout<<page[0]<<" is the least recently used.\nDeleting and inserting new page......\n";
                for(int i =0;i<WINDOW;i++)
                {
                  page[i] = page[i+1];
                }
                page[rp] = x;
                break;
      default : hid(page,check(page,rp,x),rp,x);
		cout<<"Hit!!\n";
                break;
    }
    LRU = page[0];
    cout<<"The cache is : \n";
    for(int j =0;j<=rp;j++)
      cout<<page[j]<<"\t";
    cout<<"\nLeast Recently Used Page : "<<LRU<<endl;
  }while(x!=-1);
}
