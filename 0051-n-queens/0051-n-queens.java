class Solution {
    boolean isValid(List<List<String>> list,char board[][],int n,int row,int col){
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<n ;i--,j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
        }
        return true;
    }
    void helper(List<List<String>> list,char board[][],int n,int row){
        if(row==n){
            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            list.add(current);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(list,board,n,row,i)){
                board[row][i]='Q';
                helper(list,board,n,row+1);
                board[row][i] ='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(list,board,n,0);

        return list;
    }
}