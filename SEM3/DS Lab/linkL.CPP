#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct node
{
int element;
struct node *next_e;
}n1;
void create_l(n1 *ele)
{
printf("Enter element : ");
scanf("%d",&ele->element);
printf("To enter another element enter Y\n");
if(getchar()=='Y' || getchar()=='y')
       {
       ele->next_e = (n1 *)malloc(sizeof(n1));
       create_l(ele->next_e);
       }
else
	ele->next_e = NULL;
	return;
}
void print_l(n1 *ele)
{
if(ele->next_e != NULL)
	{
	printf("%d--->",ele->element);
	//printf("Address of element : %d\n\n",ele);
	if(ele->next_e->next_e == NULL)
		printf("%d\n",ele->next_e->element);
	print_l(ele->next_e);
	}
}
int countL(n1 *ele)
{
	int c = 0;n1 * cur = ele;
	while(cur!=NULL)
	{
		c++;
		cur = cur->next_e;
	}
	return c;
}
void concat(n1 *l1,n1 *l2)
{
	n1 *temp;
	temp = l1;
	while(temp->next_e!=NULL)
	{
		temp = temp->next_e;
	}
	//temp = (n1 *)malloc(sizeof(n1));
	temp->next_e = l2;
}
n1 *reverse(n1 *p,n1 *c)
{
	n1 *temp = c->next_e;
	if(temp == NULL)
	{
		c->next_e = p;
		return c;
	}
	else
	{
		c->next_e = p;
		reverse(c,temp);
	}
}
void main()
{
clrscr();
n1 *head1,*head2;
head1 = (n1 *)malloc(sizeof(n1));
printf("Creating list 1......\n");
create_l(head1) ;                 ;
printf("\nEntered elements are : \n");
print_l(head1);
printf("The no. of elements of list 1 are : %d\n",countL(head1));
printf("Creating list 2.......\n");
head2 = (n1 *)malloc(sizeof(n1));
create_l(head2);
printf("\nEntered elements are : \n");
print_l(head2);
printf("The no. of elements of list 2 are : %d\n",countL(head2));
printf("After concatenating list 2 to list 1.....\n");
concat(head1,head2);
print_l(head1);
n1 *head3 = reverse(head1,head1->next_e);//storing the reversed list in new one
head1->next_e = NULL;        //setting last element address as null
printf("After reversing list 1......\n");
print_l(head3);
getch();
}