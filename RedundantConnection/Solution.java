package RedundantConnection;

class Solution {
    int parent[]=new int[1001];
    int rank[]=new int[1001];

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int res[]=new int[2];
        for(int i=0;i<1001;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        int u=0,v=0;
        for(int i=0;i<edges.length;i++)
        {
            u=edges[i][0];
            v=edges[i][1];
            if(findPar(u)!=findPar(v))
                union(u,v);
            else
            {
                res[0]=u;
                res[1]=v;
            }
        }
        return res;
    }
    public int findPar(int u)
    {
        if(parent[u]==u)
            return u;
        else
            return parent[u]=findPar(parent[u]);
    }
    public void union(int u,int v)
    {
        u=findPar(u);
        v=findPar(v);
        if(rank[u]<rank[v])
        {
            parent[u]=v;
        }
        else
        if(rank[v]<rank[u])
        {
            parent[v]=u;
        }
        else
        {
            parent[u]=v;
            rank[v]++;
        }
    }
}
