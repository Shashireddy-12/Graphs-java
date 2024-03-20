import java.util.ArrayList;

public class cycle {
    static class edge{
        int src;
        int dest;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }
        public static void insert(ArrayList<edge> graph[])
        {
            for(int i=0;i<graph.length;i++)
            {
                graph[i]=new ArrayList<edge>();
            }
            graph[0].add(new edge(0,1));
           // graph[1].add(new edge(1,0));
            graph[2].add(new edge(2,1));
            graph[2].add(new edge(2,3));
            graph[3].add(new edge(3,4));
            graph[4].add(new edge(4,2));
           

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
        if( isCycle(graph,e.dest,visit,rec));
        {
            return true;
        }
        }

    }
rec[cur]=false;
    return false;
    }
        public static void main(String a[])
        {
            int v=5;
            ArrayList<edge> graph[]=new ArrayList[v];
            insert(graph);

            System.out.println(isCycle(graph,0,new boolean[v],new boolean [v]));
        }
    }

    

