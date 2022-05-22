class Solution {
    public int percentageLetter(String s, char letter) {
        int counter = 0;
        double res;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == letter){
                counter++;
            }
        }
        res = (((double) counter) / s.length())*100;
        return (int) Math.floor(res);
    }
}
