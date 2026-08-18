class Solution {
    int[][] dp;
    int solve(int i, int walls, int[] cost, int[] time) {   
        if (walls <= 0)
            return 0;
        if (i == cost.length)
            return 1000000000;
        if (dp[i][walls] != -1)
            return dp[i][walls];

        int paint = cost[i] + solve(i + 1, walls - 1 - time[i], cost, time);

        int skip = solve(i + 1, walls, cost, time);

        return dp[i][walls] = Math.min(paint, skip);
    }

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, n, cost, time);
    }
}