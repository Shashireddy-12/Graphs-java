import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsalgo {
    static class edge{
        int src;
        int dest;
        int wt;
        edge(int src,int dest,int wt)
        {
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void insert(ArrayList<edge> graph[],int v)
    {
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,10));
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,3,30));
        graph[1].add(new edge(1,0,10));
        graph[1].add(new edge(1,3,40));
        graph[2].add(new edge(2,0,10));
        graph[2].add(new edge(2,3,50));
        graph[3].add(new edge(3,0,30));
        graph[3].add(new edge(3,1,40));
        graph[3].add(new edge(3,2,50));
    }
    static class pair implements Comparable<pair>
    {
            int node;
            int cost;
            pair(int node,int cost)
            {
                this.node=node;
                this.cost=cost;
            }
            @Override
        public int compareTo(pair p2)
         {
            return this.cost-p2.cost;
        }
        
        
    }
    public static void prims(ArrayList<edge>graph[], int v)
    {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        boolean visit[]=new boolean[v];
        pq.add(new pair(0,0));
        int total=0;
        while(!pq.isEmpty())
        {
            pair cur=pq.remove();
            if(visit[cur.node]==false)
            {
                   visit[cur.node]=true;
                   total+=cur.cost;
            }
            for(int i=0;i<graph[cur.node].size();i++)
            {
                edge e=graph[cur.node].get(i);
                if(visit[e.dest]==false)
                {
                    pq.add(new pair(e.dest,e.wt));
                }
            }
        }
        System.out.println(total);
    }
    public static void main(String a[])
    {
        int v=4;
        ArrayList graph[]=new ArrayList[v];
        insert(graph,v);
        prims(graph,v);
    }
}
