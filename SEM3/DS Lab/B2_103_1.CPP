#include<stdio.h>
#include<conio.h>
void insert(int qu[],int n,int *f,int *r)
{
	if(*r == n-1)
	{
		printf("Queue is full.!!!!\n");
		return;
	}
	else
	{
		printf("Enter the element : ");
		scanf("%d",&qu[++(*r)] );
		if((*f) == -1)
			(*f)++;
		return;
	}
}
void delf(int qu[],int *f,int *r)
{
	if((*f) == -1 )
	{
		printf("No element present!!!\n");
		return;
	}
	else if((*f) == (*r))    //Only one element case
	{
		printf("Last element removed!\n");
		*f = *r = -1;
		return;
	}
	else
	{
		(*f)++;
		return;
	}
}
void printQu(int qu[],int f,int r)
{
	if(f == -1)
		return;
	for(int i = f;i<r;i++)
	{
		printf("%d--->",qu[i]);
	}
	printf("%d\n",qu[i]);
	return;
}
void delr(int qu[],int *f,int *r)
{
	if((*f) == -1)
	{
		printf("Empty queue.!!\n");
		return;
	}
	else if((*f) == (*r))
	{
		*f = *r = -1;
		printf("Last element deleted!!!\n");
		return;
	}
	else
	{
		(*r)--;
		return;
	}
}
void insrtf(int qu[],int max,int *f,int *r)
{
	if((*f) == 0)
	{
		printf("Front insertion not possible!!\n");
		return;
	}
	else if((*f) == (max -1))
	{
		(*f) = -1;
		insrtf(qu,max,f,r) ;
	}
	else if((*f) ==  -1)
	{
		(*f) == 1;
		insrtf(qu,max,f,r);
	}
	else if((*f) > 0 && (*f) < max)
	{
		printf("Enter the element to be inserted : ");
		scanf("%d",&qu[--(*f)]);
		return;
	}
	else
	{
		printf("Error in front insertion:-(\n");
		return;
	}
}
void main()
{
clrscr();
int front = -1 , rear = -1;
printf("Enter the total no. of elements of queue : ");
int n;
scanf("%d",&n);
int queue[100];
printf("Enter the elements : \n");
for(int i = 0;i<n;i++)
{
	scanf("%d",&queue[i]);
	rear++;
	if(front == -1)
		front++;
}
printQu(queue,front,rear);
int m = 0;
label :
printf("Select an operation : \n");
printf("1.Insert from rear.\n");
printf("2.Delete from rear.\n");
printf("3.Insert from Front\n");
printf("4.Delete from Front.\n");
printf("5.Exit \n");
fflush(stdin);
scanf("%d",&m);
switch(m)
{
	case 1:
		insert(queue,n,&front,&rear);
		printQu(queue,front,rear);
		goto label;
	case 2:
		delr(queue,&front,&rear);
		printQu(queue,front,rear);
		goto label;
	case 3:
		insrtf(queue,n,&front,&rear);
		printQu(queue,front,rear);
		goto label;
	case 4:
		delf(queue,&front,&rear);
		printQu(queue,front,rear);
		goto label;
	default :
		printQu(queue,front,rear);
		break;
}
getch();
}