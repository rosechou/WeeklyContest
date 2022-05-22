// note: using long type, instead of double 

class Solution {
     public int minimumLines(int[][] stockPrices) {
        int res = 0;
         
        // Arrays.sort(stockPrices, new Comparator<int[]>() {
        // public int compare(int[] a, int[] b) {
        //     return a[0] - b[0];
        //     }
        // });
        
        // sort in increasing order by the first element
        Arrays.sort(stockPrices,(a,b)->a[0]-b[0]);

        if(stockPrices.length <= 1){
            return 0;
        }
        long tempDay = stockPrices[1][0] - stockPrices[0][0];
        long tempPrice = stockPrices[1][1] - stockPrices[0][1];
         
        for(int i = 1;i < stockPrices.length - 1;i++){
            long day = stockPrices[i + 1][0] - stockPrices[i][0];
            long price = stockPrices[i + 1][1] - stockPrices[i][1];
            
            if(tempDay * price != tempPrice * day){
                res++;
                tempDay = day;
                tempPrice = price;
            }
        }
        return res + 1;
     }
}
