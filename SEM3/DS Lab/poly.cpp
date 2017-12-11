#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct poly
{
	int coef;
	int powX,powY,powZ;
	struct poly *next;
}term;
term* insrt(term *exp,int c,int px,int py,int pz)
{
	term *temp = exp,*n;
	n = (term *)malloc(sizeof(term));
	n->coef = c;n->powX= px;n->powY = py;n->powZ = pz;
	if(exp==NULL || (temp->powX < px || (temp->powX == px && (temp->powY < py)  || (temp->powY == py && (temp->powZ < pz) ) ) ) )
	{
		n->next = exp;
		exp = n;
		return exp;
	}
	else
	{
		while(temp->next != NULL)
		{
			//temp = temp->next;
			if(temp->next->powX < px || (temp->next->powX == px && (temp->next->powY < py  || (temp->next->powY == py && ( temp->next->powZ < pz ) ) ) ) )
			{
				n->next = temp->next;
				temp->next = n;
				return exp;
			}
			temp = temp->next;
		}
		if(temp->next == NULL)
		{
			n->next = NULL;
			temp->next = n;
		}
		return exp;
	}
	//return exp;
}
void prntP(term *t)
{
	//printf("Printing...\n");
	if(t != NULL)
	{
		if(t->coef!=0)
	    printf("+[(%d)(x^%d)(y^%d)(z^%d)] ",t->coef,t->powX,t->powY,t->powZ);
		prntP(t->next);
	}
	return;
}

term *add(term *t1,term *t2)
{
    term *temp1 = t1,*temp2 = t2;
    while(temp2!=NULL)
    {
		temp1 = t1;
		while(temp1 != NULL)
		{
			if(temp1->powX == temp2->powX && temp1->powY == temp2->powY && temp1->powZ == temp2->powZ)
			{
				temp1->coef+=temp2->coef;
				break;
			}
			temp1 = temp1->next;
		}
		if(temp1 == NULL )
			t1 = insrt(t1,temp2->coef,temp2->powX,temp2->powY,temp2->powZ);
		temp2 = temp2->next;
    }
    return t1;
}

term *sub(term *t1,term *t2)
{
    term *temp1 = t1,*temp2 = t2;
    while(temp2!=NULL)
    {
		temp1 = t1;
		while(temp1 != NULL)
		{
			if(temp1->powX == temp2->powX && temp1->powY == temp2->powY && temp1->powZ == temp2->powZ)
			{	
				temp1->coef-=temp2->coef;
				break;
			}
			temp1 = temp1->next;
		}
		if(temp1 == NULL )
			t1 = insrt(t1,-temp2->coef,temp2->powX,temp2->powY,temp2->powZ);
		temp2 = temp2->next;
    }
    return t1;
}

int main()
{
	clrscr();
	printf("Enter the total node of polynomials : ");
	int x1;
	scanf("%d",&x1);
	term *start1 = NULL;
	while(x1)
	{
	     int px,py,pz,c;
		 printf("Enter the co-efficient,power of x, y & z : ");
	     scanf("%d%d%d%d",&c,&px,&py,&pz);
	     start1 = insrt(start1,c,px,py,pz);
	     x1--;
	}
	printf("Enter the total node of polynomials : ");
	int x2;
	scanf("%d",&x2);
	term *start2 = NULL;
	while(x2)
	{
	     int px,py,pz,c;
		 printf("Enter the co-efficient,power of x, y & z : ");
	     scanf("%d%d%d%d",&c,&px,&py,&pz);
	     start2 = insrt(start2,c,px,py,pz);
	     x2--;
	}
	int opt = 0;
	label:
	    printf("Select Option\n1.Add(1+2)\n2.Sub(1-2)\n3.Add(2+1)\n4.Sub(2-1)\n5.Display\n6.Exit\n");
	    scanf("%d",&opt);
	    switch(opt)
	    {
	    case 1: start1 = add(start1,start2);
		    goto label;
	    case 2: start1 = sub(start1,start2);
		    goto label;
	    case 5: printf("Polynomial 1 : \n");prntP(start1);printf("\n");
		    printf("Polynomial 2 : \n");prntP(start2);printf("\n");
		    goto label;
	    case 6: printf("Program Terminated.");break;
	    case 3: start2 = add(start2,start1);goto label;
	    case 4: start2 = sub(start2,start1);goto label;
	    default: printf("Error\n");break;
	    }
	getch();
	return 0;
}
