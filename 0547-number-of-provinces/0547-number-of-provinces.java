class Solution {
    public void createAdj(ArrayList<ArrayList<Integer>> list,int V,int isConnected[][]){
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
    }
    public void helper(ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr){
        vis[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++){
            if(!vis[adj.get(curr).get(i)]){
                helper(adj,vis,adj.get(curr).get(i));
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int prov =0;
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       createAdj(adj,isConnected.length,isConnected);
       boolean vis[] = new boolean[isConnected.length];
       for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                prov++;
                helper(adj,vis,i);
            }
       }
       return prov;
    }
}