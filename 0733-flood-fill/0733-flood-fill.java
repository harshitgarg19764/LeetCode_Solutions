class Solution {
    public void helper(int[][] grid,int row,int col,boolean vis[][],int color,int org){
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0 || vis[row][col] || grid[row][col]!=org){
            return;
        }
        if(!vis[row][col] && grid[row][col]==org){
            vis[row][col]=true;
            grid[row][col]=color;
            helper(grid,row,col+1,vis,color,org);
            helper(grid,row+1,col,vis,color,org);
            helper(grid,row,col-1,vis,color,org);
            helper(grid,row-1,col,vis,color,org);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int org = image[sr][sc];
        helper(image,sr,sc,vis,color,org);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
        return image;
    }
}