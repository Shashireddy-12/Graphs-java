import java.util.ArrayList;
import java.util.Stack;

public class kosarajualgo {
    static class edge{
        int src;
        int des;
        edge(int src,int des)
        {
            this.src=src;
            this.des=des;
        }
    }
    public static void insert(ArrayList<edge> graph[],int v)
    {
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,2));
        graph[0].add(new edge(0,3));
        graph[1].add(new edge(1,0));
        graph[2].add(new edge(2,1));
        graph[3].add(new edge(3,4));
       

    
    }
    public static void topsort(ArrayList<edge> graph[],int cur,boolean visit[],Stack<Integer> s)
    {
        visit[cur]=true;
        for(int i=0;i<graph[cur].size();i++)
        {
            edge e=graph[cur].get(i);
            if(visit[e.des]==false)
            {
                 topsort(graph,e.des,visit,s);
            }
        }
        s.push(cur);
    }
    public static void dfs(ArrayList<edge> graph[],int cur,boolean vis[])
    {
        vis[cur]=true;
        System.out.print(cur);
        for(int i=0;i<graph[cur].size();i++)
        {
            edge e=graph[cur].get(i);
            if(vis[e.des]==false)
            {
                dfs(graph,e.des,vis);
            }
        }
    }
    public static void kosaraju(ArrayList<edge> graph[],int v)
    {
        //step 1;
        Stack<Integer> s=new Stack<>();
        boolean visit[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(visit[i]==false)
            {
                topsort(graph,i,visit,s);
            }
        }
        //step2
        ArrayList<edge> transpose[]=new ArrayList[v];
        for(int k=0;k<graph.length;k++)
        {
            visit[k]=false;
            transpose[k]=new ArrayList<edge>();
        }
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                edge e=graph[i].get(j);
                transpose[e.des].add(new edge(e.des,e.src));
            }
        }
        //step3
        while(!s.isEmpty())
        {
           int c=s.pop();
           if(visit[c]==false)
           {
            dfs(transpose,c,visit);
            //System.out.println();
           }
           System.out.println();
        }

    }
    public static void main(String a[])
    {
        int v=5;
        ArrayList<edge> graph[]=new ArrayList[v];
        insert(graph,v);
        kosaraju(graph,v);
    }
    
}
