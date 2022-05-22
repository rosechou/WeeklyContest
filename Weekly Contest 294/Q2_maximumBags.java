class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        int[] remaining = new int[rocks.length];
        for(int i = 0;i < rocks.length;i++){
            remaining[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remaining);
        for(int i = 0;i < rocks.length;i++){
            if(remaining[i] != 0 && additionalRocks >= remaining[i]){
                additionalRocks = additionalRocks - remaining[i];
                remaining[i] = 0;
            }
        }
        for(int i = 0;i < rocks.length;i++){
            if(remaining[i] == 0){
                res++;
            }
        }
        return res;
    }
}
