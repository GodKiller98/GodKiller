#include<iostream>
#define MAX 100
#include<stdlib.h>
#include<string.h>
using namespace std;

typedef struct node
{
	char ele;
	struct node *LChild;
	struct node *RChild;
}tree;

void inorder(tree *a)
{
	if(a!=NULL)
	{
		inorder(a->LChild);
		cout<<a->ele<<" ";
		inorder(a->RChild);
	}
}

void push(tree *a[],int *cp, tree *e)
{
  if(*cp == MAX-1)
	{
	  //cout<<"Stack is full!!!";
	  return;
	}
  else
	{
	  a[++(*cp)] = e;
	  return;
	}
}

tree *pop(tree *b[],int *cp)
{
  if(*cp < 0)
	{
		return (0);
	}
	else
	{
		return b[(*cp)--];
	}
}

void preorder(tree *a)
{
	if(a!=NULL)
	{
		cout<<a->ele<<" ";
		preorder(a->LChild);
		preorder(a->RChild);
	}
}

void postorder(tree *a)
{
	if(a!=NULL)
	{
		postorder(a->LChild);
		postorder(a->RChild);
		cout<<a->ele<<" ";
	}
}

int main()
{
  tree *nodes[MAX];
  char exp[MAX];
  cout<<"Enter a postfix expression : ";
  cin.getline(exp,MAX);
  int curPos = -1,len = strlen(exp);
  for(int i = 0;i<len;i++)
  {
    if( (exp[i]>='0' && exp[i] <='9') || (exp[i]>='a' && exp[i] <='z') )
    {
      tree *newNode = (tree *)malloc( sizeof(tree) );
      newNode->ele = exp[i];newNode->LChild = newNode->RChild = NULL;
      push(nodes,&curPos,newNode);
    }
    else
    {
      tree *newNode = (tree *)malloc( sizeof(tree) );
      newNode->ele = exp[i];
      newNode->RChild = pop(nodes,&curPos);
      newNode->LChild = pop(nodes,&curPos);
      push(nodes,&curPos,newNode);
    }
  }
  tree *root = pop(nodes,&curPos);
  cout<<"Inorder Form of expression tree is : \n";
  inorder(root);cout<<endl;
  cout<<"Preorder Form of expression tree is : \n";
  preorder(root);cout<<endl;
  cout<<"postorder Form of expression tree is : \n";
  postorder(root);cout<<endl;
  return 0;
}