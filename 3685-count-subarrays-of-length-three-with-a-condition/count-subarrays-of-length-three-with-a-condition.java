class Solution {
    public int countSubarrays(int[] nums) {
        int left=0;
        int right=2;
        int c=0;
        while(right<=nums.length-1)
        {
            if((nums[left]+nums[right])==nums[left+1]/2.0)
                c++;
            left++;
            right++;
        }
        return c;
    }
}