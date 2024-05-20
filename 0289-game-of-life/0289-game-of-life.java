class Solution {
    int[] x = {0,1,1,1,0,-1,-1,-1};
    int[] y = {1,1,0,-1,-1,-1,0,1};
    public void gameOfLife(int[][] board) {
        int n=board.length, m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int zero=0, one=0;
                for(int k=0;k<8;k++){
                    int ni=i+x[k], nj=j+y[k];
                    if(ni>=0&&ni<n&&nj>=0&&nj<m){
                        if(board[ni][nj]==1 || board[ni][nj]==3)
                            one++;
                        else
                            zero++;
                    }
                }
                
                if(board[i][j]==1){
                    if(one<2||one>3)
                        board[i][j]=3;
                }else{
                    if(one==3){
                        board[i][j]=2;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
}