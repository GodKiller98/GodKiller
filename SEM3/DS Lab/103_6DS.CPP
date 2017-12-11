#include<iostream.h>
#include<conio.h>
#include<stdlib.h>
typedef struct node
{
	int ele;
	struct node *LChild;
	struct node *RChild;
}tree;
tree *insert(tree *root,int e)
{
	tree *temp,*parent,*p;
	temp = (tree *)malloc( sizeof(tree) )  ;
	temp->ele = e;
	temp->LChild = temp->RChild = NULL;
	if(root == NULL)
		return temp;
	parent = NULL;p = root;
	while(p!=NULL)
	{
		parent = p;
		if(p->ele < e)
			p = p->RChild;
		else
			p = p->LChild;
	}
	if(parent->ele < e)
		parent->RChild = temp;
	else
		parent->LChild = temp;
	return root;
}
int maxE(tree *a)
{
	if(a->RChild!=NULL)
	{
		return maxE(a->RChild);
	}
	else
		return a->ele;
}
void inorder(tree *a)
{
	if(a!=NULL)
	{
		inorder(a->LChild);
		cout<<a->ele<<" ";
		inorder(a->RChild);
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
tree *find(tree *t,tree **p,int *child,int a)
{
	if(t!=NULL)
	{
	if(t->ele == a)
		return t;
	else if(a< t->ele)
	{
		*p = t;*child = 0;     //indicating the side on which ans would be
		return find(t->LChild,p,child,a);
	}
	else if(a > t->ele)
	{
		*p = t;*child = 1;
		return find(t->RChild,p,child,a);
	}
	else
	{
		return NULL;
	}
	}
	else
		return NULL;
}
void del(tree *t,int a)
{
	tree *temp,*parent = t;int child;
	temp = find(t,&parent,&child,a);
	if(temp!=NULL)
	{
		if(temp->LChild == NULL && temp->RChild == NULL)
			(child == 0)?parent->LChild = NULL:parent->RChild = NULL;
		else if(temp->LChild!=NULL && temp->RChild == NULL)
			(child == 0)?parent->LChild = temp->LChild:parent->RChild = temp->LChild;
		else if(temp->RChild!=NULL && temp->LChild == NULL)
			(child == 0)?parent->LChild = temp->RChild:parent->RChild = temp->RChild;
		else
		{
			tree *t1 = temp->RChild;
			while(t1->LChild!=NULL)
			{
				t1 = t1->LChild;
			}
			int t2 = t1->ele;
			del(t,t2);
			temp->ele = t2;
		}
	}
}
int main()
{
	clrscr();
	tree *root = NULL;
	int x;
	label:
	cout<<"Enter item(-1 To Quit): ";
	cin>>x;
	if(x !=-1 )
	{
		root = insert(root,x);
		goto label;
	}
	res:
		int opt;
		cout<<"Enter choice of operation: \n";
		cout<<"1.Insertion\n2.Printing\n3.Max Term\n4.Deletion\n5.Exit\n";
		cin>>opt;
		switch(opt)
		{
			case 1: cout<<"Enter no. to be inserted: ";
					int in;cin>>in;
					root = insert(root,in);
					goto res;
			case 2: cout<<"Tree in inorder format: \n";inorder(root);cout<<endl;
					cout<<"Tree in preorder format: \n";preorder(root);cout<<endl;
					cout<<"Tree in postorder format: \n";postorder(root);cout<<endl;
					goto res;
			case 3: cout<<"The max term of the tree is : "<<maxE(root)<<endl;
					goto res;
			case 4: cout<<"Enter the element to be deleted : ";
					cin>>in;
					del(root,in);
					goto res;
			case 5: break;
			default: cout<<"Error.Try again.\n";goto res;
		}
	return 0;
}