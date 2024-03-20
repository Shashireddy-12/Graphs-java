import java.util.ArrayList;

public class belmanford {
    static class edge{
        int src;
        int des;
        int wt;
        edge(int src,int des,int wt)
        {
            this.src=src;
            this.des=des;
            this.wt=wt;
        }

    }
    public static void insert(ArrayList<edge> graph[],int v)
    {
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));
        graph[1].add(new edge(1,2,-4));
        graph[2].add(new edge(2,3,2));
        graph[3].add(new edge(3,4,4));
        graph[4].add(new edge(4,1,-1));
    }
    public static void bell(ArrayList<edge> graph[],int src, int v)
    {
        int dist[]=new int[v];
        for(int i=0;i<v;i++)
        {
            if(i!=src)
            {
            dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<v-1;i++)//this loop is for iterations that is goes upto v-1
        {
           for(int j=0;j<v;j++)// this loop  is for move along with vertices
           {
            for(int k=0;k<graph[j].size();k++)
            {
                edge e=graph[j].get(k);
                int u=e.src;
                int h=e.des;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+e.wt<dist[h])//here dist[u] value is must be a non infinitive because in java if we add anything to infinite then it will give you the negative value and the bellford becomes negative so it will npt work
            {
                dist[h]=dist[u]+e.wt;
            }


            }
           }
        } 
        for(int i=0;i<dist.length;i++)
        {
            System.out.println(dist[i]);
        }
    }
    public static void main(String a[])
    {
        int v=5;
        ArrayList<edge> graph[]=new ArrayList[v];
        insert(graph,v);
        bell(graph,0,v);
    }
    
}
