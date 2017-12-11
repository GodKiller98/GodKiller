#include<stdio.h>
//#include<conio.h>
#define WINDOW 2

int check(int a[],int r,int ele)
{
  for(int i = 0;i<=r;i++)
  {
    if(a[i] == ele)
      return i;     //to HIT
  }
  if(r == WINDOW)
    return 4;   //delete last used element and insert new.
  else if(r<WINDOW)
    return 5;     //to just insert
}

int main()
{
  int in,page[WINDOW+1],rp = -1,FI;
  label:
    printf("Enter element to insert (-1 to Quit) : \n");
    scanf("%d",&in);
    if(in != -1){
    switch( check(page,rp,in) )
    {
      case 5: page[++rp] = in;
              break;
      case 4: printf("%d is the first element to enter.Deleting and inserting new : \n",FI);
              for(int i =0;i<WINDOW;i++)
                {
                  page[i] = page[i+1];
                }
                page[rp] = in ;
                break;
      default: break;
    }
    FI = page[0];
    printf("The cache is : \n");
    for(int i = 0;i<=rp;i++)
    {
      printf("%d ",page[i]);
    }
    printf("\nFirst Entered Element : %d\n",FI);
    goto label;
    }
  return 0;
}
