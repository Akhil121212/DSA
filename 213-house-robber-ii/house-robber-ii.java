class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];    


        return Math.max(rob(nums,0,n-2),
                        rob(nums,1,n-1));
    }    

    public int rob(int[] nums,int s,int e){
            int prev1=0;
            int prev2=0;
            for(int i=s;i<=e;i++){
                int curr=Math.max(prev1, nums[i] + prev2);
                prev2=prev1;
                prev1=curr;
                
            }
            return prev1;
        }
        
    
}