class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for(int i = 0; i <= amount; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min( 1 + dp[i - coin],dp[i]);
            }
        }
        if(dp[amount] > amount){
            return - 1;
        }
        else{
            return dp[amount];
        }
    }
}