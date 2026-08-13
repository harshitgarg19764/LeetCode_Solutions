class flight{
    int vertex;
    int k;
    int wt;
    flight(int vertex,int wt,int k){
        this.vertex=vertex;
        this.k = k;
        this.wt=wt;
    }
}
class Solution {
    public void createadj(int[][] flights,int n,ArrayList<ArrayList<flight>> list){
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            list.get(u).add(new flight(v,wt,0));
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<flight>> list = new ArrayList<>();
        int dist[] = new int[n];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        createadj(flights,n,list);
        Queue<flight> q = new LinkedList<>();
        q.add(new flight(src,0,0));
        while(!q.isEmpty()){
            flight curr = q.poll();
            if(curr.k>k){
                break;
            }
            for(int i=0;i<list.get(curr.vertex).size();i++){
                int v = list.get(curr.vertex).get(i).vertex;
                int wt = list.get(curr.vertex).get(i).wt;
                if(curr.wt+wt<dist[v] && curr.k<=k){
                    dist[v]=curr.wt+wt;
                    q.add(new flight(v,dist[v],curr.k+1));
                }
            }
        }

        if(dist[dst]!=Integer.MAX_VALUE){
            return dist[dst];
        }
        else{
            return -1;
        }
    }
}