class Solution {
    public int minCost(int[][] grid) {
       int m = grid.length;
       int n= grid[0].length;

       boolean[][][] dp = new boolean[m][n][1024];

       dp[0][0][grid[0][0]]=true;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int currentVal =grid[i][j];

                if(i==0 && j==0) continue;

                if(i>0){
                    for(int k=0;k<1024;k++){
                        if(dp[i-1][j][k]){
                            dp[i][j][k^currentVal]=true;
                        }
                    }
                }

                if(j>0){
                    for(int k=0;k<1024;k++){
                        if(dp[i][j-1][k]){
                            dp[i][j][k^currentVal]=true;
                        }
                    }
                }
            }
        }

        for(int k=0;k<1024;k++){
            if(dp[m-1][n-1][k])
            return k;
        }
        

        return -1;
    }
}