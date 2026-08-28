class Solution {
    private int[] rd = {-1, 1, 0, 0};
    private int[] cd = {0, 0, -1, 1};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        int area = 1;
        grid[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int tr = r + rd[i];
            int tc = c + cd[i];
            area += dfs(grid, tr, tc);
        }

        return area;
    }
}