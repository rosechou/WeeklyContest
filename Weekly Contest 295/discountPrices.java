// Time Limit Exceeded	
class Solution {
    public String discountPrices(String sentence, int discount) {
        String res = "";
        int j = 0;
        char prev = ' ';
        for(int i = 0;i < sentence.length();i++){
            if(sentence.charAt(i) == '$' && prev == ' '){
                String num = "";
                for(j = i + 1;j < sentence.length();j++){
                    if(Character.isDigit(sentence.charAt(j))){
                        num = num + sentence.charAt(j);
                    }else{
                        break;
                    }
                }
                res = res + "$";
                // j = j + 1;
                if(j < sentence.length()){
                    if(sentence.charAt(j) == ' ' && num != ""){
                        long price = Long.parseLong(num);
                        // float input = (Integer.parseInt(num)*discount);
                        // input = input / 100;
                        // res = res + String.format("%.2f", price - input) + " ";
                        
                        double ans = price - (double) ((double) price * (discount / 100.00));
                        res = res + String.format("%.2f", ans) + " ";
                        i = j;
                        prev = ' ';
                        // System.out.println(String.format("%.2f", ans));
                    }else{
                        if(num != ""){
                            prev = num.charAt(num.length() - 1);
                        }
                        res = res + num;
                        i = j - 1;
                    }
                }else if(j == sentence.length() && num != ""){
                    long price = Long.parseLong(num);  
                    double ans = price - (double) ((double) price * (discount / 100.00));
                    res = res + String.format("%.2f", ans);
                    i = j;
                }
            }else{
                prev = sentence.charAt(i);
                System.out.println(prev);
                res = res + sentence.charAt(i);
            }
        }
        return res;
    }
}
