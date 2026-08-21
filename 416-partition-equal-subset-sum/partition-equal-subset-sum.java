class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        dp = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target);
    }

    boolean solve(int[] nums, int i, int target) {

        if (target == 0)
            return true;

        if (i == nums.length || target < 0)
            return false;

        if (dp[i][target] != null)
            return dp[i][target];

        dp[i][target] =
            solve(nums, i + 1, target - nums[i]) ||
            solve(nums, i + 1, target);

        return dp[i][target];
    }
}