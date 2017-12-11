#include<iostream.h>
#include<conio.h>
#include<stdlib.h>
#define MAX 100
typedef struct Vertex
{
	int data;
	Vertex *NextVertex;
};
void QInsert(Vertex *q[],int *f,int *r,Vertex *data)
{
	if(*r == MAX - 1)
		return;
	q[++(*r)] = data;
	if((*f) == -1)
		*f = 0;
	return;
}
Vertex *QDelete(Vertex *q[],int *f,int *r)
{
	if(*f == -1)
		return NULL;
	else if(*f == *r)
	{
		int temp = *f;
		*f = *r = -1;
		return q[temp];
	}
	else
		return q[(*f)++];
}
void AddVertex(Vertex *head,int d)
{
	Vertex *temp = head;
	while(temp->NextVertex!=NULL)
		temp = temp->NextVertex;
	temp->NextVertex = (Vertex *)malloc(sizeof(Vertex));
	temp = temp->NextVertex;
	temp->data = d;
	temp->NextVertex = NULL;
}
void dfs(Vertex *head[],int visited[],int value)
{
	cout<<head[value]->data<<"\t";visited[value] = 1;
	Vertex *temp = head[value]->NextVertex;
	while(temp!=NULL)
	{
		if(visited[temp->data] == 0)
			dfs(head,visited,temp->data);
		temp = temp->NextVertex;
	}
}
void bfs(Vertex *head[],int visited[],int value)
{
	Vertex *temp,*Queue[MAX];
	int front = -1,rear = -1;
	QInsert(Queue,&front,&rear,head[value]);
	while(front != -1 && rear != -1)
	{
		temp =  head[QDelete(Queue,&front,&rear)->data];
		while(temp!=NULL)
		{
			if(visited[temp->data] == 0)
			{
				cout<<temp->data<<"\t";
				visited[value] = 1;
				QInsert(Queue,&front,&rear,temp->NextVertex);
			}
			temp = temp->NextVertex;
			value = temp->data;
		}//end of inner while
	}
}
int main()
{
	clrscr();
	int TotalVertices,TotalAdjNodes,visited[MAX],value,NodeValue;
	Vertex *head[MAX];
	cout<<"Enter the total no. of vertices in the graph :- ";
	cin>>TotalVertices;
	for(int i = 0;i<TotalVertices;i++)
	{
		cout<<"Enter the vertex:- ";
		cin>>value;
		//AddVertex(head[i],value);
		head[value] = (Vertex *)malloc(sizeof(Vertex));
		head[value]->data = value;
		head[value]->NextVertex = NULL;
		visited[value] = 0;
		cout<<"Enter the total adjacent vertices of \""<<head[value]->data<<"\" : ";
		cin>>TotalAdjNodes;
		for(int j = 0;j<TotalAdjNodes;j++)
		{
			cout<<"Enter the adjacent node:- ";
			cin>>NodeValue;
			AddVertex(head[value],NodeValue);
		}
	}
	int opt;
	cout<<"Enter the traversal:- \n";
	cout<<"1.DFS Traversal.\n2.BFS Traversal.\n3.Exit.\n";
	cin>>opt;
	switch(opt)
	{
		case 1:
		cout<<"Enter the start for DFS traversal:- ";
		cin>>value;
		cout<<"DFS Traversal :- \n";
		dfs(head,visited,value);
		cout<<endl;
		for(i = 0;i<MAX;i++)
			visited[i] = 0;
		break;
		case 2:
		cout<<"Enter the start for BFS traversal:- ";
		cin>>value;
		cout<<"\nBFS Traversal :- \n";
		bfs(head,visited,value);
		cout<<endl;
		for(i = 0;i<MAX;i++)
			visited[i] = 0;
		break;
		case 3:break;
		default:
		cout<<"Illeagal value entered.\nTerminating the program......\n.";
		getch();
		return 0;
	}
	cout<<"Thank You.Visit Again!!!\n";
	getch();
	return 0;
}