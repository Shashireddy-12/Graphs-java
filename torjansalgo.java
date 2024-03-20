import java.util.ArrayList;

public class torjansalgo {
    static class edge{
        int src;
        int dest;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }
    public static void insert(ArrayList<edge> graph[],int v)
    {
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2)); 
        graph[0].add(new edge(0,3));
        graph[1].add(new edge(1,0));

        graph[1].add(new edge(1,2));
        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,1));
        graph[3].add(new edge(3,0));
        graph[3].add(new edge(3,4));
        graph[4].add(new edge(4,3));
        
    }
    public static void dfs(ArrayList<edge> graph[],int cur,boolean vis[],int distime[],int lowdistime[],int time,int parent)
    {
           vis[cur]=true;
        distime[cur]=lowdistime[cur]=++time;
        for(int i=0;i<graph[cur].size();i++)
        {
            edge e=graph[cur].get(i);
            if(e.dest==parent)
            {
                continue;
            }
            else if(vis[e.dest]==false)
            {
            dfs(graph,e.dest,vis,distime,lowdistime,time,cur);
            lowdistime[cur]=Math.min(lowdistime[cur],lowdistime[e.dest]);
            if(lowdistime[cur]<lowdistime[e.dest])
            {
                System.out.println(cur+"--->"+e.dest);
            }
            }
            else{
                lowdistime[cur]=Math.min(lowdistime[cur],distime[e.dest]);//articulation condition
            }
        }
    
    }
    public static void torjan(ArrayList<edge> graph[],int v)
    {
        int distime[]=new int[v];
        int lowdistime[]=new int[v];
        boolean visit[]=new boolean[v];
        int time=0;
        for(int i=0;i<v;i++)
        {
            if(visit[i]==false)
            {
                dfs(graph,i,visit,distime,lowdistime,time,-1);
            }
        }
    }
    public static void main(String a[])
    {
        int v=5;
        ArrayList<edge> graph[]=new ArrayList[v];
        insert(graph,v);
        torjan(graph,v);
    }
    
}
