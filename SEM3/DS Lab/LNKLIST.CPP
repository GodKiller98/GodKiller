#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct node
{
	int ele;
	struct node *next;
}n;
void createLL(n **n1,int x)
{
	if(x > 0)
	{
		*n1 = (n *)malloc(sizeof(n));
		printf("Enter Data : ");
		scanf("%d",&(*n1)->ele);
		createLL(&(*n1)->next,x-1);
	}
	else
	{
		*n1 = NULL;
		printf("List created succesfully!!!!\n");
		return;
	}
}
void prntLL(n *n2)
{
	if(n2 != NULL)
	{
		printf("%d",n2->ele);
		if(n2->next!=NULL)
		{
			printf("--->");
			prntLL(n2->next);
		}

	}
	return;
}
void insrtSort(n **n3,int e)
{
		n *temp = *n3,*ptr;
		if(temp == NULL || temp->ele >= e)
		{
			ptr = (n *)malloc(sizeof(n));
			ptr->ele =e;
			ptr->next = temp;
			temp = ptr;
			*n3 = temp;
		}
		else
		{
			while(temp->next!=NULL && temp->next->ele < e)
			{
				temp = temp->next;
			}
			ptr = (n *)malloc(sizeof(n));
			ptr->ele = e;
			ptr->next = temp->next;
			temp->next = ptr;
		}
}
int countL(n *ele)
{
	int c = 0;n *cur = ele;
	while(cur!=NULL)
	{
		c++;
		cur = cur->next;
	}
	return c;
}
n *reverse(n *head)
{
	n *temp,*nw,*start = NULL;
	temp = head;
	while(temp!=NULL)
	{
		nw = (n *)malloc(sizeof(n));
		nw->ele =  temp->ele;
		nw->next = start;
		start = nw;
		temp = temp->next;
	}
	return start;
}
void del(n **n4)
{
	int e;
	printf("Enter the element to delete : ");
	scanf("%d",&e);
	n *temp=  *n4,*ptr;
	if(temp->ele == e)
	{
		ptr = temp;
		temp = ptr->next;
		free(ptr);
		*n4 = temp;
	}
	else
	{
		while(temp->next!=NULL && temp->next->ele !=e)
			temp = temp->next;
		if(temp->next == NULL &&temp->next->ele != e)
			printf("Element does not exist!\n");
		else
		{
			ptr = temp->next;
			temp->next = ptr->next;
			free(ptr);
		}
	}
}
void concat(n **head1,n **head2)
{
	//int l = countL(head2);
	n *temp = *head2;
	while(temp!=NULL)
	{
		insrtSort(head1,temp->ele);
		temp = temp->next;
	}
}
void main()
{
	clrscr();
	n *head1 = NULL,*head2 = NULL;
	printf("Enter the total elements of list 1 : ");
	int i = 0,x,e;
	scanf("%d",&x);
	//createLL(&head,x);
	for(;i<x;i++)                           //for creating ll
	{
		printf("Enter the element : ");
		scanf("%d",&e);
		insrtSort(&head1,e);
	}
	printf("Enter the total elements of list 2 : ");
	scanf("%d",&x);
	for(i = 0;i<x;i++)                           //for creating ll
	{
		printf("Enter the element : ");
		scanf("%d",&e);
		insrtSort(&head2,e);
	}
	int option = -1;
	do
	{
		printf("Entering menu.Press any key to continue.!!");
		getch();
		clrscr();
		printf("****MAIN MENU****\n");
		printf("1.Insert(List 1)\n2.Insert(List 2)\n");
		printf("3.Delete(List 1)\n4.Delete(List 2)\n5.Concatenation\n");
		printf("6.Reverse(List 1)\n7.Reverse(List 2)\n8.Display\n9.Count\n10.Exit\n");
		scanf("%d",&option);
		switch(option)
		{
		case 1:
			printf("Enter the value to insert : ");
			scanf("%d",&e);
			insrtSort(&head1,e);
			break;
		case 2:
			printf("Enter the value to insert : ");
			scanf("%d",&e);
			insrtSort(&head2,e);
			break;
		case 3:
			del(&head1);
			break;
		case 4:
			del(&head2);
			break;
		case 6:
			head1 =  reverse(head1);
			break;
		case 7:
			head2 = reverse(head2);
			break;
		case 8:
			printf("List 1 : \n");
			prntLL(head1);
			printf("\nList 2 : \n");
			prntLL(head2);
			printf("\n");
			break;
		case 10 : break;
		case 5:
			printf("Performing sorted concantenation.....\n");
			concat(&head1,&head2);
			break;
		case 9: printf("No. of elements of.....\n");
			printf("List 1 are : %d\n",countL(head1));
			printf("List 2 are : %d\n",countL(head2));
			break;
		default:printf("Error.Try Again!!");
		}
	}while(option!=10);
getch();
}