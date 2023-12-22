class Solution {
    public int totalNQueens(int n) {
        int[] result = {0};
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(result,board,0);
        return result[0];
    }
    public void helper(int[] result,char[][] board,int row){
              int n = board.length;
              if(row == n){
                     result[0]++;
                     return;
              }
              for(int j =0;j<n;j++){
                     if(isSafe(board,row,j)){
                            board[row][j] = 'Q';
                            helper(result,board,row+1);
                            board[row][j] = '.';
                     }
              }
       }
       public boolean isSafe(char[][] board,int row,int col){
              //check the row
              int n = board.length;
              for(int j=0;j<n;j++){
                     if(board[row][j] == 'Q')
                     return false;
              }
              for(int i=0;i<n;i++){
                     if(board[i][col] == 'Q')
                     return false;
              }
              int i = row,j=col;
              //North east
              while(i >=0 && j <n){
                     if(board[i][j] == 'Q')
                     return false;
                     i--;j++;
              }
              //North west
              i = row;j=col;
              while(i >=0 && j >=0){
                     if(board[i][j] == 'Q')
                     return false;
                     i--;j--;
              }
              //South west
              i = row;j=col;
              while(i < n && j >= 0){
                     if(board[i][j] == 'Q')
                     return false;
                     i++;j--;
              }
              //North west
              i = row;j=col;
              while(i < n && j < n){
                     if(board[i][j] == 'Q')
                     return false;
                     i++;j++;
              }
              return true;
       }
}