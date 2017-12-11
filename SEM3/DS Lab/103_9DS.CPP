#include<iostream.h>
#include<conio.h>
#define M 11
int h(int x)
{
	return x%M;
}
int ReHashLP(int key,int y,int ht[])
{
	int j = 1;
	for(int i = 0;i < M;i++)
	{
		if(ht[(h(key) + j)%M] == -1)
			return (y + j)%M;
		else
			j++;
	}
	//cout<<"Overflow of data\n";
	return M + j;
}
int ReHashQP(int key,int y,int ht[])
{
	int j = 1;
	for(int i = 0;i<M;i++)
	{
		if(ht[( h(key) + j*j)%M] == -1)
			return (y+j*j)%M;
		else
			j++;
	}
	//cout<<"Overflow of data\n";
	return M + j;
}
int HashSearch(int key,int ht[])
{
	int y = h(key);
	if(ht[y] == key)
		return 0;
	else
	{
		for(int i = 0;i<M;i++)
		{
			if(ht[i] == key)
				if(i == 0)
					return M;
				else
					return i;
		}
		return M + i;
	}
}
int main()
{
	clrscr();
	int HashTableLP[M],HashTableQP[M],input,hs;
	for(int i = 0;i<M;i++)
		HashTableLP[i] = HashTableQP[i] = -1;
	cout<<"Enter the total elements in hash table(should be less than 11) : ";
	cin>>hs;
	if(hs > 11 )
		return 0;
	for(i = 0;i<hs;i++)
	{
		cout<<"Enter the data: ";
		cin>>input;
		if(HashTableLP[h(input)] == -1)
			HashTableLP[h(input)] = input;
		else
			HashTableLP[ReHashLP( input, h(input) , HashTableLP )] = input;
		if(HashTableQP[h(input)] == -1)
			HashTableQP[h(input)] = input;
		else
			HashTableQP[ReHashLP( input, h(input) , HashTableQP )] = input;
	}
	cout<<"Enter the data to searched : ";
	cin>>input;
	cout<<"Using Linear Probing........\n";
	hs = HashSearch(input,HashTableLP);
	if( hs == 0 )
		cout<<"Element found at ( in O(1) ): "<<h(input)<<endl;
	else
		if( hs > M )
			cout<<"Element not found"<<endl;
		else
			cout<<"Element found at ( after probing ) : "<<hs%M<<endl;
	cout<<"Using Quadratic Probing.....\n";
	hs = HashSearch(input,HashTableQP);
	if( hs == 0 )
		cout<<"Element found at ( in O(1) ): "<<h(input)<<endl;
	else
		if( hs > M )
			cout<<"Element not found"<<endl;
		else
			cout<<"Element found at ( after probing ) : "<<hs%M<<endl;
	getch();
	return 0;
}