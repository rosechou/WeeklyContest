// 0. len of original nums
// 1. iterate from index 1 and repeat the iteration until newNum==nums
// 2. put index 0 to newNum
// 3. if nums[i - 1] <= nums[i] => put nums[i] into newNum

// Time Limit Exceeded
// class Solution {
//     public int totalSteps(int[] nums) {
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         for (int num : nums) {
//             list.add(num);
//         }
//         ArrayList<Integer> newList = new ArrayList<Integer>();
//         ArrayList<Integer> temp = new ArrayList<Integer>();
//         temp = (ArrayList)list.clone();
//         int res = 0;
        
//         while(list.size() != newList.size()){
//             res++;
//             list = (ArrayList)temp.clone();
//             newList.removeAll(newList);
//             if(list.size() > 0){
//                 newList.add(list.get(0));
//             }
            
//             for(int i = 1;i < list.size();i++){
//                 if(list.get(i - 1) <= list.get(i)){
//                     newList.add(list.get(i));
//                 }
//             }
//             temp = (ArrayList)newList.clone(); 
//         }
//         return res - 1;
//     }
// }

class Solution {
    public int totalSteps(int[] nums) {
        int res = 0;
        int[] record = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = nums.length - 1;i >= 0;i--){
            while(!stack.empty() && nums[i] > nums[stack.peek()]){
                // update the min elements has met
                record[i] = Math.max(record[i] + 1, record[stack.peek()]);
                stack.pop();
            }
            stack.push(i);
            res = Math.max(res, record[i]);
        }
        return res;
    }
}
