// When encouter TTL, think about hashmap (some O(1) data structure)
// 1. build a hashmap, put (value, index)
// 2. iterate elements in operations
// 3. look up and replace in nums
// 4. delete old and add new in hashmap
// 5. return nums

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0;i < operations.length;i++){
            int index = map.get(operations[i][0]);
            nums[index] = operations[i][1];
            map.remove(operations[i][0]);
            map.put(operations[i][1], index);
        }
        return nums;
    }
}
