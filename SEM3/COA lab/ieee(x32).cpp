#include <iostream>
#include<stdlib.h>
//#include<conio.h>
#define MAX 32
#define MAX64 64
using namespace std;

int bic(int a[],int x)
{
    int i = 0;
    while(x && i<MAX)
    {
        a[i++] = x%2;
        x = x/2;
    }
    return i;
}

int floatB(int b[],float y)
{
    int i = 0;
    while(y!=0.000000 && i<MAX)
    {
        b[i++] = (int)(y*2);
        y = (y*2) - (int)(y*2);
    }
    for(int j = 0;j<i/2;j++)
    {
        int temp = b[i-j-1];
        b[i-j-1] = b[j];
        b[j] = temp;
    }
    return i;
}

int main()
{
    //clrscr();
    float x = 0;
    cout<<"WELCOME TO IEEE CONVERTER:-)\nEnter your number : ";
    cin>>x;
    int num[MAX];
    if(x >=0)
    {
        num[0] = 0;
    }
    else
    {
        num[0] = 1;
        x = -x;
    }
    int exp = (int)x;
    x = x -(int)x;
    int EXP[MAX],MANT[MAX];
    int pow = bic(EXP,exp) - 1;
    int len = floatB(MANT,x) - 1;
    /*pow +=127;*/int temp = 128;  //use pow+=1023 and temp to 1024 for 64 bit
    if(pow >0 || (pow ==0 && EXP[pow] ==1))    //to insert binary equivalent of exponent in array
    {
        pow += 127;
        for(int i = 1;i<9;i++ ) //i<11 for 64 bit
        {
            num[i] = (pow&temp)?1:0;
            temp/=2;
        }
    }
    else
    {
        temp = len;
        while(temp>=0)
        {
            if(MANT[temp--] == 1)
            {pow = temp - len ;break;}
        }
        len += pow;
        pow+=127;temp = 128;
        for(int i = 1;i<9;i++ ) //i<11 for 64 bit
        {
            num[i] = (pow&temp)?1:0;
            temp = temp>>1;
        }
    }
    pow -=127;
    //temp = pow - 1; //setting pointer to get mantissa
    for(int i = 0;i<pow;i++)
    {
        MANT[++len] = EXP[i];   //copy mantissa part
    }
    for(int i = 9;i<MAX && len>=0;i++)
    {
        num[i] = MANT[len--];
        temp = i;
    }
    cout<<"GIVEN NO. IN IEEE FORMAT IS : \n";
    cout<<num[0]<<" ||| ";
    for(int i = 1;i<9 ;i++)
    {
        cout<<num[i]<<" ";
    }
    cout<<" ||| ";
    for(int i = 9;i<=temp;i++)
    {
        cout<<num[i]<<" ";
    }
    cout<<"0\n";
    //getch();
    return 0;
}
