// 1. iterate from the tail of ques
// 2. calculate the maximum possible point which is current point or the point after skipping
// 3. update maximum value
// 3. go to step 1
// 4. return the first maximum possible point

public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long max = 0;
        int i = questions.length - 1;
        while(i >= 0){
            long nextValue = (i + questions[i][1] + 1 > questions.length - 1) ? 0 : dp[i + questions[i][1] + 1];
            dp[i] = Math.max(max, questions[i][0] + nextValue);
            max = Math.max(max, dp[i]);
            i--;
        }
        return dp[0];
}


// time complexity: O(N), N is length of questions array
// space complexity: O(N), N is length of questions array
