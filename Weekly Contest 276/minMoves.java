public int minMoves(int target, int maxDoubles) {
        int res = 0;
		while(maxDoubles > 0 && target > 1) {
	        if(target % 2 != 0) {
	        	res+=2;
	        	maxDoubles--;
//	        	System.out.println("double");
	        }else {
	        	res++;
	        	maxDoubles--;
//	        	System.out.println("double*");
	        }
	        target = target / 2;
		}
		if(target > 1) {
//			System.out.println(target - 1);
			res += (target - 1);
		}
		return res;
}
