package com.algorithm.RecallMethod;

public class Island {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    max = max>dfs(grid,i,j)?max:dfs(grid,i,j);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] input,int m,int n){
        if(m>=0 && m<input.length && n>=0 && n<input[0].length && input[m][n] == 1){
            input[m][n] = 0;
            return 1+dfs(input,m+1,n)+dfs(input,m-1,n)+dfs(input,m,n+1)+dfs(input,m,n-1);
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        Island island = new Island();
        island.maxAreaOfIsland(a);
    }
}
