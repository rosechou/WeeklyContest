class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] arr = new int[26];
        int res = 0;
        for(int i = 0;i < s.length();i++){
            arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
        }
        while(true){
            for(int i = 0;i < target.length();i++){
                if(arr[target.charAt(i) - 'a'] > 0){
                    arr[target.charAt(i) - 'a'] = arr[target.charAt(i) - 'a'] - 1;
                }else{
                    return res;
                }
            }
            res++;
        }
    }
}
