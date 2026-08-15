class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i <= n; i++) {

            int oneStep = c + costs[i - 1] + 1;
            int twoStep = b + costs[i - 1] + 4;
            int threeStep = a + costs[i - 1] + 9;

            int current = Math.min(oneStep, Math.min(twoStep, threeStep));

            a = b;
            b = c;
            c = current;
        }

        return c;
    }
}