class Solution {
    public int minMaxGame(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            list.add(nums[i]);
        }
        int turn = 0;
        while(list.size() > 1){
            for(int i = 0;i < list.size() - 1;i++){
                if(turn == 0){
                    newList.add(Math.min(list.get(i), list.get(i + 1)));
                    turn = 1;
                }else if(turn == 1){
                    newList.add(Math.max(list.get(i), list.get(i + 1)));
                    turn = 0;
                }
                i++;
            }
            list.clear();
            list = (ArrayList)newList.clone();
            newList.clear();
        }
        return list.get(0);
    }
}
