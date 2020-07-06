class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i= 0; i<nums.length; i++) {
            for (int j = i+1; i<nums.length; j++){
               if(target == nums[i]+nums[j]) {
                  int[] res = {nums[i],nums[j]};
                   return res;
               }
            }
        }
        return null;
    }
}