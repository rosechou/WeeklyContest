class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxNum = Integer.MAX_VALUE;
        int[][] dist = new int[m][n];
        for(int[] arr : dist){
            Arrays.fill(arr, maxNum);
        }
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[3]);
        while(!dq.isEmpty()){
            int[] curr = dq.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];
            for(int i = 0;i < 4;i++){
                if(row + x[i] >= 0 && row + x[i] < m && col + y[i] >= 0 && col + y[i] < n && dist[row + x[i]][col + y[i]] == maxNum){
                    if(grid[row + x[i]][col + y[i]] == 0){
                        dist[row + x[i]][col + y[i]] = val;
                        dq.offerFirst(new int[]{val, row + x[i], col + y[i]});
                    }else if(grid[row + x[i]][col + y[i]] == 1){
                        dist[row + x[i]][col + y[i]] = val + 1;
                        dq.offer(new int[]{val + 1, row + x[i], col + y[i]});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
