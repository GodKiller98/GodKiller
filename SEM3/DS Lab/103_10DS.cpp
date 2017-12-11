#include <stdio.h>
#include <stdlib.h>
int visited[10],adj[10][10],n,c,front=0,rear=0,q[10];
void bfs(int);
void dfs(int);
int main()
{
int ch,i,j;
while(1)
{
printf("Select any one of the choices given below\n");
printf("1. DFS and BFS traversal\n");
printf("2. Exit\n");
printf("Response: ");
scanf("%d",&ch);
if(ch<=3)
{
switch(ch)
{
case 1:
printf("Enter the no of nodes in the graph: ");
scanf("%d",&n);
printf("Enter the adjacency matrix\n");
for(i=0;i<n;i++)
{ for(j=0;j<n;j++)
{
scanf("%d",&adj[i][j]);
}
}
for(i=0;i<10;i++)
visited[i]=0;
printf("DFS TRAVERSAL\n");
dfs(0);
printf("\n");
for(i=0;i<10;i++)
visited[i]=0;
printf("BFS TRAVERSAL\n");
bfs(0);
printf("\n");
break;
case 2:
exit(0);
break;
}
}
else
break;
}
return 0;
}
void dfs(int p)
{
int i;
printf("%d\t",p);
visited[p]=1;
for(i=0;i<n;i++)
{
if(!visited[i] && adj[p][i]==1)
{
dfs(i);
}
}
}
void bfs(int p)
{
visited[p]=1;
q[rear]=p;
rear++;
while(rear!=front)
{
int i;
int u=q[front];
printf("%d\t",u);
front++;
for(i=0;i<n;i++)
{ if(visited[i]==0 && adj[u][i]==1)
{
q[rear]=i;
rear++;
visited[i]=1;
}
}
}
printf("\n");
}
