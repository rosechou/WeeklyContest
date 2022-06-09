class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int range;
        for(int i = 0;i < nums.length;i++){
            range = nums[i] + k;
            int j;
            for(j = i + 1;j < nums.length;j++){
                if(nums[j] > range){
                    res++;
                    break;
                }
                
            }
            j = j -1;
            i = j;
        }
        return res + 1;
    }
}
