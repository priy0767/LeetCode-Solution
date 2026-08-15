class Solution {
   
    
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
       
       
           return houseRobber(nums,dp,0,n);
       
       
        
    }
    private int houseRobber(int[] nums,int[] dp,int i,int n){
        if(i>=n)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        int robCount = nums[i] + houseRobber(nums,dp,i+2,n);
        int skipCount = houseRobber(nums,dp,i+1,n);
        dp[i]=Math.max(robCount,skipCount);
        
      return dp[i];
    }
}