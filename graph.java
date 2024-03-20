import java.util.*;
public class graph
{
    static class edge
    {
        int src;
        int dest;
      //  int wt;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
            //this.wt=wt;
        }
    }
    public static void insert(ArrayList<edge> graph[])
    {
               for(int i=0;i<graph.length;i++)
               {
                graph[i]=new ArrayList<edge>();
               }
              graph[0].add(new edge(0,1));
               graph[0].add(new edge(0,4));
               graph[1].add(new edge(1,0));
               graph[1].add(new edge(1,2));
               graph[2].add(new edge(2,1));
               graph[2].add(new edge(2,3));
            //   graph[3].add(new edge(3,1,10));
             //  graph[3].add(new edge(3,2,-1));
    }
    public static void bfs(ArrayList<edge>graph[],int v)
    {
        Queue<Integer> k=new LinkedList<>();
        k.add(0);
        boolean visit[]=new boolean[v];
        while(!k.isEmpty())
        {
            int h=k.remove();
            if(visit[h]==false)
            {
                System.out.println(h);
                visit[h]=true;
            }
            for(int i=0;i<graph[h].size();i++)
            {
                  edge e=graph[h].get(i);
                  k.add(e.dest);
            }

        }
    }
    public static void dfs(ArrayList<edge> graph[],int cur,boolean visit[])
    {
        System.out.print(cur);
        visit[cur]=true;
        for(int i=0;i<graph[cur].size();i++)
        {
            edge e=graph[cur].get(i);
            if(visit[e.dest]==false)
            {
                dfs(graph,e.dest,visit);
            }
        }
    }
    public static void srtodes(ArrayList<edge> graph[],int src,int des,String path,boolean visit[])
    {
        if(src==des)
        {
        System.out.print(path);
        //visit[src]=true;
        }
        for(int i=0;i<graph[src].size();i++)
        {
            edge e=graph[src].get(i);

            if(!visit[e.dest])
            {
                visit[src]=true;
                srtodes(graph,e.dest,des,path+e.dest,visit);
                visit[src]=false;
            }
        }
    }
    public static boolean isCycle(ArrayList<edge> graph[],int cur,boolean visit[],boolean rec[])
    {
        visit[cur]=true;
        rec[cur]=true;

    
    for(int i=0;i<graph[cur].size();i++)
    {
        edge e=graph[cur].get(i);
        if(rec[e.dest]==true)
        {
            return true;
        }
        
        else if(visit[e.dest]==false)
        {
          if(  isCycle(graph,e.dest,visit,rec))
          {
            return true;
          }
        }

    }
    rec[cur]=false;
    return true;
    }
    public static void topsort(ArrayList<edge> graph[], int cur,boolean visit[],Stack<Integer> st)
    {
          visit[cur]=true;
          for(int i=0;i<graph[cur].size();i++)
          {
            edge e=graph[cur].get(i);
            if(visit[e.dest]==false)
            {
                topsort(graph,e.dest,visit,st);
            }
            
          }
          st.push(cur);
        //  cur++;
         
    }
    public static void top(ArrayList<edge>graph[],int v)
    {
        boolean vis[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++)
        {
            if(vis[i]==false)
            {
                topsort(graph,i,vis,st);
            }
        }
        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }
        
    }
    //cycle in undirected graph
    public static boolean uncycle(ArrayList<edge> graph[],boolean visit[],int cur,int par)
    {
        visit[cur]=true;
        for(int i=0;i<graph[cur].size();i++)
        {
            edge e=graph[cur].get(i);
            if(visit[e.dest]==true&&e.dest!=par)
            {
                return true;
            }
            else if(visit[e.dest]==false)
            {
                if(uncycle(graph,visit,e.dest,cur))
                {
                    return true;
                }
            }
        

        }
        return false;
    }
    public static void main(String a[])
    {
       int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[v];
        insert(graph);
        boolean visit[]=new boolean[v];
       System.out.print( uncycle(graph,visit,0,-1));
        
        
    }
}